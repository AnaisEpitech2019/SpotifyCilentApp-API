package com.spotifyclientapp.anais.spotifyclientapp_api.managers;

import android.util.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spotifyclientapp.anais.spotifyclientapp_api.callbacks.MyCallback;
import com.spotifyclientapp.anais.spotifyclientapp_api.callbacks.MyResponseCallback;
import com.spotifyclientapp.anais.spotifyclientapp_api.models.Tokens;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIManager {

    private static Retrofit retrofit;

    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";

    private static String BASE_URL = "";
    private static String AUTH_TOKEN = "";
    private static String REFRESH_TOKEN = "";

    public static void setBaseUrl(String baseUrl) {
        BASE_URL = baseUrl;
        buildRetrofitInstance(BASE_URL);
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getAuthToken() {
        return AUTH_TOKEN;
    }

    static void setAuthToken(String authToken) {
        AUTH_TOKEN = authToken;
    }

    static String getRefreshToken() {
        return REFRESH_TOKEN;
    }

    static void setRefreshToken(String refreshToken) {
        REFRESH_TOKEN = refreshToken;
    }

    public static Retrofit retrofit() {
        return retrofit;
    }


    /*
    ** Build a new Retrofit instance with a new base URL
    **
    ** @param endPoint base URL
    */
    private static void buildRetrofitInstance(String endPoint) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // FOR HTTPS
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.sslSocketFactory(getSSLSocketFactory());
        httpClient.hostnameVerifier(new HostnameVerifier() {

            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });

        OkHttpClient client = httpClient.build();
        retrofit = new Retrofit.Builder()
                .baseUrl(endPoint)
                .client(client)
                .addConverterFactory(getDateGSONConverter())
                .build();
    }

    private static SSLSocketFactory getSSLSocketFactory() {
        try {

            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            return sslSocketFactory;

        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            return null;
        }
    }


    /*
    ** Create a service from Services interfaces with default URL
    ** @param serviceClass interface class defining the  service
    ** @return created Service
    */
    public static <S> S buildService(Class<S> serviceClass) {
        return buildService(serviceClass, BASE_URL);
    }

    /*
    ** @param serviceClass interface class defining the service
    ** @param endPoint user-provided URL endpoing
    ** @return created service
    */
    static <S> S buildService(Class<S> serviceClass, String endPoint) {
        if (retrofit == null)
            buildRetrofitInstance(endPoint);

        return retrofit.create(serviceClass);
    }


    /**
     * Create a Retrofit callback from provided listener
     *
     * @param listener callback listener
     * @return created callback
     */
    public static Callback<Tokens> createCredentialsAPICallback(final MyCallback<Tokens> listener) {

        return new Callback<Tokens>() {
            @Override
            public void onResponse(Call<Tokens> call, Response<Tokens> response) {
                if (response.isSuccessful()) {
                    setAuthToken(response.body().token);
                    setRefreshToken(response.body().refreshToken);

                    listener.onResponseSuccess(response.body(), response.headers());
                } else {
                    Error error = parseError(response);

                    listener.onResponseFailure(response.message(), error, response.code());
                }
            }

            @Override
            public void onFailure(Call<Tokens> call, Throwable t) {
                listener.onFailure(t.getMessage());
            }
        };
    }

    /*
    ** Create a Retrofit callback from provided listener
    ** @param listener callback listener
    ** @return created callback
    */
    public static <S> Callback<S> createAPICallback(final MyCallback<S> listener) {

        return new Callback<S>() {
            @Override
            public void onResponse(Call<S> call, Response<S> response) {
                if (response.isSuccessful()) {
                    listener.onResponseSuccess(response.body(), response.headers());
                } else {
                    Error error = parseError(response);

                    listener.onResponseFailure(response.message(), error, response.code());
                }
            }

            @Override
            public void onFailure(Call<S> call, Throwable t) {
                listener.onFailure(t.getMessage());
            }
        };
    }


    /*
    ** Create a Retrofit callback from provided listener
    ** @param listener callback listener
    ** @return created callback
    */
    static <S> Callback<S> createAPIResponseCallback(final MyResponseCallback<S> listener) {

        return new Callback<S>() {
            @Override
            public void onResponse(Call<S> call, Response<S> response) {
                if (response.isSuccessful()) {
                    listener.onResponseSuccess(response, response.headers());
                } else {
                    Error error = parseError(response);

                    listener.onResponseFailure(response.message(), error, response.code());
                }
            }

            @Override
            public void onFailure(Call<S> call, Throwable t) {
                listener.onFailure(t.getMessage());
            }
        };
    }

    private static Error parseError(Response<?> response) {
        Converter<ResponseBody, Error> converter =
                APIManager.retrofit()
                        .responseBodyConverter(Error.class, new Annotation[0]);

        Error error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new Error();
        }
        return error;
    }


    /*
    ** Convert timestamps to Date object where applicable.
    ** @return generated GsonConvertFactory
    */
    static GsonConverterFactory getDateGSONConverter() {
        final Gson gson = new GsonBuilder()
                .setDateFormat(TIMESTAMP_FORMAT) // Allow timestamps to be converted to Date object directly when necessary
                .create();

        return GsonConverterFactory.create(gson);
    }

    private static String encodeCredentialsForBasicAuthorization(String user, String password) {
        return Base64.encodeToString((user + ":" + password).getBytes(), Base64.NO_WRAP);
    }

}

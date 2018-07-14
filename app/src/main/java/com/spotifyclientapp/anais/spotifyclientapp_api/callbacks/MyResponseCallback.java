package com.spotifyclientapp.anais.spotifyclientapp_api.callbacks;

import okhttp3.Headers;
import retrofit2.Response;

/*
 ** MyCallback interface for asynchronous API calls
 ** Return the whole Response object
 */
public interface MyResponseCallback<T> {

    /*
    ** Called when the API returned successfully
    ** @param response Response object containing the templated object
    ** @param headers
    */
    void onResponseSuccess(Response<T> response, Headers headers);

    /*
    ** Called when the API returned an error, or an incorrect json format
    ** @param message error message
    ** @param error error body
    ** @param code
    */
    void onResponseFailure(String message, Error error, int code);

    /*
    ** Called when the API call failed
    ** @param message error message
    */
    void onFailure(String message);
}


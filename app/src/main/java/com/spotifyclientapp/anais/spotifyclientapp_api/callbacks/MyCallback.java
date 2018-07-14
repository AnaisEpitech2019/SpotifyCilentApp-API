package com.spotifyclientapp.anais.spotifyclientapp_api.callbacks;

import okhttp3.Headers;

public interface MyCallback<T> {

    /*
    ** Called when the API returned successfully
    ** @param response templated response object
    ** @param headers headers
    */
    void onResponseSuccess(T response, Headers headers);

    /*
    ** Called when the API returned an error, or an incorrect json format
    ** @param message error message
    ** @param error error body
    ** @param code error code
    */
    void onResponseFailure(String message, Error error, int code);

    /*
    ** Called when the API call failed
    ** @param message error message
    */
    void onFailure(String message);
}


package com.spotifyclientapp.anais.spotifyclientapp_api.models;

import com.google.gson.annotations.SerializedName;

public class Tokens {

    public static final String TOKEN = "access_token";
    public static final String REFRESH_TOKEN = "refresh_token";

    /// Authentication token
    @SerializedName(TOKEN)
    public String token;

    /// Refresh token
    @SerializedName(REFRESH_TOKEN)
    public String refreshToken;

    public static String getTOKEN() {
        return TOKEN;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static String getRefreshToken() {
        return REFRESH_TOKEN;
    }
}

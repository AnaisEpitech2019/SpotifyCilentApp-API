package com.spotifyclientapp.anais.spotifyclientapp_api.models.utils;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Image implements Serializable {

    public static final String URL = "url";

    @SerializedName(URL)
    public String url_icon;
}

package com.spotifyclientapp.anais.spotifyclientapp_api.models.search;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Followers implements Serializable {

    public static final String HREF = "href";
    public static final String NB = "total";

    @SerializedName(HREF)
    public String href;

    @SerializedName(NB)
    public int nb_followers;
}

package com.spotifyclientapp.anais.spotifyclientapp_api.models.modelsAll;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AllTracks implements Serializable {

    public static final String TOTAL = "total";
    public static final String HREF = "href";

    @SerializedName(TOTAL)
    public int nb_tracks;

    @SerializedName(HREF)
    public String href;
}

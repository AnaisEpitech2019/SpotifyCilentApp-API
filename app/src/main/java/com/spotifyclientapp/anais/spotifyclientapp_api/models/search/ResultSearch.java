package com.spotifyclientapp.anais.spotifyclientapp_api.models.search;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ResultSearch implements Serializable {

    public static final String ALLRESULT = "artists";
    public static final String HREF = "href";
    public static final String ITEMS = "items";
    public static final String NEXT = "next";
    public static final String TOTAL = "total";

    @SerializedName(ALLRESULT)
    public ResultSearch artists;

    @SerializedName(HREF)
    public String href;

    @SerializedName(ITEMS)
    public List<Artist> list_artists;

    @SerializedName(NEXT)
    public String next;

    @SerializedName(TOTAL)
    public int nb_artists;

}

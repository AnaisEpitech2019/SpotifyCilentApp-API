package com.spotifyclientapp.anais.spotifyclientapp_api.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class AllPlaylist implements Serializable {

    public static final String TOTAL = "total";
    public static final String HREF = "href";
    public static final String ITEMS = "items";

    @SerializedName(TOTAL)
    public int nb_playlists;

    @SerializedName(HREF)
    public String href;

    @SerializedName(ITEMS)
    public List<Playlist> playlists;
}

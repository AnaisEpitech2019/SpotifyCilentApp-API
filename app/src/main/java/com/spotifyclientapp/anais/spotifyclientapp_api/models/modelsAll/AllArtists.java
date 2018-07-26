package com.spotifyclientapp.anais.spotifyclientapp_api.models.modelsAll;

import com.google.gson.annotations.SerializedName;
import com.spotifyclientapp.anais.spotifyclientapp_api.models.search.Artist;

import java.io.Serializable;
import java.util.List;

public class AllArtists implements Serializable {

    public static final String ARTISTS = "artists";

    @SerializedName(ARTISTS)
    public List<Artist> list_artists;
}

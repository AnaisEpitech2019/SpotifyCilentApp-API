package com.spotifyclientapp.anais.spotifyclientapp_api.models.artist;

import com.google.gson.annotations.SerializedName;
import com.spotifyclientapp.anais.spotifyclientapp_api.models.search.Artist;

import java.io.Serializable;
import java.util.List;

public class Track implements Serializable {

    public static final String ALBUM = "album";
    public static final String ARTISTS = "artists";
    public static final String MARKETS = "available_markets";
    public static final String NB_DISC = "disc_number";
    public static final String DURATION = "duration_ms";
    public static final String HREF = "href";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String POPULARITY = "popularity";
    public static final String NB_TRACK = "track_number";

    @SerializedName(ALBUM)
    public Album album;

    @SerializedName(ARTISTS)
    public List<Artist> list_artists;

    @SerializedName(MARKETS)
    public List<String> list_markets;

    @SerializedName(NB_DISC)
    public int nb_disc;

    @SerializedName(DURATION)
    public int duration;

    @SerializedName(HREF)
    public String href;

    @SerializedName(ID)
    public String id;

    @SerializedName(NAME)
    public String name;

    @SerializedName(POPULARITY)
    public int popularity;

    @SerializedName(NB_TRACK)
    public int nb_track;
}

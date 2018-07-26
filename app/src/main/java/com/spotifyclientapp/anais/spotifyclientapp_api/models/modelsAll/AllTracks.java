package com.spotifyclientapp.anais.spotifyclientapp_api.models.modelsAll;

import com.google.gson.annotations.SerializedName;
import com.spotifyclientapp.anais.spotifyclientapp_api.models.artist.Track;

import java.io.Serializable;
import java.util.List;

public class AllTracks implements Serializable {

    public static final String TOTAL = "total";
    public static final String HREF = "href";
    public static final String TRACKS = "tracks";

    @SerializedName(TOTAL)
    public int nb_tracks;

    @SerializedName(HREF)
    public String href;

    @SerializedName(TRACKS)
    public List<Track> list_tracks;
}

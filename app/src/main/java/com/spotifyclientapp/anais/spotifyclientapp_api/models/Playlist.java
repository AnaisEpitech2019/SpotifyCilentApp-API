package com.spotifyclientapp.anais.spotifyclientapp_api.models;

import com.google.gson.annotations.SerializedName;
import com.spotifyclientapp.anais.spotifyclientapp_api.models.modelsAll.AllTracks;

import java.io.Serializable;

public class Playlist implements Serializable {

    public static final String ID = "id";
    public static final String NAME = "display_name";
    public static final String HREF = "href";
    public static final String TYPE = "type";
    public static final String URI = "uri";
    public static final String TRACKS = "tracks";

    @SerializedName(ID)
    public String id;

    @SerializedName(HREF)
    public String href;

    @SerializedName(NAME)
    public String name;

    @SerializedName(URI)
    public String uri;

    @SerializedName(TYPE)
    public String type;

    @SerializedName(TRACKS)
    public AllTracks tracks;
}

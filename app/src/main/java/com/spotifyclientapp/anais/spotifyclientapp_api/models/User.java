package com.spotifyclientapp.anais.spotifyclientapp_api.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {

    public static final String ID = "id";
    public static final String NAME = "display_name";
    public static final String HREF = "href";
    public static final String TYPE = "type";
    public static final String URI = "uri";

    @SerializedName(ID)
    public String id;

    @SerializedName(NAME)
    public String username;

    @SerializedName(HREF)
    public String href;

    @SerializedName(TYPE)
    public String type;

    @SerializedName(URI)
    public String uri;
}

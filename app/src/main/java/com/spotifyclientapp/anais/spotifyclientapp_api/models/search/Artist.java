package com.spotifyclientapp.anais.spotifyclientapp_api.models.search;

import com.google.gson.annotations.SerializedName;
import com.spotifyclientapp.anais.spotifyclientapp_api.models.utils.Image;

import java.io.Serializable;
import java.util.List;

public class Artist implements Serializable {

    public static final String FOLLOWERS = "followers";
    public static final String GENRES = "genres";
    public static final String HREF = "href";
    public static final String ID = "id";
    public static final String IMAGES = "images";
    public static final String NAME = "name";
    public static final String POPULARITY = "popularity";

    @SerializedName(FOLLOWERS)
    public Followers followers;

    @SerializedName(GENRES)
    public List<String> list_genres;

    @SerializedName(HREF)
    public String href;

    @SerializedName(ID)
    public String id;

    @SerializedName(IMAGES)
    public List<Image> images;

    @SerializedName(NAME)
    public String name;

    @SerializedName(POPULARITY)
    public int popularity;
}

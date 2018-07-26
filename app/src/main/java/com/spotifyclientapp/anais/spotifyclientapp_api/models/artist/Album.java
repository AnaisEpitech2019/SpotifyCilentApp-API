package com.spotifyclientapp.anais.spotifyclientapp_api.models.artist;

import com.google.gson.annotations.SerializedName;
import com.spotifyclientapp.anais.spotifyclientapp_api.models.search.Artist;
import com.spotifyclientapp.anais.spotifyclientapp_api.models.utils.Image;

import java.io.Serializable;
import java.util.List;

public class Album implements Serializable {

    public static final String ALBUM_TYPE = "album_type";
    public static final String TYPE = "type";
    public static final String ARTISTS = "artists";
    public static final String MARKETS = "available_markets";
    public static final String HREF = "href";
    public static final String ID = "id";
    public static final String IMG = "images";
    public static final String NAME = "name";
    public static final String RELEASE_DATE = "release_date";
    public static final String RELEASE_DATE_PRECISION = "release_date_precision";

    @SerializedName(ALBUM_TYPE)
    public String album_type;

    @SerializedName(TYPE)
    public String type;

    @SerializedName(ARTISTS)
    public List<Artist> list_artists;

    @SerializedName(MARKETS)
    public List<String> list_markets;

    @SerializedName(HREF)
    public String href;

    @SerializedName(ID)
    public String id;

    @SerializedName(IMG)
    public List<Image> list_img;

    @SerializedName(NAME)
    public String name;

    @SerializedName(RELEASE_DATE)
    public String release_date;

    @SerializedName(RELEASE_DATE_PRECISION)
    public String precision_release;
}

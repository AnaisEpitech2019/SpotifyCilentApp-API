package com.spotifyclientapp.anais.spotifyclientapp_api.models;

import com.google.gson.annotations.SerializedName;
import com.spotifyclientapp.anais.spotifyclientapp_api.models.utils.Image;

import java.io.Serializable;
import java.util.List;

public class CategoryMusic implements Serializable {

    public static final String HREF = "href";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String ICON = "icons";

    @SerializedName(HREF)
    public String href;

    @SerializedName(ID)
    public String id;

    @SerializedName(NAME)
    public String name;

    @SerializedName(ICON)
    public List<Image> icons;

}

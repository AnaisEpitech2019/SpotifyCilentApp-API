package com.spotifyclientapp.anais.spotifyclientapp_api.models.modelsAll;

import com.google.gson.annotations.SerializedName;
import com.spotifyclientapp.anais.spotifyclientapp_api.models.CategoryMusic;

import java.io.Serializable;
import java.util.List;

public class AllCategories implements Serializable {

    public static final String ALL = "categories";
    public static final String HREF = "href";
    public static final String TOTAL = "total";
    public static final String CATEGORIES = "items";
    public static final String PREV = "prev";
    public static final String NEXT = "next";

    @SerializedName(ALL)
    public AllCategories info_categories;

    @SerializedName(HREF)
    public String href;

    @SerializedName(TOTAL)
    public int nb_categories;

    @SerializedName(CATEGORIES)
    public List<CategoryMusic> list_categories;

    @SerializedName(PREV)
    public String prev;

    @SerializedName(NEXT)
    public String next;
}

package com.spotifyclientapp.anais.spotifyclientapp_api.services;

import com.spotifyclientapp.anais.spotifyclientapp_api.models.modelsAll.AllCategories;
import com.spotifyclientapp.anais.spotifyclientapp_api.models.search.ResultSearch;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public class HomeServices {

    public interface getAllCategories {
        @GET("/v1/browse/categories")
        Call<AllCategories> load(
                @Header("Authorization") String authHeader,
                @QueryMap Map<String, Object> map
                );
    }

    public interface getResultSearch {
        @GET("/v1/search")
        Call<ResultSearch> load(
                @Header("Authorization") String authHeader,
                @QueryMap Map<String, Object> map
        );
    }
}

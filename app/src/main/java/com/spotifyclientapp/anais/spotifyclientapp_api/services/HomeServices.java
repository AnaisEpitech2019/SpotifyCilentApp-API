package com.spotifyclientapp.anais.spotifyclientapp_api.services;

import com.spotifyclientapp.anais.spotifyclientapp_api.models.modelsAll.AllCategories;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public class HomeServices {

    public interface getAllCategories {
        @GET("/v1/browse/categories{extension}")
        Call<AllCategories> load(
                @Header("Authorization") String authHeader,
                @Path("extension") String extension
        );
    }
}

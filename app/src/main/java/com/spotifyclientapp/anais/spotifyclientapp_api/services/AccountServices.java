package com.spotifyclientapp.anais.spotifyclientapp_api.services;

import com.spotifyclientapp.anais.spotifyclientapp_api.models.modelsAll.AllPlaylist;
import com.spotifyclientapp.anais.spotifyclientapp_api.models.authentication.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public class AccountServices {

    public interface getUser {
        @GET("/v1/me")
        Call<User> load(
                @Header("Authorization") String authHeader
        );
    }

    public interface getAllPlaylists {
        @GET("/v1/me/playlists")
        Call<AllPlaylist> load(
                @Header("Authorization") String authHeader
        );
    }
}

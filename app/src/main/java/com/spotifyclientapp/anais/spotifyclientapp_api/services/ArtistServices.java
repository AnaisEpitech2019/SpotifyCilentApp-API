package com.spotifyclientapp.anais.spotifyclientapp_api.services;

import com.spotifyclientapp.anais.spotifyclientapp_api.models.modelsAll.AllArtists;
import com.spotifyclientapp.anais.spotifyclientapp_api.models.modelsAll.AllTracks;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class ArtistServices {

    public interface getTopTracks {
        @GET("/v1/artists/{id}/top-tracks")
        Call<AllTracks> load(
                @Header("Authorization") String authHeader,
                @Path("id") String id,
                @Query("country") String country
        );
    }

    public interface getRelatedArtists {
        @GET("/v1/artists/{id}/related-artists")
        Call<AllArtists> load(
                @Header("Authorization") String authHeader,
                @Path("id") String id
        );
    }
}

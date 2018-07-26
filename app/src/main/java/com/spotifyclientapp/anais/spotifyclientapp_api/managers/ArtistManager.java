package com.spotifyclientapp.anais.spotifyclientapp_api.managers;

import android.util.Log;

import com.spotifyclientapp.anais.spotifyclientapp_api.callbacks.MyCallback;
import com.spotifyclientapp.anais.spotifyclientapp_api.models.modelsAll.AllArtists;
import com.spotifyclientapp.anais.spotifyclientapp_api.models.modelsAll.AllTracks;
import com.spotifyclientapp.anais.spotifyclientapp_api.services.ArtistServices;

import java.io.Serializable;

import retrofit2.Call;

public class ArtistManager implements Serializable {

    public static Call<AllTracks> getTopTracks(String id, String country, MyCallback<AllTracks> callback) {

        Call<AllTracks> call = APIManager.buildService(ArtistServices.getTopTracks.class)
                .load(
                        "Bearer " + APIManager.getAuthToken(),
                        id,
                        country

                );

        call.enqueue(APIManager.createAPICallback(callback));
        return call;
    }

    public static Call<AllArtists> getRelatedArtists(String id, MyCallback<AllArtists> callback) {

        Call<AllArtists> call = APIManager.buildService(ArtistServices.getRelatedArtists.class)
                .load(
                        "Bearer " + APIManager.getAuthToken(),
                        id
                );

        call.enqueue(APIManager.createAPICallback(callback));
        return call;
    }
}

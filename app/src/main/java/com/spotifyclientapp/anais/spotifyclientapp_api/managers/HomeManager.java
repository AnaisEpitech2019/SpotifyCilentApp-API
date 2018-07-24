package com.spotifyclientapp.anais.spotifyclientapp_api.managers;

import com.spotifyclientapp.anais.spotifyclientapp_api.callbacks.MyCallback;
import com.spotifyclientapp.anais.spotifyclientapp_api.models.modelsAll.AllCategories;
import com.spotifyclientapp.anais.spotifyclientapp_api.services.HomeServices;

import retrofit2.Call;

public class HomeManager {

    public static Call<AllCategories> getAllCategories(String extension, MyCallback<AllCategories> callback) {

        Call<AllCategories> call = APIManager.buildService(HomeServices.getAllCategories.class)
                .load(
                        "Bearer " + APIManager.getAuthToken(),
                        extension
                );

        call.enqueue(APIManager.createAPICallback(callback));
        return call;
    }
}

package com.spotifyclientapp.anais.spotifyclientapp_api.managers;

import com.spotifyclientapp.anais.spotifyclientapp_api.callbacks.MyCallback;
import com.spotifyclientapp.anais.spotifyclientapp_api.models.modelsAll.AllCategories;
import com.spotifyclientapp.anais.spotifyclientapp_api.services.HomeServices;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

public class HomeManager {

    public static Call<AllCategories> getAllCategories(String offset, String limit, MyCallback<AllCategories> callback) {

        Map<String, Object> map = new HashMap<>();

        map.put("offset", offset);
        map.put("limit", limit);

        Call<AllCategories> call = APIManager.buildService(HomeServices.getAllCategories.class)
                .load(
                        "Bearer " + APIManager.getAuthToken(),
                        map
                );

        call.enqueue(APIManager.createAPICallback(callback));
        return call;
    }
}

package com.spotifyclientapp.anais.spotifyclientapp_api.managers;

import com.spotifyclientapp.anais.spotifyclientapp_api.callbacks.MyCallback;
import com.spotifyclientapp.anais.spotifyclientapp_api.models.modelsAll.AllPlaylist;
import com.spotifyclientapp.anais.spotifyclientapp_api.models.authentication.User;
import com.spotifyclientapp.anais.spotifyclientapp_api.services.AccountServices;

import retrofit2.Call;

public class AccountManager {

    public static Call<User> getCurrentUser(MyCallback<User> callback) {
        Call<User> call = APIManager.buildService(AccountServices.getUser.class)
                .load(
                        "Bearer " + APIManager.getAuthToken()
                );
        call.enqueue((APIManager.createAPICallback(callback)));
        return call;
    }

    public static Call<AllPlaylist> getAllPlaylists(MyCallback<AllPlaylist> callback) {

        Call<AllPlaylist> call = APIManager.buildService(AccountServices.getAllPlaylists.class)
                .load(
                        "Bearer " + APIManager.getAuthToken()
                );

        call.enqueue(APIManager.createAPICallback(callback));
        return call;
    }
}

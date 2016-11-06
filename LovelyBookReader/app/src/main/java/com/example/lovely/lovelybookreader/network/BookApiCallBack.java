package com.example.lovely.lovelybookreader.network;


import android.support.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lovely on 16/11/3.
 */

public abstract class BookApiCallBack<T> implements Callback<T> {
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (!response.isSuccessful()) {
            onError(call,"response error");
        } else if (response.body() == null) {
            onError(call, "response body error");
        } else {
            onResult(call, response.body());
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }

    public abstract void onResult(Call<T> call, @NonNull T result);
    public abstract void onError(Call<T> call, String error);
}

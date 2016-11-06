package com.example.lovely.lovelybookreader.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lovely on 16/11/2.
 */

public class BookServiceGenerate {
    private static final String BASE_API_URL = "http://api.zhuishushenqi.com";
    private static OkHttpClient httpClient = new OkHttpClient();
    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_API_URL).addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }
}

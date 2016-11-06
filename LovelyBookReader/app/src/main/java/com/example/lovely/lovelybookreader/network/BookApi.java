package com.example.lovely.lovelybookreader.network;

import com.example.lovely.lovelybookreader.data.BookShow;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lovely on 16/11/2.
 */

public class BookApi {
        private interface BookCommendService {
        @GET("/book/recommend")
        Call<BookShow> getListBookCommend(@Query("gender") String gender);
    }
        private final BookCommendService service;
    public BookApi() {
        service = BookServiceGenerate.createService(BookCommendService.class);
    }

    public Call<BookShow> getListBookCommend(String sex) {
        return service.getListBookCommend(sex);
    }


}

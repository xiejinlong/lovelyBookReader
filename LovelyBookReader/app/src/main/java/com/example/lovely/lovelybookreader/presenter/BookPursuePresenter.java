package com.example.lovely.lovelybookreader.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.lovely.lovelybookreader.data.BookShow;
import com.example.lovely.lovelybookreader.network.BookApi;
import com.example.lovely.lovelybookreader.network.BookApiCallBack;
import com.example.lovely.lovelybookreader.network.BookServiceGenerate;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lovely on 16/11/3.
 */

public class BookPursuePresenter {

    public interface OnGetBookList{
        void onGetBookList(BookShow bookShow);
    }
    BookShow bookShowList;
    public OnGetBookList onGetBookList;

    public void setOnGetBookList(OnGetBookList onGetBookList) {
        this.onGetBookList = onGetBookList;
    }

    public void getPursueBookList() {
        new BookApi().getListBookCommend("male").enqueue(new BookApiCallBack<BookShow>() {

            @Override
            public void onResult(Call<BookShow> call, @NonNull BookShow result) {
                Log.i("XJL","success");
               bookShowList  = result;
                onGetBookList.onGetBookList(bookShowList);

            }

            @Override
            public void onError(Call<BookShow> call, String error) {
                Log.i("XJL","error");
            }
        });
    }


}

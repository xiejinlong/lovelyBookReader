package com.example.lovely.lovelybookreader.fragment;

import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lovely.lovelybookreader.R;
import com.example.lovely.lovelybookreader.adapter.RecyclerViewAdapter;
import com.example.lovely.lovelybookreader.data.BookShow;
import com.example.lovely.lovelybookreader.presenter.BookPursuePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lovely on 16/11/1.
 */

public class BookPursueFragment extends Fragment implements RecyclerViewAdapter.MyItemClickListener,BookPursuePresenter.OnGetBookList{

    private List<BookShow> bookList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BookPursuePresenter pursuePresenter = new BookPursuePresenter();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_main_page_1,null);
        recyclerView = (RecyclerView) view.findViewById(R.id.book_like_list);
        initRecyclerView();
        pursuePresenter.setOnGetBookList(this);
        pursuePresenter.getPursueBookList();
        return view;
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


    }

    private void setRecyclerViewListener() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });


    }

    @Override
    public void onItemClickListener(BookShow.RecommendBooks books) {
        Log.i("XJL", "the bookshow name====>" +books.toString());
    }

    @Override
    public void onGetBookList(BookShow bookShow) {
        recyclerView.setAdapter(new RecyclerViewAdapter(bookShow.books,this));
    }
}

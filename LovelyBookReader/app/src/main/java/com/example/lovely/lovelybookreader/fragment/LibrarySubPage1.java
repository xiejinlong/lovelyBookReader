package com.example.lovely.lovelybookreader.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lovely.lovelybookreader.R;

/**
 * Created by lovely on 16/10/20.
 */

public class LibrarySubPage1 extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_library_page_1,null);
        return view;
    }
}
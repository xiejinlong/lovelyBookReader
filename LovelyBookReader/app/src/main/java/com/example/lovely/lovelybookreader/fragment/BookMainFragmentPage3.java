package com.example.lovely.lovelybookreader.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lovely.lovelybookreader.R;

import java.util.List;

/**
 * Created by lovely on 16/10/20.
 */

public class BookMainFragmentPage3 extends Fragment {
    private List<Fragment> fragmentList;
    private ViewPager viewPager;
    private TextView textView1,textView2,textView3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_main_page_3,null);
        return view;
    }
}

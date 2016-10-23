package com.example.lovely.lovelybookreader.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lovely.lovelybookreader.R;
import com.example.lovely.lovelybookreader.adapter.BookFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lovely on 16/10/20.
 */

public class BookMainFragmentPage2 extends Fragment implements View.OnClickListener{
    private List<Fragment> fragmentList;
    private ChildViewPager viewPager;
    private TextView textView1,textView2,textView3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_main_page_2,null);
        viewPager = (ChildViewPager) view.findViewById(R.id.book_library_view_pager);
        textView1 = (TextView) view.findViewById(R.id.book_library_title_1);
        textView2 = (TextView) view.findViewById(R.id.book_library_title_2);
        textView3 = (TextView) view.findViewById(R.id.book_library_title_3);
        textView1.setSelected(true);
        initViewPager();
        return view;
    }

    public void initViewPager() {
        fragmentList = new ArrayList<>();
        LibrarySubPage1 fragmentPage1 = new LibrarySubPage1();
        LibrarySubPage2 fragmentPage2 = new LibrarySubPage2();
        LibrarySubPage3 fragmentPage3 = new LibrarySubPage3();

        fragmentList.add(fragmentPage1);
        fragmentList.add(fragmentPage2);
        fragmentList.add(fragmentPage3);
        viewPager.setAdapter(new BookFragmentAdapter(getActivity().getSupportFragmentManager(),fragmentList));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        textView1.setSelected(true);
                        textView2.setSelected(false);
                        textView3.setSelected(false);
                        break;
                    case 1:
                        textView1.setSelected(false);
                        textView2.setSelected(true);
                        textView3.setSelected(false);
                        break;
                    case 2:
                        textView1.setSelected(false);
                        textView2.setSelected(false);
                        textView3.setSelected(true);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.book_library_title_1:
                textView1.setSelected(true);
                textView2.setSelected(false);
                textView3.setSelected(false);
                viewPager.setCurrentItem(0);
                break;
            case R.id.book_library_title_2:
                textView1.setSelected(false);
                textView2.setSelected(true);
                textView3.setSelected(false);
                viewPager.setCurrentItem(1);
                break;
            case R.id.book_library_title_3:
                textView1.setSelected(false);
                textView2.setSelected(false);
                textView3.setSelected(true);
                viewPager.setCurrentItem(2);
                break;
            default:
                break;
        }
    }
}

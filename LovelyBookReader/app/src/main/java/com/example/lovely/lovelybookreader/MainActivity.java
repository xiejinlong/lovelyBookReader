package com.example.lovely.lovelybookreader;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lovely.lovelybookreader.adapter.BookFragmentAdapter;
import com.example.lovely.lovelybookreader.fragment.BookCommunityFragment;
import com.example.lovely.lovelybookreader.fragment.BookFinderFragment;
import com.example.lovely.lovelybookreader.fragment.BookPursueFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private View bookReaderTitle;
    private View bookReaderFinder;
    private View bookReaderMore;
    private TextView bookPursue;
    private TextView bookCommunity;
    private TextView bookFind;
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initView();
        initViewPager();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitBy2Click();
        }
        return false;
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.book_main_pager);

        bookReaderTitle = findViewById(R.id.book_reader_title);
        bookReaderFinder = findViewById(R.id.book_find_image);
        bookReaderMore = findViewById(R.id.book_moreover);

        bookPursue = (TextView) findViewById(R.id.book_like);
        bookCommunity = (TextView) findViewById(R.id.book_community);
        bookFind = (TextView) findViewById(R.id.book_find);

        initClickListener();
        bookPursue.setSelected(true);
    }

    private void initClickListener() {
        bookReaderFinder.setOnClickListener(this);
        bookReaderTitle.setOnClickListener(this);
        bookReaderMore.setOnClickListener(this);

        bookPursue.setOnClickListener(this);
        bookCommunity.setOnClickListener(this);
        bookFind.setOnClickListener(this);
    }

    private void initViewPager() {
        fragmentList = new ArrayList<>();
        BookPursueFragment fragmentPage1 = new BookPursueFragment();
        BookCommunityFragment fragmentPage2 = new BookCommunityFragment();
        BookFinderFragment fragmentPage3 = new BookFinderFragment();
        fragmentList.add(fragmentPage1);
        fragmentList.add(fragmentPage2);
        fragmentList.add(fragmentPage3);
        viewPager.setAdapter(new BookFragmentAdapter(getSupportFragmentManager(), fragmentList));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                    int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bookPursue.setSelected(true);
                        bookCommunity.setSelected(false);
                        bookFind.setSelected(false);
                        break;
                    case 1:
                        bookPursue.setSelected(false);
                        bookCommunity.setSelected(true);
                        bookFind.setSelected(false);
                        break;
                    case 2:
                        bookPursue.setSelected(false);
                        bookFind.setSelected(true);
                        bookCommunity.setSelected(false);
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
            case R.id.book_like:
                bookPursue.setSelected(true);
                bookCommunity.setSelected(false);
                bookFind.setSelected(false);
                viewPager.setCurrentItem(0);
                break;
            case R.id.book_community:
                bookPursue.setSelected(true);
                bookCommunity.setSelected(true);
                bookFind.setSelected(false);
                viewPager.setCurrentItem(1);
                break;
            case R.id.book_find:
                bookPursue.setSelected(true);
                bookCommunity.setSelected(false);
                bookFind.setSelected(true);
                viewPager.setCurrentItem(2);
                break;
            default:
                break;
        }
    }

    private long lastBackClickTime = 0;

    private void exitBy2Click() {
        if ((System.currentTimeMillis() - lastBackClickTime) > 2000) {
            Toast.makeText(this, "再次点击退出", Toast.LENGTH_SHORT).show();
            lastBackClickTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }
}

package com.example.lovely.lovelybookreader;

import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lovely.lovelybookreader.adapter.BookFragmentAdapter;
import com.example.lovely.lovelybookreader.fragment.BookMainFragmentPage1;
import com.example.lovely.lovelybookreader.fragment.BookMainFragmentPage2;
import com.example.lovely.lovelybookreader.fragment.BookMainFragmentPage3;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener{
    private ViewPager viewPager;
    private TextView bookShelfText;
    private TextView bookText;
    private TextView novelText;
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
        bookShelfText = (TextView) findViewById(R.id.book_shelf);
        bookText = (TextView) findViewById(R.id.book_library);
        novelText = (TextView) findViewById(R.id.book_novel);
        bookShelfText.setOnClickListener(this);
        bookText.setOnClickListener(this);
        novelText.setOnClickListener(this);
        bookShelfText.setBackgroundColor(Color.RED);
    }

    private void initViewPager() {
        fragmentList = new ArrayList<>();
        BookMainFragmentPage1 fragmentPage1 = new BookMainFragmentPage1();
        BookMainFragmentPage2 fragmentPage2 = new BookMainFragmentPage2();
        BookMainFragmentPage3 fragmentPage3 = new BookMainFragmentPage3();
        fragmentList.add(fragmentPage1);
        fragmentList.add(fragmentPage2);
        fragmentList.add(fragmentPage3);
        viewPager.setAdapter(new BookFragmentAdapter(getSupportFragmentManager(),fragmentList));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bookShelfText.setBackgroundColor(Color.RED);
                        bookText.setBackgroundColor(Color.GRAY);
                        novelText.setBackgroundColor(Color.GRAY);
                        break;
                    case 1:
                        bookShelfText.setBackgroundColor(Color.GRAY);
                        bookText.setBackgroundColor(Color.RED);
                        novelText.setBackgroundColor(Color.GRAY);
                        break;
                    case 2:
                        bookShelfText.setBackgroundColor(Color.GRAY);
                        novelText.setBackgroundColor(Color.RED);
                        bookText.setBackgroundColor(Color.GRAY);
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
            case R.id.book_shelf:
                bookShelfText.setBackgroundColor(Color.RED);
                bookText.setBackgroundColor(Color.GRAY);
                novelText.setBackgroundColor(Color.GRAY);
                viewPager.setCurrentItem(0);
                break;
            case R.id.book_library:
                bookShelfText.setBackgroundColor(Color.GRAY);
                bookText.setBackgroundColor(Color.RED);
                novelText.setBackgroundColor(Color.GRAY);
                viewPager.setCurrentItem(1);
                break;
            case R.id.book_novel:
                bookShelfText.setBackgroundColor(Color.GRAY);
                novelText.setBackgroundColor(Color.RED);
                bookText.setBackgroundColor(Color.GRAY);
                viewPager.setCurrentItem(2);
                break;
            default:
                break;
        }
    }

    private long lastBackClickTime = 0;
    private void exitBy2Click() {
        if ((System.currentTimeMillis() - lastBackClickTime) > 2000) {
            Toast.makeText(this,"再次点击退出",Toast.LENGTH_SHORT).show();
            lastBackClickTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }

}

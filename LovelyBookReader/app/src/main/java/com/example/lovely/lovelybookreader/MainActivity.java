package com.example.lovely.lovelybookreader;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.app.AlertDialog;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lovely.lovelybookreader.adapter.BookFragmentAdapter;
import com.example.lovely.lovelybookreader.adapter.SettingAdapter;
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
    private ListView listView;
    private AlertDialog builder;
    private SettingAdapter sa;

    private List<String> listName = new ArrayList<>();
    private List<Integer> listRes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initView();
        builder = new AlertDialog.Builder(this).create();
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
        initListView();
    }

    private void initListView() {
        listName.add("请登录");
        listName.add("我的消息");
        listName.add("同步书架");
        listName.add("扫描本地书籍");
        listName.add("Wifi传书");
        listName.add("意见反馈");
        listName.add("夜间模式");
        listName.add("设置");

        listRes.add(R.drawable.home_menu_0);
        listRes.add(R.drawable.home_menu_1);
        listRes.add(R.drawable.home_menu_2);
        listRes.add(R.drawable.home_menu_3);
        listRes.add(R.drawable.home_menu_4);
        listRes.add(R.drawable.home_menu_5);
        listRes.add(R.drawable.theme_night);
        listRes.add(R.drawable.home_menu_6);


        sa = new SettingAdapter(listRes,listName);
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
            case R.id.book_moreover:
                listView = (ListView) View.inflate(getApplicationContext(),R.layout.book_list_view,null);
                listView.setAdapter(sa);
                builder.setView(listView);
                builder.show();
                setDialogPosition();
                break;
            default:
                break;
        }
    }

    private void setDialogPosition() {
        Window window  = builder.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.RIGHT | Gravity.TOP);
        lp.x = 10;
        lp.y = 100;
        lp.width = 500;
        lp.height = 600;
        window.setAttributes(lp);

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

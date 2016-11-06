package com.example.lovely.lovelybookreader.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lovely.lovelybookreader.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lovely on 16/11/1.
 */

public class BookFinderFragment extends Fragment {

    private ListView listView;
    private List<Integer> findListImage = new ArrayList<>();
    private List<String> findListName = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_main_page_3,null);
        listView = (ListView) view.findViewById(R.id.book_find_list_view);
        initListView();

        return view;
    }

    private void initListView() {
        findListName.clear();
        findListImage.clear();
        findListImage.add(R.drawable.home_find_rank);
        findListImage.add(R.drawable.home_find_topic);
        findListImage.add(R.drawable.home_find_category);
        findListImage.add(R.drawable.home_find_listen);

        findListName.add("排行榜");
        findListName.add("主题菜单");
        findListName.add("分类");
        findListName.add("有声小说");

        listView.setAdapter(new FindAdapter(findListImage, findListName));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("XJL","posistion=====>"+position);
            }
        });
    }

    public class FindAdapter extends BaseAdapter {

        private List<Integer> findListImage;
        private List<String> findListName;

        public FindAdapter(List<Integer> findListImage, List<String> findListName) {
            this.findListImage = findListImage;
            this.findListName = findListName;
        }

        @Override
        public int getCount() {
            return findListName.size();
        }

        @Override
        public Object getItem(int position) {
            return findListName.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = View.inflate(parent.getContext(),R.layout.book_find_list_item,null);
            ImageView imageShow = (ImageView) convertView.findViewById(R.id.book_find_list_image);
            TextView textView = (TextView) convertView.findViewById(R.id.book_find_list_text);
            imageShow.setBackgroundResource(findListImage.get(position));
            textView.setText(findListName.get(position));
            return convertView;
        }
    }
}

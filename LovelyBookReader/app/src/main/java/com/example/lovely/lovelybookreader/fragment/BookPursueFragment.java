package com.example.lovely.lovelybookreader.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.lovely.lovelybookreader.R;

/**
 * Created by lovely on 16/11/1.
 */

public class BookPursueFragment extends Fragment {
    private Button testButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_main_page_1,null);
        testButton = (Button) view.findViewById(R.id.book_button_text);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testButton.setText("aaaaaaa");
            }
        });
        return view;
    }
}

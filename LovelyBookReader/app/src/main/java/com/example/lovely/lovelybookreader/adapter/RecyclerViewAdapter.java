package com.example.lovely.lovelybookreader.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lovely.lovelybookreader.R;
import com.example.lovely.lovelybookreader.data.BookShow;
import com.example.lovely.lovelybookreader.utils.ImageUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lovely on 16/11/2.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    public interface MyItemClickListener{
        void onItemClickListener(BookShow.RecommendBooks books);
    }
    private List<BookShow.RecommendBooks> bookShowList;
    private MyItemClickListener myItemClickListener;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler_view_adapter,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public RecyclerViewAdapter(List<BookShow.RecommendBooks> recommendBooksbookShow, MyItemClickListener myItemClickListener) {
        this.bookShowList = recommendBooksbookShow;
        this.myItemClickListener = myItemClickListener;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.item_book_pict);
        TextView bookName = (TextView) holder.itemView.findViewById(R.id.item_book_name);
        TextView charter = (TextView) holder.itemView.findViewById(R.id.item_book_charter);
        TextView charterName = (TextView) holder.itemView.findViewById(R.id.item_book_charter_name);
        TextView section = (TextView) holder.itemView.findViewById(R.id.item_book_section);
        TextView sectionName = (TextView) holder.itemView.findViewById(R.id.item_book_section_name);
        final BookShow.RecommendBooks book = getItem(position);
        String a = "/agent/";
        new ImageUtils(imageView).execute(book.getCover().replace(a,""));
        Log.i("XJL","url=====>" +book.cover);
        bookName.setText(book.getTitle());
        charter.setText(book.getAuthor());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myItemClickListener.onItemClickListener(book);
            }
        });
    }


    public BookShow.RecommendBooks getItem (int position) {
        return bookShowList.get(position);
    }

    @Override
    public int getItemCount() {
        return bookShowList == null ? 0 : bookShowList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);

        }
    }



}
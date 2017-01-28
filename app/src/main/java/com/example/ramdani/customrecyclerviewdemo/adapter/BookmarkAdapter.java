package com.example.ramdani.customrecyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ramdani.customrecyclerviewdemo.MainActivity;
import com.example.ramdani.customrecyclerviewdemo.R;
import com.example.ramdani.customrecyclerviewdemo.model.Bookmark;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramdani on 28/01/17.
 */

public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.ViewHolder> {

    private Context context;
    private List<Bookmark> mBookmark;

    public BookmarkAdapter(Context context, List<Bookmark> mBookmark) {
        this.context = context;
        this.mBookmark = mBookmark;
    }

    public Context getContext(){
        return context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View bookmarkView = inflater.inflate(R.layout.custom_list_bookmark, parent, false);

        ViewHolder viewHolder = new ViewHolder(bookmarkView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Bookmark bookmark = mBookmark.get(position);

        TextView tvTitleBookmark = holder.titleBookmark;

        tvTitleBookmark.setText(bookmark.getTitle());

    }

    @Override
    public int getItemCount() {
        return mBookmark.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView titleBookmark;
        public TextView labelTag;
        public TextView dateUpdate;

        public ViewHolder(View itemView) {
            super(itemView);

            titleBookmark = (TextView) itemView.findViewById(R.id.tv_title);
            labelTag = (TextView) itemView.findViewById(R.id.tv_tags);
            dateUpdate = (TextView) itemView.findViewById(R.id.tv_date_update);
        }

    }
}

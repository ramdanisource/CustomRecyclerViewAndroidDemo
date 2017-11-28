package com.example.ramdani.customrecyclerviewdemo.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ramdani.customrecyclerviewdemo.R;
import com.example.ramdani.customrecyclerviewdemo.adapter.BookmarkAdapter;
import com.example.ramdani.customrecyclerviewdemo.model.Bookmark;

/**
 * Created by ramdanix on 11/28/17.
 */

public class BookmarkViewHolder extends RecyclerView.ViewHolder {

    public TextView titleBookmark;
    public TextView labelTag;
    public TextView dateUpdate;

    public void bind(final Bookmark item, final BookmarkAdapter.OnBookmarClickListener listener) {
        titleBookmark.setText(item.getTitle());
        labelTag.setText(item.getTag());
        dateUpdate.setText(item.getDateUpdate());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.onItemClick(item);
            }
        });
    }

    public BookmarkViewHolder(View itemView) {
        super(itemView);

        titleBookmark = itemView.findViewById(R.id.tv_title);
        labelTag = itemView.findViewById(R.id.tv_tags);
        dateUpdate = itemView.findViewById(R.id.tv_date_update);
    }
}

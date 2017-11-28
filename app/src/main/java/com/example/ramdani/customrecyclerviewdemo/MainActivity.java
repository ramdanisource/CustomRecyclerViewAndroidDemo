package com.example.ramdani.customrecyclerviewdemo;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ramdani.customrecyclerviewdemo.adapter.BookmarkAdapter;
import com.example.ramdani.customrecyclerviewdemo.adapter.GenericAdapter;
import com.example.ramdani.customrecyclerviewdemo.model.Bookmark;
import com.example.ramdani.customrecyclerviewdemo.viewholder.BookmarkViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "BOOKMARK_CLICK";
    ArrayList<Bookmark> bookmarks;
    Context context = this;

    GenericAdapter<Bookmark,BookmarkViewHolder> bookmarkViewHolderGenericAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instance Recyclerview
        RecyclerView rvBookmark = findViewById(R.id.rv_list_bookmark);

        bookmarks = new ArrayList<>();
        bookmarks.add(new Bookmark("Belajar Java Dasar","Mobile Programming","28 Nov 2017"));
        bookmarks.add(new Bookmark("Belajar Android Dasar","Mobile Programming","28 Nov 2017"));
        bookmarks.add(new Bookmark("Belajar Android Menengah","Mobile Programming","28 Nov 2017"));
        bookmarks.add(new Bookmark("Belajar Android Expert","Mobile Programming","28 Nov 2017"));
        bookmarks.add(new Bookmark("Belajar Kotlin Dasar","Mobile Programming","28 Nov 2017"));
        bookmarks.add(new Bookmark("Belajar Android Dengan Kotlin","Mobile Programming","28 Nov 2017"));
        bookmarks.add(new Bookmark("Belajar React Native","Mobile Programming","28 Nov 2017"));

        //BookmarkAdapter bookmarkAdapter = new BookmarkAdapter(this, bookmarks,bookmarClickListener);

        bookmarkViewHolderGenericAdapter = new GenericAdapter<Bookmark, BookmarkViewHolder>(R.layout.custom_list_bookmark,BookmarkViewHolder.class, Bookmark.class,bookmarks) {
            @Override
            protected void bind(BookmarkViewHolder holder, Bookmark model) {
                holder.bind(model, bookmarClickListener);
            }
        };

        //set adapter
        rvBookmark.setAdapter(bookmarkViewHolderGenericAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        //set Devider
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvBookmark.getContext(), linearLayoutManager.getOrientation());

        //set layout
        rvBookmark.setLayoutManager(linearLayoutManager);

        //devider
        rvBookmark.addItemDecoration(dividerItemDecoration);

    }

    BookmarkAdapter.OnBookmarClickListener bookmarClickListener = new BookmarkAdapter.OnBookmarClickListener() {
        @Override
        public void onItemClick(Bookmark item) {
            Log.d(TAG, "bookmark click: "+item.getTitle());
            String detailBookmark = item.getTitle()+"\n"+item.getTag()+"\n"+item.getDateUpdate();
            alert(detailBookmark);
        }
    };

    public void alert(String pesan){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        // set title
        alertDialogBuilder.setTitle(pesan);

        // set dialog message
        alertDialogBuilder
                .setTitle("Detail Bookmark")
                .setMessage(pesan)
                .setCancelable(true)
                .setPositiveButton("done",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }
}

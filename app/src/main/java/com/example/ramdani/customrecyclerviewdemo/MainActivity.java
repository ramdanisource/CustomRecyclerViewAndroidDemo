package com.example.ramdani.customrecyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ramdani.customrecyclerviewdemo.adapter.BookmarkAdapter;
import com.example.ramdani.customrecyclerviewdemo.model.Bookmark;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Bookmark> bookmarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instance Recyclerview
        RecyclerView rvBookmark = (RecyclerView) findViewById(R.id.rv_list_bookmark);

        bookmarks = Bookmark.createBookmarkList(50);

        BookmarkAdapter bookmarkAdapter = new BookmarkAdapter(this, bookmarks);

        //set adapter
        rvBookmark.setAdapter(bookmarkAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        //set Devider
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvBookmark.getContext(), linearLayoutManager.getOrientation());

        //set layout
        rvBookmark.setLayoutManager(linearLayoutManager);

        //devider
        rvBookmark.addItemDecoration(dividerItemDecoration);



    }
}

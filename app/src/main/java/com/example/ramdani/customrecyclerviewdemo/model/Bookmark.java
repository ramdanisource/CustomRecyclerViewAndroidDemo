package com.example.ramdani.customrecyclerviewdemo.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ramdani on 28/01/17.
 */

public class Bookmark {

    private String title;
    private String tag;
    private String dateUpdate;

    public Bookmark(String title) {
        this.title = title;
    }

    public Bookmark(String title, String tag, String dateUpdate) {
        this.title = title;
        this.tag = tag;
        this.dateUpdate = dateUpdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public static int lastBookmarkId = 0;

    public static ArrayList<Bookmark> createBookmarkList(int numBookmark){

        ArrayList<Bookmark> bookmarks = new ArrayList<Bookmark>();

        for (int i = 1; i<= numBookmark; i++){
            bookmarks.add(new Bookmark("Ini Bookmark "+ ++lastBookmarkId));
        }

        return bookmarks;

    }
}

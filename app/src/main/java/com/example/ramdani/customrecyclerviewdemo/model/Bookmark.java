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

    public String getDateUpdate() {
        return dateUpdate;
    }


}

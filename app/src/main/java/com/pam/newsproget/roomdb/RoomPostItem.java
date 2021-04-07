package com.pam.newsproget.roomdb;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.pam.newsproget.model.Content;
import com.pam.newsproget.model.Excerpt;
import com.pam.newsproget.model.Guid;
import com.pam.newsproget.model.Links;
import com.pam.newsproget.model.PostItem;
import com.pam.newsproget.model.Title;

import java.util.Date;
import java.util.List;

@Entity
public class RoomPostItem {
    @PrimaryKey
    int id;
    String date;
    String title;
    String content;

    public RoomPostItem() {
    }

    public RoomPostItem(PostItem postItem) {
        this.id = postItem.getId();
        this.date = postItem.getDate().toString();
        this.title = postItem.getTitle().getRendered();
        this.content = postItem.getContent().getRendered();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

package com.pam.newsprojet.roomdb;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PostDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertPosts(List<RoomPostItem> post);

    @Query("select * from RoomPostItem")
    List<RoomPostItem> getallPosts();
}

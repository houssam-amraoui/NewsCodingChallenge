package com.pam.newsproget.roomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.pam.newsproget.model.PostItem;


@Database(entities = {RoomPostItem.class},version = 1,exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    private static RoomDB instance;
    public abstract PostDao postDao();

    public static synchronized RoomDB getInstance(Context context){
        if (instance == null)
            instance= Room.databaseBuilder(context, RoomDB.class,"mydbname").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        return instance;
    }

}

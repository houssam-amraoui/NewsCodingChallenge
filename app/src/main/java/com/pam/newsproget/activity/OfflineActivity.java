package com.pam.newsproget.activity;

import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.pam.newsproget.R;
import com.pam.newsproget.roomdb.RoomDB;
import com.pam.newsproget.roomdb.RoomPostItem;

import java.util.List;

public class OfflineActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView titles;
    RoomDB room;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_offline);
        toolbar = findViewById(R.id.toolbar);
        titles = findViewById(R.id.titles);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        room =  RoomDB.getInstance(this);
        StringBuilder stringBuilder = new StringBuilder();

        List<RoomPostItem> list = room.postDao().getallPosts();
        for (RoomPostItem item:list)
            stringBuilder.append(item.getTitle()+"\n\n");



        titles.setText(stringBuilder.toString());

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}

package com.pam.newsproget.activity;

import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.pam.newsproget.R;

public class ContentActivity extends AppCompatActivity {
    Toolbar toolbar;

    TextView title, time, categaory, content;
    ImageView image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_content);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");


        title = findViewById(R.id.title);
        time = findViewById(R.id.time);
        categaory = findViewById(R.id.categaory);
        content = findViewById(R.id.content);
        image = findViewById(R.id.imagepost);


        title.setText(getIntent().getStringExtra("title"));
        content.setText(Html.fromHtml(getIntent().getStringExtra("description")));
        categaory.setText(getIntent().getStringExtra("category"));
        time.setText(getIntent().getStringExtra("pubDate"));


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

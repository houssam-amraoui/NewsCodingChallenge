package com.pam.newsproget.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pam.newsproget.R;
import com.pam.newsproget.adapters.Adapter;
import com.pam.newsproget.model.PostItem;
import com.pam.newsproget.retrefit.ApiClient;
import com.pam.newsproget.roomdb.RoomDB;
import com.pam.newsproget.roomdb.RoomPostItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    int mPage = 1;
    boolean isLastPage = false;
    boolean isLoading = false;
    RecyclerView recyclerView;
    Adapter adapter;

    RoomDB room;
    ImageView offline;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rev);
        adapter = new Adapter(this);
        room =  RoomDB.getInstance(this);
        offline = findViewById(R.id.offline);
        offline.setOnClickListener(v -> {
            startActivity(new Intent(this,OfflineActivity.class));
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                int countItem = recyclerView.getLayoutManager().getItemCount();

                int lastVisiblePosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
                if (!isLastPage)
                    if (lastVisiblePosition != 0 && !isLoading && countItem - 1 == lastVisiblePosition) {
                        isLoading = true;
                        mPage++;
                        loadProducts();
                    }
            }

        });
        loadProducts();
    }

    private void loadProducts() {
        if (isNetworkAvailable()) {
            ApiClient.getInterface().getposts(1).enqueue(new Callback<List<PostItem>>() {
                @Override
                public void onResponse(@NonNull Call<List<PostItem>> call, @NonNull Response<List<PostItem>> response) {
                    if (mPage == 1) {
                        adapter.clearItems();
                        List<RoomPostItem> list = new ArrayList<>();

                        for (PostItem postItem:response.body())
                            list.add( new RoomPostItem(postItem));

                        room.postDao().insertPosts(list);

                    }
                    isLoading = false;
                    if (response.body() != null || !response.body().isEmpty()) {
                        adapter.addItems(response.body());
                    } else {
                        isLastPage = true;
                    }
                }

                @Override
                public void onFailure(Call<List<PostItem>> call, Throwable t) {
                    if (mPage == 1) {
                        adapter.clearItems();
                    }
                }
            });
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}

package com.pam.newsprojet.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.pam.newsprojet.R;
import com.pam.newsprojet.activity.ContentActivity;
import com.pam.newsprojet.model.PostItem;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Adapter extends RecyclerView.Adapter<Adapter.bodiholder> {

    private Context context;
    private List<PostItem> postItems = new ArrayList<>();

    private SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy", new Locale("ar", "ma"));
    private SimpleDateFormat dateFormatcontent = new SimpleDateFormat("dd/MM/yyyy - hh:mm", new Locale("ar", "ma"));


    public Adapter(Context context) {
        this.context = context;
    }

    @NotNull
    @Override
    public bodiholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new bodiholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final bodiholder holder, int position) {

        holder.t1.setText(postItems.get(position).getTitle().getRendered());
        holder.t2.setText(dateFormat.format(postItems.get(position).getDate()));

        holder.categaory.setText(postItems.get(position).getCategories().get(0) + "");

        //Glide.with(context).load(postItems.get(position).getimg).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.image);

       // holder.itemView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.bounce));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            int position = holder.getAdapterPosition();

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, ContentActivity.class);
                intent.putExtra("description", postItems.get(position).getContent().getRendered());
                intent.putExtra("title", postItems.get(position).getTitle().getRendered());
                intent.putExtra("pubDate", dateFormatcontent.format(postItems.get(position).getDate()));
                intent.putExtra("category", postItems.get(position).getCategories().get(0) + "");
                context.startActivity(intent);
            }

        });
    }


    @Override
    public int getItemCount() {
        return postItems.size();
    }

    public void clearItems() {
        postItems.clear();
        notifyDataSetChanged();
    }

    public void addItems(List<PostItem> items) {
        postItems.addAll(items);
        notifyDataSetChanged();
    }



    static class bodiholder extends RecyclerView.ViewHolder {
        TextView t1, t2, categaory;
        ImageView image;
        CardView card;

        bodiholder(View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.title);
            t2 = itemView.findViewById(R.id.time);
            categaory = itemView.findViewById(R.id.categaory);
            image = itemView.findViewById(R.id.imagepost);
            card = itemView.findViewById(R.id.cardcategaory);

        }
    }

}

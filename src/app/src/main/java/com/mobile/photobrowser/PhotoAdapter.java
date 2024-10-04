package com.mobile.photobrowser;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// PhotoAdapter.java
public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {
    private List<String> photoUrls;
    private Context context;

    public PhotoAdapter(List<String> photoUrls, Context context) {
        this.photoUrls = photoUrls;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_photo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String photoUrl = photoUrls.get(position);
        // Load the photo thumbnail using Glide or Picasso
        Glide.with(context).load(photoUrl).into(holder.imageView);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, PhotoDetailActivity.class);
            intent.putExtra("photoUrl", photoUrl);
            context.startActivity(intent);
        });

//        holder.itemView.setOnClickListener(v -> {
//            lastSelectedPosition = holder.getAdapterPosition();
//            Intent intent = new Intent(context, PhotoDetailActivity.class);
//            intent.putExtra("photoUrl", photoUrl);
//            context.startActivity(intent);
//        });
    }

    @Override
    public int getItemCount() {
        return photoUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}


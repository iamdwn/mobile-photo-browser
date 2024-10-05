package com.mobile.photobrowser;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bumptech.glide.Glide;


public class PhotoDetailActivity extends AppCompatActivity {
    private ImageView photoDetailView;

    private int lastSelectedPosition = -1;
//    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);

        photoDetailView = findViewById(R.id.photoDetailView);

        // Get the photo URL from the intent
        String photoUrl = getIntent().getStringExtra("photoUrl");

        // Load the photo using Glide
        Glide.with(this).load(photoUrl).into(photoDetailView);

        //Back to home
        Button homeBtn = findViewById(R.id.btn_home);

        homeBtn.setOnClickListener(v -> {
           finish();
        });
    }
}
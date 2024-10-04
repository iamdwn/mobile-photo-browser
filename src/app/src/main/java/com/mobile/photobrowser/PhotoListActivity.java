package com.mobile.photobrowser;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class PhotoListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PhotoAdapter adapter;
    private List<String> photoUrls;
    private int lastSelectedPosition = -1;
//    private RecyclerView recyclerView;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("lastPosition", lastSelectedPosition);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lastSelectedPosition = savedInstanceState.getInt("lastPosition", -1);
        // Scroll to the last position
        if (lastSelectedPosition != -1) {
            recyclerView.scrollToPosition(lastSelectedPosition);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Scroll to the saved position when returning
        if (lastSelectedPosition != -1) {
            recyclerView.scrollToPosition(lastSelectedPosition);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample data, replace with real photo URLs
        photoUrls = Arrays.asList("https://i.pinimg.com/474x/46/03/69/460369516d71d50fa3dd43a0c1ef9c4b.jpg",
                "https://sanphamtot.vn/wp-content/uploads/2022/11/meme-meo-khoc-28.jpg",
                "https://m.media-amazon.com/images/I/51y8GUVKJoL.jpg",
                "https://creatorset.com/cdn/shop/files/Screenshot_2024-04-24_173231_2048x2048.png?v=1713973029",
                "https://static.wikia.nocookie.net/14116e91-7e5d-4bc4-b730-e3b593a12832",
                "https://ih1.redbubble.net/image.5191178205.2942/raf,360x360,075,t,fafafa:ca443f4786.jpg"
                        );

        adapter = new PhotoAdapter(photoUrls, this);
        recyclerView.setAdapter(adapter);
    }
}
package com.example.mymusicapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Song_Bottom_Nav extends AppCompatActivity {
    private BottomNavigationView mNavView;
    private FrameLayout mMainFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_each_song);
        mMainFrame = (FrameLayout) findViewById(R.id.song_main_frame);
        mNavView = (BottomNavigationView) findViewById(R.id.navigationView);

        mNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_favorites:
                        Toast.makeText(getApplicationContext(),"Favourites",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.navigation_previous_song:
                        Toast.makeText(getApplicationContext(),"Previous Song",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.navigation_play:
                        Toast.makeText(getApplicationContext(),"Play Song",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.navigation_next:
                        Toast.makeText(getApplicationContext(),"Next song",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.navigation_share:
                        Toast.makeText(getApplicationContext(),"Share",Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;

                }
            }
    });
}
}

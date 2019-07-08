package com.example.mymusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SheeranSongs extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheeran_songs);

        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Castle On The Hill", "Ed Sheeran",R.raw.castle_on_the_hill, R.drawable.divide));
        songs.add(new Song("How Would You Feel", "Ed Sheeran",R.raw.how_would_you_feel,R.drawable.divide));
        songs.add(new Song("Eraser","Ed Sheeran",R.raw.eraser,R.drawable.divide));


        SongAdaptor adapter = new SongAdaptor(this, songs);


        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter); listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = songs.get(position);

                mediaPlayer = MediaPlayer.create(SheeranSongs.this, song.getmAudioResourceId());

                mediaPlayer.start();

            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();
    }



}


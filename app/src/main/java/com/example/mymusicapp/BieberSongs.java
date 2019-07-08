package com.example.mymusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BieberSongs extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener mCompleteListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bieber_songs);

        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Love Yourself", "Justin Bieber",R.raw.love_yourself, R.drawable.purpose));


        SongAdaptor adapter = new SongAdaptor(this, songs);


        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter); listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = songs.get(position);

                releaseMediaPlayer();

                mediaPlayer = MediaPlayer.create(BieberSongs.this, song.getmAudioResourceId());

                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(mCompleteListener);
            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}

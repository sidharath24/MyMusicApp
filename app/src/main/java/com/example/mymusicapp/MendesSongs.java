package com.example.mymusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MendesSongs extends AppCompatActivity {
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
        setContentView(R.layout.activity_mendes_songs);

        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("treat You Better", "Shawn Mendes",R.raw.treat_you_better, R.drawable.treat_you_better));


        SongAdaptor adapter = new SongAdaptor(this, songs);


        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter); listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = songs.get(position);

                releaseMediaPlayer();

                mediaPlayer = MediaPlayer.create(MendesSongs.this, song.getmAudioResourceId());

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

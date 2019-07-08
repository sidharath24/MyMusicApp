package com.example.mymusicapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class SongAdaptor extends ArrayAdapter<Song> {

    public SongAdaptor(Context context, ArrayList<Song> songs) {
        super(context, 0, songs);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
      /*  TextView textView = listItemView.findViewById(android.R.id.text1);
        textView.setTextColor(getResources().getColor(R.color.colorAccent));*/
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Song currentSong = getItem(position);

        TextView songNameTextView = (TextView) listItemView.findViewById(R.id.song_text_view);
        songNameTextView.setText(currentSong.getmSongName());

        TextView singerNameTextView = (TextView) listItemView.findViewById(R.id.singer_text_view);

        singerNameTextView.setText(currentSong.getmSongArtist());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this word or not
        if (currentSong.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentSong.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}

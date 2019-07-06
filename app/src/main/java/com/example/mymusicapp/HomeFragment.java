package com.example.mymusicapp;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.zip.Inflater;

public class HomeFragment extends Fragment{
    private ImageView edSheeranSongs, justinBieberSongs, shawnMendesSongs;
    private Context context;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        edSheeranSongs = view.findViewById(R.id.ed_sheeran);
        justinBieberSongs = view.findViewById(R.id.justin_bieber);
        shawnMendesSongs = view.findViewById(R.id.shawn_mendes);

        edSheeranSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SheeranSongs.class);
                startActivity(intent);
            }
        });

        justinBieberSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BieberSongs.class);
                startActivity(intent);
            }
        });

        shawnMendesSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MendesSongs.class);
                startActivity(intent);
            }
        });
        return view;
    }
}


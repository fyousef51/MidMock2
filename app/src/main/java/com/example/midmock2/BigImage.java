package com.example.midmock2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

public class BigImage extends AppCompatActivity {

    MediaPlayer mpsound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_image);

        mpsound = new MediaPlayer();

        mpsound = MediaPlayer.create(this, R.raw.track1);
        mpsound.start();

    }
}
package com.example.songgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // hello sherry
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.keep_on);
        mediaPlayer.start(); // no need to call prepare(); create() does that for you
    }
}
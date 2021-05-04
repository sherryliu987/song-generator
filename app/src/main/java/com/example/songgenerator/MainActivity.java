package com.example.songgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // hello sherry
         mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.keep_on);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start(); // no need to call prepare(); create() does that for you
    }
}
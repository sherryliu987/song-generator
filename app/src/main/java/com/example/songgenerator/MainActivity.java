package com.example.songgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    boolean note1 = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // hello sherry
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.note1);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.reset();
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.note2);
//                try {
//                    String path = "android.resource://" + getPackageName() + "/" + R.raw.note2;
//                    mediaPlayer.setDataSource(path);
//                    System.out.println("WORKOOOOOOOOOOOOO");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    System.out.println("NO WORKOOOOOOOOOO");
//                }
                mediaPlayer.start();
            }
        });
    }
    //hiiii
    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();

//            if(note1){
//
//            }else{
//                try {
//                    mediaPlayer.setDataSource(String.valueOf(R.raw.note2));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            note1 = !note1;
//            mediaPlayer.start(); // no need to call prepare(); create() does that for you
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

}
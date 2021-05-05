package com.example.songgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String sequence = "";
    int[] notes = {R.raw.note1, R.raw.note2};
    int i = 0;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // hello sherry

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.note1);

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                System.out.println("FINISHED PLAYING DA NOTEEEEE");
                mediaPlayer.reset();
                i++;
                if(i < sequence.length()){
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), notes[(sequence.charAt(i) - 'a') % 2]);
                    mediaPlayer.start();
                }
            }
        });

    }

    public void playSong(View view){

        final EditText edit =  (EditText) findViewById(R.id.textInputEditText);
        sequence = (String) edit.getText().toString();
        sequence = sequence.toLowerCase();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), notes[(sequence.charAt(i) - 'a') % 2]);
        mediaPlayer.start();
    }

//    //hiiii
//    @Override
//    protected void onResume() {
//        super.onResume();
//        mediaPlayer.start();
//        }

}
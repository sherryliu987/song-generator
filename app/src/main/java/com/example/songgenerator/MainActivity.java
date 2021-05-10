package com.example.songgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.text.BreakIterator;
import java.util.concurrent.TimeUnit;

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
        TextView newtext = (TextView) findViewById(R.id.songText);
        newtext.setText("Most recent song-text");

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
        // TextView newtext = (TextView) findViewById(R.id.songText);
        final EditText edit =  (EditText) findViewById(R.id.textInputEditText);
        String sequence = (String) edit.getText().toString();
        sequence = sequence.toLowerCase();
        if (sequence.length()>0) {
            TextView seqtext = findViewById(R.id.songText);
            seqtext.setText(sequence);
            for (int j=0; j<sequence.length(); j++) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), notes[(sequence.charAt(j) - 'a') % 2]);
                mediaPlayer.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }

    }

//    //hiiii
//    @Override
//    protected void onResume() {
//        super.onResume();
//        mediaPlayer.start();
//        }

}
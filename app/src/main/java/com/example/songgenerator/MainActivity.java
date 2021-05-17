package com.example.songgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.text.BreakIterator;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    String sequence = "";
    int[] notes = {R.raw.c,R.raw.d,R.raw.e,R.raw.f,R.raw.g,R.raw.a,R.raw.b, R.raw.bird_honk};
    int i = 0;
    char[] notenames = {'C', 'D', 'E', 'F', 'G', 'A','B', '!'};

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView newtext = (TextView) findViewById(R.id.songText);
        newtext.setText("Most recent song-text");

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.a);

    }

    public void playSong(View view) {
        final EditText edit =  (EditText) findViewById(R.id.textInputEditText);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.a);
        String sequence = (String) edit.getText().toString();
        sequence = sequence.toLowerCase();
        if (sequence.length()>0) {
            TextView seqtext = findViewById(R.id.songText);
            String actualNotes = "";
            for (int j=0; j<sequence.length(); j++) {
                double randNum = Math.random();
                if(randNum < 0.1){
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), notes[7]);
                    actualNotes+=notenames[7];
                }else{
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), notes[Math.abs(sequence.charAt(j) - 'a') % 7]);
                    actualNotes+=notenames[Math.abs(sequence.charAt(j) - 'a') % 7];
                }
                mediaPlayer.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
            seqtext.setText(actualNotes);
        }

        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;

    }

}
package com.example.thefirst100;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class WinnerActivity extends AppCompatActivity {
    String WinnerName;
    TextView PlayerNameCong;
    Button newGameCong;
    int choice = ThreadLocalRandom.current().nextInt(1, 3);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        if (choice==1){
            final MediaPlayer mediaPlayer =  MediaPlayer.create(this , R.raw.hdidwhogra);
            mediaPlayer.start();
        } else if (choice==2){
            final MediaPlayer media =  MediaPlayer.create(this , R.raw.skty);
            media.start();
        } else {
            final MediaPlayer mediaPlayer =  MediaPlayer.create(this , R.raw.hdidwhogra);
            mediaPlayer.start();
        }
        init();
        PlayerNameCong.setText(WinnerName);
        newGameCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WinnerActivity.this , MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
    public void init(){
        WinnerName = getIntent().getStringExtra("WinnerName");
        PlayerNameCong = findViewById(R.id.PlayerNameCong);
        newGameCong = findViewById(R.id.newGameCong);
    }
    @Override
    public void onBackPressed() {
        Intent ii = new Intent(WinnerActivity.this , MainActivity.class);
        startActivity(ii);
        finish();
    }
}
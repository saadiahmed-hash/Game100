package com.example.thefirst100;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.MutableLong;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

public class GameActivity extends AppCompatActivity {

    TextView Player1Name, Player2Name, RecordingScore1, RecordingScore2, TotalPonintPlayer2, TotalPonintPlayer1;
    ImageView DiceResuLte;
    public ConstraintLayout RollBtnPlayer2, RollBtnPlayer1, Player2Zone, Player1Zone, HoldPlayer2, HoldPlayer1;
    public Button NewGameBtn;
    public MutableLong ScoreDice1 = new MutableLong(0);
    public MutableLong ScoreDice2 = new MutableLong(0);
    public MutableLong TotalScore1 = new MutableLong(0);
    public MutableLong TotalScore2 = new MutableLong(0);
    public String FirstPlayerName;
    public String SecondPlayerName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        init();


        Player1Name.setText(FirstPlayerName);
        Player2Name.setText(SecondPlayerName);
        RollBtnPlayer1.setClickable(false);
        // Roll btn Player 2
        RollBtnPlayer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RollBtnPlayer2.setClickable(false);
                rotateDice();
                RollDiceImage(RollBtnPlayer2, RollBtnPlayer1, Player2Zone, Player1Zone, ScoreDice2, ScoreDice1, HoldPlayer2, HoldPlayer1);
                RecordingScore2.setText(String.valueOf(ScoreDice2.value));
            }
        });
        HoldPlayer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HoldPlayer2.setClickable(false);
                holdDice(HoldPlayer2, HoldPlayer1, TotalPonintPlayer2, TotalScore2, ScoreDice2, RecordingScore2, SecondPlayerName);
                RollBtnPlayer1.setVisibility(View.VISIBLE);
                RollBtnPlayer1.setClickable(true);
                RollBtnPlayer2.setVisibility(View.INVISIBLE);
            }
        });


        RollBtnPlayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RollBtnPlayer1.setClickable(false);
                rotateDice();
                RollDiceImage(RollBtnPlayer1, RollBtnPlayer2, Player1Zone, Player2Zone, ScoreDice1, ScoreDice2, HoldPlayer1, HoldPlayer2);
                RecordingScore1.setText(String.valueOf(ScoreDice1.value));
            }
        });

        HoldPlayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HoldPlayer1.setClickable(false);
                holdDice(HoldPlayer1, HoldPlayer2, TotalPonintPlayer1, TotalScore1, ScoreDice1, RecordingScore1, FirstPlayerName);
                RollBtnPlayer2.setVisibility(View.VISIBLE);
                RollBtnPlayer2.setClickable(true);
                RollBtnPlayer1.setVisibility(View.INVISIBLE);
            }
        });
        NewGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });
    }

    private void init() {

        FirstPlayerName = getIntent().getStringExtra("firstNamePlayer");
        SecondPlayerName = getIntent().getStringExtra("secondNamePlayer");
        Player1Name = findViewById(R.id.Player1Name);
        Player2Name = findViewById(R.id.Player2Name);

        DiceResuLte = findViewById(R.id.DiceResuLte);
        RollBtnPlayer2 = findViewById(R.id.RollPlayer2);
        RollBtnPlayer1 = findViewById(R.id.RollPlayer1);
        Player2Zone = findViewById(R.id.Player2Zone);
        Player1Zone = findViewById(R.id.Player1Zone);


        RecordingScore1 = findViewById(R.id.RecordingScore1);
        RecordingScore2 = findViewById(R.id.RecordingScore2);
        ScoreDice1.value = 0;
        ScoreDice2.value = 0;
        RecordingScore1.setText(String.valueOf(ScoreDice1.value));
        RecordingScore2.setText(String.valueOf(ScoreDice2.value));
        TotalScore1.value = 0;
        TotalScore2.value = 0;
        HoldPlayer2 = findViewById(R.id.HoldPlayer2);
        HoldPlayer1 = findViewById(R.id.HoldPlayer1);
        TotalPonintPlayer2 = findViewById(R.id.TotalPonintPlayer2);
        TotalPonintPlayer1 = findViewById(R.id.TotalPonintPlayer1);
        TotalPonintPlayer1.setText("Current : " + String.valueOf(TotalScore1.value));
        TotalPonintPlayer2.setText("Current : " + String.valueOf(TotalScore2.value));
        NewGameBtn = findViewById(R.id.NewGameBtn);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void RollDiceImage(ConstraintLayout RollBtnClicked, ConstraintLayout RollBtnWaiting, ConstraintLayout ZoneClicked, ConstraintLayout ZoneWating, MutableLong ScoreDiceClicked, MutableLong ScoreDiceWaiting, ConstraintLayout HoldClicked, ConstraintLayout HoldWaiting) {

        int NumberDice = ThreadLocalRandom.current().nextInt(1, 7);

        switch (NumberDice) {
            case 1:
                final MediaPlayer mediaPlayer = MediaPlayer.create(this , R.raw.laugh);
                mediaPlayer.start();
                DiceResuLte.setImageDrawable(getDrawable(R.drawable.dice1));
                RollBtnClicked.setClickable(false);
                RollBtnWaiting.setClickable(true);
                ZoneClicked.setBackgroundResource(R.color.SleepPlayer);
                ZoneWating.setBackgroundResource(R.color.ActivePlayer);
                RollBtnClicked.setVisibility(View.INVISIBLE);
                RollBtnWaiting.setVisibility(View.VISIBLE);
                HoldClicked.setVisibility(View.INVISIBLE);
                HoldWaiting.setVisibility(View.VISIBLE);
                ScoreDiceClicked.value = 0;
                ScoreDiceWaiting.value = 0;
                break;
            case 2:

                DiceResuLte.setImageDrawable(getDrawable(R.drawable.dice2));
                RollBtnClicked.setClickable(true);
                ScoreDiceClicked.value += 2;
                break;
            case 3:
                DiceResuLte.setImageDrawable(getDrawable(R.drawable.dice3));
                RollBtnClicked.setClickable(true);
                ScoreDiceClicked.value += 3;
                break;
            case 4:
                DiceResuLte.setImageDrawable(getDrawable(R.drawable.dice4));
                RollBtnClicked.setClickable(true);
                ScoreDiceClicked.value += 4;
                break;
            case 5:
                DiceResuLte.setImageDrawable(getDrawable(R.drawable.dice5));
                RollBtnClicked.setClickable(true);
                ScoreDiceClicked.value += 5;
                break;
            case 6:
                DiceResuLte.setImageDrawable(getDrawable(R.drawable.dice6));
                RollBtnClicked.setClickable(true);
                ScoreDiceClicked.value += 6;
                break;

        }
    }
    @SuppressLint("SetTextI18n")
    public void holdDice(ConstraintLayout holdClickede, ConstraintLayout holdWaiting, TextView CurrentScore, MutableLong totalScoreClicked, MutableLong minScoreClicked, TextView minTextViewScore, String WinnerName) {
        totalScoreClicked.value += minScoreClicked.value;
        minScoreClicked.value = 0;
        CurrentScore.setText("Current :  " + String.valueOf(totalScoreClicked.value));
        if (totalScoreClicked.value >= 100) {
            Intent i = new Intent(GameActivity.this, WinnerActivity.class);
            i.putExtra("WinnerName", WinnerName);
            startActivity(i);
            finish();
        }
        holdClickede.setVisibility(View.INVISIBLE);
        holdWaiting.setVisibility(View.VISIBLE);
        holdClickede.setClickable(true);
        minTextViewScore.setText(String.valueOf(minScoreClicked.value));
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void rotateDice() {
        //DiceResuLte

        final MediaPlayer mediaPlayer = MediaPlayer.create(this ,R.raw.sound);
        mediaPlayer.start();

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotate);
        RollBtnPlayer1.setClickable(false);
        RollBtnPlayer2.setClickable(false);
        DiceResuLte.startAnimation(anim);
        DiceResuLte.setImageDrawable(getDrawable(R.drawable.dice1));
        DiceResuLte.startAnimation(anim);
        DiceResuLte.setImageDrawable(getDrawable(R.drawable.dice2));
        DiceResuLte.startAnimation(anim);
        DiceResuLte.setImageDrawable(getDrawable(R.drawable.dice3));
        DiceResuLte.startAnimation(anim);
        DiceResuLte.setImageDrawable(getDrawable(R.drawable.dice4));
        DiceResuLte.startAnimation(anim);
        DiceResuLte.setImageDrawable(getDrawable(R.drawable.dice5));
        DiceResuLte.startAnimation(anim);
        DiceResuLte.setImageDrawable(getDrawable(R.drawable.dice6));
        DiceResuLte.startAnimation(anim);
        RollBtnPlayer1.setClickable(true);
        RollBtnPlayer2.setClickable(true);

    }
}

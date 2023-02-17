package com.example.thefirst100;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button StartBtn;
    EditText SecondPlayerName , FirstPlayerName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initialization();
           StartBtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if (checkFields()){
                       Intent i = new Intent(MainActivity.this, GameActivity.class);
                       i.putExtra("firstNamePlayer" , FirstPlayerName.getText().toString());
                       i.putExtra("secondNamePlayer" , SecondPlayerName.getText().toString());
                       startActivity(i);
                   }
                   //finish();
               }
           });
    }
    private void initialization() {
        StartBtn = findViewById(R.id.StartBtn);
        FirstPlayerName = findViewById(R.id.FirstPlayerName);
        SecondPlayerName = findViewById(R.id.SecondPlayerName);
    }

    private boolean checkFields() {
        if (FirstPlayerName.getText().toString().isEmpty()) {
            FirstPlayerName.setText("Player1");
        }
        if (SecondPlayerName.getText().toString().isEmpty()){
            SecondPlayerName.setText("Player2");
        }
         if (FirstPlayerName.getText().toString().length() >7){
            FirstPlayerName.setError("Put the first player name and under of 8 letters please !");
            return false;
        } else if (SecondPlayerName.getText().toString().length() >7) {
            SecondPlayerName.setError("Put the second player name and under of 8 letters please !");
            return false;
        } else {
            return true;
        }
    }
}
package com.example.thefirst100;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class splashAcitivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_acitivity);

        //  Thread thread = new Thread( new Runnable() {
        //        @Override
        //        public void run() {
        //            try
        //            {
        //                   Thread.sleep(3000);
        //
        //                }
        //                Intent intent = new Intent(1stActivity.this, SecondActivity.class);
        //                startActivity(intent);
        //            }
        //            catch (Exception e) {
        //                e.printStackTrace();
        //            }
        //            finally {
        //                finish();
        //            }
        //        }
        //    });
        //
        //    thread.start();

    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
                Intent i = new Intent(splashAcitivity.this , MainActivity.class);
                startActivity(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                finish();
            }

        }
    });
        thread.start();
    }
}
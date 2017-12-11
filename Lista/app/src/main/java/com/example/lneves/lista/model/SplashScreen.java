package com.example.lneves.lista.model;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lneves.lista.ListActivity;
import com.example.lneves.lista.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showList();
            }
        },5000);

    }
    private void showList(){
        Intent intent = new Intent(SplashScreen.this, ListActivity.class);
        startActivity(intent);
        finish();
    }
}

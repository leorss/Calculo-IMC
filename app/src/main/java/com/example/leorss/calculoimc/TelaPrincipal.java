package com.example.leorss.calculoimc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class TelaPrincipal extends AppCompatActivity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telaprincipal);

        Handler handler = new Handler();
        handler.postDelayed(this, 2000);

    }

    @Override
    public void run(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}

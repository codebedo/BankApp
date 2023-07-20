package com.h5200026_bedirhan_aydin_bankacilik_uygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        // Ekranın 3 saniye gösterdikten sonra giris ekranına geçiş yapacak
        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{

                    Intent intent = new Intent(splash.this, giris_ekrani.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timerThread.start();
    }
}
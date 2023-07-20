package com.h5200026_bedirhan_aydin_bankacilik_uygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.Set;

public class giris_ekrani extends AppCompatActivity {
    // butonları tanımladık
    Button b1, b2, b3;
    FrameLayout qrkd, bsv, dvz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giris_ekrani);
        // Butonların layout dosyasındaki idlerine atama yaptık.
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        qrkd = findViewById(R.id.qrQode);
        bsv = findViewById(R.id.bsv);


        // On click methodu ile Bı butonna tıkalama özelliği verdik ve login ekranına geçiş yapmasını sağladık
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //intent fonksiyounu  ile
                //
                Intent gecisYap = new Intent(giris_ekrani.this, login.class);
                startActivity(gecisYap);
            }
        });

        // On click methodu ile B2 butonna tıkalama özelliği verdik ve Ticari giris ekranına geçiş yapmasını sağladık
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent fonksiyounu  ile Ticari giris ekranına geçiş yapmasını sağladık

                startActivity(new Intent(giris_ekrani.this, TicariGiris.class));
            }
        });
        //On click methodu ile B3 butona tıklama özelliği verdik ve Musteri olmak istiyorum ekranına geçiş yapmasını sağladık
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // intent fonksiyonu ile Musteri olmak istiyorum ekranına geöiş yapmasını sağladık
                startActivity(new Intent(giris_ekrani.this, Musteriolmkistiyorum.class));
            }
        });

        qrkd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(giris_ekrani.this, qrCode.class));
            }
        });

       
    }
}
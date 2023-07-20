package com.h5200026_bedirhan_aydin_bankacilik_uygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class İslemMenusu extends AppCompatActivity {
Button Fatura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);


        Fatura.findViewById(R.id.Fatura);

        Fatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(İslemMenusu.this, fatura.class));
            }
        });
    }
}
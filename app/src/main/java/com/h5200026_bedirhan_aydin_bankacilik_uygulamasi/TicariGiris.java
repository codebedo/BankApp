package com.h5200026_bedirhan_aydin_bankacilik_uygulamasi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TicariGiris extends AppCompatActivity {
    // Butonları ve textviewleri tanımladık
    Button button2;
    EditText sifre, Ticarinumara;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticari_giris);
            // kullanıcağımız butonlara sistemeolması için atama yaptık
        button2 = (Button) findViewById(R.id.button2);
        Ticarinumara = (EditText) findViewById(R.id.pasw3);
        sifre = (EditText) findViewById(R.id.pasw4);
        final  String pasw   = sifre.getText().toString();
        final  String ticari   = Ticarinumara.getText().toString();
        // veri tabanının şifreyi tanıma  ve işlem yapma kodları...
        databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (equals(pasw)){
                    final String getPassword = snapshot.child(pasw).child("password").getValue(String.class);

                }else if(equals(ticari)){
                    final String getPassword = snapshot.child(pasw).child("password").getValue(String.class);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        // anasayfaya geçiş kodları
        startActivity(new Intent(TicariGiris.this, AnaSayfa.class));
    }
}
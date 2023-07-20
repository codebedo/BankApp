package com.h5200026_bedirhan_aydin_bankacilik_uygulamasi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {
    // şifre ve şifre görüntülenme butonu tanımı yaptık
    EditText password;
    boolean passwordVisible;
    // firebase veri tabanına referans alması için yazıldı
   DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // layout için tanımlar yaptık
        password =findViewById(R.id.psw);
        TextView textView =findViewById(R.id.textView);
        Button giris = findViewById(R.id.giris);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // şifremi unuttum ekranına geçmesi için yazıldı
                startActivity(new Intent(login.this,Sifreunuttum.class));
                finish();
            }
        });

        // şifre gösterme butonunnun kodları

        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right=2;
                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    if (motionEvent.getRawX()>=password.getRight()-password.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=password.getSelectionEnd();
                        if(passwordVisible){
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);
                            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }else{
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24,0);
                            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        password.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }

        });




        final  String sifre   = password.getText().toString();


        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // anasayfaya geçiş kodları
                startActivity(new Intent(login.this, AnaSayfa.class));
            }
        });


    }
}
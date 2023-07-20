package com.h5200026_bedirhan_aydin_bankacilik_uygulamasi;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;


import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthSettings;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GithubAuthProvider;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PlayGamesAuthProvider;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Musteriolmkistiyorum extends AppCompatActivity {
    EditText name, pasw, pasw2, PhoneTxt;
    Button button;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bireyselkayit);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        name = (EditText) findViewById(R.id.name);
        PhoneTxt = (EditText) findViewById(R.id.PhoneTxt);
        pasw = (EditText) findViewById(R.id.pasw);
        pasw2 = (EditText) findViewById(R.id.pasw2);
        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                // veri alırken herhangi bir hata kontrolü için veri tiplerini ve yerlerini tanımladık.
                final String Telefon = PhoneTxt.getText().toString();
                final String sifre = pasw.getText().toString();
                final String sifre_tekrar = pasw2.getText().toString();
                final String isim = name.getText().toString();
                int sifre_karakter = sifre.length();


                // Kişi bilgilerini alırken herhangi bir hata da rapor almak için koşul yazdık.
                if (isim.matches("") || Telefon.matches("")
                        || sifre.matches("") || sifre_tekrar.matches("")) {
                    Toast.makeText(Musteriolmkistiyorum.this,
                            "Lütfen alanları boş bırakmayın", Toast.LENGTH_SHORT).show();

                } else if (sifre_karakter < 8) {//şifre karakter sayısı kontrolü
                    Toast.makeText(Musteriolmkistiyorum.this,
                            "Şifre 8 karakterden az olamaz", Toast.LENGTH_SHORT).show();

                } else if (!sifre.matches(sifre_tekrar)) {//şifre karakter sayısı kontrolü
                    Toast.makeText(Musteriolmkistiyorum.this,
                            "şifreler uyuşmuyor", Toast.LENGTH_SHORT).show();

                } else {//hata yoksa

                    mDatabase.child("users").child(isim).child("username").setValue(name);
                    mDatabase.child("users").child(Telefon).child("userPhone").setValue(PhoneTxt);
                    mDatabase.child("users").child(sifre).child("userPassword").setValue(pasw);

                    Intent gecisYap = new Intent(Musteriolmkistiyorum.this,
                            login.class);
                    startActivity(gecisYap);
                    

                }




            }


        });

    }


}






package com.senturkzehra.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class Kullanici_giris extends AppCompatActivity {
    Button girisyap;
    Button uyeolma;
    CheckBox sifregoster;
    EditText kuladi;
    EditText kulsifre;
    sqlite_katmani vk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici_giris);

        girisyap=findViewById(R.id.btngiris);
        uyeolma=findViewById(R.id.btnuyeol);
        sifregoster=(CheckBox) findViewById(R.id.sifregoster);
        kulsifre=(EditText)findViewById(R.id.txtsifre);
        kuladi=(EditText)findViewById(R.id.txtkadi);
        vk = new sqlite_katmani(this);


        girisyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean check = vk.kontrolislemi(kuladi.getText().toString(), kulsifre.getText().toString());
                if (check == true) {
                    AlertDialog.Builder basarilimesaj = new AlertDialog.Builder(Kullanici_giris.this);
                    basarilimesaj.setMessage("GİRİŞ BAŞARILI...");
                    basarilimesaj.show();
                    Intent girisyap = new Intent(Kullanici_giris.this, panel.class);
                    startActivity(girisyap);

                }
                else {
                    AlertDialog.Builder hatamesaji = new AlertDialog.Builder(Kullanici_giris.this);
                    hatamesaji.setMessage("KULLANICI ADI VEYA ŞİFRENİZ YANLIŞ, LÜTFEN YETKİLİ KİŞİYE BİLDİRİNİZ..!");
                    hatamesaji.show();
                }
            }


        });

        sifregoster.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked)
                {
                    kulsifre .setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                else
                {
                    kulsifre.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }




    }

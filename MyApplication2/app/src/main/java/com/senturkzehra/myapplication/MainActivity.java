package com.senturkzehra.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TimeKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;


public class
MainActivity extends AppCompatActivity {

    Button musterigirisi;
    Button kullanicigirisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        musterigirisi=(Button)findViewById(R.id.btnmusterigirisi);
        kullanicigirisi=(Button)findViewById(R.id.btnkullanicigirisi);

        musterigirisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent girisyap = new Intent(MainActivity.this, Musteri_giris.class);
                startActivity(girisyap);
            }
        });

        kullanicigirisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent girisyap = new Intent(MainActivity.this, Kullanici_giris.class);
                startActivity(girisyap);
            }
        });



    }




}
package com.senturkzehra.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Musteri_panel extends AppCompatActivity {

    Button kargosorgula;
    Button cikisyap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musteri_panel);

        kargosorgula=(Button)findViewById(R.id.kargosorgula);
        cikisyap=(Button)findViewById(R.id.cikisyap);

        kargosorgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kargosorgulamayagit=new Intent(Musteri_panel.this,MusteriKargoSorgulama.class);
                startActivity(kargosorgulamayagit);
            }
        });

        cikisyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cikisyap=new Intent(Musteri_panel.this,MainActivity.class);
                startActivity(cikisyap);
            }
        });
    }
}
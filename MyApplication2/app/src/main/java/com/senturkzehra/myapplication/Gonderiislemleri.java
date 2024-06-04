package com.senturkzehra.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Gonderiislemleri extends AppCompatActivity {
    Button gonderilerilistele;
    ListView liste;
    sqlite_katmani vk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gonderiislemleri);
        vk = new sqlite_katmani(this);
        gonderilerilistele=(Button)findViewById(R.id.gonderilistele);
        liste=(ListView)findViewById(R.id.gonderilistesi);

        gonderilerilistele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlite_katmani vt=new sqlite_katmani(Gonderiislemleri.this);
                List<String>gonderilistele=vt.gonderilistele();
                ArrayAdapter<String>adapter=new ArrayAdapter<String>(Gonderiislemleri.this, android.R.layout.select_dialog_singlechoice,gonderilistele);
                liste.setAdapter(adapter);
            }
        });








    }
}
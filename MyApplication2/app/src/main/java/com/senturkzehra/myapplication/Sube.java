package com.senturkzehra.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class Sube extends AppCompatActivity {

  EditText sube;
  Button subegoster;
  ListView subelerigoster;


    ArrayAdapter adapter;
    ArrayList<String> listitem;

    sqlite_katmani vk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sube);

        vk = new sqlite_katmani(this);//uygulama acildiginda veritabanini acar.


        sube=(EditText)findViewById(R.id.txtsube);
        subegoster=(Button)findViewById(R.id.btnsubegoster);
        subelerigoster=(ListView)findViewById(R.id.subeler);


        subegoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlite_katmani vt=new sqlite_katmani(Sube.this);
                List<String>subelistele=vt.subelistele(sube.getText().toString());
                ArrayAdapter<String>adapter=new ArrayAdapter<String>(Sube.this, android.R.layout.select_dialog_singlechoice,subelistele);
                subelerigoster.setAdapter(adapter);


            }
        });




    }
}
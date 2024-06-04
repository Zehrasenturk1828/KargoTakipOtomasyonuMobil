package com.senturkzehra.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Musteri_list_islem extends AppCompatActivity {

    Button goster;
    Button sil;
    Button guncelle;
    ListView liste;
    sqlite_katmani vk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musteri_list_islem);

        vk = new sqlite_katmani(this);
        sil=(Button)findViewById(R.id.buttonsil);
        goster=(Button)findViewById(R.id.buttongoster);
        liste=(ListView)findViewById(R.id.musteriler);





        goster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sqlite_katmani vt=new sqlite_katmani(Musteri_list_islem.this);
                List<String>musterilistele=vt.listele();
                ArrayAdapter<String>adapter=new ArrayAdapter<String>(Musteri_list_islem.this, android.R.layout.select_dialog_multichoice,musterilistele);
                liste.setAdapter(adapter);
            }
        });

    }
}
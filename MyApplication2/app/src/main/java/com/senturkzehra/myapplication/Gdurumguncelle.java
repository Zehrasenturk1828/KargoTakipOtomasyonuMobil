package com.senturkzehra.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;

public class Gdurumguncelle extends AppCompatActivity {
    EditText gonkodu;
    EditText gonderidurum;
    Button gdurumguncelle;

    String[] gonderidurumları={"GÖNDERİNİZ TRANSFER AŞAMASINDA","GÖNDERİNİZ TESLİMAT ŞUBESİNDE","GÖNDERİNİZ TESLİMATTA","GÖNDERİNİZ TESLİM EDİLDİ","GÖNDERİNİZ TESLİM EDİLEMEDİ"};
    ArrayAdapter<String>dataadaptergonderidurumlari;

    sqlite_katmani vk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gdurumguncelle);

        vk=new sqlite_katmani(this);
        gdurumguncelle=(Button)findViewById(R.id.gonderidurumguncelle);
        gonderidurum=(EditText)findViewById(R.id.gonderidurum);
        gonkodu=(EditText)findViewById(R.id.gkodu);

        gdurumguncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlite_katmani vt=new sqlite_katmani(Gdurumguncelle.this);
                int a=Integer.parseInt(gonkodu.getText().toString());
                SQLiteDatabase db=vt.getWritableDatabase();
                db.execSQL("UPDATE gonderi SET gdurum='"+gonderidurum.getText().toString()+"' WHERE gkodu='"+a+"'");
                AlertDialog.Builder basarilimesaj = new AlertDialog.Builder(Gdurumguncelle.this);
                basarilimesaj.setMessage("GÜNCELLEME BAŞARILI");
                basarilimesaj.show();
            }
        });


    }
}
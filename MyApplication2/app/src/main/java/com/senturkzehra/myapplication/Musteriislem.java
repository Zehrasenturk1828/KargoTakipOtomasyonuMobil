package com.senturkzehra.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.constraintlayout.solver.ArrayRow;

import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Musteriislem extends AppCompatActivity {

    EditText kulid;
    EditText adi;
    EditText sadi;
    EditText tel;
    EditText musmail;
    EditText musadres;
    EditText musadi;
    EditText mussifre;
    Button islemegit;
    Button btnekle;
    Button buttongoster;
    CheckBox yetki;


    ArrayList<String> listitem;
    ArrayAdapter adapter;


    private sqlite_katmani vk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musteri_islem);

        vk = new sqlite_katmani(this);//uygulama acildiginda veritabanini acar.
        listitem = new ArrayList<>();

        islemegit=(Button)findViewById(R.id.islempanelinegit);
        btnekle = (Button) findViewById(R.id.buttonekle);
        buttongoster = (Button) findViewById(R.id.buttongoster);
        kulid=(EditText)findViewById(R.id.id);
        adi = (EditText) findViewById(R.id.ad);
        sadi = (EditText) findViewById(R.id.soyad);
        tel = (EditText) findViewById(R.id.telefon);
        musmail = (EditText) findViewById(R.id.mail);
        musadres = (EditText) findViewById(R.id.adres);
        musadi = (EditText) findViewById(R.id.kadi);
        mussifre = (EditText) findViewById(R.id.sifre);
        boolean yetkili;

        Boolean kontrol=vk.kayitvarmi(musmail.getText().toString());




        btnekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (adi.getText().toString().isEmpty()|| sadi.getText().toString().isEmpty()|| tel.getText().toString().isEmpty()|| musmail.getText().toString().isEmpty()|| musadres.getText().toString().isEmpty()|| musadi.getText().toString().isEmpty()|| mussifre.getText().toString().isEmpty())
                {
                    AlertDialog.Builder hatamesaji = new AlertDialog.Builder(Musteriislem.this);
                    hatamesaji.setMessage("Alanlar boş gelçilmez...");
                    hatamesaji.show();
                }
                else if (kontrol==true)
                {
                    AlertDialog.Builder hatamesaji = new AlertDialog.Builder(Musteriislem.this);
                    hatamesaji.setMessage("BU MAIL ADRESİ SİSTEME KAYITLI...");
                    hatamesaji.show();

                }
                else
                    {
                        sqlite_katmani vt=new sqlite_katmani(Musteriislem.this);
                        //ContentValues val=new ContentValues();
                        vt.veriekle(adi.getText().toString(),sadi.getText().toString(),tel.getText().toString(),musmail.getText().toString(),musadres.getText().toString(),musadi.getText().toString(),mussifre.getText().toString(),"MÜŞTERİ");
                        AlertDialog.Builder basarilimesaj = new AlertDialog.Builder(Musteriislem.this);
                        basarilimesaj.setMessage("KAYIT BAŞARILI...");
                        basarilimesaj.show();
                        return;

                }
                }
               });

        islemegit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent islemegit=new Intent(Musteriislem.this,Musteri_list_islem.class);
                startActivity(islemegit);
            }
        });



    }

}

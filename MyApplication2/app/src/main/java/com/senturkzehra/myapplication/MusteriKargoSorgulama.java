package com.senturkzehra.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MusteriKargoSorgulama extends AppCompatActivity {
    EditText gonkodu;
    Button gonderisonucu;
    TextView gonderidurum;
    TextView gonderikodu;
    sqlite_katmani vk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musteri_kargo_sorgulama);

        gonkodu=(EditText)findViewById(R.id.textgonkodu);
        gonderisonucu=(Button)findViewById(R.id.butonsorgula);
        gonderidurum=(TextView)findViewById(R.id.gonderidurumu);
        gonderikodu=(TextView)findViewById(R.id.gonderikodu);
        vk=new sqlite_katmani(this);

        gonderisonucu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlite_katmani vt=new sqlite_katmani(MusteriKargoSorgulama.this);
                SQLiteDatabase db=vt.getReadableDatabase();
                String sql="Select gkodu,gdurum from gonderi where gkodu="+gonkodu.getText().toString()+"";
                Cursor cr=db.rawQuery(sql,null);
                while(cr.moveToNext())
                {
                    gonderikodu.setText(cr.getInt(0));
                    gonderidurum.setText(cr.getString(8));
                }



            }
        });
    }
}
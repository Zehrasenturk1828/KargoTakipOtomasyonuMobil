package com.senturkzehra.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class Sorgulama extends AppCompatActivity {
    EditText gonkodu;
    Button sorgula;
    Button getir;
    ListView listele;
    sqlite_katmani vk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorgulama);
        vk = new sqlite_katmani(this);

        gonkodu=(EditText)findViewById(R.id.txtgonkodu);
        sorgula=(Button)findViewById(R.id.btnsorgula);
        getir=(Button)findViewById(R.id.btngetir);
        listele=(ListView)findViewById(R.id.gonderilistesi);

        sorgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlite_katmani vt=new sqlite_katmani(Sorgulama.this);
                int a=Integer.valueOf(gonkodu.getText().toString());
                List<String> gonderilistele=vt.Gonderisorgula(a);
                ArrayAdapter<String>adapter=new ArrayAdapter<String>(Sorgulama.this, android.R.layout.select_dialog_singlechoice,gonderilistele);
                listele.setAdapter(adapter);
            }
        });
        getir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlite_katmani vt=new sqlite_katmani(Sorgulama.this);
                List<String>getir=vt.gonderilistele();
                ArrayAdapter<String>adapter=new ArrayAdapter<String>(Sorgulama.this, android.R.layout.select_dialog_singlechoice,getir);
                listele.setAdapter(adapter);
            }
        });

    }
}
package com.senturkzehra.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class Gonderi extends AppCompatActivity {

    Button gonderiekle;
    Button paneledon;
    Button gonislemleregit;
    EditText gonadi;
    EditText gonsadi;
    EditText gontelefon;
    EditText gonmail;
    EditText gonadres;
    EditText aladi;
    EditText alsadi;
    EditText aladres;
    EditText almail;
    EditText altelefon;
    EditText en;
    EditText boy;
    EditText yukseklik;
    EditText agirlik;



    private sqlite_katmani vk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gonderi);
        vk = new sqlite_katmani(this);

        gonderiekle=(Button)findViewById(R.id.gonderiolustur);
        paneledon=(Button)findViewById(R.id.paneledon);
        gonislemleregit=(Button)findViewById(R.id.gonderiislemlerinegit);
        gonadi=(EditText)findViewById(R.id.textgadi);
        gonsadi=(EditText)findViewById(R.id.textgsadi);
        gonadres=(EditText)findViewById(R.id.textgadres);
        gonmail=(EditText)findViewById(R.id.textgmail);
        gontelefon=(EditText)findViewById(R.id.textgtelefon);
        aladi=(EditText)findViewById(R.id.textaladi);
        alsadi=(EditText)findViewById(R.id.textalsadi);
        aladres=(EditText)findViewById(R.id.textaladres);
        almail=(EditText)findViewById(R.id.textalmail);
        altelefon=(EditText)findViewById(R.id.altelefon);
        en=(EditText)findViewById(R.id.en);
        boy=(EditText)findViewById(R.id.boy);
        yukseklik=(EditText)findViewById(R.id.yukseklik);
        agirlik=(EditText)findViewById(R.id.agirlik);






        gonderiekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random r=new Random();
                int gondkodu=r.nextInt(500000000);
                Double eni,boyu,yuksekligi,agirligi,fiyati;
                double a=0.000003;
                int b=5;
                eni=Double.parseDouble(en.getText().toString());
                boyu=Double.parseDouble(boy.getText().toString());
                yuksekligi=Double.parseDouble(yukseklik.getText().toString());
                agirligi=Double.parseDouble(agirlik.getText().toString());
                fiyati=eni*boyu*yuksekligi*agirligi*a+b;
                long fiyat1=Math.round(fiyati);
                String fiyat=String.valueOf(fiyat1);
                sqlite_katmani vt=new sqlite_katmani(Gonderi.this);
                gonderiler gonderi=new gonderiler(gondkodu,gonadi.getText().toString(),gonsadi.getText().toString(),gonadres.getText().toString(),gonmail.getText().toString(),gontelefon.getText().toString(),aladi.getText().toString(),alsadi.getText().toString(),aladres.getText().toString(),almail.getText().toString(),altelefon.getText().toString(), en.getText().toString(),yukseklik.getText().toString(),boy.getText().toString(),agirlik.getText().toString(),fiyat,"GÖNDERİNİZ ALINDI");
                vt.gonderiekle(gonderi);
                AlertDialog.Builder basarilimesaj = new AlertDialog.Builder(Gonderi.this);
                basarilimesaj.setMessage("KAYIT BAŞARILI, KARGO TAKİP NUMARASI: "+ gondkodu +"\n"+"FİYAT: "+fiyat+"TL");
                basarilimesaj.show();
                return;


            }
        });
        paneledon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paneledon=new Intent(Gonderi.this,panel.class);
                startActivity(paneledon);
            }
        });
        gonislemleregit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gondislemleregit=new Intent(Gonderi.this,Gonderiislemleri.class);
                startActivity(gondislemleregit);
            }
        });





    }
}
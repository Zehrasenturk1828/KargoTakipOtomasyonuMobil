package com.senturkzehra.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class uyeOl extends AppCompatActivity {
    Button uyeol;
    Button girisedon;
    TextView adi;
    TextView soyadi;
    TextView telefon;
    TextView mail;
    TextView adres;
    TextView kuladi;
    TextView kulsifre;

    ArrayList<String> listitem;
    ArrayAdapter adapter;


    private sqlite_katmani vk;
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_paneledon,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_item_paneledon:
                Toast.makeText(getApplicationContext(), "GİRİŞE DÖN", Toast.LENGTH_SHORT).show();
                Intent paneledon=new Intent(uyeOl.this,MainActivity.class);
                startActivity(paneledon);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uye_ol);

        vk = new sqlite_katmani(this);//uygulama acildiginda veritabanini acar.
        listitem = new ArrayList<>();


        uyeol=findViewById(R.id.btnuyeol);
        girisedon=findViewById(R.id.butngirisedon);
        adi=findViewById(R.id.txtadi);
        soyadi=findViewById(R.id.txtsoyadi);
        telefon=findViewById(R.id.texttelefon);
        mail=findViewById(R.id.textmail);
        adres=findViewById(R.id.textadres);
        kuladi=findViewById(R.id.textkuladi);
        kulsifre=findViewById(R.id.txtsifre);

        uyeol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((!adi.getText().toString().isEmpty())&&(!soyadi.getText().toString().isEmpty())
                        &&(!telefon.getText().toString().isEmpty())&&(!mail.getText().toString().isEmpty())
                        &&(!adres.getText().toString().isEmpty())&&(!kuladi.getText().toString().isEmpty())
                        &&(!kulsifre.getText().toString().isEmpty()))
                {

                    sqlite_katmani vt=new sqlite_katmani(uyeOl.this);
                    Boolean kontrol=vt.kayitvarmi(mail.getText().toString());
                    if (!(kontrol==true)) {
                        vt.uyeol(adi.getText().toString(), soyadi.getText().toString(), telefon.getText().toString(), mail.getText().toString(), adres.getText().toString(), kuladi.getText().toString(), kulsifre.getText().toString());
                        AlertDialog.Builder basarilimesaj = new AlertDialog.Builder(uyeOl.this);
                        basarilimesaj.setMessage("Kaydınız başarıyla tamamlanmıştır..");
                        basarilimesaj.show();
                        Intent girisyap = new Intent(uyeOl.this, Musteri_panel.class);
                        startActivity(girisyap);
                    }
                    else
                    {
                        AlertDialog.Builder hatamesaji = new AlertDialog.Builder(uyeOl.this);
                        hatamesaji.setMessage("Bu mail şu an mevcuttur, lütfen kullanıcı girişi yapınız...");
                        hatamesaji.show();

                    }
                }
                else
                {
                    AlertDialog.Builder hatamesaji = new AlertDialog.Builder(uyeOl.this);
                    hatamesaji.setMessage("Alanlar boş gelçilmez...");
                    hatamesaji.show();
                    finish();
                    startActivity(getIntent());
                }

            }
        });
        girisedon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent girisedon=new Intent(uyeOl.this,MainActivity.class);
                startActivity(girisedon);
            }
        });
    }
}
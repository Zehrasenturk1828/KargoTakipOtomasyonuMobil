package com.senturkzehra.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

public class panel extends AppCompatActivity {
    Button Musteriekle;
    Button Subeekle;
    Button Gonderiekle;
    Button GonderiDurumGuncelle;
    Button Gonderidurumsorgula;
    Button oturumkapa;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_iem,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_item_cikis:
                Toast.makeText(getApplicationContext(), "cikis", Toast.LENGTH_SHORT).show();
                Intent cikisyap=new Intent(panel.this,MainActivity.class);
                startActivity(cikisyap);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);

        Musteriekle=findViewById(R.id.musteriolustur);
        Subeekle=findViewById(R.id.subesorgulama);
        Gonderiekle=findViewById(R.id.gonderiolusturma);
        GonderiDurumGuncelle=findViewById(R.id.gonderidurumguncelle);
        Gonderidurumsorgula=(Button)findViewById(R.id.gonderidurumsorgula);
        oturumkapa=(Button)findViewById(R.id.cikisyap);

     Musteriekle.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent musteriekle=new Intent(panel.this,Musteriislem.class);
             startActivity(musteriekle);
         }
     });
        Subeekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent subeekle = new Intent(panel.this,Sube.class);
                startActivity(subeekle);

            }
        });

        Gonderiekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gonderiekle = new Intent(panel.this,Gonderi.class);
                startActivity(gonderiekle);
            }
        });
        GonderiDurumGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent durumguncelle=new Intent(panel.this,Gdurumguncelle.class);
                startActivity(durumguncelle);
            }
        });
        Gonderidurumsorgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent durumsorgula=new Intent(panel.this,Sorgulama.class);
                startActivity(durumsorgula);
            }
        });
        oturumkapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent oturumkapat=new Intent(panel.this,MainActivity.class);
                startActivity(oturumkapat);
            }
        });



    }
}
package com.senturkzehra.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class  sqlite_katmani extends SQLiteOpenHelper {

    private static final String Veritabani_adi="KargotDb";
    private static final int versiyon=1;
    private static final String tabloadi="gonderiler";

    public sqlite_katmani(Context c){
        super(c, Veritabani_adi,null,versiyon);

    }



    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE kullanici(id INTEGER PRIMARY KEY,ad TEXT, soyad TEXT, telefon TEXT, mail TEXT, adres TEXT, kullanici_adi TEXT, sifre TEXT)");
        //db.execSQL("CREATE TABLE gonderi(gkodu INTEGER PRIMARY KEY, gadi TEXT, gsadi TEXT, gadres TEXT, gmail TEXT, gtelefon TEXT, aladi TEXT, alsadi TEXT, aladres TEXT, almail TEXT, altelefon TEXT,en TEXT, yukseklik TEXT, boy TEXT, agirlik TEXT, fiyat TEXT, gdurum TEXT)");
        //db.execSQL("CREATE TABLE gonderiler(gkodu INTEGER PRIMARY KEY, gadi TEXT, gsadi TEXT, gadres TEXT, gmail TEXT, gtelefon TEXT, aladi TEXT, alsadi, aladres TEXT, almail TEXT, altelefon TEXT,en TEXT, yukseklik TEXT, boy TEXT, agirlik TEXT, fiyat TEXT, gdurum TEXT)");
        db.execSQL("CREATE TABLE sube(subeid INTEGER PRIMARY KEY, subeadi TEXT, subeacikadres TEXT, subetelefon TEXT)");
        db.execSQL("CREATE TABLE "+ tabloadi+"(gkodu INTEGER PRIMARY KEY, gadi TEXT, gsadi TEXT, gadres TEXT, gmail TEXT, gtelefon TEXT, aladi TEXT, alsadi TEXT, aladres TEXT, almail TEXT, altelefon TEXT, en TEXT, yukseklik TEXT, boy TEXT, agirlik TEXT, fiyat TEXT, gdurum TEXT)");
        //db.execSQL("INSERT INTO "+tabloadi+"(gkodu,gadi,gsadi,gadres,gmail,gtelefon,aladi,alsadi,aladres,almail,altelefon,en,yukseklik,boy,agirlik,fiyat,gdurum) VALUES (3432423,'Zehra','Senturk','dscsd','dsdsas','2423423432','ewee','rrewr','eewewr','ewrwerew','123131312','12','12','12','12','5,0','GONDERINIZ ALINDI')");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS  kullanici");
        db.execSQL("DROP TABLE IF EXISTS gonderi ");
        //db.execSQL("DROP TABLE IF EXISTS gonderiler ");
        db.execSQL("DROP TABLE IF EXISTS sube ");
        db.execSQL("DROP TABLE IF EXISTS gonderiler");
        onCreate(db);

    }

    public void veriekle(String ad,String soyad,String tel,String mail,String adres,String kadi,String sifre, String kullaniciyetki){
        SQLiteDatabase db=this.getWritableDatabase();//yazdirma yapmak icin baglanti aciyoruz.
        ContentValues val=new ContentValues();

        val.put("ad",ad);
        val.put("soyad",soyad);
        val.put("telefon",tel);
        val.put("mail",mail);
        val.put("adres",adres);
        val.put("kullanici_adi",kadi);
        val.put("sifre",sifre);
        val.put("kullaniciyetki",kullaniciyetki);
        db.insert("kullanici",null,val);//tabloya ekleme

        return;
    }
    public void uyeol(String ad,String soyad,String tel,String mail,String adres,String kadi,String sifre)
    {
        SQLiteDatabase db=this.getWritableDatabase();//yazdirma yapmak icin baglanti aciyoruz.
        ContentValues val=new ContentValues();

        val.put("ad",ad);
        val.put("soyad",soyad);
        val.put("telefon",tel);
        val.put("mail",mail);
        val.put("adres",adres);
        val.put("kullanici_adi",kadi);
        val.put("sifre",sifre);



        db.insert("kullanici",null,val);//tabloya ekleme

        return;

    }


    public List<String>listele()
        {
            List<String> veriler=new ArrayList<String>();//liste olusturma
            SQLiteDatabase db=this.getWritableDatabase();//vt yazdirma islemi icin baglanti acma
            //String[] sutunlar = {"id","ad", "soyad", "mail", "telefon", "adres", "kullanici_adi", "sifre"};
            String selectquery="Select * from kullanici order by kullanici_adi ASC";
            Cursor cr=db.rawQuery(selectquery,null);
            //Cursor cr=db.query("kullanici",sutunlar,null,null,count(*)>1,null, null);
            while(cr.moveToNext())
            {
                veriler.add("ID: "+cr.getInt(0)+"\n"+"AD: "+cr.getString(1)+"\n"+"SOYAD: "+cr.getString(2)+"\n"+"MAİL: "+cr.getString(3)+"\n"+"TELEFON: "+cr.getString(4)+"\n"+"ADRES: "+cr.getString(5)+"\n"+"KULLANICI ADI: "+cr.getString(6)+"\n"+"ŞİFRE: "+cr.getString(7)+"\n"+"KULLANICI YETKİ:"+cr.getString(8));

            }
            return veriler;

        }

        public void gonderiekle(gonderiler gonderi)
        {


            SQLiteDatabase db=this.getWritableDatabase();//yazdirma yapmak icin baglanti aciyoruz.
            ContentValues val=new ContentValues();
            val.put("id",gonderi.getGkodu());
            val.put("gonad",gonderi.getGadi());
            val.put("gonsadi",gonderi.getGsadi());
            val.put("gonadres",gonderi.getGadres());
            val.put("gonmail",gonderi.getGmail());
            val.put("gontelefon",gonderi.getGtelefon());
            val.put("aladi",gonderi.getAladi());
            val.put("aladi",gonderi.getAlsadi());
            val.put("aladres",gonderi.getAladres());
            val.put("almail",gonderi.getAlmail());
            val.put("altelefon",gonderi.getAltelefon());
            val.put("en",gonderi.getEn());
            val.put("yukseklik",gonderi.getYukseklik());
            val.put("boy",gonderi.getBoy());
            val.put("agirlik",gonderi.getAgirlik());
            val.put("fiyat",gonderi.getFiyat());
            val.put("gdurum",gonderi.getGdurum());

            db.insert(tabloadi,null,val);


        }
        public List<String>gonderilistele()
         {
        List<String> gonderiverileri=new ArrayList<String>();//liste olusturma
        SQLiteDatabase db=this.getWritableDatabase();
        //String[] sutunlar = {"gonderikodu", "gonderenad", "gonderensoyad", "gonderenadres", "gonderenmail", "gonderentelefon", "alanadi", "alansadi", "alansadres", "alanmail", "alantelefon","fiyat", "gonderidurum"};
        String selectquery="SELECT * FROM  "+tabloadi;
        Cursor cr=db.rawQuery(selectquery,null);
        //Cursor c=db.query("gonderi",sutunlar,null,null,null,null,null);
        while (cr.moveToNext())
        {
            gonderiverileri.add("GÖNDERİ KODU: "+cr.getInt(0)+"\n"+"GÖNDEREN ADI: "+cr.getString(1)+"\n"+"GÖNDEREN SOYAD: "+cr.getString(2)+"\n"+"GÖNDEREN ADRES: "+cr.getString(3)+"\n"+"GÖNDEREN MAİL: "+cr.getString(4)+"\n"+"GÖNDEREN TELEFON: "+cr.getString(5)+"\n"+"ALICI ADI: "+cr.getString(6)+"\n"+"ALICI SOYADI: "+cr.getString(7)+"\n"+"ALICI ADRES: "+cr.getString(8)+"\n"+"ALICI MAİL: "+cr.getString(9)+"\n"+"ALICI TELEFON: "+cr.getString(10)+"\n"+"GÖNDERİ EN: "+cr.getString(11)+"\n"+"GÖNDERİ YÜKSEKLİK: "+cr.getString(12)+"\n"+"GÖNDERİ BOY: "+cr.getString(13)+"\n"+"GÖNDERİ AĞIRLIK: "+cr.getString(14)+"\n"+"GÖNDERİ FİYAT: "+cr.getString(15)+"\n"+"GÖNDERİ DURUM: "+cr.getString(16));
        }
        return gonderiverileri;

        }
        public List<String>subelistele(String subeadi)
        {
            List<String> subeverileri=new ArrayList<>();//liste olusturma
            SQLiteDatabase db=this.getWritableDatabase();
            //String[] sutunlar = {"id","subeadi", "subeacikadres"};
            String sql="SELECT subeid, subeadi, subeadres, subetelefon FROM Sube WHERE subeadi like'%"+subeadi+"%'";
            Cursor cr=db.rawQuery(sql,null);
            //Cursor c=db.query("sube",sutunlar,null,null,null,null,null);
            while (cr.moveToNext())
            {
                subeverileri.add("Şube No: "+cr.getInt(0)+"\n"+"Şube Adı: "+cr.getString(1)+"\n"+"Şube Adres: "+cr.getString(2)+"\n"+"Şube telefon"+cr.getString(3));
            }
            return subeverileri;

        }
        public void durumguncelle(String durum, Integer gkodu)
        {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues val=new ContentValues();
            val.put("gdurum",durum);
            val.put("gkodu",gkodu);
            db.update("gonderi",val,"gkodu=?",null);
        }
        public void verisil(Integer id)
        {
            SQLiteDatabase db=this.getWritableDatabase();//yazdirma yapmak icin baglanti aciyoruz.
            db.delete("kullanici","id+="+id,null);
            db.close();
        }
        public void veriguncelle(String guncellecekid,String kuladi,String sifre,String telefon, String mail)
        {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues Guncelle = new ContentValues();
            Guncelle.put("kullanici_adi",kuladi);
            Guncelle.put("sifre",sifre);
            Guncelle.put("telefon",telefon);
            Guncelle.put("mail",mail);

            db.update("kullanici",Guncelle,"id+="+guncellecekid,null);


        }

        public Boolean kontrolislemi(String kuladi, String sifre)
        {
            SQLiteDatabase db=this.getReadableDatabase();
            Cursor cursor=db.rawQuery("SELECT * FROM kullanici WHERE kullanici_adi=? and sifre=?",new String[]{kuladi,sifre});
            if (cursor.getCount()>0)
                return true;
            else
                return false;

        }
        public Boolean kayitvarmi(String kulmail)
        {
            SQLiteDatabase db=this.getReadableDatabase();
            Cursor cursor=db.rawQuery("SELECT * FROM kullanici WHERE mail=?",new String[]{kulmail});
            if (cursor.getCount()>0) {
                return true;

            }
            else
                return false;

        }


    public List<String> Gonderisorgula(Integer gonderikodu)
    {
        List<String> gonderiverileri=new ArrayList<>();//liste olusturma
        SQLiteDatabase db=this.getWritableDatabase();
        String sql="SELECT gkodu, gdurum FROM gonderiler WHERE gkodu='"+gonderikodu+"'";
        Cursor cr=db.rawQuery(sql,null);
        while(cr.moveToNext())
        {
            gonderiverileri.add("GÖNDERİ KODU:"+cr.getInt(0)+"\n"+"GÖNDERİ DURUMU"+cr.getString(16));
        }
        return gonderiverileri;
    }



    }

}






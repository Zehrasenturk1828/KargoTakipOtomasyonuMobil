package com.senturkzehra.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Musteri{
    private int id;
    private String ad;
    private String soyad;
    private String mail;
    private String telefon;
    private String adres;
    private String kadi;
    private String sifre;

    public Musteri(int id, String ad, String soyad, String mail, String telefon, String adres, String kadi, String sifre) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.mail = mail;
        this.telefon = telefon;
        this.adres = adres;
        this.kadi = kadi;
        this.sifre = sifre;
    }

    public int getId() {
        return id;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public String getMail() {
        return mail;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getAdres() {
        return adres;
    }

    public String getKadi() {
        return kadi;
    }

    public String getSifre() {
        return sifre;
    }
}
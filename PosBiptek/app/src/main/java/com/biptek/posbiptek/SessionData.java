package com.biptek.posbiptek;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


//digunakan untuk menyimpan data - data kecil yang digunakan di beberapa Activity secara tetap meskipun aplikasi sudah ditutup
//Menggunakan SharedPreferences
public class SessionData {
    private SharedPreferences sharedPreferences;

    public SessionData(Context context){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setUsername(String username){
        sharedPreferences.edit().putString("USERNAME", username).commit();
    }

    public String getUsername(){
        return sharedPreferences.getString("USERNAME", null);
    }

    public void setKodePerusahaan(long kodePerusahaan){
        sharedPreferences.edit().putLong("KODEPERUSAHAAN", kodePerusahaan).commit();
    }

    public long getKodePerusahaan(){
        return sharedPreferences.getLong("KODEPERUSAHAAN", -1);
    }

    public void setKodeToko(long kodeToko){
        sharedPreferences.edit().putLong("KODETOKO", kodeToko).commit();
    }
    public long getKodeToko(){
        return sharedPreferences.getLong("KODETOKO", -1);
    }

    public void setJabatanLogIn(String jabatan){
        sharedPreferences.edit().putString("JABATAN", jabatan).commit();
    }

    public String getJabatanLogIn(){
        return sharedPreferences.getString("JABATAN", null);
    }
}

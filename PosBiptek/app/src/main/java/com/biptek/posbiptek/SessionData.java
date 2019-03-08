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
        String username = sharedPreferences.getString("username", null);
        return username;
    }

    public void setKodePerusahaan(){

    }

    public long getKodePerusahaan(){

    }

}

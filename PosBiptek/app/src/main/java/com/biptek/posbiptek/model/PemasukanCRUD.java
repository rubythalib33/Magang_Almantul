package com.biptek.posbiptek.model;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class PemasukanCRUD {
    private static final String LOGTAG = "POS_BIPTEK_SYS";
    private SQLiteOpenHelper dbhandler;
    private SQLiteDatabase database;

    private static final String[] allColumns = {
            "kode_data_pemasukan",
            "kode_pemasukan",
            "tanggal_pemasukan",
            "jumlah_pemasukan"
    };

    public PemasukanCRUD(Context context){
        dbhandler = new DatabaseHelper(context);
    }

    public void open () {
        Log.i (LOGTAG, "Datanase Opened");
        database = dbhandler.getWritableDatabase();
    }

    public void close () {
        Log.i (LOGTAG, "Database Closed");
        dbhandler.close();
    }

    public long addPemasukan(Pemasukan pemasukan){
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_pemasukan", pemasukan.getKode_pemasukan());
        contentValues.put("tanggal_pemasukan", pemasukan.getTanggal_pemasukan());
        contentValues.put("jumlah_pemasukan", pemasukan.getJumlah_pemasukan());
        long insertid = database.insert("pemasukan", null, contentValues);
        return insertid;
    }

    //mendapatkan 1 data pemasukan
    public Pemasukan getPemasukan(long kode_data_pemasukan){
        Cursor cursor = database.query("pemasukan",
                allColumns,
                "kode_data_pemasukan=?",
                new String[]{String.valueOf(kode_data_pemasukan)},
                null,
                null,
                null);

        if(cursor != null)
            cursor.moveToFirst();

        Pemasukan pemasukan = new Pemasukan(cursor.getLong(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getInt(3));

        return pemasukan;
    }

    //mendapatkan semua data pemasukan
    public List<Pemasukan> getAllPemasukan(){
        Cursor cursor = database.query("pemasukan",
                allColumns,
                null,
                null,
                null,
                null,
                null);

        List<Pemasukan> pemasukans = new ArrayList<>();
        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){
                Pemasukan pemasukan = new Pemasukan();
                pemasukan.setKode_data_pemasukan(cursor.getLong(cursor.getColumnIndex("kode_data_pemasukan")));
                pemasukan.setKode_pemasukan(cursor.getString(cursor.getColumnIndex("kode_pemasukan")));
                pemasukan.setTanggal_pemasukan(cursor.getString(cursor.getColumnIndex("tanggal_pemasukan")));
                pemasukan.setJumlah_pemasukan(cursor.getInt(cursor.getColumnIndex("jumlah_pemasukan")));
                pemasukans.add(pemasukan);
            }
        }

        return pemasukans;
    }

    public void updatePemasukan(Pemasukan pemasukan){
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_pemasukan", pemasukan.getKode_pemasukan());
        contentValues.put("tanggal_pemasukan", pemasukan.getTanggal_pemasukan());
        contentValues.put("jumlah_pemasukan", pemasukan.getJumlah_pemasukan());
        database.update("pemasukan", contentValues, "kode_data_pemasukan=?", new String[]{String.valueOf(pemasukan.getKode_data_pemasukan())});
    }

    public void deletePemasukan(Pemasukan pemasukan){
        database.delete("pemasukan", "kode_data_pemasukan=?", new String[]{String.valueOf(pemasukan.getKode_data_pemasukan())});
    }
}

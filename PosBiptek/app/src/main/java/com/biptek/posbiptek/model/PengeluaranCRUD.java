package com.biptek.posbiptek.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class PengeluaranCRUD {
    private static final String LOGTAG = "POS_BIPTEK_SYS";
    private SQLiteOpenHelper dbhandler;
    private SQLiteDatabase database;

    private static final String[] allColumns = {
            "kode_data_pengeluaran",
            "kode_pengeluaran",
            "tanggal_pengeluaran",
            "jumlah_pengeluaran"
    };

    public PengeluaranCRUD(Context context){
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

    public long addPengeluaran(Pengeluaran pengeluaran){
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_pengeluaran", pengeluaran.getKode_pengeluaran());
        contentValues.put("tanggal_pengeluaran", pengeluaran.getTanggal_pengeluaran());
        contentValues.put("jumlah_pengeluaran", pengeluaran.getJumlah_pengeluaran());
        long insertid = database.insert("pengeluaran", null, contentValues);
        return insertid;
    }

    //mendapatkan 1 data pengeluaran
    public Pengeluaran getPengeluaran(long kode_data_pengeluaran){
        Cursor cursor = database.query("pengeluaran",
                allColumns,
                "kode_data_pengeluaran=?",
                new String[]{String.valueOf(kode_data_pengeluaran)},
                null,
                null,
                null);

        if(cursor != null)
            cursor.moveToFirst();

        Pengeluaran pengeluaran = new Pengeluaran(cursor.getLong(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getInt(3));

        return pengeluaran;
    }

    //mendapatkan semua data pengeluaran
    public List<Pengeluaran> getAllPengeluaran(){
        Cursor cursor = database.query("pengeluaran",
                allColumns,
                null,
                null,
                null,
                null,
                null);

        List<Pengeluaran> pengeluarans = new ArrayList<>();
        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){
                Pemasukan pemasukan = new Pemasukan();
                pemasukan.setKode_data_pemasukan(cursor.getLong(cursor.getColumnIndex("kode_data_pengeluaran")));
            }
        }
    }
}

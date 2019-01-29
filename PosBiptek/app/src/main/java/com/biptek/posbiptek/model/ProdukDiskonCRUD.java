package com.biptek.posbiptek.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ProdukDiskonCRUD {
    private static final String LOGTAG = "POS_BIPTEK_SYS";
    private SQLiteOpenHelper dbhandler;
    private SQLiteDatabase database;

    private static final String[] allColumns = {
            "kode_diskon",
            "kode_produk_diskon",
            "besar_diskon",
            "tanggal_mulai_berlaku_diskon",
            "tanggal_berakhir_diskon"
    };

    public ProdukDiskonCRUD(Context context){
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

    public long addProdukDiskon(ProdukDiskon produkDiskon, Produk produk){
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_produk_diskon", produk.getKode_produk());
        contentValues.put("besar_diskon", produkDiskon.getBesar_diskon());
        contentValues.put("tanggal_mulai_berlaku_diskon", produkDiskon.getTanggal_mulai_berlaku_diskon());
        contentValues.put("tanggal_berakhir_diskon", produkDiskon.getTanggal_berakhir_diskon());
        long inserid = database.insert("produk_diskon", null, contentValues);
        return inserid;
    }

    //mendapatkan 1 data diskon produk
    public ProdukDiskon getProdukDiskon(long kode_diskon){
        Cursor cursor = database.query("produk_diskon",
                allColumns,
                "kode_diskon=?",
                new String[]{String.valueOf(kode_diskon)},
                null,
                null,
                null);

        if(cursor != null)
            cursor.moveToFirst();

        ProdukDiskon produkDiskon = new ProdukDiskon(cursor.getLong(0),
                cursor.getString(1),
                cursor.getInt(2),
                cursor.getString(3),
                cursor.getString(4));

        return produkDiskon;
    }

    //mendapatkan semua data diskon produk
    public List<ProdukDiskon> getAllProdukDiskon(){
        Cursor cursor = database.query("produk_diskon",
                allColumns,
                null,
                null,
                null,
                null,
                null);

        List<ProdukDiskon> produkDiskons = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                ProdukDiskon produkDiskon = new ProdukDiskon();
                produkDiskon.setKode_diskon(cursor.getLong(cursor.getColumnIndex("kode_diskon")));
                produkDiskon.setKode_produk_diskon(cursor.getString(cursor.getColumnIndex("kode_produk_diskon")));
                produkDiskon.setBesar_diskon(cursor.getInt(cursor.getColumnIndex("besar_diskon")));
                produkDiskon.setTanggal_mulai_berlaku_diskon(cursor.getString(cursor.getColumnIndex("tanggal_mulai_berlaku_diskon")));
                produkDiskon.setTanggal_berakhir_diskon(cursor.getString(cursor.getColumnIndex("tanggal_berakhir_diskon")));
                produkDiskons.add(produkDiskon);
            }
        }

        return produkDiskons;
    }

    public void updateProdukDiskon(ProdukDiskon produkDiskon, Produk produk){
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_produk_diskon", produk.getKode_produk());
        contentValues.put("besar_diskon", produkDiskon.getBesar_diskon());
        contentValues.put("tanggal_mulai_berlaku_diskon", produkDiskon.getTanggal_mulai_berlaku_diskon());
        contentValues.put("tanggal_berakhir_diskon", produkDiskon.getTanggal_berakhir_diskon());
        database.update("produk_diskon", contentValues, "kode_diskon=?", new String[]{String.valueOf(produkDiskon.getKode_diskon())});
    }

    public void deleteProdukDiskon(ProdukDiskon produkDiskon){
        database.delete("produk_diskon", "kode_diskon=?", new String[]{String.valueOf(produkDiskon.getKode_diskon())});
    }
}

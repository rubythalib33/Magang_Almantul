package com.biptek.posbiptek.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class BundleProdukCRUD {
    private static final String LOGTAG = "POS_BIPTEK_SYS";
    private SQLiteOpenHelper dbhandler;
    private SQLiteDatabase database;

    private static final String[] allColumns = {
            "kode_bundle",
            "nama_bundle",
            "harga_bundle",
    };

    public BundleProdukCRUD(Context context){
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

    public long addBundleProduk(BundleProduk bundleProduk){

        //untuk table bundle
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama_bundle", bundleProduk.getNama_bundle());
        contentValues.put("harga_bundle", bundleProduk.getHarga_bundle());
        long insertid = database.insert("bundle", null, contentValues);

        untuk table

        return insertid;
    }

    //mendapatkan 1 data bundle produk
    public BundleProduk getBundleProduk(long kode_bundle){
        Cursor cursor = database.query("bundle",
                allColumns,
                "kode_bundle=?",
                new String[]{String.valueOf(kode_bundle)},
                null,
                null,
                null);

        if(cursor != null)
            cursor.moveToFirst();

        BundleProduk bundleProduk = new BundleProduk(cursor.getLong(0),
                cursor.getString(1),
                cursor.getInt(2));

        return bundleProduk;
    }

    //mendapatkan semua data bundle produk
    public List<BundleProduk> getAllBundleProduk(){
        Cursor cursor = database.query("bundle",
                allColumns,
                null,
                null,
                null,
                null,
                null);

        List<BundleProduk> bundleProduks = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                BundleProduk bundleProduk = new BundleProduk();
                bundleProduk.setKode_bundle(cursor.getLong(cursor.getColumnIndex("kode_bundle")));
                bundleProduk.setNama_bundle(cursor.getString(cursor.getColumnIndex("nama_bundle")));
                bundleProduk.setHarga_bundle(cursor.getInt(cursor.getColumnIndex("harga_bundle")));
                bundleProduks.add(bundleProduk);
            }
        }

        return bundleProduks;
    }

    public void updateBundleProduk(BundleProduk bundleProduk){
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama_bundle", bundleProduk.getNama_bundle());
        contentValues.put("harga_bundle", bundleProduk.getHarga_bundle());
        database.update("bundle", contentValues, "kode_bundle=?", new String[]{String.valueOf(bundleProduk.getKode_bundle())});
    }

    public void deleteBundleProduk(BundleProduk bundleProduk){
        database.delete("bundle", "kode_bundle=?", new String[]{String.valueOf(bundleProduk.getKode_bundle())});
    }
}

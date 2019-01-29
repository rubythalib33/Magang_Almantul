package com.biptek.posbiptek.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class RestockCRUD {
    private static final String LOGTAG = "POS_BIPTEK_SYS";
    private SQLiteOpenHelper dbhandler;
    private SQLiteDatabase database;

    private static final String[] allColumns = {
            "kode_restock",
            "kode_supplier_restock",
            "tanggal_transaksi_restock",
            "tanggal_jatuh_tempo",
            "bukti_transakti_restock"
    };

    public RestockCRUD(Context context){
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

    public long addRestock(Restock restock, Supplier supplier){

        //untuk table restock
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_supplier_restock", supplier.getKode_supplier());
        contentValues.put("tanggal_transaksi_restock", restock.getTanggal_transaksi_restock());
        contentValues.put("tanggal_jatuh_tempon", restock.getTanggal_jatuh_tempo());
        contentValues.put("bukti_transaksi_restock", restock.getBukti_transaksi_restock());
        long insertid = database.insert("restock", null, contentValues);

        untuk table

        return insertid;
    }

    //mendapatkan 1 data restock
    public Restock getRestock(long kode_restock){
        Cursor cursor = database.query("restock",
                allColumns,
                "kode_restock=?",
                new String[]{String.valueOf(kode_restock)},
                null,
                null,
                null);

        if(cursor != null)
            cursor.moveToFirst();

        Restock restock = new Restock(cursor.getLong(0),
                cursor.getLong(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4));

        return  restock;
    }

    //mendapatkan semua data restock
    public List<Restock> getAllRestock(){
        Cursor cursor = database.query("restock",
                allColumns,
                null,
                null,
                null,
                null,
                null);

        List<Restock> restocks = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                Restock restock = new Restock();
                restock.setKode_restock(cursor.getLong(cursor.getColumnIndex("kode_restock")));
                restock.setKode_supplier_restock(cursor.getLong(cursor.getColumnIndex("kode_supplier_restock")));
                restock.setTanggal_transaksi_restock(cursor.getString(cursor.getColumnIndex("tanggal_transaksi_restock")));
                restock.setTanggal_jatuh_tempo(cursor.getString(cursor.getColumnIndex("tanggal_jatuh_tempo")));
                restock.setBukti_transaksi_restock(cursor.getString(cursor.getColumnIndex("bukti_transaksi_restock")));
                restocks.add(restock);
            }
        }

        return restocks;
    }

    public void updateRestock(Restock restock, Supplier supplier){
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_supplier_restock", supplier.getKode_supplier());
        contentValues.put("tanggal_transaksi_restock", restock.getTanggal_transaksi_restock());
        contentValues.put("tanggal_jatuh_tempon", restock.getTanggal_jatuh_tempo());
        contentValues.put("bukti_transaksi_restock", restock.getBukti_transaksi_restock());
        database.update("restock", contentValues, "kode_restock=?", new String[]{String.valueOf(restock.getKode_restock())});
    }

    public void deleteRestock(Restock restock){
        database.delete("restock", "kode_restock=?", new String[]{String.valueOf(restock.getKode_restock())});
    }
}

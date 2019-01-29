package com.biptek.posbiptek.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TransaksiPenjualanCRUD {
    private static final String LOGTAG = "POS_BIPTEK_SYS";
    private SQLiteOpenHelper dbhandler;
    private SQLiteDatabase database;

    private static final String[] allColumns = {
            "kode_penjualan",
            "kode_user_penjualan",
            "nama_customer",
            "tanggal_transaksi_penjualan"
    };

    private static final String[] allColumnsList = {
            "kode_penjualan_list",
            "kode_produk_list_terjual",
            "jumlah_produk_terjual"
    };

    public TransaksiPenjualanCRUD(Context context){
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

    public long addTransaksiPenjualan(TransaksiPenjualan transaksiPenjualan, User user, List<ListProdukTerjual> listProdukTerjuals){

        //untuk table transaksi_penjualan
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_user_penjualan", user.getUsername());
        contentValues.put("nama_customer", transaksiPenjualan.getNama_customer());
        contentValues.put("tanggal_transaksi_penjualan", transaksiPenjualan.getTanggal_transaksi_penjualan());
        long inserid = database.insert("transaksi_penjualan", null, contentValues);

        //untuk table list_produk_terjual
        for(ListProdukTerjual produkTerjual : listProdukTerjuals){
            ContentValues contentValuesList = new ContentValues();
            contentValuesList.put("kode_penjualan_list", inserid);
            contentValuesList.put("kode_produk_list_terjual", produkTerjual.getKode_produk_list_terjual());
            contentValuesList.put("jumlah_produk_terjual", produkTerjual.getJumlah_produk_terjual());
            database.insert("list_produk_terjual", null, contentValuesList);
        }

        return inserid;
    }

    //mendapatkan 1 data transaksi penjualan
    public TransaksiPenjualan getTransaksiPenjualan(long kode_penjualan){
        Cursor cursor = database.query("transaksi_penjualan",
                allColumns,
                "kode_penjualan=?",
                new String[]{String.valueOf(kode_penjualan)},
                null,
                null,
                null);

        if(cursor != null)
            cursor.moveToFirst();

        TransaksiPenjualan transaksiPenjualan = new TransaksiPenjualan(cursor.getLong(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3));

        return transaksiPenjualan;
    }

    //mendapatkan list barang yang terjual pada transaksi tertentu
    public List<ListProdukTerjual> getListProdukTerjual(long kode_penjualan_list){
        Cursor cursor = database.query("list_produk_terjual",
                allColumnsList,
                "kode_penjualan_list=?",
                new String[]{String.valueOf(kode_penjualan_list)},
                null,
                null,
                null);

        List<ListProdukTerjual> listProdukTerjuals = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                ListProdukTerjual produkTerjual = new ListProdukTerjual();
                produkTerjual.setKode_penjualan_list(cursor.getLong(cursor.getColumnIndex("kode_penjualan_list")));
                produkTerjual.setKode_produk_list_terjual(cursor.getString(cursor.getColumnIndex("kode_produk_list_terjual")));
                produkTerjual.setJumlah_produk_terjual(cursor.getInt(cursor.getColumnIndex("jumlah_produk_terjual")));
                listProdukTerjuals.add(produkTerjual);
            }
        }

        return listProdukTerjuals;
    }

    //mendapatkan semua data transaksi penjualan
    public List<TransaksiPenjualan> getAllTransaksiPenjualan(){
        Cursor cursor = database.query("transaksi_penjualan",
                allColumns,
                null,
                null,
                null,
                null,
                null);

        List<TransaksiPenjualan> transaksiPenjualans = new ArrayList<>();
        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){
                TransaksiPenjualan transaksiPenjualan = new TransaksiPenjualan();
                transaksiPenjualan.setKode_penjualan(cursor.getLong(cursor.getColumnIndex("kode_penjualan")));
                transaksiPenjualan.setKode_user_penjualan(cursor.getString(cursor.getColumnIndex("kode_user_penjualan")));
                transaksiPenjualan.setNama_customer(cursor.getString(cursor.getColumnIndex("nama_customer")));
                transaksiPenjualan.setTanggal_transaksi_penjualan(cursor.getString(cursor.getColumnIndex("tanggal_transaksi_penjualan")));
                transaksiPenjualans.add(transaksiPenjualan);
            }
        }

        return transaksiPenjualans;
    }

    public void updateTransaksiPenjualan(TransaksiPenjualan transaksiPenjualan, User user, List<ListProdukTerjual> listProdukTerjuals){

        //update di table transaksi_penjualan
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_user_penjualan", user.getUsername());
        contentValues.put("nama_customer", transaksiPenjualan.getNama_customer());
        contentValues.put("tanggal_transaksi_penjualan", transaksiPenjualan.getTanggal_transaksi_penjualan());
        database.update("transaksi_penjualan", contentValues, "kode_penjualan=?", new String[]{String.valueOf(transaksiPenjualan.getKode_penjualan())});

        for(ListProdukTerjual produkTerjual : listProdukTerjuals){
            ContentValues contentValuesList = new ContentValues();
            contentValuesList.put("kode_penjualan_list", transaksiPenjualan.getKode_penjualan());
            contentValuesList.put("kode_produk_list_terjual", produkTerjual.getKode_produk_list_terjual());
            contentValuesList.put("jumlah_produk_terjual", produkTerjual.getJumlah_produk_terjual());
            database.update();
        }
    }

    public void deleteTransaksiPenjualan(TransaksiPenjualan transaksiPenjualan){
        database.delete("transaksi_penjualan", "kode_penjualan=?", new String[]{String.valueOf(transaksiPenjualan.getKode_penjualan())});
    }
}

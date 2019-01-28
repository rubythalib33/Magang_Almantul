package com.biptek.posbiptek.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ProdukCRUD {
    private static final String LOGTAG = "POS_BIPTEK_SYS";
    private SQLiteOpenHelper dbhandler;
    private SQLiteDatabase database;

    private static final String[] allColumns = {
            "kode_produk",
            "jenis_produk",
            "kategori_produk",
            "nama_produk",
            "deskripsi_produk",
            "harga_jual_produk",
            "harga_beli_produk",
            "satuan_produk",
            "gambar_produk",
            "stok_produk",
            "stok_kritis_produk",
            "status_produk"
    };

    public ProdukCRUD(Context context){
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

    public void addProduk(Produk produk){
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_produk", produk.getKode_produk());
        contentValues.put("jenis_produk", produk.getJenis_produk());
        contentValues.put("kategori_produk", produk.getKategori_produk());
        contentValues.put("nama_produk", produk.getNama_produk());
        contentValues.put("deskripsi_produk", produk.getDeskripsi_produk());
        contentValues.put("harga_jual_produk", produk.getHarga_jual_produk());
        contentValues.put("harga_beli_produk", produk.getHarga_beli_produk());
        contentValues.put("satuan_produk", produk.getSatuan_produk());
        contentValues.put("gambar_produk", produk.getGambar_produk());
        contentValues.put("stok_produk", produk.getStok_produk());
        contentValues.put("stok_kritis_produk", produk.getStok_kritis_produk());
        contentValues.put("status_produk", produk.getStatus_produk());
        database.insert("produk", null, contentValues);
    }

    //mendapatkan 1 produk
    public Produk getProduk (String kode_produk){
        Cursor cursor = database.query("produk",
                allColumns,
                "kode_produk=?",
                new String[]{kode_produk},
                null,
                null,
                null);

        if (cursor != null)
            cursor.moveToFirst();

        Produk produk = new Produk(cursor.getString(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getInt(5),
                cursor.getInt(6),
                cursor.getString(7),
                cursor.getString(8),
                cursor.getInt(9),
                cursor.getInt(10),
                cursor.getString(11));

        return produk;
    }

    //mendapatkan semua produk
    public List<Produk> getAllProduk(){
        Cursor cursor = database.query("produk",
                allColumns,
                null,
                null,
                null,
                null,
                null
                );

        List<Produk> produks = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                Produk produk = new Produk();
                produk.setKode_produk(cursor.getString(cursor.getColumnIndex("kode_produk")));
                produk.setJenis_produk(cursor.getString(cursor.getColumnIndex("jenis_produk")));
                produk.setKategori_produk(cursor.getString(cursor.getColumnIndex("kategori_produk")));
                produk.setNama_produk(cursor.getString(cursor.getColumnIndex("nama_produk")));
                produk.setDeskripsi_produk(cursor.getString(cursor.getColumnIndex("deskripsi_produk")));
                produk.setHarga_jual_produk(cursor.getInt(cursor.getColumnIndex("harga_jual_produk")));
                produk.setHarga_beli_produk(cursor.getInt(cursor.getColumnIndex("harga_beli_produk")));
                produk.setSatuan_produk(cursor.getString(cursor.getColumnIndex("satuan_produk")));
                produk.setGambar_produk(cursor.getString(cursor.getColumnIndex("gambar_produk")));
                produk.setStok_produk(cursor.getInt(cursor.getColumnIndex("stok_produk")));
                produk.setStok_kritis_produk(cursor.getInt(cursor.getColumnIndex("stok_kritis_produk")));
                produk.setStatus_produk(cursor.getString(cursor.getColumnIndex("status_produk")));
                produks.add(produk);
            }
        }

        return produks;
    }

    public void updateProduk(Produk produk){
        ContentValues contentValues = new ContentValues();
        contentValues.put("kode_produk", produk.getKode_produk());
        contentValues.put("jenis_produk", produk.getJenis_produk());
        contentValues.put("kategori_produk", produk.getKategori_produk());
        contentValues.put("nama_produk", produk.getNama_produk());
        contentValues.put("deskripsi_produk", produk.getDeskripsi_produk());
        contentValues.put("harga_jual_produk", produk.getHarga_jual_produk());
        contentValues.put("harga_beli_produk", produk.getHarga_beli_produk());
        contentValues.put("satuan_produk", produk.getSatuan_produk());
        contentValues.put("gambar_produk", produk.getGambar_produk());
        contentValues.put("stok_produk", produk.getStok_produk());
        contentValues.put("stok_kritis_produk", produk.getStok_kritis_produk());
        contentValues.put("status_produk", produk.getStatus_produk());
        database.update("produk", contentValues, "kode_produk=?", new String[]{produk.getKode_produk()});
    }

    public void deleteProduk(Produk produk){
        database.delete("produk", "kode_produk=?", new String[] {produk.getKode_produk()});
    }
}

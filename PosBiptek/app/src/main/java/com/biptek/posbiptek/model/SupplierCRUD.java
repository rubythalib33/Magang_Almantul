package com.biptek.posbiptek.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SupplierCRUD {
    private static final String LOGTAG = "POS_BIPTEK_SYS";
    private SQLiteOpenHelper dbhandler;
    private SQLiteDatabase database;

    private static final String[] allColumns = {
            "kode_supplier",
            "nama_supplier",
            "email_supllier",
            "no_telepon_supplier",
            "alamat_supplier"};

    public SupplierCRUD(Context context){
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

    public long addSupplier(Supplier supplier){
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama_supplier", supplier.getNama_supplier());
        contentValues.put("email_supplier", supplier.getEmail_supplier());
        contentValues.put("no_telepon_supplier", supplier.getNo_telepon_supplier());
        contentValues.put("alamat_supplier", supplier.getAlamat_supplier());
        long insertid = database.insert("supplier", null, contentValues);
        return insertid;
    }

    //mendapatkan 1 supplier
    public Supplier getSupplier(long kode_supplier){
        Cursor cursor = database.query("supplier",
                allColumns,
                "kode_supplier=?",
                new String[]{String.valueOf(kode_supplier)},
                null,
                null,
                null);

        if(cursor != null)
            cursor.moveToFirst();

        Supplier supplier = new Supplier(cursor.getLong(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4));

        return supplier;
    }

    //mendapatkan semua supplier
    public List<Supplier> getAllSupplier(){
        Cursor cursor = database.query("supplier",
                allColumns,
                null,
                null,
                null,
                null,
                null);

        List<Supplier> suppliers = new ArrayList<>();
        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){
                Supplier supplier = new Supplier();
                supplier.setKode_supplier(cursor.getLong(cursor.getColumnIndex("kode_supplier")));
                supplier.setNama_supplier(cursor.getString(cursor.getColumnIndex("nama_supplier")));
                supplier.setEmail_supplier(cursor.getString(cursor.getColumnIndex("email_supplier")));
                supplier.setNo_telepon_supplier(cursor.getString(cursor.getColumnIndex("no_telepon_supplier")));
                supplier.setAlamat_supplier(cursor.getString(cursor.getColumnIndex("alamat_supplier")));
                suppliers.add(supplier);
            }
        }

        return suppliers;
    }

    public void updateSupplier(Supplier supplier){
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama_supplier", supplier.getNama_supplier());
        contentValues.put("email_supplier", supplier.getEmail_supplier());
        contentValues.put("no_telepon_supplier", supplier.getNo_telepon_supplier());
        contentValues.put("alamat_supplier", supplier.getAlamat_supplier());
        database.update("supplier", contentValues, "kode_supplier=?", new String[]{String.valueOf(supplier.getKode_supplier())});
    }

    public void deleteSupplier(Supplier supplier){
        database.delete("supplier", "kode_supplier", new String[]{String.valueOf(supplier.getKode_supplier())});
    }
}

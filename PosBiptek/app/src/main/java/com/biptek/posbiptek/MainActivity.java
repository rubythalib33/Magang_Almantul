package com.biptek.posbiptek;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.biptek.posbiptek.model.*;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDBHelper = new DatabaseHelper(this);
        TextView textView = findViewById(R.id.textView);
        textView.append(this.getApplicationInfo().dataDir+"\n");


        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        ProdukCRUD produkCRUD = new ProdukCRUD(this);
        produkCRUD.open();
        Produk produk = produkCRUD.getProduk("2");
        produk.setDeskripsi_produk("Ubuntu 18.04");
        produkCRUD.updateProduk(produk);
        textView.append(produkCRUD.getProduk("2").toString());
        produkCRUD.close();
    }
}

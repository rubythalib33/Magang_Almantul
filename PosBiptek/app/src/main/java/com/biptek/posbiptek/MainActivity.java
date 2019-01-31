package com.biptek.posbiptek;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.biptek.posbiptek.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_admin);

//        mDBHelper = new DatabaseHelper(this);
//        TextView textView = findViewById(R.id.textView);
//        textView.append(this.getApplicationInfo().dataDir+"\n");
//
//        try {
//            mDBHelper.updateDataBase();
//        } catch (IOException mIOException) {
//            throw new Error("UnableToUpdateDatabase");
//        }
//
//        CRUD crud = new CRUD(this);
//        crud.open();
//        crud.addProduk(new Produk("2",
//                "jasa",
//                "komputer",
//                "Install Linux OS",
//                "Ubuntu 18.10",
//                50000,
//                0,
//                "unit",
//                "-",
//                30,
//                0,
//                "baru"));
//        User user = crud.getUser("odhi");
//        List<ListProdukTerjual> produkTerjuals = new ArrayList<>();
//        TransaksiPenjualan transaksiPenjualan = new TransaksiPenjualan(2, user.getUsername(), "putra", "hari ini");
//        produkTerjuals.add(new ListProdukTerjual(transaksiPenjualan.getKode_penjualan(), "1", 11));
//        produkTerjuals.add(new ListProdukTerjual(transaksiPenjualan.getKode_penjualan(), "2", 2));
//        crud.deleteTransaksiPenjualan(transaksiPenjualan);
//        textView.append(crud.getAllTransaksiPenjualan().toString());
//        //textView.append(crud.getListProdukTerjual(transaksiPenjualan.getKode_penjualan()).toString());
//        crud.close();
    }
}

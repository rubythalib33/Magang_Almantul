package com.biptek.posbiptek.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Restock;

import java.util.ArrayList;

public class laporanpembelian extends AppCompatActivity {
    ListView listLaporan;
    Button cari;
    ArrayList<Restock> restockArrayList;
    Fragment filter;
    CRUD crud;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laporanpembelian);
        listLaporan = findViewById(R.id.listviewLaporanpembelian);
        cari = findViewById(R.id.filterLaporan);
        loadlistPembelian();
    }

    private void loadlistPembelian() {
        crud.open();
        restockArrayList = crud.getAllRestock();
        crud.close();

        if(restockArrayList.isEmpty()){
            Toast.makeText(getApplicationContext(), "Data Toko Kosong !", Toast.LENGTH_SHORT).show();
        }
    }
}

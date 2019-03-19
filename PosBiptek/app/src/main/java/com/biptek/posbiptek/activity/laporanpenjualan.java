package com.biptek.posbiptek.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.TransaksiPenjualan;

import java.util.ArrayList;

public class laporanpenjualan extends AppCompatActivity {
    private ArrayList<TransaksiPenjualan> transaksiPenjualans;
    private ListView listpenjualan;
    private CRUD crud;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laporanpenjualan);

        listpenjualan = (ListView)findViewById(R.id.listviewLaporanPenjualan);

    }
}

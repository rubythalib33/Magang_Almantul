package com.biptek.posbiptek.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.adapter.LaporanPembelianAdapter;
import com.biptek.posbiptek.adapter.PenjualanAdapter;
import com.biptek.posbiptek.adapter.ProdukAdapter;
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

        loaddatalistview();
    }

    private void loaddatalistview() {
        crud.open();
        transaksiPenjualans = crud.getAllTransaksiPenjualan();
        crud.close();

        if(transaksiPenjualans.isEmpty()){
            Toast.makeText(getApplicationContext(),"Data Kosong", Toast.LENGTH_SHORT).show();
        }else {
            PenjualanAdapter penjualanAdapter = new PenjualanAdapter(this, transaksiPenjualans);
            listpenjualan.setAdapter(penjualanAdapter);
            penjualanAdapter.notifyDataSetChanged();

        }

        listpenjualan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }
}

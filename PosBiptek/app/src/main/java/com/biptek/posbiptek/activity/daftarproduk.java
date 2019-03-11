package com.biptek.posbiptek.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.adapter.ProdukAdapter;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Produk;

import java.util.ArrayList;

public class daftarproduk extends AppCompatActivity {
    private ListView listProduk;
    private ArrayList<Produk> produks;
    private CRUD crud;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftarproduk);

        Button cari = findViewById(R.id.buttonCariProduk);
        Button tambah = findViewById(R.id.buttontambahproduk);
        listProduk = findViewById(R.id.ListProduk);
        crud = new CRUD(this);
        produks = new ArrayList<>();
        loadDataListView();

        cari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(daftarproduk.this, tambahproduk.class));
            }
        });
    }

    private void loadDataListView(){
        crud.open();
        produks = crud.getAllProduk();
        crud.close();

        if(produks.isEmpty()){
            Toast.makeText(getApplicationContext(),"Data Kosong", Toast.LENGTH_SHORT).show();
        }else {
            ProdukAdapter produkAdapter = new ProdukAdapter(this, produks);
            listProduk.setAdapter(produkAdapter);
            produkAdapter.notifyDataSetChanged();

        }

        listProduk.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

}

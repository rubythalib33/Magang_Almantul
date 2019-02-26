package com.biptek.posbiptek;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Produk;

import java.util.List;

public class daftarproduk extends AppCompatActivity {
     private Button cari, tambah;
     private ListView listProduk;
     private CRUD crud;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftarproduk);

        cari = (Button)findViewById(R.id.buttonCariProduk);
        tambah = (Button)findViewById(R.id.buttontambahproduk);
        listProduk = (ListView)findViewById(R.id.ListProduk);
        crud = new CRUD(this);

        crud.open();
        List<Produk> produks = crud.getAllProduk();
        crud.close();

        if(produks.isEmpty()){
            Toast.makeText(getApplicationContext(),"Data Kosong", Toast.LENGTH_SHORT).show();
        }else {
            //belum diisi
        }

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

}

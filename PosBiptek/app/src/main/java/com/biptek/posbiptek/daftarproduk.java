package com.biptek.posbiptek;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class daftarproduk extends AppCompatActivity {
     Button cari, tambah;
     ListView listProduk;
     DatabaseHelper mdb;
     CRUD crud;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftarproduk);

        cari = (Button)findViewById(R.id.buttonCariProduk);
        tambah = (Button)findViewById(R.id.buttontambahproduk);
        listProduk = (ListView)findViewById(R.id.ListProduk);
        mdb = new DatabaseHelper(this);
        crud = new CRUD(this);

        crud.open();

        ArrayList<String> Listpro = new ArrayList<>();
        List data = crud.getAllProduk();

        if(data.isEmpty()){
            Toast.makeText(getApplicationContext(),"Data Kosong", Toast.LENGTH_SHORT).show();
        }else {
            for(int i=0; i<= data.size(); i++){
            Listpro.add(data.get(i).toString());
                ListAdapter listAdapter = new ArrayAdapter<>(this, R.layout.daftarproduk);
                listProduk.setAdapter(listAdapter);
            }
        }
        crud.close();

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

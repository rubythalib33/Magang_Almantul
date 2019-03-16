package com.biptek.posbiptek.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
        final Button tambah = findViewById(R.id.buttontambahproduk);
        listProduk = findViewById(R.id.ListProduk);
        EditText editTextSearchProduk = (EditText) findViewById(R.id.editTextSearchProduk);
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
                Intent addProduk = new Intent(daftarproduk.this, tambahproduk.class);
                addProduk.putExtra("mode", "add");
                startActivity(addProduk);
            }
        });

        editTextSearchProduk.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadDataListView();
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
                Intent updateProduk = new Intent(daftarproduk.this, tambahproduk.class);
                updateProduk.putExtra("mode", "update");
                updateProduk.putExtra("kode_produk", produks.get(position).getKode_produk());
                startActivity(updateProduk);
            }
        });
    }

}

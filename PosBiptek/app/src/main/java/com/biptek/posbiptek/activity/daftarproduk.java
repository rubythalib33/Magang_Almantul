package com.biptek.posbiptek.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.adapter.ProdukAdapter;
import com.biptek.posbiptek.fragment.FragmentDeleteConfirmation;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Produk;

import java.util.ArrayList;

public class daftarproduk extends AppCompatActivity {
    private ListView listProduk;
    private ArrayList<Produk> produks;
    private ProdukAdapter produkAdapter;
    private CRUD crud;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftarproduk);

        Button tambah = findViewById(R.id.buttontambahproduk);
        listProduk = findViewById(R.id.ListProduk);
        EditText editTextSearchProduk = findViewById(R.id.editTextSearchProduk);
        crud = new CRUD(this);
        produks = new ArrayList<>();
        loadDataListView();

        editTextSearchProduk.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                produkAdapter.getFilter().filter(s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println("Text ["+s+"]");
                produkAdapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                produkAdapter.getFilter().filter(s.toString());
            }
        });

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addProduk = new Intent(daftarproduk.this, TambahProduk.class);
                addProduk.putExtra("mode", "add");
                startActivity(addProduk);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadDataListView();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        loadDataListView();
    }

    private void loadDataListView(){
        crud.open();
        produks = crud.getAllProduk();
        crud.close();

        if(produks.isEmpty()){
            Toast.makeText(getApplicationContext(),"Data Kosong", Toast.LENGTH_SHORT).show();
        }

        produkAdapter = new ProdukAdapter(this, produks);
        listProduk.setAdapter(produkAdapter);
        produkAdapter.notifyDataSetChanged();

        listProduk.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent updateProduk = new Intent(daftarproduk.this, TambahProduk.class);
                updateProduk.putExtra("mode", "update");
                updateProduk.putExtra("kode_produk", ((Produk) produkAdapter.getItem(position)).getKode_produk());
                startActivity(updateProduk);
            }
        });

        listProduk.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment deleteConfirmation = new FragmentDeleteConfirmation();
                Bundle bundle = new Bundle();
                bundle.putString("KODEPRODUK", ((Produk) produkAdapter.getItem(position)).getKode_produk());
                bundle.putString("menu", "produk");
                deleteConfirmation.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerProduk, deleteConfirmation).addToBackStack(null).commit();
                return true;
            }
        });
    }

}

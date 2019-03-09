package com.biptek.posbiptek.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.adapter.KontakAdapter;
import com.biptek.posbiptek.adapter.PegawaiAdapter;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.DatabaseHelper;
import com.biptek.posbiptek.model.Supplier;

import java.util.ArrayList;
import java.util.List;

public class daftarkontak extends AppCompatActivity {

    private CRUD crud;
    ListView listSupplier;
    KontakAdapter kontakAdapter;
    ArrayList<Supplier> supplier;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftarkontak);

        listSupplier = (ListView)findViewById(R.id.listviewKontak);
        crud = new CRUD(this);
        supplier = new ArrayList<>();
//        loadDataListView();

    }

    private void loadDataListView() {
    //    crud.open();
  //      supplier = crud.getAllSupplier();
  //      crud.close();

        if(supplier.isEmpty()){
            Toast.makeText(getApplicationContext(),"Data Kosong", Toast.LENGTH_SHORT).show();
        }else {
            kontakAdapter = new KontakAdapter(this, supplier);
            listSupplier.setAdapter(kontakAdapter);
            kontakAdapter.notifyDataSetChanged();
        }
    }
}

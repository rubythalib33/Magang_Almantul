package com.biptek.posbiptek;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class daftarkontak extends AppCompatActivity {

    private DatabaseHelper mdb;
    private CRUD crud;
    ListView listSupplier;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftarkontak);

        listSupplier = (ListView)findViewById(R.id.ListHutang);
        mdb = new DatabaseHelper(this);
        crud = new CRUD(this);
        crud.open();

        ArrayList<String> Listkontaksupplier = new ArrayList<>();
        List datasupplier = crud.getAllProduk();

        if(datasupplier.isEmpty()){
            Toast.makeText(getApplicationContext(),"Data Kosong", Toast.LENGTH_SHORT).show();
        }else {
            for(int i=0; i<= datasupplier.size(); i++){
                Listkontaksupplier.add(datasupplier.get(i).toString());
                ListAdapter listAdapter = new ArrayAdapter<>(this, R.layout.daftarkontak);
                listSupplier.setAdapter(listAdapter);
            }
        }
        crud.close();

    }
}

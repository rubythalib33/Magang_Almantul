package com.biptek.posbiptek.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Supplier;

import java.util.ArrayList;

public class daftarkontak extends AppCompatActivity {

    private CRUD crud;
    private ListView listSupplier;
    private ArrayList<Supplier> supplier;
    private Fragment popUpSupplier;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftarkontak);

        listSupplier = findViewById(R.id.listviewKontak);
        crud = new CRUD(this);
        supplier = new ArrayList<>();
        //Fragment cuyy baru kesini

    }

}

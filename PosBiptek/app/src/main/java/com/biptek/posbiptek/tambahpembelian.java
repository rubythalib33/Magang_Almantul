package com.biptek.posbiptek;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class tambahpembelian extends AppCompatActivity {
    Button pProduk, batalPembelian;
    String spinnerList[] = {};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambahpembelian);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, spinnerList);
        MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner)findViewById(R.id.NamaSuplierSpinner);
        betterSpinner.setAdapter(arrayAdapter);

        pProduk = (Button)findViewById(R.id.buttonpilihprodukpembelian);
        batalPembelian = (Button)findViewById(R.id.buttonbatalpembelian);

        pProduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tambahpembelian.this, pilihprodukpembelian.class));
            }
        });

        batalPembelian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tambahpembelian.this, homeadmin.class));
            }
        });
    }
}

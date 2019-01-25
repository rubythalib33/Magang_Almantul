package com.biptek.posbiptek;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class pilihprodukpembelian extends AppCompatActivity {
    Button bSimpanPilihan, bBatalPilih;
    String[] satuanProduk = {};
    String [] kategoriProduk = {};
    String [] jenisProduk = {};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plihprodukpembelian);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, satuanProduk);
        MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner)findViewById(R.id.SatuanProdukPembelian);
        betterSpinner.setAdapter(arrayAdapter);

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, kategoriProduk);
        MaterialBetterSpinner betterSpinner2 = (MaterialBetterSpinner)findViewById(R.id.KategoriProdukPembelian);
        betterSpinner2.setAdapter(arrayAdapter2);

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, jenisProduk);
        MaterialBetterSpinner materialBetterSpinner = (MaterialBetterSpinner)findViewById(R.id.JenisProdukPembelian);
        materialBetterSpinner.setAdapter(stringArrayAdapter);

        bSimpanPilihan = (Button)findViewById(R.id.buttonsimpanpilihan);
        bBatalPilih = (Button)findViewById((R.id.buttonbatalpilih));

        bSimpanPilihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Data Berhasil di Tambahkan", Toast.LENGTH_SHORT).show();
            }
        });

        bBatalPilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pilihprodukpembelian.this, tambahpembelian.class));
            }
        });
    }
}

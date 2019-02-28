package com.biptek.posbiptek.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.model.*;

public class tambahproduk extends AppCompatActivity {
    final Context context = this;
    Button simpan,batal;
    EditText kodeProduk, jenisProduk, kategoriProduk, namaProduk, deskripsiProduk, hargaJual,
             hargaBeli, satuanProduk, gambarProduk, stokProduk, stokKritisProduk, statusProduk;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambahproduk);

        simpan = findViewById(R.id.buttonsimpantambahproduk);
        batal = findViewById(R.id.bataltambahproduk);

        kodeProduk = findViewById(R.id.kodeTambahroduk);
        jenisProduk = findViewById(R.id.jenisTambahProduk);
        kategoriProduk = findViewById(R.id.kategoriTambahProduk);
        namaProduk = findViewById(R.id.namaTambahroduk);
        deskripsiProduk = findViewById(R.id.deskripsiTambahProduk);
        hargaJual = findViewById(R.id.hargaJual);
        hargaBeli = findViewById(R.id.hargaBeli);
        satuanProduk = findViewById(R.id.satuanTambahProduk);
        gambarProduk = findViewById(R.id.gambarTambahProduk);
        stokProduk = findViewById(R.id.StokTambahProduk);
        stokKritisProduk = findViewById(R.id.StokKritisProduk);
        statusProduk = findViewById(R.id.statusTambahProduk);


        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CRUD crud = new CRUD(context);
                crud.open();
                crud.addProduk(new Produk(
                        kodeProduk.getText().toString(),
                        jenisProduk.getText().toString(),
                        kategoriProduk.getText().toString(),
                        namaProduk.getText().toString(),
                        deskripsiProduk.getText().toString(),
                        Integer.parseInt(hargaJual.getText().toString()),
                        Integer.parseInt(hargaBeli.getText().toString()),
                        satuanProduk.getText().toString(),
                        gambarProduk.getText().toString(),
                        Integer.parseInt(stokProduk.getText().toString()),
                        Integer.parseInt(stokKritisProduk.getText().toString()),
                        statusProduk.getText().toString()
                ));
                crud.close();
                Toast.makeText(getApplicationContext(), "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
            }
        });

        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tambahproduk.this, daftarproduk.class);
                startActivity(intent);
            }
        });

    }
}

package com.biptek.posbiptek.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.model.*;

public class tambahproduk extends AppCompatActivity {
    EditText kodeProduk, kategoriProduk, namaProduk, deskripsiProduk, hargaJual,
             hargaBeli, satuanProduk, gambarProduk, stokProduk, stokKritisProduk, statusProduk;
    Spinner jenisProduk;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambahproduk);

        kodeProduk = findViewById(R.id.kodeTambahProduk);
        jenisProduk = findViewById(R.id.jenisTambahProduk);
        kategoriProduk = findViewById(R.id.kategoriTambahProduk);
        namaProduk = findViewById(R.id.namaTambahProduk);
        deskripsiProduk = findViewById(R.id.deskripsiTambahProduk);
        hargaJual = findViewById(R.id.hargaJualTambahProduk);
        hargaBeli = findViewById(R.id.hargaBeliTambahProduk);
        satuanProduk = findViewById(R.id.satuanTambahProduk);
        gambarProduk = findViewById(R.id.gambarTambahProduk);
        stokProduk = findViewById(R.id.StokTambahProduk);
        stokKritisProduk = findViewById(R.id.StokKritisTambahProduk);
        statusProduk = findViewById(R.id.statusTambahProduk);

        ArrayAdapter<String> listJenisProduk = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,
                new String[]{"barang", "jasa"});
        jenisProduk.setAdapter(listJenisProduk);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data.getStringExtra("mode").equals("update")){
            CRUD crud = new CRUD(this);
            crud.open();
            Produk produk = crud.getProduk(data.getStringExtra("kode_produk"));
            crud.close();
            kodeProduk.setText(produk.getKode_produk());
            jenisProduk.setSelection();
        }
    }

    public void clickTambahProduk(View view){
        CRUD crud = new CRUD(this);
        crud.open();
        crud.addProduk(new Produk(
                kodeProduk.getText().toString(),
                jenisProduk.getSelectedItem().toString(),
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
        onBackPressed();
    }

    public void clickBatalTambahProduk(View view){
        onBackPressed();
    }

    public void clickBarcodeTambahProduk(View view){
        startActivity(new Intent(tambahproduk.this, BarcodeScanner.class));
    }
}

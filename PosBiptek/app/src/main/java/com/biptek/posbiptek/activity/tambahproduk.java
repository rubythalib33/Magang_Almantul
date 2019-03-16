package com.biptek.posbiptek.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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
    protected void onResume() {
        super.onResume();
        if (getIntent().getStringExtra("mode").equals("update")) {
            CRUD crud = new CRUD(this);
            crud.open();
            Produk produk = crud.getProduk(getIntent().getStringExtra("kode_produk"));
            crud.close();
            kodeProduk.setText(produk.getKode_produk());

            if (!produk.getJenis_produk().equals(jenisProduk.getSelectedItem().toString()))
                jenisProduk.setSelection(1);

            kategoriProduk.setText(produk.getKategori_produk());
            namaProduk.setText(produk.getNama_produk());
            deskripsiProduk.setText(produk.getDeskripsi_produk());
            hargaJual.setText(String.valueOf(produk.getHarga_jual_produk()));
            hargaBeli.setText(String.valueOf(produk.getHarga_beli_produk()));
            satuanProduk.setText(produk.getSatuan_produk());
            gambarProduk.setText(produk.getGambar_produk());
            stokProduk.setText(String.valueOf(produk.getStok_produk()));
            stokKritisProduk.setText(String.valueOf(produk.getStok_kritis_produk()));
            statusProduk.setText(produk.getStatus_produk());

            TextView updateProduk = findViewById(R.id.textViewTambahProduk);
            updateProduk.setText("Update Produk");

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

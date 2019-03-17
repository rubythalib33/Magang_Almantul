package com.biptek.posbiptek.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Produk;

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

        if (getIntent().getStringExtra("mode").equals("update")) {
            CRUD crud = new CRUD(this);
            crud.open();
            Produk produk = crud.getProduk(getIntent().getStringExtra("kode_produk"));
            crud.close();
            kodeProduk.setText("Kode Produk : "+produk.getKode_produk());
            kodeProduk.setEnabled(false);
            Button barcodeScanner = findViewById(R.id.BarcodeTambahProduk);
            barcodeScanner.setVisibility(View.INVISIBLE);

            if (!produk.getJenis_produk().equals(jenisProduk.getItemAtPosition(0)))
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK)
            kodeProduk.setText(data.getStringExtra("barcodeResult"));
    }

    public void clickTambahProduk(View view){
        Produk produk = new Produk(
                getIntent().getStringExtra("kode_produk"),
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
        );
        CRUD crud = new CRUD(this);
        crud.open();
        if (getIntent().getStringExtra("mode").equals("update")) {
            crud.updateProduk(produk);
            crud.close();
            onBackPressed();
        }
        else if (crud.addProduk(produk)) {
            crud.close();
            onBackPressed();
        }
        else {
            Toast.makeText(this, "Kode Produk sudah digunakan sebelumnya !", Toast.LENGTH_LONG).show();
            crud.close();
        }
    }

    public void clickBatalTambahProduk(View view){
        onBackPressed();
    }

    public void clickBarcodeTambahProduk(View view){
        startActivityForResult(new Intent(tambahproduk.this, BarcodeScanner.class), 1);
    }
}

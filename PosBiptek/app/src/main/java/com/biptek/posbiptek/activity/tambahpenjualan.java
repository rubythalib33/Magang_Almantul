package com.biptek.posbiptek.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.adapter.ProdukAdapter;
import com.biptek.posbiptek.fragment.FragmentPenjualan;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Produk;

import java.util.ArrayList;

public class tambahpenjualan extends AppCompatActivity {
    private ArrayList<Produk> items;
    private ListView listItems;
    private TextView totalHarga;
    private CRUD crud;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambahpenjualan);

        listItems = findViewById(R.id.listProdukTerjual);
        totalHarga = findViewById(R.id.totalHargaPenjualan);
        crud = new CRUD(this);
        items = new ArrayList<>();
        loadDataListView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            crud.open();
            items.add(crud.getProduk(data.getStringExtra("barcodeResult")));
            crud.close();
            loadDataListView();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        loadDataListView();
    }

    public void loadDataListView(){
        ProdukAdapter produkAdapter = new ProdukAdapter(this, items);
        listItems.setAdapter(produkAdapter);
    }

    public void getKodeProduk(String kodeProduk){
        crud.open();
        items.add(crud.getProduk(kodeProduk));
        crud.close();
    }

    public void clickPilihProdukPenjualan(View view){
        Fragment pilihProduk = new FragmentPenjualan();
        getSupportFragmentManager().beginTransaction().replace(R.id.popUpSearchProdukPenjualan, pilihProduk).addToBackStack(null).commit();
    }

    public void clickSimpanPenjualan(View view){

    }

    public void clickBatalPenjualan(View view){
        onBackPressed();
    }

    public void clickBarcodePenjualan(View view){
        startActivityForResult(new Intent(tambahpenjualan.this, BarcodeScanner.class), 1);
    }
}

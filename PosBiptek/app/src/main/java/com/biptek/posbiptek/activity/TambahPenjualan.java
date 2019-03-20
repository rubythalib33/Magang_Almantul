package com.biptek.posbiptek.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.adapter.PenjualanAdapter;
import com.biptek.posbiptek.fragment.FragmentPenjualan;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Produk;

import java.util.ArrayList;

public class TambahPenjualan extends AppCompatActivity {
    private ArrayList<Produk> items;
    private ArrayList<Integer> produkFilter;
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
        produkFilter = new ArrayList<>();
        loadDataListView();
        updateViewHeight();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            crud.open();
            items.add(crud.getProduk(data.getStringExtra("barcodeResult")));
            crud.close();
            loadDataListView();
            updateViewHeight();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        loadDataListView();
        updateViewHeight();
    }

    private void updateViewHeight(){
        ListAdapter listAdapter = listItems.getAdapter();
        if(listAdapter == null)
            return;

        int desireWidth = View.MeasureSpec.makeMeasureSpec(listItems.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for(int i = 0; i<listAdapter.getCount(); i++){
            view = listAdapter.getView(i, view, listItems);
            if(i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desireWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desireWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();

        }
        ViewGroup.LayoutParams params = listItems.getLayoutParams();
        params.height = totalHeight+(listItems.getDividerHeight()*(listAdapter.getCount()-1));
        listItems.setLayoutParams(params);
    }

    public void totalBiaya(int subTotal, boolean increase){
        if(increase)
            totalHarga.setText(String.valueOf(Integer.parseInt(totalHarga.getText().toString())+subTotal));
        else
            totalHarga.setText(String.valueOf(Integer.parseInt(totalHarga.getText().toString())-subTotal));
    }

    public void loadDataListView(){
        PenjualanAdapter penjualanAdapter = new PenjualanAdapter(this, items);
        listItems.setAdapter(penjualanAdapter);
    }

    public void addItemBeli(String kodeProduk){
        crud.open();
        items.add(crud.getProduk(kodeProduk));
        crud.close();
    }

    public void addIndexKodeProduk(int position){
        produkFilter.add(position);
    }

    public void removeIndexKodeProduk(int position){
        produkFilter.remove(position);
    }

    public void clickPilihProdukPenjualan(View view){
        Fragment pilihProduk = new FragmentPenjualan();
        Bundle bundle = new Bundle();
        bundle.putIntegerArrayList("produkFilter", produkFilter);
        pilihProduk.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.popUpSearchProdukPenjualan, pilihProduk).addToBackStack(null).commit();
    }

    public void clickSimpanPenjualan(View view){

    }

    public void clickBatalPenjualan(View view){
        onBackPressed();
    }

    public void clickBarcodePenjualan(View view){
        startActivityForResult(new Intent(TambahPenjualan.this, BarcodeScanner.class), 1);
    }
}

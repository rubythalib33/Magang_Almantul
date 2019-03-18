package com.biptek.posbiptek.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.adapter.ProdukAdapter;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Produk;

import java.util.ArrayList;

public class FragmentPenjualan extends Fragment {
    private View view;
    private ListView listProduk;
    private ArrayList<Produk> produkArrayList;
    private ProdukAdapter produkAdapter;
    private EditText searchProduk;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_penjualan, container,false);

        listProduk = view.findViewById(R.id.listProdukPenjualan);
        searchProduk = view.findViewById(R.id.popUpSearchProdukPenjualan);
        loadDataListView();

        searchProduk.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println("Text ["+s+"]");
                produkAdapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }

    private void loadDataListView(){
        CRUD crud = new CRUD(getContext());
        produkArrayList = crud.getAllProduk();
        crud.close();

        if(produkArrayList.isEmpty())
            Toast.makeText(getContext(), "Data Kosong !", Toast.LENGTH_SHORT).show();

        produkAdapter = new ProdukAdapter(getContext(), produkArrayList);
        listProduk.setAdapter(produkAdapter);
        produkAdapter.notifyDataSetChanged();

        listProduk.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}

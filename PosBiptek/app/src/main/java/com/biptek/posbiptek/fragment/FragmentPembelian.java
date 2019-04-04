package com.biptek.posbiptek.fragment;

import android.content.res.Configuration;
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
import com.biptek.posbiptek.activity.TambahPenjualan;
import com.biptek.posbiptek.adapter.ProdukAdapter;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Produk;

import java.util.ArrayList;
import java.util.Objects;

public class FragmentPembelian extends Fragment {
    private ListView listProduk;
    private ProdukAdapter produkAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentpembelian, container, false);

        listProduk = view.findViewById(R.id.listProdukPembelian);
        EditText searchProduk = view.findViewById(R.id.searchProdukPembelian);
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

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO) {
        } else if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_YES) {
        }
    }

    private void loadDataListView(){
        CRUD crud = new CRUD(getContext());
        crud.open();
        ArrayList<Produk> produkArrayList = crud.getAllProduk();
        crud.close();

        if(produkArrayList.isEmpty())
            Toast.makeText(getContext(), "Data Kosong !", Toast.LENGTH_SHORT).show();

        produkAdapter = new ProdukAdapter(getContext(), produkArrayList);
        for(int filter : getArguments().getIntegerArrayList("produkFilter")){
            produkArrayList.remove(filter);
        }
        listProduk.setAdapter(produkAdapter);
        produkAdapter.notifyDataSetChanged();


        listProduk.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TambahPenjualan tambahPenjualan = (TambahPenjualan) getActivity();
                tambahPenjualan.addItemBeli(((Produk)produkAdapter.getItem(position)).getKode_produk());
                tambahPenjualan.addIndexKodeProduk(position);
                Objects.requireNonNull(getActivity()).onBackPressed();
            }
        });
    }
}
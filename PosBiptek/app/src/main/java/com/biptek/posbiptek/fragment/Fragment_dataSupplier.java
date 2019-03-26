package com.biptek.posbiptek.fragment;

import android.content.Intent;
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
import android.widget.ListAdapter;
import android.widget.Toast;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.activity.tambahpembelian;
import com.biptek.posbiptek.adapter.SupplierAdapter;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Supplier;

import java.util.ArrayList;
import java.util.Objects;

public class Fragment_dataSupplier extends Fragment {
    private ListView listSupplier;
    private SupplierAdapter supplierAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentsupplier, container, false);

        listSupplier = view.findViewById(R.id.listfragmentSupplier);
        loadDataListViewSupplier();
        return view;
    }

    private void loadDataListViewSupplier() {
        CRUD crud = new CRUD(getContext());
        crud.open();
        final ArrayList<Supplier> suppliers = crud.getAllSupplier();
        crud.close();

        if(suppliers.isEmpty())
            Toast.makeText(getContext().getApplicationContext(), "Data Supplier Kosong !", Toast.LENGTH_SHORT).show();

        supplierAdapter = new SupplierAdapter(getContext(), suppliers);
        listSupplier.setAdapter(supplierAdapter);
        supplierAdapter.notifyDataSetChanged();

        listSupplier.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity().getBaseContext(), tambahpembelian.class);
                intent.putExtra("namasupplier", suppliers.get(position).getNama_supplier());
                getActivity().startActivity(intent);
            }
        });

    }
}

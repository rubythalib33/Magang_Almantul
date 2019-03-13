package com.biptek.posbiptek.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.adapter.SupplierAdapter;
import com.biptek.posbiptek.fragment.FragmentDeleteConfirmation;
import com.biptek.posbiptek.fragment.FragmentSupplier;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Supplier;

import java.util.ArrayList;

public class daftarkontak extends AppCompatActivity {

    private CRUD crud;
    private ListView listSupplier;
    private ArrayList<Supplier> supplier;
    private Fragment popUpSupplier;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftarKontak);

        listSupplier = findViewById(R.id.listviewKontak);
        crud = new CRUD(this);
        supplier = new ArrayList<>();
        popUpSupplier = new FragmentSupplier();
        loadListToko();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        loadListToko();
    }

    public void clickTambahSupplier(View view){
        Bundle bundle = new Bundle();
        bundle.putInt("mode", 1);
        popUpSupplier.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerSupplier, popUpSupplier);
    }

    private void loadListToko(){
        crud.open();
        supplier = crud.getAllSupplier();
        crud.close();

        if(supplier.isEmpty())
            Toast.makeText(getApplicationContext(), "Data Supplier Kosong !", Toast.LENGTH_SHORT).show();

        SupplierAdapter supplierAdapter = new SupplierAdapter(this, supplier);
        listSupplier.setAdapter(supplierAdapter);
        supplierAdapter.notifyDataSetChanged();

        listSupplier.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putInt("mode", 2);
                bundle.putLong("idSupplier", supplier.get(position).getKode_supplier());
                popUpSupplier.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerManajemenToko, popUpSupplier).addToBackStack(null).commit();
            }
        });

        listSupplier.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment deleteConfirmation = new FragmentDeleteConfirmation();
                Bundle bundle = new Bundle();
                bundle.putLong("idSupplier", supplier.get(position).getKode_supplier());
                deleteConfirmation.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerManajemenToko, deleteConfirmation).addToBackStack(null).commit();
                return true;
            }
        });
    }


}

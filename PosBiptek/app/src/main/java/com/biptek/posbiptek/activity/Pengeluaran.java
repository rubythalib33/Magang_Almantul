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

public class Pengeluaran extends AppCompatActivity {

    private CRUD crud;
    private ListView listPengeluaran;
    private ArrayList<Pengeluaran> pengeluaran;
    private Fragment popUpPengeluaran;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pengeluaran);

        listPengeluaran = findViewById(R.id.listviewKontak);
        crud = new CRUD(this);
        pengeluaran = new ArrayList<>();
        popUpPengeluaran = new FragmentPengeluaran();
        loadListToko();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        loadListToko();
    }

    public void clickTambahPengeluaran(View view){
        Bundle bundle = new Bundle();
        bundle.putInt("mode", 1);
        popUpPengeluaran.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerPengeluaran, popUpPengeluaran).addToBackStack(null).commit();
    }

    private void loadListToko(){
        crud.open();
        pengeluaran = crud.getAllPengeluaran();
        crud.close();

        if(pengeluaran.isEmpty())
            Toast.makeText(getApplicationContext(), "Data Pengeluaran Kosong !", Toast.LENGTH_SHORT).show();

        PengeluaranAdapter pengeluaranAdapter = new PengeluaranAdapter(this, pengeluaran);
        listPengeluaran.setAdapter(PengeluaranAdapter);
        PengeluaranAdapter.notifyDataSetChanged();

        listPengeluaran.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putInt("mode", 2);
                bundle.putLong("idPengeluaran", pengeluaran.get(position).getKode_Pengeluaran());
                popUpPengeluaran.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerPengeluaran, popUpPengeluaran).addToBackStack(null).commit();
            }
        });

        listPengeluaran.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment deleteConfirmation = new FragmentDeleteConfirmation();
                Bundle bundle = new Bundle();
                bundle.putLong("idPengeluaran", pengeluaran.get(position).getKode_Pengeluaran());
                bundle.putString("menu", "pengeluaran");
                deleteConfirmation.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerPengeluaran, deleteConfirmation).addToBackStack(null).commit();
                return true;
            }
        });
    }


}

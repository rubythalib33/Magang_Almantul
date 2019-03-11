package com.biptek.posbiptek.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.adapter.TokoAdapter;
import com.biptek.posbiptek.fragment.FragmentManajemenToko;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Toko;

import java.util.ArrayList;

public class ManajemenToko extends AppCompatActivity {
    private ListView daftarToko;
    private CRUD crud;
    private ArrayList<Toko> tokoArrayList;
    private Fragment popUpToko;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manajemen_toko);

        daftarToko = findViewById(R.id.ListToko);
        crud = new CRUD(this);
        tokoArrayList = new ArrayList<>();
        bundle = new Bundle();
        popUpToko = new FragmentManajemenToko();
        loadListToko();
    }

    public void clickTambahToko(View view){
        bundle.putInt("mode", 1);
        bundle.putLong("idToko", -1);
        popUpToko.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerManajemenToko, popUpToko).addToBackStack(null).commit();
    }

    private void loadListToko(){
        crud.open();
        tokoArrayList = crud.getAllToko();
        crud.close();

        if(tokoArrayList.isEmpty()){
            Toast.makeText(getApplicationContext(), "Data Toko Kosong !", Toast.LENGTH_SHORT).show();
        }
        else {
            TokoAdapter tokoAdapter = new TokoAdapter(this, tokoArrayList);
            daftarToko.setAdapter(tokoAdapter);
            tokoAdapter.notifyDataSetChanged();
        }

        daftarToko.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                bundle.putInt("mode", 2);
                bundle.putLong("idToko", tokoArrayList.get(position).getKode_toko());
                popUpToko.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerManajemenToko, popUpToko).addToBackStack(null).commit();
            }
        });
    }
}

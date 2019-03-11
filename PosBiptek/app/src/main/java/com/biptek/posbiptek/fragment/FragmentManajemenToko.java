package com.biptek.posbiptek.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Toko;

import java.util.Objects;

public class FragmentManajemenToko extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_manajemen_toko, container, false);
        final CRUD crud = new CRUD(getActivity());

        Button simpanToko = view.findViewById(R.id.fragmentTokoSimpan);
        Button batalToko = view.findViewById(R.id.fragmentTokoBatal);

        //untuk update toko
        if(getArguments().getLong("idToko", -1) != -1){
            crud.open();
            Toko toko = crud.getToko(getArguments().getLong("idToko"));
            crud.close();
            ((TextView)view.findViewById(R.id.fragmentDataToko)).setText("Update Toko");
            ((EditText)view.findViewById(R.id.fragmentNamaToko)).setText(toko.getNama_toko());
            ((EditText)view.findViewById(R.id.fragmentAlamatToko)).setText(toko.getAlamat_toko());
            ((EditText)view.findViewById(R.id.fragmentNoTelpToko)).setText(toko.getNo_telepon_toko());
        }

        simpanToko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toko toko = new Toko();
                EditText namaToko = view.findViewById(R.id.fragmentNamaToko);
                EditText alamatToko = view.findViewById(R.id.fragmentAlamatToko);
                EditText noTelpToko = view.findViewById(R.id.fragmentNoTelpToko);

                if (namaToko.getText().toString().equals(""))
                    namaToko.setError("Tidak boleh kosong !");
                else
                    toko.setNama_toko(namaToko.getText().toString());

                if (alamatToko.getText().toString().equals(""))
                    alamatToko.setError("Tidak boleh kosong !");
                else
                    toko.setAlamat_toko(alamatToko.getText().toString());

                if (noTelpToko.getText().toString().matches("^[0-9,+]{10,}$"))
                    toko.setNo_telepon_toko(noTelpToko.getText().toString());
                else
                    noTelpToko.setError("Silahkan isi nomor telepon toko dengan benar !");

                //Untuk tambah Toko
                if(getArguments().getInt("mode") == 1){
                    crud.open();
                    long idToko = crud.addToko(toko);
                    crud.close();
                    if(idToko != -1)
                        Objects.requireNonNull(getActivity()).onBackPressed();
                }
                //untuk update toko
                else if (getArguments().getInt("mode") == 2){
                    crud.open();
                    crud.updateToko(toko);
                    crud.close();
                    Objects.requireNonNull(getActivity()).onBackPressed();
                }
            }
        });

        batalToko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Objects.requireNonNull(getActivity()).onBackPressed();

            }
        });

        return view;
    }
}

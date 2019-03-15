package com.biptek.posbiptek.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.model.CRUD;

import java.util.Objects;

public class FragmentDeleteConfirmation extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delete_confirmation, container, false);
        Button ya = view.findViewById(R.id.fragmentDeleteYa);
        Button tidak = view.findViewById(R.id.fragmentDeleteTidak);

        ya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CRUD crud = new CRUD(getContext());
                crud.open();
                switch (getArguments().getString("menu")){
                    case "toko":
                        crud.deleteToko(getArguments().getLong("idToko"));
                        crud.close();
                        break;
                    case "pegawai":
                        crud.deletePegawai(getArguments().getString("USERNAME"));
                        crud.close();
                        break;
                    case "admin":
                        crud.deleteAdmin(getArguments().getString("USERNAMEADMIN"));
                        crud.close();
                        break;
                    case "produk":
                        crud.deleteProduk(getArguments().getString("KODEPRODUK"));
                        crud.close();
                        break;
                    case "supplier":
                        crud.deleteSupplier(getArguments().getLong("idSupplier"));
                        crud.close();
                        break;
                }
                Objects.requireNonNull(getActivity()).onBackPressed();
            }
        });

        tidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Objects.requireNonNull(getActivity()).onBackPressed();
            }
        });

        return view;
    }
}

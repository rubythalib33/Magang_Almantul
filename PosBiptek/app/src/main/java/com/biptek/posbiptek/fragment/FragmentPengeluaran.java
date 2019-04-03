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
import com.biptek.posbiptek.SessionData;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Supplier;

import java.util.Objects;

public class FragmentPengeluaran extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pengeluaran, container, false);
        final CRUD crud = new CRUD(getContext());

        Button simpanSupplier = view.findViewById(R.id.fragmentPengeluaraSimpan);
        Button batalSupplier = view.findViewById(R.id.fragmentPengeluaranBatal);
        final EditText namaSupplier = view.findViewById(R.id.fragmentTokoPengeluaran);
        final EditText alamatSupplier = view.findViewById(R.id.fragmentKodePengeluaran);
        final EditText noTelpSupplier = view.findViewById(R.id.fragmentTanggalPengeluaran);
        final EditText emailSupplier = view.findViewById(R.id.fragmentJumlahPengeluaran);

        simpanSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SessionData sessionData = new SessionData(getContext());
                Supplier supplier = new Supplier();

                if (namaSupplier.getText().toString().equals(""))
                    namaSupplier.setError("Tidak boleh kosong !");
                else
                    supplier.setNama_supplier(namaSupplier.getText().toString());

                if (alamatSupplier.getText().toString().equals(""))
                    alamatSupplier.setError("Tidak boleh kosong !");
                else
                    supplier.setAlamat_supplier(alamatSupplier.getText().toString());

                if (noTelpSupplier.getText().toString().matches("^[0-9,+]{10,}$"))
                    supplier.setNo_telepon_supplier(noTelpSupplier.getText().toString());
                else
                    noTelpSupplier.setError("Silahkan isi nomor telepon Supplier dengan benar !");

                if (emailSupplier.getText().toString().equals(""))
                    emailSupplier.setError("Tidak boleh kosong !");
                else if(emailSupplier.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+"))
                    supplier.setEmail_supplier(emailSupplier.getText().toString());
                else
                    emailSupplier.setError("Email Tidak Valid");

                //Untuk tambah Supplier
                if(getArguments().getInt("mode") == 1){
                    crud.open();
                    long idSupplier = crud.addSupplier(supplier);
                    crud.close();
                    if(idSupplier != -1)
                        Objects.requireNonNull(getActivity()).onBackPressed();
                }
                //untuk update Supplier
                else if (getArguments().getInt("mode") == 2){
                    supplier.setKode_supplier(getArguments().getLong("idSupplier"));
                    crud.open();
                    crud.updateSupplier(supplier);
                    crud.close();
                    Objects.requireNonNull(getActivity()).onBackPressed();
                }
            }
        });

        batalSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Objects.requireNonNull(getActivity()).onBackPressed();

            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        CRUD crud = new CRUD(getContext());

        //untuk update Supplier
        if(getArguments().getInt("mode") == 2){
            crud.open();
            Supplier supplier = crud.getSupplier(getArguments().getLong("idSupplier"));
            crud.close();
            ((TextView) view.findViewById(R.id.fragmentDataPengeluaran)).setText("Update Supplier");
            ((EditText)view.findViewById(R.id.fragmentTokoPengeluaran)).setText(supplier.getNama_supplier());
            ((EditText)view.findViewById(R.id.fragmentKodePengeluaran)).setText(supplier.getAlamat_supplier());
            ((EditText)view.findViewById(R.id.fragmentNoTelpSupplier)).setText(supplier.getNo_telepon_supplier());
            ((EditText)view.findViewById(R.id.fragmentEmailSupplier)).setText(supplier.getEmail_supplier());
        }
        else if(getArguments().getInt("mode") == 1) {
            ((EditText)view.findViewById(R.id.fragmentTokoPengeluaran)).setText("");
            ((EditText)view.findViewById(R.id.fragmentKodePengeluaran)).setText("");
            ((EditText)view.findViewById(R.id.fragmentNoTelpSupplier)).setText("");
            ((EditText)view.findViewById(R.id.fragmentEmailSupplier)).setText("");
        }

    }
}

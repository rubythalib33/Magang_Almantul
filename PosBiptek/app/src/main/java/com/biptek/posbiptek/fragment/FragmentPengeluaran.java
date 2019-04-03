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
import com.biptek.posbiptek.model.Pengeluaran;

import java.util.Objects;

public class FragmentPengeluaran extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pengeluaran, container, false);
        final CRUD crud = new CRUD(getContext());

        Button simpanPengeluaran = view.findViewById(R.id.fragmentPengeluaraSimpan);
        Button batalPengeluaran = view.findViewById(R.id.fragmentPengeluaranBatal);
        final EditText namaTokoPengeluaran = view.findViewById(R.id.fragmentTokoPengeluaran);
        final EditText kodePengeluaran = view.findViewById(R.id.fragmentKodePengeluaran);
        final EditText tanggalPengeluaran = view.findViewById(R.id.fragmentTanggalPengeluaran);
        final EditText jumlahPengeluaran = view.findViewById(R.id.fragmentJumlahPengeluaran);

        simpanPengeluaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SessionData sessionData = new SessionData(getContext());
                Pengeluaran pengeluaran = new Pengeluaran();

                if (namaTokoPengeluaran.getText().toString().equals(""))
                    namaTokoPengeluaran.setError("Tidak boleh kosong !");
                else
                    pengeluaran.setKode_toko_pengeluaran(Long.parseLong(namaTokoPengeluaran.getText().toString()));

                if (kodePengeluaran.getText().toString().equals(""))
                    kodePengeluaran.setError("Tidak boleh kosong !");
                else
                    pengeluaran.setKode_pengeluaran(kodePengeluaran.getText().toString());

                if (tanggalPengeluaran.getText().toString().equals(""))
                    tanggalPengeluaran.setError("Tidak boleh kosong");
                else
                    pengeluaran.setTanggal_pengeluaran(tanggalPengeluaran.getText().toString());

                if (jumlahPengeluaran.getText().toString().equals(""))
                    jumlahPengeluaran.setError("Tidak boleh kosong !");
                else if(jumlahPengeluaran.getText().toString().matches("[0-9]"))
                    pengeluaran.setJumlah_pengeluaran(Integer.parseInt(jumlahPengeluaran.getText().toString()));
                else
                    jumlahPengeluaran.setError("Masukan Tidak Valid");

                //Untuk tambah Pengeluaran
                if(getArguments().getInt("mode") == 1){
                    crud.open();
                    long idPengeluaran = crud.addPengeluaran(pengeluaran);
                    crud.close();
                    if(idPengeluaran != -1)
                        Objects.requireNonNull(getActivity()).onBackPressed();
                }
                //untuk update Pengeluaran
                else if (getArguments().getInt("mode") == 2){
                    pengeluaran.setKode_data_pengeluaran(getArguments().getLong("idPengeluaran"));
                    crud.open();
                    crud.updatePengeluaran(pengeluaran);
                    crud.close();
                    Objects.requireNonNull(getActivity()).onBackPressed();
                }
            }
        });

        batalPengeluaran.setOnClickListener(new View.OnClickListener() {
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

        //untuk update Pengeluaran
        if(getArguments().getInt("mode") == 2){
            crud.open();
            Pengeluaran pengeluaran = crud.getPengeluaran(getArguments().getLong("idPengeluaran"));
            crud.close();
            ((TextView) view.findViewById(R.id.fragmentDataPengeluaran)).setText("Update Pengeluaran");
            ((EditText)view.findViewById(R.id.fragmentTokoPengeluaran)).setText(pengeluaran.getKode_toko_pengeluaran()+"");
            ((EditText)view.findViewById(R.id.fragmentKodePengeluaran)).setText(pengeluaran.getKode_pengeluaran());
            ((EditText)view.findViewById(R.id.fragmentTanggalPengeluaran)).setText(pengeluaran.getTanggal_pengeluaran());
            ((EditText)view.findViewById(R.id.fragmentJumlahPengeluaran)).setText(pengeluaran.getJumlah_pengeluaran());
        }
        else if(getArguments().getInt("mode") == 1) {
            ((EditText)view.findViewById(R.id.fragmentTokoPengeluaran)).setText("");
            ((EditText)view.findViewById(R.id.fragmentKodePengeluaran)).setText("");
            ((EditText)view.findViewById(R.id.fragmentTanggalPengeluaran)).setText("");
            ((EditText)view.findViewById(R.id.fragmentJumlahPengeluaran)).setText("");
        }

    }
}

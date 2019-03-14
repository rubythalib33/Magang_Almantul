package com.biptek.posbiptek.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.SessionData;
import com.biptek.posbiptek.model.Admin;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Pegawai;
import com.biptek.posbiptek.model.Toko;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.Objects;

public class Fragment_Pegawai extends Fragment {
    private CRUD crud;
    Button simpan, batal;
    TextView judul;
    private View view;
    String[] spinnerList = {"kasir"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentdetailpegawai, container, false);
        crud = new CRUD(getContext());

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this.getActivity(),
                R.layout.support_simple_spinner_dropdown_item, spinnerList);
        final MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner)view.findViewById(R.id.fragmentJabatanUSer);
        betterSpinner.setAdapter(arrayAdapter);

        judul=(TextView)view.findViewById(R.id.fragmentdetailpegawai);
        final EditText namalengkap = (EditText) view.findViewById(R.id.fragmentNamaLengkapUser);
        final EditText usernm = (EditText) view.findViewById(R.id.fragmentUsernameUser);
        final EditText pass = (EditText) view.findViewById(R.id.fragmentPasswordUser);
        final EditText no_tlp = (EditText) view.findViewById(R.id.fragmentNomorTeleponUser);
        final MaterialBetterSpinner JabatanTU = (MaterialBetterSpinner) view.findViewById(R.id.fragmentJabatanUSer);
        simpan = (Button)view.findViewById(R.id.fragmentUserSimpan);
        batal = (Button)view.findViewById(R.id.fragmentUserBatal);


        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pegawai pegawai = new Pegawai();
                SessionData sessionData = new SessionData(getContext());
                pegawai.setKode_toko_pegawai(sessionData.getKodeToko());

                if(namalengkap.getText().toString().equals(""))
                    namalengkap.setError("Tidak Boleh Kosong");
                else pegawai.setNama_lengkap_pegawai(namalengkap.getText().toString());

                if(usernm.getText().toString().equals(""))
                    usernm.setError("Tidak Boleh Kosong");
                else pegawai.setUsername_pegawai(usernm.getText().toString());

                if(pass.getText().toString().equals(""))
                    pass.setError("Tidak Boleh Kosong");
                else pegawai.setPassword_pegawai(pass.getText().toString());

                if(no_tlp.getText().toString().matches("^[0-9,+]{10,}$"))
                    pegawai.setNo_telepon_pegawai(no_tlp.getText().toString());
                else no_tlp.setError("isi Dengan Format yang benar");

                if(JabatanTU.getText().toString().equals(""))
                    JabatanTU.setError("Tidak Boleh kosong");
                else pegawai.setJabatan_pegawai(JabatanTU.getText().toString());

                //Untuk tambah Pegawai
                if(getArguments().getInt("kode") == 10){
                    crud.open();
                    long idToko = crud.addPegawai(pegawai);
                    crud.close();
                    if(idToko != -1)
                        Objects.requireNonNull(getActivity()).onBackPressed();
                }
                //untuk update Pegawai
                else if (getArguments().getInt("kode") == 11){
                    pegawai.setUsername_pegawai(getArguments().getString("USERNAME"));
                    crud.open();
                    crud.updatePegawai(pegawai);
                    crud.close();
                    Objects.requireNonNull(getActivity()).onBackPressed();
                }

            }
        });

        batal.setOnClickListener(new View.OnClickListener() {
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

        //untuk update user
        if(getArguments().getInt("kode") == 11){
            crud.open();
            Pegawai pegawai = crud.getPegawai(getArguments().getString("USERNAME"));
            crud.close();
            ((TextView)this.getView().findViewById(R.id.fragmentdetailpegawai)).setText("Update User");
            ((EditText)this.getView().findViewById(R.id.fragmentNamaLengkapUser)).setText(pegawai.getNama_lengkap_pegawai());
            ((EditText)this.getView().findViewById(R.id.fragmentUsernameUser)).setText(pegawai.getUsername_pegawai());
            ((EditText)this.getView().findViewById(R.id.fragmentPasswordUser)).setText(pegawai.getPassword_pegawai());
            ((EditText)this.getView().findViewById(R.id.fragmentNomorTeleponUser)).setText(pegawai.getNo_telepon_pegawai());
            ((MaterialBetterSpinner)this.getView().findViewById(R.id.fragmentJabatanUSer)).setText(pegawai.getJabatan_pegawai());
        }
        else if(getArguments().getInt("kode") == 10) {
            ((EditText)this.getView().findViewById(R.id.fragmentNamaLengkapUser)).setText("");
            ((EditText)this.getView().findViewById(R.id.fragmentUsernameUser)).setText("");
            ((EditText)this.getView().findViewById(R.id.fragmentPasswordUser)).setText("");
            ((EditText)this.getView().findViewById(R.id.fragmentNomorTeleponUser)).setText("");
            ((MaterialBetterSpinner)this.getView().findViewById(R.id.fragmentJabatanUSer)).setText("");
        }
    }
}

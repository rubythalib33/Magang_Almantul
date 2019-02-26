package com.biptek.posbiptek.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Pegawai;

public class Fragment_detail extends Fragment {
    private CRUD crud;
    TextView namalengkap, usernm, pass, no_tlp, jabatan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentdetailpegawai, container, false);
        crud = new CRUD(getActivity());
        String username = getArguments().getString("Nama_Pegawai");

        namalengkap = (TextView)view.findViewById(R.id.textViewNamaLengkap);
        usernm = (TextView)view.findViewById(R.id.textViewUsername);
        pass = (TextView)view.findViewById(R.id.textViewPassword);
        no_tlp = (TextView)view.findViewById(R.id.textViewNomorTelepon);
        jabatan = (TextView)view.findViewById(R.id.textViewJabatan);

        crud.open();
        Pegawai pegawai = crud.getPegawai(username);
        crud.close();

        namalengkap.setText("Nama Lengkap : "+ pegawai.getNama_lengkap_pegawai());
        usernm.setText("Username : " + pegawai.getUsername_pegawai());
        pass.setText("Password : "+ pegawai.getPassword_pegawai());
        no_tlp.setText("Nomor telepon " + pegawai.getNo_telepon_pegawai());
        jabatan.setText("Jabatan : "+pegawai.getJabatan_pegawai());


        return view;
    }
}

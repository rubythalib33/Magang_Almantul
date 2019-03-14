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
import com.biptek.posbiptek.model.Admin;
import com.biptek.posbiptek.model.CRUD;
import com.biptek.posbiptek.model.Pegawai;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.Objects;

public class Fragment_Admin extends Fragment {

    EditText namalengkap, username, password, nomortelepon;
    private CRUD crud;
    Button simpan, batal;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentdetailadmin, container, false);
        crud = new CRUD(getContext());

        namalengkap = (EditText)view.findViewById(R.id.fragmentNamaLengkapAdmin);
        username = (EditText)view.findViewById(R.id.fragmentUsernameAdmin);
        password = (EditText)view.findViewById(R.id.fragmentPasswordAdmin);
        nomortelepon = (EditText)view.findViewById(R.id.fragmentNomorTeleponAdmin);
        simpan = (Button)view.findViewById(R.id.fragmentAdminSimpan);
        batal = (Button)view.findViewById(R.id.fragmentAdminBatal);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SessionData sessionData = new SessionData(getContext());
                Admin admin = new Admin();
                admin.setKode_perusahaan_admin(sessionData.getKodePerusahaan());

                if(namalengkap.getText().toString().equals(""))
                    namalengkap.setError("Tidak Boleh Kosong");
                else admin.setNama_lengkap_admin(namalengkap.getText().toString());

                if(username.getText().toString().equals(""))
                    username.setError("Tidak Boleh Kosong");
                else admin.setUsername_admin(username.getText().toString());

                if(password.getText().toString().equals(""))
                    password.setError("Tidak Boleh Kosong");
                else admin.setPassword_admin(password.getText().toString());

                if(nomortelepon.getText().toString().matches("^[0-9,+]{10,}$"))
                    admin.setNo_telepon_admin(nomortelepon.getText().toString());
                else nomortelepon.setError("isi Dengan Format yang benar");


                //Untuk tambah Pegawai
                if(getArguments().getInt("key") == 20){
                    crud.open();
                    long id = crud.addAdmin(admin);
                    crud.close();
                    if(id != -1)
                        Objects.requireNonNull(getActivity()).onBackPressed();
                }
                //untuk update Pegawai
                else if (getArguments().getInt("key") == 21){
                    admin.setUsername_admin(getArguments().getString("USERNAMEADMIN"));
                    crud.open();
                    crud.updateAdmin(admin);
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

        //untuk update Admin
        if(getArguments().getInt("key") == 21){
            crud.open();
            Admin admin = crud.getAdmin(getArguments().getString("USERNAMEADMIN"));
            crud.close();
            ((TextView) view.findViewById(R.id.fragmentdetailadmin)).setText("Update Admin");
            ((EditText)view.findViewById(R.id.fragmentNamaLengkapAdmin)).setText(admin.getNama_lengkap_admin());
            ((EditText)view.findViewById(R.id.fragmentUsernameAdmin)).setText(admin.getUsername_admin());
            ((EditText)view.findViewById(R.id.fragmentPasswordAdmin)).setText(admin.getPassword_admin());
            ((EditText)view.findViewById(R.id.fragmentNomorTeleponAdmin)).setText(admin.getNo_telepon_admin());

        }
        else if(getArguments().getInt("key") == 20) {
            ((EditText)this.getView().findViewById(R.id.fragmentNamaLengkapAdmin)).setText("");
            ((EditText)this.getView().findViewById(R.id.fragmentUsernameAdmin)).setText("");
            ((EditText)this.getView().findViewById(R.id.fragmentPasswordAdmin)).setText("");
            ((EditText)this.getView().findViewById(R.id.fragmentNomorTeleponAdmin)).setText("");
        }
    }
}

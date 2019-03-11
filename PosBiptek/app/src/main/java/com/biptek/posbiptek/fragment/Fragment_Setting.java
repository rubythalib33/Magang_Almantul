package com.biptek.posbiptek.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.activity.ManajemenToko;
import com.biptek.posbiptek.activity.More_admin;
import com.biptek.posbiptek.activity.manajemen_perusahaan;
import com.biptek.posbiptek.activity.manajemen_user;

import java.util.Objects;

public class Fragment_Setting extends Fragment {
    ImageButton b2,b3,b4;
    Button b1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popupsetting, container, false);
                b1 = view.findViewById(R.id.buttonmanajemenperusahaan);
                b2 = view.findViewById(R.id.buttonmanajemenuser);
                b3 = view.findViewById(R.id.buttontutupsetting);
                b4 = view.findViewById(R.id.buttonmanajementoko);

                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getActivity(), More_admin.class));
                        Objects.requireNonNull(getActivity()).finish();
                    }
                });

                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getActivity(), manajemen_perusahaan.class));
                        Objects.requireNonNull(getActivity()).finish();
                    }
                });

                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getActivity(), manajemen_user.class));
                    }
                });

                b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getActivity(), ManajemenToko.class));
                    }
                });

        return view;
    }
}

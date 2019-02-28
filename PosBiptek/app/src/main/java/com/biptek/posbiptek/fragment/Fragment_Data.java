package com.biptek.posbiptek.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.activity.daftarhutang;
import com.biptek.posbiptek.activity.daftarkontak;
import com.biptek.posbiptek.activity.daftarproduk;

public class Fragment_Data extends Fragment {
    private BottomNavigationView bottomNavigationView;
    Button b1, b2, b3, b4, b5;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popupmenudata, container, false);
            b1 = (Button)view.findViewById(R.id.button7);
            b2 = (Button)view.findViewById(R.id.button10);
            b3 = (Button)view.findViewById(R.id.button13);
            b4 = (Button)view.findViewById(R.id.button14);
            b5 = (Button)view.findViewById(R.id.buttonXdata);

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), daftarkontak.class);
                    startActivity(intent);
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), daftarproduk.class);
                    startActivity(intent);
                }
            });

            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), daftarhutang.class);
                    startActivity(intent);
                }
            });

            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            b5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    fm.popBackStack();
                }
            });
        return view;
    }
}

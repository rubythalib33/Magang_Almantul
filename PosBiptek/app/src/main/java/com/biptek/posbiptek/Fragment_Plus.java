package com.biptek.posbiptek;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment_Plus extends Fragment {
    Button b1, b2, b3, b4;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popuptambah, container, false);

        b1 = (Button) view.findViewById(R.id.buttonpenjualan);
        b2 = (Button) view.findViewById(R.id.buttonpembelian);
        b3 = (Button) view.findViewById(R.id.buttonhutang);
        b4 = (Button) view.findViewById(R.id.button15);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   Intent intent = new Intent(getActivity(), tambahpenjualan.class);
                   startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), tambahpembelian.class);
                startActivity(intent);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), homeadmin.class);
                startActivity(intent);
            }
        });

        return view;
    }
}

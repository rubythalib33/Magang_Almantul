package com.biptek.posbiptek;

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

public class Fragment_Setting extends Fragment {
    ImageButton b1,b2,b3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popupsetting, container, false);
                b1 = (ImageButton)view.findViewById(R.id.buttonmanajementoko);
                b2 = (ImageButton)view.findViewById(R.id.buttonmanajemenuser);
                b3 = (ImageButton)view.findViewById(R.id.buttontutupsetting);

                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), More_admin.class);
                        startActivity(intent);
                    }
                });

                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), manajemen_toko.class);
                        startActivity(intent);
                    }
                });

                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), manajemen_user.class);
                        startActivity(intent);
                    }
                });
        return view;
    }
}

package com.biptek.posbiptek.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.model.Admin;

import java.util.ArrayList;

public class AdminAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Admin> arrayList;

    public AdminAdapter(Context context, ArrayList <Admin> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }
    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.customlistpegawai,null);

        TextView usrname = convertView.findViewById(R.id.usrnamepgw);
        TextView jbtn = convertView.findViewById(R.id.jtnListPegwai);
        TextView pss = convertView.findViewById(R.id.Passview);

        Admin admin = arrayList.get(position);

        usrname.setText("Nama Lengkap : "+admin.getNama_lengkap_admin());
        jbtn.setText("Username : "+admin.getUsername_admin());
        pss.setText("Password : "+admin.getPassword_admin());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return convertView;
    }
}


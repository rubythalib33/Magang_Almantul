package com.biptek.posbiptek.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.biptek.posbiptek.R;
import com.biptek.posbiptek.model.Pegawai;

import java.util.ArrayList;

public class PegawaiAdapter extends BaseAdapter {
    private Context context;
    private ArrayList <Pegawai>  arrayList;

    public PegawaiAdapter(Context context, ArrayList <Pegawai> arrayList){
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
        Pegawai pegawai = arrayList.get(position);

        usrname.setText("Username : "+pegawai.getUsername_pegawai());
        jbtn.setText("Jabatan : "+pegawai.getJabatan_pegawai());
        pss.setText("Password : "+pegawai.getPassword_pegawai());
        return convertView;
    }
}

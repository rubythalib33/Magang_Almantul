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
import java.util.List;

public class PegawaiAdapter extends BaseAdapter {

    Context context;
    ArrayList <Pegawai>  arrayList;

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
        TextView usrname = (TextView)convertView.findViewById(R.id.usrnamepgw);

        Pegawai pegawai = arrayList.get(position);

        usrname.setText(pegawai.getUsername_pegawai());
        return convertView;
    }
}

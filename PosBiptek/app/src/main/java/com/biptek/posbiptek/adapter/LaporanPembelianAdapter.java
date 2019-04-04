package com.biptek.posbiptek.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.biptek.posbiptek.model.Restock;

import java.util.ArrayList;

public class LaporanPembelianAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Restock> arrayList;

    public LaporanPembelianAdapter(Context context, ArrayList<Restock> arrayList){
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
        return null;
    }
}

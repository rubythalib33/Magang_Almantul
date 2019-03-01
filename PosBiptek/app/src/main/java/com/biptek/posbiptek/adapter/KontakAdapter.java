package com.biptek.posbiptek.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.biptek.posbiptek.model.Supplier;

import java.util.ArrayList;

public class KontakAdapter extends BaseAdapter {
    private ArrayList<Supplier> suppliers;
    private Context context;

    public KontakAdapter(Context context, ArrayList<Supplier> suppliers){
        this.context = context;
        this.suppliers = suppliers;
    }

    @Override
    public int getCount() {
        return this.suppliers.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}

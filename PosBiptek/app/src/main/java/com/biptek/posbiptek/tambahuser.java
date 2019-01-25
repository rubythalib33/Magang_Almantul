package com.biptek.posbiptek;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class tambahuser extends AppCompatActivity {

    String [] SpinnerList ={"admin", "user"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambahuser);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, SpinnerList);
        MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner)findViewById(R.id.SpinnerJabatan);
        betterSpinner.setAdapter(arrayAdapter);
    }
}

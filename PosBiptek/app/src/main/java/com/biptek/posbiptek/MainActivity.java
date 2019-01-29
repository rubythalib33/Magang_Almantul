package com.biptek.posbiptek;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.biptek.posbiptek.model.*;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDBHelper = new DatabaseHelper(this);
        TextView textView = findViewById(R.id.textView);
        textView.append(this.getApplicationInfo().dataDir+"\n");

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        SupplierCRUD supplierCRUD = new SupplierCRUD(this);
        Supplier supplier = new Supplier(0,
                "unilever",
                "abc@abv.com",
                "0271123123",
                "Jl, blabal");
        supplierCRUD.open();
        supplier.setKode_supplier(supplierCRUD.addSupplier(supplier));
        supplierCRUD.close();
        textView.append(supplier.toString());
    }
}

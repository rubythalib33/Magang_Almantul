package com.biptek.posbiptek.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.biptek.posbiptek.R;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class BarcodeScanner extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_scanner);

        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 2);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            mScannerView.setResultHandler(this);
            mScannerView.startCamera();
        }
        else finish();
    }

    @Override
    public void handleResult(Result result) {
        Log.v("TAG", result.getText());
        Log.v("TAG", result.getBarcodeFormat().toString());
        Intent intent = new Intent();
        intent.putExtra("barcodeResult", result.getText());
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }
}

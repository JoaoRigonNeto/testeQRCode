package com.example.qrcode_test;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import javax.xml.transform.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);
        setContentView(R.layout.activity_main);
    }
    public void onResume()
    {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    public void onPause()
    {
        super.onPause();
        mScannerView.stopCamera();
    }
    @Override
    public void handleResult(com.google.zxing.Result rawResult) {
        Toast.makeText(this, rawResult.getText(), Toast.LENGTH_LONG).show();
        mScannerView.resumeCameraPreview(this);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

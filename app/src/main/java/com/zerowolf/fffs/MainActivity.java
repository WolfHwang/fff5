package com.zerowolf.fffs;

import android.os.Bundle;

import com.zerowolf.jsbridge.BridgeWebView;
import com.zerowolf.jsbridge.DefaultHandler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private BridgeWebView mBridgeWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        mBridgeWebView = findViewById(R.id.webViewRelease);
        initWebView();
    }


    private void initWebView() {
        mBridgeWebView.setDefaultHandler(new DefaultHandler());

        mBridgeWebView.loadUrl("http://fffs.wxjcy.cn");

//        mBridgeWebView.registerHandler("getNativeTest") { "asda", }
    }
}

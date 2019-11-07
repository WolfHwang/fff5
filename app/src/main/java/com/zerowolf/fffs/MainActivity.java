package com.zerowolf.fffs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zerowolf.jsbridge.BridgeHandler;
import com.zerowolf.jsbridge.BridgeWebView;
import com.zerowolf.jsbridge.CallBackFunction;
import com.zerowolf.jsbridge.DefaultHandler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private BridgeWebView mBridgeWebView;
    private ImageView mBackImage;
    private Button mTestBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        mBridgeWebView = findViewById(R.id.webViewRelease);
        mBackImage = findViewById(R.id.backImage);
        mTestBtn = findViewById(R.id.testBtn);

        mTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBackImage.setVisibility(View.GONE);
            }
        });

        mBackImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBridgeWebView.callHandler("listenBackIconClick", "原生端点击了返回按钮", new CallBackFunction() {
                    @Override
                    public void onCallBack(String data) {

                    }
                });
            }
        });

        initWebView();
    }


    private void initWebView() {
        mBridgeWebView.setDefaultHandler(new DefaultHandler());

        boolean isDev = false;

        if (isDev) {
            mBridgeWebView.loadUrl("file:///android_asset/demo.html");
        } else {
            mBridgeWebView.loadUrl("http://fffs.wxjcy.cn");
        }

        registerHandler();
//        mBridgeWebView.registerHandler("getNativeTest") { "asda", }
    }

    private void registerHandler() {
        mBridgeWebView.registerHandler("openBackIcon", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                mBackImage.setVisibility(View.VISIBLE);
            }
        });

        mBridgeWebView.registerHandler("closeBackIcon", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                mBackImage.setVisibility(View.GONE);
            }
        });

    }


}

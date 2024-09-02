package com.example.zhiliang;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.myapplication.R;


public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 设置窗口Insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViewById(R.id.open_webview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebView();
            }
        });

        findViewById(R.id.open_webviewv0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebViewV0();
            }
        });

        findViewById(R.id.open_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });

        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.equals("myapp://openBActivity")) {
                    // 处理自定义 URL Scheme
                    openActivity();
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        webView.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl("file://android_asset/index.html");


    }

    private void openActivity(){
        String url = "roibest://mypage";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void openWebViewV0(){

        // 添加启动Chrome浏览器的代码
        String url = "https://www.mentiscope.com/8718899129/8718899129_download.html?channel_id=4&rb_pixel_id=123&promote_url_id=3454317279&rb_tid=0&invite_code=&rb_page=1&rb_time=1724753921726&link_id=L2408276962071548798398534";
//        String url ="http://localhost:8081";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        intent.setPackage("com.android.chrome");

        // 检查是否安装了Chrome浏览器
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            // 如果没有安装Chrome，可以选择启动系统默认浏览器
            intent.setPackage(null);
            startActivity(intent);
        }
    }


    private void openWebView(){

        // 添加启动Chrome浏览器的代码
//        String url = "https://www.mentiscope.com/8718899129/8718899129_download.html?channel_id=4&rb_pixel_id=123&promote_url_id=3454317279&rb_tid=0&invite_code=&rb_page=1&rb_time=1724753921726&link_id=L2408276962071548798398534";
        String url ="http://localhost:8081";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        intent.setPackage("com.android.chrome");

        // 检查是否安装了Chrome浏览器
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            // 如果没有安装Chrome，可以选择启动系统默认浏览器
            intent.setPackage(null);
            startActivity(intent);
        }
    }
}
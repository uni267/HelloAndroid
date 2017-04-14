package com.example.jeb.clprismclient;

import android.app.ActionBar;
import android.content.pm.ActivityInfo;
import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.Window;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ClPrism extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // setContentView()呼び出し前に、タイトルバーなし設定を行う
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //レイアウト設定
        setContentView(R.layout.activity_cl_prism);

       //横向き固定
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //レイアウトで指定したWebViewのIDを指定する。
        WebView myWebView = (WebView)findViewById(R.id.webView1);

        //リンクをタップしたときに標準ブラウザを起動させない
        //myWebView.setWebViewClient(new WebViewClient());
        myWebView.setWebViewClient(new WebViewClient() {
                                      @Override
                                      public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                                          handler.proceed();
                                      }
                                  });
        //最初のページを表示する。
        myWebView.loadUrl("https://www.google.co.jp");
        //myWebView.loadUrl("https://192.168.100.202/");

        //jacascript,DOMStrageを許可する
        //WebSettings theitem = myWebView.getSettings();
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setDomStorageEnabled(true);

        //JAVAハンドラ追加

    }
}

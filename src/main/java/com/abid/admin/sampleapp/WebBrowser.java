package com.abid.admin.sampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebBrowser extends AppCompatActivity {

    WebView webView;
    String url="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_browser);
        //String url = "https://www.google.com";

         url = getIntent().getStringExtra("url");

        WebAction();
    }

    public void WebAction(){

      //surl = "https://www.google.com";//editText.getText().toString();
        if (!url.equalsIgnoreCase("") && url !=null) {
            webView = (WebView) findViewById(R.id.webView);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setAppCacheEnabled(true);
            webView.loadUrl(url);

            webView.setWebViewClient(new WebViewClient() {

                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {


                    webView.loadUrl("file:///assets/error.html");

                }

                public void onPageFinished(WebView view, String url) {
                    // do your stuff here
                    //swipe.setRefreshing(false);
                }

            });
        }else{

        }
    }
   // app/src/main/assets

    @Override
    public void onBackPressed(){

        if (webView.canGoBack()){
            webView.goBack();
        }else {
            finish();
        }
    }

}

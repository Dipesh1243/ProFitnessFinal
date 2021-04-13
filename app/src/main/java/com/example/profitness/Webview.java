package com.example.profitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.MediaController;

public class Webview extends AppCompatActivity {

    WebView webView;
    Button bt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webView = findViewById(R.id.webviewvideo);
        bt1 = findViewById(R.id.backweb);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(Webview.this, Cardio.class);
                startActivity(i2);
            }
        });



        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String res_image = bundle.getString("my_image");
            webView.setWebViewClient(new WebViewClient());
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);

            if (res_image.equals("swim")){

                webView.loadUrl("https://www.wikihow.com/Swim");


            }else if (res_image.equals("jump")){
                webView.loadUrl("https://www.wikihow.com/Jump-Rope");
            }

            else if (res_image.equals("jog")){
                webView.loadUrl("https://www.wikihow.com/Jog");
            }

            else if (res_image.equals("box")){
                webView.loadUrl("https://www.wikihow.com/Train-for-Boxing");
            }
            else if (res_image.equals("cycle")){
                webView.loadUrl("https://www.wikihow.com/Ride-a-Bicycle");
            }

            else if (res_image.equals("powerwalk")){
                webView.loadUrl("https://www.wikihow.com/Walk-Fast");
            }

            else if (res_image.equals("rowing")){
                webView.loadUrl("https://www.wikihow.com/Row-on-a-Rowing-Machine");
            }
            else if (res_image.equals("elliptical")){
                webView.loadUrl("https://www.wikihow.com/Use-an-Elliptical-Machine");
            }
            else if (res_image.equals("stairs")){
                webView.loadUrl("https://www.wikihow.com/Use-a-Stairmaster");
            }
            else if (res_image.equals("treadmill")){
                webView.loadUrl("https://www.wikihow.fitness/Use-a-Treadmill-For-Beginners");
            }
            else if (res_image.equals("spinbike")){
                webView.loadUrl("https://www.wikihow.com/Use-a-Spin-Bike");
            }



        }

    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
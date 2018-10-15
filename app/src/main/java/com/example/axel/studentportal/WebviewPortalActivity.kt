package com.example.axel.studentportal

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import android.webkit.WebViewClient

class WebviewPortalActivity : AppCompatActivity() {

    var webView: WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview_portal_activity)
        webView = findViewById(R.id.webViewScreen)
        val extras: Bundle = intent.extras
        val urlString = extras.getString("Url")
        webView!!.webViewClient = WebviewUrl()
        webView!!.settings.javaScriptEnabled
        webView!!.settings.javaScriptCanOpenWindowsAutomatically
        webView!!.loadUrl(urlString)


    }

}
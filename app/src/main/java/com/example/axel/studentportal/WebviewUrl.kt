package com.example.axel.studentportal

import android.graphics.Bitmap
import android.webkit.WebView
import android.webkit.WebViewClient

class WebviewUrl : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        view.loadUrl(url)
        print(view.loadUrl(url))
        return false

    }

}

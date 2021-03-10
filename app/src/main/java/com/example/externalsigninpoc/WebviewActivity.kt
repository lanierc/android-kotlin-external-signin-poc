package com.example.externalsigninpoc

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

class WebviewActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        val bun = Bundle().apply {
            val redirectUri = intent.getStringExtra(REDIRECT_URI)
            val url = intent.getStringExtra(URL)
            putString(REDIRECT_URI, redirectUri)
            putString(URL, url)
        }
    }
    companion object {
        const val URL = "url"
        const val REDIRECT_URI = "redirectUri"

        fun newIntent(context: Context, url: String, redirectUri: String): Intent {
            val intent = Intent(context, WebviewActivity::class.java)
            intent.putExtra(URL, url)
            intent.putExtra(REDIRECT_URI, redirectUri)

            return intent
        }
    }
}
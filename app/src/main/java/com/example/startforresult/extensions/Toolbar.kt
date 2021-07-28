package com.example.startforresult.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

fun AppCompatActivity.initToolbar(toolbar: Toolbar, titulo: String = ""){
    setSupportActionBar(toolbar)
    supportActionBar?.title = titulo.uppercase()
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    toolbar.setNavigationOnClickListener { onBackPressed() }
}
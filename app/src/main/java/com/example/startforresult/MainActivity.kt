package com.example.startforresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var startResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result ->
            if (result.resultCode == 299) {
                val data = result.data
                val msg = data?.getStringExtra("key")
                txtResult.text = "Texto da segunda tela: $msg"
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listeners()

    }

    private fun listeners() {
        btn.setOnClickListener {
            startResult.launch(Intent(this, SegundaActivity::class.java))
        }
    }

}
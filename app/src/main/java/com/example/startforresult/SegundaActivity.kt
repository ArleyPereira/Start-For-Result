package com.example.startforresult

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.startforresult.extensions.initToolbar
import kotlinx.android.synthetic.main.activity_segunda.*
import kotlinx.android.synthetic.main.activity_segunda.btn

class SegundaActivity : AppCompatActivity() {

    private var startResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                val msg = data?.getStringExtra("key")
                txtResultTerceiraTela.text = "Texto da terceira tela: $msg"
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        initToolbar(toolbar)

        listeners()

    }

    private fun listeners(){
        btn.setOnClickListener {
            val intent = Intent()
            intent.putExtra("key", edt.text.toString())
            setResult(299, intent)
            finish()
        }

        btnTerceiraTela.setOnClickListener {
            startResult.launch(Intent(this, TerceiraActivity::class.java))
        }
    }

}
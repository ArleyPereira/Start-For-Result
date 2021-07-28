package com.example.startforresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.startforresult.extensions.initToolbar
import kotlinx.android.synthetic.main.activity_segunda.*
import kotlinx.android.synthetic.main.activity_terceira.*
import kotlinx.android.synthetic.main.activity_terceira.btn
import kotlinx.android.synthetic.main.activity_terceira.edt
import kotlinx.android.synthetic.main.activity_terceira.toolbar

class TerceiraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terceira)

        initToolbar(toolbar)

        listeners()

    }

    private fun listeners() {
        btn.setOnClickListener {
            val intent = Intent()
            intent.putExtra("key", edt.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }

}
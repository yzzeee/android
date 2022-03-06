package com.example.cogito

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val goToMain = findViewById<Button>(R.id.go_to_main)
        goToMain.setOnClickListener{
            intent.putExtra("name", "yzzeee")
            setResult(RESULT_OK, intent)
            finish()
        }
        val detailActivity = findViewById<TextView>(R.id.detail_activity)
        detailActivity.text = intent.data.toString()
    }
}
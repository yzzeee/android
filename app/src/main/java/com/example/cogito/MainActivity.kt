package com.example.cogito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val result = it.data?.getStringExtra("name")
            val mainTextView = findViewById<TextView>(R.id.main_text)
            mainTextView.text = result
        }

        val goToDetailBtn = findViewById<Button>(R.id.go_to_detail)
        goToDetailBtn.setOnClickListener{
            val intent = Intent(this, DetailActivity::class.java)
            resultLauncher.launch(intent)
        }
    }
}
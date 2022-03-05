package com.example.cogito

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goToDetailBtn = findViewById<Button>(R.id.go_to_detail)
        goToDetailBtn.setOnClickListener{
            val intent = Intent(this, DetailActivity::class.java)
            startActivityForResult(intent, 10)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 10 && resultCode == Activity.RESULT_OK) {
            val result = data?.getStringExtra("name")
            val mainTextView = findViewById<TextView>(R.id.main_text)
            mainTextView.text = result
        }
    }
}
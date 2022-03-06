package com.example.cogito

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import java.lang.Exception

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

        val phoneNumberEditText = findViewById<EditText>(R.id.editText1)
        val callPhoneButton = findViewById<Button>(R.id.call_phone)

        callPhoneButton.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_CALL
            Toast.makeText(this, phoneNumberEditText.text.toString(), Toast.LENGTH_SHORT).show()
            intent.data = Uri.parse("tel:" + phoneNumberEditText.text.toString())
            startActivity(intent)
        }

        val webAddressEditText = findViewById<EditText>(R.id.editText2)
        val actionEditButton = findViewById<Button>(R.id.action_edit)

        actionEditButton.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_EDIT
            intent.data = Uri.parse("http://" + webAddressEditText.text.toString())
            startActivity(intent)
        }

        val actionHelloButton = findViewById<Button>(R.id.action_hello)

        actionHelloButton.setOnClickListener {
            val intent = Intent()
            intent.action = "ACTION_HELLO"
            try {
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "No activity found to handle 'ACTION_HELLO'", Toast.LENGTH_SHORT).show()
            }
        }

        val packageTestButton = findViewById<Button>(R.id.package_test)

        packageTestButton.setOnClickListener {
            val intent = Intent()
            val pkg = "com.example.cogito2"
            intent.action = Intent.ACTION_VIEW
            intent.`package` = pkg
            startActivity(intent)
        }
    }
}
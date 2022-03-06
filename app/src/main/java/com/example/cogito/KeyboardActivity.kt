package com.example.cogito

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.cogito.databinding.ActivityKeyboardBinding

class KeyboardActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityKeyboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val manager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        binding.keyboardUp.setOnClickListener {
            binding.editView.requestFocus()
            manager.showSoftInput(binding.editView, InputMethodManager.SHOW_IMPLICIT)
        }

        binding.keyboardDown.setOnClickListener {
            manager.hideSoftInputFromWindow(currentFocus?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }
}
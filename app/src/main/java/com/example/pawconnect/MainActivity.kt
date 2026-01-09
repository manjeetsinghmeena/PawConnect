package com.example.pawconnect

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etName = findViewById<TextInputEditText>(R.id.etName)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etPhone = findViewById<TextInputEditText>(R.id.etPhone)
        val btnLogin = findViewById<Button>(R.id.button)

        btnLogin.setOnClickListener {
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val phone = etPhone.text.toString().trim()

            if (name.isEmpty()) {
                etName.error = "Name is required"
                return@setOnClickListener
            }
            if (email.isEmpty()) {
                etEmail.error = "Email is required"
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "Please enter a valid email address"
                return@setOnClickListener
            }
            if (phone.isEmpty()) {
                etPhone.error = "Phone number is required"
                return@setOnClickListener
            }
            if (phone.length != 10) {
                etPhone.error = "Please enter a valid 10-digit phone number"
                return@setOnClickListener
            }
            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}

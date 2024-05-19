package com.aristidevs.nuwelogin.ui.resetPassword

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aristidevs.nuwelogin.R
import com.google.android.material.button.MaterialButton

class ForgotPasswordEnterCodeValidationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_for_new_password)


        val btnNext = findViewById<MaterialButton>(R.id.btnNext)
        val btnBack = findViewById<MaterialButton>(R.id.btnBack)
        btnNext.setOnClickListener {
            Toast.makeText(this, "Codigo fino, next pantalla", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ForgotPasswordEnterNew::class.java)
            startActivity(intent)
        }

        btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}
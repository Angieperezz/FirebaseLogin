package com.aristidevs.nuwelogin.ui.signin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aristidevs.nuwelogin.R
import com.aristidevs.nuwelogin.ui.verification.VerificationActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class SignInActivityEnterData : AppCompatActivity(){

    private lateinit var etName: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_know_you)

        etName = findViewById(R.id.etName)

        val btnNext = findViewById<MaterialButton>(R.id.btnNext)
        btnNext.setOnClickListener {
         //startActivity(VerificationActivity.create(this))
        }


    }

}
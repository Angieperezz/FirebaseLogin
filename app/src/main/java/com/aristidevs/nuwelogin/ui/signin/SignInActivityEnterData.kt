package com.aristidevs.nuwelogin.ui.signin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aristidevs.nuwelogin.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class SignInActivityEnterData : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_know_you)

        val btnNext = findViewById<MaterialButton>(R.id.btnNext)
        btnNext.setOnClickListener {
            val intent = Intent(this, ActivityMoralOrPhysicPerson::class.java)
            startActivity(intent)
         //startActivity(VerificationActivity.create(this))
        }


    }

}
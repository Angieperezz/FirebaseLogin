package com.aristidevs.nuwelogin.ui.signin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aristidevs.nuwelogin.R
import com.google.android.material.button.MaterialButton

class ActivityMoralOrPhysicPerson: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_who_you_are_activity)

        val btnNext = findViewById<MaterialButton>(R.id.btnNext)
        btnNext.setOnClickListener {
            //startActivity(VerificationActivity.create(this))
        }


    }
}
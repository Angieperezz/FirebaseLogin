package com.aristidevs.nuwelogin.ui.signin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.aristidevs.nuwelogin.R
import com.google.android.material.button.MaterialButton

class VerifyUserEmail : AppCompatActivity() {

    companion object {
        var isUserEmailCode: Boolean = false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.verify_email)
        val btnNext = findViewById<MaterialButton>(R.id.btnNext)

        btnNext.setOnClickListener {
            isUserEmailCode = true
            val intent = Intent(this, SignInResultValidationCode::class.java)
            startActivity(intent)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        isUserEmailCode = false
    }
}

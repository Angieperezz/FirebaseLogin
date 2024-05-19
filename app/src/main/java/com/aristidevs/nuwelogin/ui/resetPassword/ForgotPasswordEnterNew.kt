package com.aristidevs.nuwelogin.ui.resetPassword

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aristidevs.nuwelogin.R
import com.aristidevs.nuwelogin.ui.login.LoginActivity
import com.aristidevs.nuwelogin.ui.signin.SignInActivityEnterData
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class ForgotPasswordEnterNew : AppCompatActivity() {

    private lateinit var etEmail : TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_new_password)


        val btnConfirm = findViewById<MaterialButton>(R.id.btnConfirm)
        val btnBack = findViewById<MaterialButton>(R.id.btnBack)
        btnConfirm.setOnClickListener {
            Toast.makeText(this, "Tu contraseña ha sido cambiada exitosamente", Toast.LENGTH_SHORT).show()
        }

        btnBack.setOnClickListener {
            onBackPressed()
        }

    }
}
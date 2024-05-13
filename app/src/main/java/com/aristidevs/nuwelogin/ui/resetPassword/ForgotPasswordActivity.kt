package com.aristidevs.nuwelogin.ui.resetPassword

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aristidevs.nuwelogin.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var etEmail: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        etEmail = findViewById(R.id.etEmail)

        val btnSendEmail = findViewById<MaterialButton>(R.id.btnSendEmail)
        btnSendEmail.setOnClickListener {
            val email = etEmail.text.toString()
            if (validateEmail(email)) {
                // Procesar la solicitud de resetear contraseña
                sendPasswordReset(email)
            } else {
                Toast.makeText(this, "Email inválido", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateEmail(email: String): Boolean {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$".toRegex())
    }

    private fun sendPasswordReset(email: String) {
        // Lógica para enviar el correo electrónico para restablecer la contraseña
        // Por ejemplo, puedes utilizar una API para enviar el correo electrónico
        // O puedes utilizar un método de la base de datos para recuperar el usuario y enviar el correo electrónico
    }

}
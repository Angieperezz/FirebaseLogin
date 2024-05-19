package com.aristidevs.nuwelogin.ui.signin

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.aristidevs.nuwelogin.R
import com.google.android.material.button.MaterialButton

class VerifyUserEmail : AppCompatActivity() {

    private lateinit var codeEditText1: EditText
    private lateinit var codeEditText2: EditText
    private lateinit var codeEditText3: EditText
    private lateinit var codeEditText4: EditText

    companion object {
        var isUserEmailCode: Boolean = false
        var codeIntroducedEmail : String = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.verify_email)

        codeEditText1 = findViewById(R.id.code1)
        codeEditText2 = findViewById(R.id.code2)
        codeEditText3 = findViewById(R.id.code3)
        codeEditText4 = findViewById(R.id.code4)

        val btnNext = findViewById<MaterialButton>(R.id.btnNext)

        btnNext.setOnClickListener {
            isUserEmailCode = true
            var codeValue1 = codeEditText1.text.toString()
            var codeValue2 = codeEditText2.text.toString()
            var codeValue3 = codeEditText3.text.toString()
            var codeValue4 = codeEditText4.text.toString()

           codeIntroducedEmail = codeValue1 + codeValue2 + codeValue3 + codeValue4
            if(!codeIntroducedEmail.isEmpty()) {
                val intent = Intent(this, SignInResultValidationCode::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "El codigo no puede estar vacio", Toast.LENGTH_SHORT).show()
            }
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        isUserEmailCode = false
    }
}

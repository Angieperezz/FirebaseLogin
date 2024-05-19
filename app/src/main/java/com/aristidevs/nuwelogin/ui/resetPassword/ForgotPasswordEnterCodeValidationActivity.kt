package com.aristidevs.nuwelogin.ui.resetPassword

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aristidevs.nuwelogin.R
import com.aristidevs.nuwelogin.ui.signin.SignInResultValidationCode
import com.aristidevs.nuwelogin.ui.signin.VerifyUserEmail
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class ForgotPasswordEnterCodeValidationActivity : AppCompatActivity() {

    private lateinit var codeEditText1: EditText
    private lateinit var codeEditText2: EditText
    private lateinit var codeEditText3: EditText
    private lateinit var codeEditText4: EditText

    companion object {
        var codeValue : String = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_for_new_password)

        codeEditText1 = findViewById(R.id.code1)
        codeEditText2 = findViewById(R.id.code2)
        codeEditText3 = findViewById(R.id.code3)
        codeEditText4 = findViewById(R.id.code4)

        val btnNext = findViewById<MaterialButton>(R.id.btnNext)
        val btnBack = findViewById<MaterialButton>(R.id.btnBack)

        btnNext.setOnClickListener {
            var codeValue1 = codeEditText1.text.toString()
            var codeValue2 = codeEditText2.text.toString()
            var codeValue3 = codeEditText3.text.toString()
            var codeValue4 = codeEditText4.text.toString()

            codeValue = codeValue1 + codeValue2 + codeValue3 + codeValue4

            if(!codeValue.isEmpty() && codeValue.length == 4 && codeValue == "1234") {
                val intent = Intent(this, ForgotPasswordEnterNew::class.java)
                startActivity(intent)
            } else if(codeValue != "1234") {
                Toast.makeText(this, "El codigo es erróneo", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this, "El codigo no puede estar vacio", Toast.LENGTH_SHORT).show()

            }

        }

        btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
package com.aristidevs.nuwelogin.ui.signin

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.aristidevs.nuwelogin.R
import com.google.android.material.button.MaterialButton

class VerifyUserPhone : AppCompatActivity() {

    private lateinit var codeEditText: EditText

    companion object {
        var isUserPhoneCode: Boolean = false
        var codeIntroduced : String = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.verify_number_phone)

        codeEditText = findViewById(R.id.codeBox)
        val codeValue = codeEditText.text.toString()
        // Procesar el valor recuperado
        println("Code value: $codeValue")

        val btnNext = findViewById<MaterialButton>(R.id.btnNext)



        btnNext.setOnClickListener {
            isUserPhoneCode = true
            codeIntroduced = codeEditText.text.toString()
            val intent = Intent(this, SignInResultValidationCode::class.java)
            startActivity(intent)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        isUserPhoneCode = false
    }

}

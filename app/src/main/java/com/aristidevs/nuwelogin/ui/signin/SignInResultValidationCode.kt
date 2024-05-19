package com.aristidevs.nuwelogin.ui.signin

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.aristidevs.nuwelogin.R
import com.aristidevs.nuwelogin.ui.signin.VerifyUserEmail.Companion.isUserEmailCode
import com.aristidevs.nuwelogin.ui.signin.VerifyUserPhone.Companion.codeIntroduced
import com.aristidevs.nuwelogin.ui.signin.VerifyUserPhone.Companion.isUserPhoneCode

class SignInResultValidationCode: AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_validation_result)

        imageView = findViewById(R.id.imageCheckSuccessOrFail)
        textView = findViewById(R.id.tvVerification)

        initUI()

        }

    private fun initUI() {
        if(codeIntroduced == "1234" && isUserPhoneCode == true){
            imageView.setImageResource(R.drawable.success_check)
            textView.text = ("Hemos confirmado correctamente tu numero telefonico")

        } else if(codeIntroduced == ""){
           //imageView.setBackgroundColor(getResources().getColor(R.color.errorBackground))
           imageView.setImageResource(R.drawable.fail_background)
            textView.text = ("El codigo introducido esta vacio o es incorrecto")
        } else if(codeIntroduced == "1234" && isUserEmailCode == true){
            imageView.setImageResource(R.drawable.success_check)
            textView.text = ("Hemos confirmado correctamente tu correo electronico")
        }
    }
}
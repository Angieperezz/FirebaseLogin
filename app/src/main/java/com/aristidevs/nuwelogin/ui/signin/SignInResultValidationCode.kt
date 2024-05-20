package com.aristidevs.nuwelogin.ui.signin

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.aristidevs.nuwelogin.R
import com.aristidevs.nuwelogin.ui.signin.VerifyUserEmail.Companion.codeIntroducedEmail
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
        if(codeIntroduced == "1234" && isUserPhoneCode){
            imageView.setImageResource(R.drawable.success_check)
            textView.text = ("Hemos confirmado correctamente tu \nnúmero de teléfono")

        } else if(codeIntroducedEmail == "1234" && isUserEmailCode){
            imageView.setImageResource(R.drawable.success_check)
            textView.text = ("Hemos confirmado correctamente tu \ncorreo electrónico")
        } else if(codeIntroduced == "" || codeIntroducedEmail == "" || codeIntroducedEmail != "1234"|| codeIntroduced != "1234"){
           //imageView.setBackgroundColor(getResources().getColor(R.color.errorBackground))
           imageView.setImageResource(R.drawable.checkmark_error)
           textView.text = ("El código introducido es incorrecto")
        }
    }
}
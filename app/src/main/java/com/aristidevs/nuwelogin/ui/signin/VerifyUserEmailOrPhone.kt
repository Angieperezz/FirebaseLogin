package com.aristidevs.nuwelogin.ui.signin

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.aristidevs.nuwelogin.R

class VerifyUserEmailOrPhone : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification_user)
        val cardView1 = findViewById<CardView>(R.id.card_view1)
        val cardView2 = findViewById<CardView>(R.id.card_view2)


        val texto = "Verifica tu correo electrónico \n\nTe enviaremos un correo con un código de verificación"
        val spannableString = SpannableString(texto)
        spannableString.setSpan(
            StyleSpan(Typeface.BOLD), // Estilo bold
            0,
            29,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        val texto2 = "Verifica tu número de teléfono \n\nTe enviaremos un código de verificación por SMS"
        val spannableString2 = SpannableString(texto2)
        spannableString2.setSpan(
            StyleSpan(Typeface.BOLD), // Estilo bold
            0,
            30,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        val textView1 = findViewById<TextView>(R.id.text_view1)
        textView1.text = spannableString

        val textView2 = findViewById<TextView>(R.id.text_view2)
        textView2.text = spannableString2

        cardView1.setOnClickListener{
            val intent = Intent(this, VerifyUserEmail::class.java)
            startActivity(intent)
        }

        cardView2.setOnClickListener {
            val intent = Intent(this, VerifyUserPhone::class.java)
            startActivity(intent)
        }

    }
}
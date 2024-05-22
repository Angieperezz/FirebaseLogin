package com.aristidevs.nuwelogin.ui.signin

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.aristidevs.nuwelogin.R
import com.google.android.material.button.MaterialButton

class ActivityMoralOrPhysicPerson: AppCompatActivity() {

    private var cardView1Selected = false
    private var cardView2Selected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_who_you_are_activity)

        val texto = "Soy persona física \n\nDesempeña una actividad económica bajo \nel ejercicio independiente de una profesión"
        val spannableString = SpannableString(texto)
        spannableString.setSpan(
            StyleSpan(Typeface.BOLD), // Estilo bold
            0,
            18,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        val texto2 = "Soy persona moral \n\nDesempeña una actividad económica a \ntraves una sociedad comercial(Dueño de empresa)"
        val spannableString2 = SpannableString(texto2)
        spannableString2.setSpan(
            StyleSpan(Typeface.BOLD), // Estilo bold
            0,
            17,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        val card_view1 = findViewById<CardView>(R.id.card_view1)
        val card_view2 = findViewById<CardView>(R.id.card_view2)

        card_view1.setOnClickListener {
            if (!cardView1Selected) {
                card_view1.setBackgroundDrawable(getResources().getDrawable(R.drawable.card_view_style))
                cardView1Selected = true
            } else {
                card_view1.setBackgroundDrawable(getResources().getDrawable(R.drawable.card_view_style_not_selected))
                cardView1Selected = false
            }
        }
        card_view2.setOnClickListener {
            if (!cardView2Selected) {
                card_view2.setBackgroundDrawable(getResources().getDrawable(R.drawable.card_view_style))
                cardView2Selected = true
            } else {
                card_view2.setBackgroundDrawable(getResources().getDrawable(R.drawable.card_view_style_not_selected))
                cardView2Selected = false
            }
        }

        val textView1 = findViewById<TextView>(R.id.text_view1)
        textView1.text = spannableString

        val textView2 = findViewById<TextView>(R.id.text_view2)
        textView2.text = spannableString2

        val btnNext = findViewById<MaterialButton>(R.id.btnNext)
        btnNext.setOnClickListener {
            val intent = Intent(this, VerifyUserEmailOrPhone::class.java)
            startActivity(intent)
            //startActivity(VerificationActivity.create(this))
        }


    }
}
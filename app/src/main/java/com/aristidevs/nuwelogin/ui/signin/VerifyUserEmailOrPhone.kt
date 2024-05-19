package com.aristidevs.nuwelogin.ui.signin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.aristidevs.nuwelogin.R

class VerifyUserEmailOrPhone : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification_user)
        val cardView1 = findViewById<CardView>(R.id.card_view1)
        val cardView2 = findViewById<CardView>(R.id.card_view2)

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
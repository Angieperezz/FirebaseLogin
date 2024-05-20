package com.aristidevs.nuwelogin.ui.introduction

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aristidevs.nuwelogin.R
import com.aristidevs.nuwelogin.databinding.ActivityIntroductionBinding
import com.aristidevs.nuwelogin.domain.CarouselCardAdapter
import com.aristidevs.nuwelogin.ui.login.LoginActivity
import com.aristidevs.nuwelogin.ui.signin.SignInActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class IntroductionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroductionBinding
    private val introductionViewModel: IntroductionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Nuwe)
        super.onCreate(savedInstanceState)
        binding = ActivityIntroductionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val texto = "Compra activos tokenizados desde cualquier parte del mundo."
        val spannableString = SpannableString(texto)
        spannableString.setSpan(
            ForegroundColorSpan(Color.BLACK),
            0,
            31,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString.setSpan(
            ForegroundColorSpan(Color.BLUE),
            32,
            texto.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        val textView = findViewById<TextView>(R.id.appCompatTextView)
        textView.text = spannableString
        initUI()

        val demoData = arrayListOf(
            R.drawable.slide_1,
            R.drawable.image2,
            R.drawable.slide_3,
        )

        val marginDp = 16
        val transformerDecoration = CardViewPageTransformerDecoration(marginDp)


        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager
        recyclerView.adapter = CarouselCardAdapter(demoData)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.addItemDecoration(transformerDecoration)

        binding.roundedCardView.clipChildren = false
        binding.roundedCardView.clipToPadding = false

    }

    private fun initUI() {
        initListeners()
        initObservers()
    }

    private fun initListeners() {
        with(binding) {
            btnLogin.setOnClickListener { introductionViewModel.onLoginSelected() }
            btnSingIn.setOnClickListener { introductionViewModel.onSignInSelected() }
        }
    }


    private fun initObservers() {
        introductionViewModel.navigateToLogin.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                goToLogin()
            }
        })
        introductionViewModel.navigateToSignIn.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                goToSingIn()
            }
        })
    }


    private fun goToSingIn() {
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
    }

    private fun goToLogin() {
        startActivity(LoginActivity.create(this))
    }
}
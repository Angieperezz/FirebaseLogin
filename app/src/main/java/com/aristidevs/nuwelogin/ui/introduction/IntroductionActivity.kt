package com.aristidevs.nuwelogin.ui.introduction

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.aristidevs.nuwelogin.R
import com.aristidevs.nuwelogin.databinding.ActivityIntroductionBinding
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

        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        val imagesCarousel = arrayListOf(
            CarouselItem(R.drawable.slide_1),
            CarouselItem(R.drawable.slide_2),
            CarouselItem(R.drawable.slide_3),
        )
        viewPager.adapter = CarouselAdapter(imagesCarousel)

        val dot1 = findViewById<ImageView>(R.id.dot1)
        val dot2 = findViewById<ImageView>(R.id.dot2)
        val dot3 = findViewById<ImageView>(R.id.dot3)

        val carouselAdapter = CarouselAdapter(imagesCarousel)
        viewPager.adapter = carouselAdapter

        viewPager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                // No se llama automáticamente, solo se llama cuando se está deslizando
            }

            override fun onPageSelected(position: Int) {
                // Aquí puedes obtener la posición actual
                println("Current position: $position")

                // Actualiza tus puntos de imagen aquí
                if (position == 0) {
                    dot1.setImageResource(R.drawable.dot_active)
                    dot2.setImageResource(R.drawable.dot_inactive)
                    dot3.setImageResource(R.drawable.dot_inactive)
                } else if (position == 1) {
                    dot1.setImageResource(R.drawable.dot_inactive)
                    dot2.setImageResource(R.drawable.dot_active)
                    dot3.setImageResource(R.drawable.dot_inactive)
                } else if (position == 2) {
                    dot1.setImageResource(R.drawable.dot_inactive)
                    dot2.setImageResource(R.drawable.dot_inactive)
                    dot3.setImageResource(R.drawable.dot_active)
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
                // No se llama automáticamente, solo se llama cuando se está cambiando el estado de scroll
            }
        })
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
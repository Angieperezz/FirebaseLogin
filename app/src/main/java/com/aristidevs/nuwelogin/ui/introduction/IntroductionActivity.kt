package com.aristidevs.nuwelogin.ui.introduction

import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.aristidevs.nuwelogin.R
import com.aristidevs.nuwelogin.databinding.ActivityIntroductionBinding
import com.aristidevs.nuwelogin.domain.CarouselRVAdapter
import com.aristidevs.nuwelogin.ui.login.LoginActivity
import com.aristidevs.nuwelogin.ui.signin.SignInActivity
import dagger.hilt.android.AndroidEntryPoint
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs


@AndroidEntryPoint
class IntroductionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroductionBinding
    private val introductionViewModel: IntroductionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Nuwe)
        super.onCreate(savedInstanceState)
        binding = ActivityIntroductionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val texto = "Compra activos tokenizados desde \n cualquier parte del mundo"
        val viewPager = findViewById<ViewPager2>(R.id.view_pager)

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

        val textView = findViewById<TextView>(com.aristidevs.nuwelogin.R.id.appCompatTextView)
        textView.text = spannableString
        initUI()

        viewPager.apply{
            clipChildren = false
            clipToPadding = false
            offscreenPageLimit = 3
            (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }

        val demoData = arrayListOf(
            "img1",
            "img2",
            "img3",
            "img4",
            "img5"
        )

        viewPager.adapter = CarouselRVAdapter(demoData)

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer((40 * Resources.getSystem().displayMetrics.density).toInt()))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = (0.80f + r * 0.20f)
        }
        viewPager.setPageTransformer(compositePageTransformer)
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
        startActivity(SignInActivity.create(this))
    }

    private fun goToLogin() {
        startActivity(LoginActivity.create(this))
    }
}
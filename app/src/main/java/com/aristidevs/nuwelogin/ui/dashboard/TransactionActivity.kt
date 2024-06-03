package com.aristidevs.nuwelogin.ui.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aristidevs.nuwelogin.R
import com.aristidevs.nuwelogin.databinding.ActivityTransactionBinding
import com.google.android.material.button.MaterialButton

class TransactionActivity  : AppCompatActivity(){

    private lateinit var btnBack : MaterialButton

    private lateinit var binding: ActivityTransactionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionBinding.inflate(layoutInflater)

        btnBack = binding.btnBack.findViewById(R.id.btnBack)
        initListener()

        setContentView(binding.root)

    }

    fun initListener() {
        btnBack.setOnClickListener {
            onBackPressed()
        }
    }

}
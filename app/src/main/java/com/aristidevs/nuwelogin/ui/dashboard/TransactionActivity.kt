package com.aristidevs.nuwelogin.ui.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aristidevs.nuwelogin.databinding.ActivityTransactionBinding

class TransactionActivity  : AppCompatActivity(){

    private lateinit var binding: ActivityTransactionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}
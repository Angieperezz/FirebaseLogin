package com.aristidevs.nuwelogin.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import androidx.fragment.app.Fragment
import com.aristidevs.nuwelogin.R
import com.aristidevs.nuwelogin.databinding.FragmentWalletBinding

class WalletFragment : Fragment() {

        private var _binding: FragmentWalletBinding? = null
        private val binding get() = _binding!!

    private lateinit var horizontalScrollView: HorizontalScrollView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentWalletBinding.inflate(layoutInflater, container, false)

        horizontalScrollView = binding.frameValues.findViewById(R.id.frameValues)
        horizontalScrollView.isHorizontalScrollBarEnabled = false
        return binding.root


    }

}
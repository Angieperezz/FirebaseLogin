package com.aristidevs.nuwelogin.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import androidx.fragment.app.Fragment
import com.aristidevs.nuwelogin.R
import com.aristidevs.nuwelogin.databinding.FragmentWalletBinding
import com.google.android.material.button.MaterialButton

class WalletFragment : Fragment() {

        private var _binding: FragmentWalletBinding? = null
        private val binding get() = _binding!!
        private lateinit var horizontalScrollView: HorizontalScrollView
        private lateinit var actions: MaterialButton
        private lateinit var myActives: MaterialButton
        private lateinit var movements: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentWalletBinding.inflate(layoutInflater, container, false)

        horizontalScrollView = binding.frameValues.findViewById(R.id.frameValues)
        horizontalScrollView.isHorizontalScrollBarEnabled = false

        //button bar
        actions = binding.actions.findViewById(R.id.actions)
        myActives = binding.myActives.findViewById(R.id.myActives)
        movements = binding.movements.findViewById(R.id.movements)
        initListeners()

        return binding.root


    }

    private fun initListeners() {
        actions.setOnClickListener {
            binding.dot1.visibility = View.VISIBLE
            binding.containerView.visibility = View.VISIBLE
            binding.frameValues.visibility = View.VISIBLE
            binding.cardLayout.visibility = View.VISIBLE
            binding.actionButtons.visibility = View.VISIBLE
            binding.textButtons.visibility = View.VISIBLE
            binding.dot3.visibility = View.INVISIBLE
            binding.dot2.visibility = View.INVISIBLE
        }
        myActives.setOnClickListener {
            binding.dot2.visibility = View.VISIBLE
            binding.dot1.visibility = View.INVISIBLE
            binding.dot3.visibility = View.INVISIBLE
            binding.containerView.visibility = View.GONE
            binding.frameValues.visibility = View.GONE
            binding.cardLayout.visibility = View.GONE
            binding.actionButtons.visibility = View.GONE
            binding.textButtons.visibility = View.GONE
        }
        movements.setOnClickListener {
            binding.dot3.visibility = View.VISIBLE
            binding.dot1.visibility = View.INVISIBLE
            binding.dot2.visibility = View.INVISIBLE
            binding.containerView.visibility = View.GONE
            binding.frameValues.visibility = View.GONE
            binding.cardLayout.visibility = View.GONE
            binding.actionButtons.visibility = View.GONE
            binding.textButtons.visibility = View.GONE
        }
    }

}
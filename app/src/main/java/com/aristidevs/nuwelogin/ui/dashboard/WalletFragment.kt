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

        //dividers
        private lateinit var divider1: View
        private lateinit var divider2: View
        private lateinit var divider3: View

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

        divider1 = binding.dividerViewView3
        initListeners()

        return binding.root


    }

    private fun initListeners() {
        actions.setOnClickListener {
            //propio de esta vista
            binding.dot1.visibility = View.VISIBLE
            binding.containerView.visibility = View.VISIBLE
            binding.frameValues.visibility = View.VISIBLE
            binding.cardLayout.visibility = View.VISIBLE
            binding.actionButtons.visibility = View.VISIBLE
            binding.textButtons.visibility = View.VISIBLE

            //Oculta otras vistas
            binding.dot3.visibility = View.INVISIBLE
            binding.dot2.visibility = View.INVISIBLE
            binding.buttonFrame.visibility = View.GONE
            binding.cryptoItems.visibility = View.GONE
            binding.itemDescription.visibility = View.GONE
            binding.movementLayout.visibility = View.GONE
            binding.actionsAndMovement.visibility = View.GONE
            binding.movementLayout2.visibility = View.GONE
            binding.movementLayout3.visibility = View.GONE
            binding.dividerViewView.visibility = View.GONE
            binding.dividerViewView2.visibility = View.GONE
            binding.dividerViewView3.visibility = View.GONE
        }
        myActives.setOnClickListener {
            binding.buttonFrame.visibility = View.VISIBLE
            binding.cryptoItems.visibility = View.VISIBLE
            binding.dot2.visibility = View.VISIBLE
            binding.itemDescription.visibility = View.VISIBLE


            binding.dot1.visibility = View.INVISIBLE
            binding.dot3.visibility = View.INVISIBLE
            binding.containerView.visibility = View.GONE
            binding.frameValues.visibility = View.GONE
            binding.cardLayout.visibility = View.GONE
            binding.actionButtons.visibility = View.GONE
            binding.textButtons.visibility = View.GONE

            binding.movementLayout.visibility = View.GONE
            binding.actionsAndMovement.visibility = View.GONE
            binding.movementLayout2.visibility = View.GONE
            binding.movementLayout3.visibility = View.GONE
            binding.dividerViewView.visibility = View.GONE
            binding.dividerViewView2.visibility = View.GONE
            binding.dividerViewView3.visibility = View.GONE
        }
        movements.setOnClickListener {
            binding.dot3.visibility = View.VISIBLE
            binding.dot1.visibility = View.INVISIBLE
            binding.dot2.visibility = View.INVISIBLE
            binding.itemDescription.visibility = View.GONE
            binding.containerView.visibility = View.GONE
            binding.frameValues.visibility = View.GONE
            binding.cardLayout.visibility = View.GONE
            binding.actionButtons.visibility = View.GONE
            binding.textButtons.visibility = View.GONE
            binding.buttonFrame.visibility = View.GONE
            binding.cryptoItems.visibility = View.GONE
            //propio de esta vista
            binding.movementLayout.visibility = View.VISIBLE
            binding.actionsAndMovement.visibility = View.VISIBLE
            binding.movementLayout2.visibility = View.VISIBLE
            binding.movementLayout3.visibility = View.VISIBLE
            binding.dividerViewView.visibility = View.VISIBLE
            binding.dividerViewView2.visibility = View.VISIBLE
            binding.dividerViewView3.visibility = View.VISIBLE



        }
    }

}
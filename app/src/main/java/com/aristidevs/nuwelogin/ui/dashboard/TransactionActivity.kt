package com.aristidevs.nuwelogin.ui.dashboard

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.BaseExpandableListAdapter
import android.widget.Button
import android.widget.ExpandableListView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.aristidevs.nuwelogin.R
import com.aristidevs.nuwelogin.databinding.ActivityTransactionBinding
import com.aristidevs.nuwelogin.ui.dashboard.model.AdapterListView
import com.aristidevs.nuwelogin.ui.dashboard.model.MyItem
import com.google.android.material.button.MaterialButton

class TransactionActivity  : AppCompatActivity(){

    private lateinit var btnBack : MaterialButton
    private lateinit var btnNext : MaterialButton
    private lateinit var selectButton : MaterialButton
    private lateinit var expandableListView : ExpandableListView

    private lateinit var binding: ActivityTransactionBinding

    private lateinit var adapter: BaseExpandableListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionBinding.inflate(layoutInflater)

        btnBack = binding.btnBack.findViewById(R.id.btnBack)
        btnNext = binding.btnNext.findViewById(R.id.btnNext)
        adapter = AdapterListView(this,
            listOf(
                MyItem(R.drawable.ic_wbtc, "Bitcoin"),
                MyItem(R.drawable.ic_usdt, "USDT"),
                MyItem(R.drawable.ic_matic, "Matic")
            )
        )
        selectButton = binding.selectButton.findViewById(R.id.selectButton)
        expandableListView = binding.listView.findViewById(R.id.listView)

        if (expandableListView != null && expandableListView.adapter != null) {

            expandableListView.setAdapter(adapter)
            adapter = expandableListView.adapter as BaseExpandableListAdapter
            expandableListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                val groupPosition = parent.selectedItemPosition
                val childPosition = position - 1 // Ya que la posición 0 es el grupo padre
                if (groupPosition == 0) {
                    // Actualizar la imagen en el botón principal
                    selectButton.findViewById<ImageView>(R.id.icon).setImageResource(adapter.getChild(groupPosition, childPosition).toString().toInt())
                    // Cerrar la lista desplegable
                    expandableListView.collapseGroup(0)
                }
            }
            // Esto no esta funcionando, ya que el adapter le llega null siempre
        } else {
        println("Soy nullo$expandableListView")
        println("Soy nullo adapter${expandableListView.adapter}")
        }

        initListener()
        setContentView(binding.root)

    }

    fun initListener() {
        btnBack.setOnClickListener {
            onBackPressed()
            binding.layoutTypeToReceive.visibility = View.GONE
            binding.qrImage.visibility = View.GONE
            binding.scanQr.visibility = View.GONE
            binding.dividerLayout.visibility = View.GONE
            binding.btnCopy.visibility = View.GONE
            binding.footerText.visibility = View.GONE
        }

        btnNext.setOnClickListener{
           binding.title2.visibility = View.GONE
           binding.layoutButton.visibility = View.GONE
           binding.accepTermsAndConditions.visibility = View.GONE
           btnNext.visibility = View.GONE
            //Propio de la siguiente vista
           binding.layoutTypeToReceive.visibility = View.VISIBLE
           binding.qrImage.visibility = View.VISIBLE
           binding.scanQr.visibility = View.VISIBLE
           binding.dividerLayout.visibility = View.VISIBLE
           binding.btnCopy.visibility = View.VISIBLE
           binding.footerText.visibility = View.VISIBLE
        }
    }

}
    package com.aristidevs.nuwelogin.ui.dashboard

    import android.os.Bundle
    import android.view.LayoutInflater
    import android.view.View
    import android.widget.LinearLayout
    import androidx.appcompat.app.AppCompatActivity
    import com.aristidevs.nuwelogin.R
    import com.google.android.material.button.MaterialButton
    import kotlin.properties.Delegates

    class TransactionSendActivity : AppCompatActivity() {

        private lateinit var btnNext: MaterialButton
        private lateinit var btnBack: MaterialButton
        private lateinit var mainLayout: LinearLayout
        private lateinit var secondLayout: View
        private lateinit var thirdLayout: View

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            setContentView(R.layout.activity_transaction_send)

            // Inflamos el layout principal
            mainLayout = findViewById(R.id.mainlayout)
            btnNext = findViewById(R.id.btnNext)
            btnBack = findViewById(R.id.btnBack)

            //Inflamos demas layouts
            secondLayout =
                LayoutInflater.from(this).inflate(R.layout.transaction_send_module, null)

            thirdLayout =
                LayoutInflater.from(this).inflate(R.layout.transaction_send_module_confirm, null)

            initListeners()
        }

        private fun initListeners() {
            //Primera vista del layout transaction_send_choose_crypto
            btnNext.setOnClickListener {
                mainLayout.removeAllViews()
                mainLayout.addView(secondLayout)
            }
            btnBack.setOnClickListener {
                onBackPressed()
            }

            //Segunda vista del layout transaction_send_module
            secondLayout.findViewById<MaterialButton>(R.id.btnNext1).setOnClickListener {
                mainLayout.removeAllViews()
                mainLayout.addView(thirdLayout)
            }
            secondLayout.findViewById<MaterialButton>(R.id.btnBack).setOnClickListener{
                onBackPressed()
            }
            //Tercera vista del layout transaction_send_module
            thirdLayout.findViewById<MaterialButton>(R.id.btnNext).setOnClickListener{
               
            }
            thirdLayout.findViewById<MaterialButton>(R.id.btnBack).setOnClickListener{
                onBackPressed()
            }
        }

    }
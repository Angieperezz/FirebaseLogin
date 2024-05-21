package com.aristidevs.nuwelogin.ui.signin

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aristidevs.nuwelogin.R
import com.aristidevs.nuwelogin.core.dialog.DialogFragmentLauncher
import com.aristidevs.nuwelogin.core.dialog.ErrorDialog
import com.aristidevs.nuwelogin.core.ex.show
import com.aristidevs.nuwelogin.ui.resetPassword.ForgotPasswordEnterCodeValidationActivity
import com.aristidevs.nuwelogin.ui.resetPassword.ForgotPasswordEnterNew
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class SignInActivityEnterData : AppCompatActivity(){

    private lateinit var etName : TextInputEditText
    private lateinit var etLastName : TextInputEditText
    private lateinit var etNumberPhone : TextInputEditText

    @Inject
    lateinit var dialogLauncher: DialogFragmentLauncher
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_know_you)

        etName = findViewById(R.id.etName)
        etLastName = findViewById(R.id.etLastName)
        etNumberPhone = findViewById(R.id.etNumberPhone)

        etNumberPhone.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // No-op
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // No-op
            }

            override fun afterTextChanged(s: Editable) {
                val text = s.toString()
                if (text.isEmpty()) {
                    // No validation needed
                    return
                }

                val pattern = Regex("\\+?\\d{1,3} ?\\(?\\d{3}\\)? ?\\d{4}") // Ejemplo: +1 (123) 456-7890

                if (pattern.matches(text)) {
                    // El texto coincide con el patrón regular
                    etNumberPhone.error = null
                } else {
                    // El texto no coincide con el patrón regular
                    etNumberPhone.error = "Invalid phone number"
                }
            }
        })

        val btnNext = findViewById<MaterialButton>(R.id.btnNext)
        btnNext.setOnClickListener {
            if(etName.length() == 0 || etNumberPhone.length() == 0 || etLastName.length() == 0) {
                showErrorDialog()
            }   else{
                val intent = Intent(this, ActivityMoralOrPhysicPerson::class.java)
                startActivity(intent)
            }

        }


    }
    private fun showErrorDialog() {
        ErrorDialog.create(
            title = getString(R.string.signin_error_dialog_title),
            description = "Debe rellenar todos los campos",
            positiveAction = ErrorDialog.Action(getString(R.string.signin_error_dialog_positive_action)) {
                it.dismiss()
            }
        ).show(dialogLauncher, this)
    }

}
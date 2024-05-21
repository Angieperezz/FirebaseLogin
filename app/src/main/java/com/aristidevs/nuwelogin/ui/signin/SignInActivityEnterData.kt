package com.aristidevs.nuwelogin.ui.signin

import android.content.Intent
import android.os.Bundle
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
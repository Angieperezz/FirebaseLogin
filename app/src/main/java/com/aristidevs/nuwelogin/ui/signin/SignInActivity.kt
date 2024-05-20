package com.aristidevs.nuwelogin.ui.signin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.aristidevs.nuwelogin.R
import com.aristidevs.nuwelogin.core.dialog.DialogFragmentLauncher
import com.aristidevs.nuwelogin.core.dialog.ErrorDialog
import com.aristidevs.nuwelogin.core.ex.*
import com.aristidevs.nuwelogin.databinding.ActivitySignInBinding
import com.aristidevs.nuwelogin.ui.login.LoginActivity
import com.aristidevs.nuwelogin.ui.resetPassword.ForgotPasswordActivity
import com.aristidevs.nuwelogin.ui.signin.model.UserSignIn
import com.aristidevs.nuwelogin.ui.verification.VerificationActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import java.util.Objects
import javax.inject.Inject

@AndroidEntryPoint
class SignInActivity : AppCompatActivity() {

//    private lateinit var etName: TextInputEditText
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_sign_in)
//
//        val btnLogin = findViewById<MaterialButton>(R.id.btnLogin)
//        val btnRegister = findViewById<MaterialButton>(R.id.btnRegister)
//        btnLogin.setOnClickListener {
//            val intent = Intent(this, SignInActivityEnterData::class.java)
//            startActivity(intent)
//        }
//
//        btnRegister.setOnClickListener {
//            startActivity(LoginActivity.create(this))
//        }
//    }

    companion object {
        fun create(context: Context): Intent =
            Intent(context, SignInActivity::class.java)
    }

    private lateinit var binding: ActivitySignInBinding
    private val signInViewModel: SignInViewModel by viewModels()

    @Inject
    lateinit var dialogLauncher: DialogFragmentLauncher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        initListeners()
        initObservers()
    }

    private fun initListeners() {

        binding.etEmail.loseFocusAfterAction(EditorInfo.IME_ACTION_NEXT)
        binding.etEmail.setOnFocusChangeListener { _, hasFocus -> onFieldChanged(hasFocus) }
        binding.etEmail.onTextChanged { onFieldChanged() }

        binding.etPassword.loseFocusAfterAction(EditorInfo.IME_ACTION_NEXT)
        binding.etPassword.setOnFocusChangeListener { _, hasFocus -> onFieldChanged(hasFocus) }
        binding.etPassword.onTextChanged { onFieldChanged() }

        binding.etPasswordRepeat.loseFocusAfterAction(EditorInfo.IME_ACTION_DONE)
        binding.etPasswordRepeat.setOnFocusChangeListener { _, hasFocus -> onFieldChanged(hasFocus) }
        binding.etPasswordRepeat.onTextChanged { onFieldChanged() }

        binding.btnRegister.setOnClickListener { signInViewModel.onLoginSelected() }

        with(binding) {
            btnLogin.setOnClickListener {
                it.dismissKeyboard()
                    goToAskData()

//                signInViewModel.onSignInSelected(
//                    UserSignIn(
//                        email = binding.etEmail.text.toString(),
//                        password = binding.etPassword.text.toString(),
//                        passwordConfirmation = binding.etPasswordRepeat.text.toString()
//
//                    )
//                )
            }
        }
    }

    private fun initObservers() {
        signInViewModel.navigateToVerifyEmail.observe(this) {
            it.getContentIfNotHandled()?.let {
                goToVerifyEmail()
            }
        }

        signInViewModel.navigateToLogin.observe(this) {
            it.getContentIfNotHandled()?.let {
                goToLogin()
            }
        }

        signInViewModel.navigateToAskData.observe(this) {
            it.getContentIfNotHandled()?.let {
                goToAskData()
            }
        }

        lifecycleScope.launchWhenStarted {
            signInViewModel.viewState.collect { viewState ->
                updateUI(viewState)
            }
        }

        signInViewModel.showErrorDialog.observe(this) { showError ->
            if (showError) showErrorDialog()
        }
    }

    private fun goToAskData() {
        val intent = Intent(this, SignInActivityEnterData::class.java)
        startActivity(intent)
    }

    private fun showErrorDialog() {
        ErrorDialog.create(
            title = getString(R.string.signin_error_dialog_title),
            description = getString(R.string.signin_error_dialog_body),
            positiveAction = ErrorDialog.Action(getString(R.string.signin_error_dialog_positive_action)) {
                it.dismiss()
            }
        ).show(dialogLauncher, this)
    }

    private fun updateUI(viewState: SignInViewState) {
        with(binding) {
            //pbLoading.isVisible = viewState.isLoading
            binding.tilEmail.error =
                if (viewState.isValidEmail) null else getString(R.string.signin_error_mail)

            binding.tilPassword.error =
                if (viewState.isValidPassword) null else getString(R.string.signin_error_password)
            binding.tilPasswordRepeat.error =
                if (viewState.isValidPassword) null else getString(R.string.signin_error_password)
        }
    }

    private fun onFieldChanged(hasFocus: Boolean = false) {
        if (!hasFocus) {
            signInViewModel.onFieldsChanged(
                UserSignIn(
                    email = binding.etEmail.text.toString(),
                    password = binding.etPassword.text.toString(),
                    passwordConfirmation = binding.etPasswordRepeat.text.toString()
                )
            )
        }
    }

    private fun goToVerifyEmail() {
        startActivity(VerificationActivity.create(this))
    }

    private fun goToLogin() {
        startActivity(LoginActivity.create(this))
    }
}
package com.aristidevs.nuwelogin.ui.signin.model

data class UserSignIn(
    val email: String,
    val password: String,
    val passwordConfirmation: String
) {
    fun isNotEmpty() =
         email.isNotEmpty() && password.isNotEmpty() && passwordConfirmation.isNotEmpty()
}
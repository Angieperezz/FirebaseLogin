package com.aristidevs.nuwelogin.data.network

import com.aristidevs.nuwelogin.ui.signin.model.UserSignIn
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserService @Inject constructor(private val firebase: FirebaseClient) {

    companion object {
        const val USER_COLLECTION = "users"
    }

    suspend fun createUserTable(userSignIn: UserSignIn) = runCatching {

        val user = hashMapOf(
            "email" to userSignIn.email
        )

        firebase.db
            .collection(USER_COLLECTION)
            .add(user).await()

    }.isSuccess
}
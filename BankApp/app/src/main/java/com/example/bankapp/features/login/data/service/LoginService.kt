package com.example.bankapp.features.login.data.service

import com.example.base.di.AppModule.Companion.BASE_URL
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService{
    @POST("{$BASE_URL}login")
    fun requestLogin(
        @Body
        loginService: LoginRequest
    ): Single<LoginResponse>
}

data class LoginRequest(
    val user: String? = null,
    val password: String? = null
)

data class LoginResponse (
    val userAccount: IdUser?,
    val error: Errors?
)

data class IdUser(
    val userId: Int?
)
data class Errors(
    val code: Int,
    val message: String
)
package com.example.bankapp.features.login.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bankapp.features.login.data.repository.LoginRepository
import com.example.bankapp.features.login.data.service.LoginRequest
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LoginActivityViewModel @Inject constructor(
    private val repository: LoginRepository
): ViewModel() {

    private val disposable = CompositeDisposable()
    val showLoading = MutableLiveData<Boolean>()
    val screenState = MutableLiveData<ScreenState>()
    val nameField = MutableLiveData<String>()
    val passwordField = MutableLiveData<String>()

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }

    fun onUserClick() {
        disposable.add(repository
            .getLogin(LoginRequest(user = null, password = null))
            .doOnSubscribe { showLoading.value = true }
            .doFinally { showLoading.value = false }
            .subscribe({
                screenState.value = ScreenState.Login(it.userAccount?.userId.toString())
            },{

            }))
        screenState.value = ScreenState.OnUserRequestToLogin
    }
}

sealed class ScreenState {
    data class Login(val id: String) : ScreenState()
    object OnUserRequestToLogin : ScreenState()
}
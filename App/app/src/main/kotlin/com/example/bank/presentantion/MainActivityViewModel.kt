package com.example.bank.presentantion

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class MainActivityViewModel : ViewModel() {

    val disposable = CompositeDisposable()

    fun getStart() {
    }

    override fun onCleared(){
        disposable.dispose()
        super onCleared
    }
}

sealed class ScreenState() {
    object Login : ScreenState()f
    object ShowError : ScreenState()
}
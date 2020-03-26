package com.example.bankapp.features.login.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bankapp.R
import com.example.bankapp.databinding.ActivityLoginBinding
import com.example.bankapp.features.details.presentantion.DetailsActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var viewModel: LoginActivityViewModel

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_login
        )
        viewModel = ViewModelProvider(this, factory).get(LoginActivityViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        hideToolbar()
        setUpListener()
    }

    private fun hideToolbar() {
        supportActionBar!!.hide()
    }

    private fun setUpListener() {
        viewModel.screenState.observe(this, Observer {
            when (it) {
                is ScreenState.Login -> openDetails()
                is ScreenState.OnUserRequestToLogin -> openDetails()
            }
        })
    }

    private fun openDetails() {
        startActivity(DetailsActivity.createIntent(this))
    }

}

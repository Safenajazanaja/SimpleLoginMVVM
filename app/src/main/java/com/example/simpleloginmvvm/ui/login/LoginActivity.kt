package com.example.simpleloginmvvm.ui.login

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.simpleloginmvvm.base.BaseActivity
import com.example.simpleloginmvvm.R
import com.example.simpleloginmvvm.data.models.LoginRequest
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        viewModel.toast.observe(this, { str ->
            Toast.makeText(baseContext, "$str", Toast.LENGTH_SHORT).show()
        })

        viewModel.login.observe(this, { b ->
            if (b) {
                Toast.makeText(baseContext, "Login success", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(baseContext, "username & password incorrect", Toast.LENGTH_SHORT)
                    .show()
            }
        })

        btLogin.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val login = LoginRequest(username, password)
            viewModel.login(login)
        }

    }

}

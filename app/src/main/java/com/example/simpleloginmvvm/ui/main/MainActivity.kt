package com.example.simpleloginmvvm.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.simpleloginmvvm.base.BaseActivity
import com.example.simpleloginmvvm.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.toast.observe(this, { str ->
            Toast.makeText(baseContext, "$str", Toast.LENGTH_SHORT).show()
        })

        btToast.setOnClickListener {
//            Toast.makeText(baseContext, "Hello dru", Toast.LENGTH_SHORT).show()
            viewModel.showToast("Hello dru")
        }

        btToast2.setOnClickListener {
            viewModel.showToast("Toast 2")
//            Toast.makeText(baseContext, "Toast 2", Toast.LENGTH_SHORT).show()
        }
    }
}
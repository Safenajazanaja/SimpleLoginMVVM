package com.example.simpleloginmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    // string, int, double, boolean, object, list
    private var _toast = MutableLiveData<String>()
    val toast: LiveData<String>
        get() = _toast

    fun showToast(str: String) {
        _toast.value = str
    }

}

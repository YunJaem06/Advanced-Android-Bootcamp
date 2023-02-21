package com.anushka.navdemo5

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    var name = MutableLiveData<String>()
    var email = MutableLiveData<String>()

    fun setName(text: String) {
        name.value = text
    }

    fun setEmail(text: String) {
        email.value = text
    }
}
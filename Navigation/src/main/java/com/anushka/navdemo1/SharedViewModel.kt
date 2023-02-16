package com.anushka.navdemo1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    var name = MutableLiveData<String>()

    fun setName(text: String) {
        name.value = text
    }
}
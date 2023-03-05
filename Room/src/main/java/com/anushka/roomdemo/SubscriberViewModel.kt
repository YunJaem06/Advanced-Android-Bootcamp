package com.anushka.roomdemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anushka.roomdemo.db.SubscriberRepository

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel() {

    val inputName = MutableLiveData<String>()

    val inputEmail = MutableLiveData<String>()
}
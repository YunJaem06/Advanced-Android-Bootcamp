package com.anushka.lifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.anushka.lifecycledemo.databinding.ActivityMainBinding
import com.anushka.lifecycledemo.ui.main.MainFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

//        lifecycleScope.launch {
//            delay(5000)
//            binding.progressBar.visibility = View.VISIBLE
//            delay(10000)
//            binding.progressBar.visibility = View.GONE
//
//        }

        lifecycleScope.launch(Dispatchers.IO) {
            Log.i("MyTag","Thread name is : ${Thread.currentThread().name}")
        }

        lifecycleScope.launchWhenCreated {

        }

        lifecycleScope.launchWhenStarted {

        }

        lifecycleScope.launchWhenResumed {

        }


    }
}
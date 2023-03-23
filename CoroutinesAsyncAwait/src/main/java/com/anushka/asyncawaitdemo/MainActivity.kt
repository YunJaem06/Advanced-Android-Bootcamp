package com.anushka.asyncawaitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Main).launch {
            Log.i("MyTag", "시작...")

            val stock1 = async(IO) {
                get1()
            }

            val stock2 = async(IO) {
                get2()
            }

            val total = stock1.await() + stock2.await()
            Toast.makeText(applicationContext, "총 $total", Toast.LENGTH_SHORT).show()
        }
    }
}

private suspend fun get1() : Int {
    delay(10000)
    Log.i("MyTag", " 1번 끝 ")
    return 55000
}

private suspend fun get2() : Int {
    delay(8000)
    Log.i("MyTag", " 2번 끝 ")
    return 35000
}
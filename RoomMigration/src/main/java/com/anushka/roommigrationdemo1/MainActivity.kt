package com.anushka.roommigrationdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.anushka.roommigrationdemo1.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = StudentDatabase.getInstance(application).subscriberDAO

        binding.btnSubmit.setOnClickListener {
            lifecycleScope.launch {
                binding.etName.text.let {
                    dao.insertStudent(Student(0,it.toString(), binding.etEmail.text.toString()))
                    binding.etName.setText("")
                    binding.etEmail.setText("")
                }
            }
        }


    }
}
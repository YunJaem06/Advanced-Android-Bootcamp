package com.anushka.navdemo5

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.findNavController
import com.anushka.navdemo5.databinding.FragmentEmailBinding
import com.anushka.navdemo5.databinding.FragmentNameBinding

class EmailFragment : Fragment() {

    private lateinit var binding: FragmentEmailBinding
    private lateinit var viewModel: SharedViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_email, container, false)
        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        binding.submitButton.setOnClickListener {
            if (!TextUtils.isEmpty(binding.emailEditText.text.toString())) {
                viewModel.setEmail(binding.emailEditText.text.toString())
                it.findNavController().navigate(R.id.action_emailFragment_to_welcomeFragment)
            } else {
                Toast.makeText(activity, "입력해주세요", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
}

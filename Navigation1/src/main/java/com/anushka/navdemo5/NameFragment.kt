package com.anushka.navdemo5

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.anushka.navdemo5.databinding.FragmentNameBinding

class NameFragment : Fragment() {

    private lateinit var binding: FragmentNameBinding
    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_name, container, false)
        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        binding.nextButton.setOnClickListener {
            if (!TextUtils.isEmpty(binding.nameEditText.text.toString())){
                viewModel.setName(binding.nameEditText.text.toString())
                it.findNavController().navigate(R.id.action_nameFragment_to_emailFragment)
            } else {
                Toast.makeText(activity, "입력해주세요", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
}

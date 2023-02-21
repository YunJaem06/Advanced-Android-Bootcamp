package com.anushka.navdemo5


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.anushka.navdemo5.databinding.FragmentEmailBinding
import com.anushka.navdemo5.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding
    private lateinit var viewModel: SharedViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_welcome, container, false)
        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        viewModel.name.observe(requireActivity(), Observer{
            binding.nameTextView.text = it.toString()
        })

        viewModel.email.observe(requireActivity(), Observer {
            binding.emailTextView.text = it.toString()
        })

        binding.viewTermsButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_welcomeFragment_to_termsFragment)
        }

        return binding.root
    }
}

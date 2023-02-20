package com.anushka.navdemo1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.anushka.navdemo1.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        // 이 때 ViewModel 생성 시 Owner 파라미터에 ‘this’ 대신 ‘requireActivity()’ 를 사용해야된다.
        // ‘this’를 사용한다면 두 프레그먼트는 서로 다른 Owner를 갖게 된다.
        // 하지만 상위 액티비티를 Owner로 설정하는 requireActivity() 코드를 사용한다면 두 개 의 Fragment는 Owner로써 같은 Onwer (상위 액티비티)를 사용하게 된다.
        // 이와 같이 같은 Onwer를 설정해 줌으로써 Fragment 간에 데이터를 공유할 수있다.
        viewModel.name.observe(requireActivity(), Observer {
            binding.textView.text = it.toString()
        })

//        var input = requireArguments().getString("user_input")
//        binding.textView.text = input.toString()

        return binding.root
    }

}
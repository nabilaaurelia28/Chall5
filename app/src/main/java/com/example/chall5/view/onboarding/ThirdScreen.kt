package com.example.chall5.view.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.chall5.R
import com.example.chall5.databinding.FragmentThirdScreenBinding
import com.example.chall5.databinding.FragmentViewPagerBinding

class ThirdScreen : Fragment() {

    private var bind: FragmentThirdScreenBinding? = null
    private val binding get() = bind!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentThirdScreenBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnMasuk.setOnClickListener{
            findNavController().navigate(R.id.action_viewPager_to_loginFragment)
        }

    }
}
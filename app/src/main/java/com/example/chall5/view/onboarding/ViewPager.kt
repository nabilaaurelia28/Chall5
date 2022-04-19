package com.example.chall5.view.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chall5.R
import com.example.chall5.adapter.ViewPagerAdapter
import com.example.chall5.databinding.FragmentViewPagerBinding


class ViewPager : Fragment() {

    private var bind: FragmentViewPagerBinding? = null
    private val binding get() = bind!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentViewPagerBinding.inflate(inflater, container, false)
        return binding.root

}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listFragment = arrayListOf<Fragment>(
            FirstScreen(),
            SecScreen(),
            ThirdScreen()
        )
        val adapter = ViewPagerAdapter (
            listFragment,
            requireActivity().supportFragmentManager,
            lifecycle
                )
        binding.vpOnBoarding.adapter = adapter
    }
}
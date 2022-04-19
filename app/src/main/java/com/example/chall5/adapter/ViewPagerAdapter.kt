package com.example.chall5.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter (list:ArrayList<Fragment>, fm : FragmentManager, lc : Lifecycle) : FragmentStateAdapter (fm,lc){
    private val  listFragment = list
    override fun getItemCount(): Int {
        return listFragment.size
    }

    override fun createFragment(position: Int): Fragment {
        return listFragment [position]
    }
}
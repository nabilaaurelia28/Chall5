package com.example.chall5.view.homepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.chall5.R
import com.example.chall5.databinding.FragmentHomepageBinding
import com.example.chall5.model.RoomDatabaseStore
import com.example.chall5.model.utility.SharedHelper

class HomepageFragment : Fragment() {

    private var bind : FragmentHomepageBinding? = null
    private val binding get()= bind!!
    private var dataUser:RoomDatabaseStore?=null
    private lateinit var shared:SharedHelper



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentHomepageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataUser = RoomDatabaseStore.getDataUser(requireContext())
        shared = SharedHelper(requireContext())
        binding.apply {
            btnLogout.setOnClickListener{
                shared.clear()
                Toast.makeText(requireContext(), "Logout berhasil", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_homepageFragment_to_loginFragment)
            }
        }
    }

    }

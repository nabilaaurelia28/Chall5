package com.example.chall5.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.chall5.R
import com.example.chall5.databinding.FragmentRegisterBinding
import com.example.chall5.model.RoomDatabaseStore
import com.example.chall5.model.data.DataUser
import kotlinx.coroutines.*


class RegisterFragment : Fragment() {

    private var bind : FragmentRegisterBinding? = null
    private val binding get()=bind!!
    private var dataUser:RoomDatabaseStore?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentRegisterBinding.inflate(inflater , container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataUser = RoomDatabaseStore.getDataUser(requireContext())

        binding.btnRegister.setOnClickListener{
            val email = binding.etEmailRegis.text.toString()
            val password = binding.etPasswordRegis.text.toString()
            val nama = binding.etNama.text.toString()
            val alamat = binding.etAlamat.text.toString()
            val usia = binding.etUsia.text.toString().toInt()
            val objDataUser = DataUser (null, email, password, nama, alamat, usia)
            GlobalScope.async {
                dataUser?.dataUserDao()?.inserDataUser(objDataUser)
            }
            CoroutineScope(Dispatchers.Main).launch {
                Toast.makeText(requireContext(),"berhasil login",Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }

        }
    }


}
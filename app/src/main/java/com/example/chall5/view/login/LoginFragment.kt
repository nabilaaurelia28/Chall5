package com.example.chall5.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.chall5.R
import com.example.chall5.databinding.FragmentLoginBinding
import com.example.chall5.model.RoomDatabaseStore
import com.example.chall5.model.utility.Constant
import com.example.chall5.model.utility.SharedHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LoginFragment : Fragment() {

    private var bind : FragmentLoginBinding? = null
    private val binding get() = bind!!
    private var dataUser : RoomDatabaseStore? = null
    private lateinit var shared: SharedHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentLoginBinding.inflate(inflater, container ,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataUser = RoomDatabaseStore.getDataUser(requireContext())
        shared = SharedHelper(requireContext())

        binding.apply {
            tvRegister.setOnClickListener{
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
            btnLogin.setOnClickListener{
                binding.apply {
                    val email = etEmail.text.toString()
                    val password = etPassword.text.toString()

                    when{
                        email.isEmpty() && password.isEmpty() -> {
                            Toast.makeText(requireContext(), "fill email & password", Toast.LENGTH_SHORT).show()


                        }
                        email.isEmpty()->{
                            Toast.makeText(requireContext(),"fill email", Toast.LENGTH_SHORT)
                        }
                        email.isEmpty()->{
                            Toast.makeText(requireContext(),"fill password",Toast.LENGTH_SHORT)
                        }
                        else -> {
                            CoroutineScope(Dispatchers.Main).launch{
                                val data = dataUser?.dataUserDao()?.getEmail(email)
                                when (data?.email){
                                    email->when (data.password){
                                        password ->{
                                            loginSession(email, password)
                                            Toast.makeText(requireContext(), "Login Success",Toast.LENGTH_SHORT).show()
                                            findNavController().navigate(R.id.action_loginFragment_to_homepageFragment)
                                        }
                                        else->Toast.makeText(requireContext(),"wrong password",Toast.LENGTH_SHORT).show()
                                    }
                                    else->Toast.makeText(requireContext(),"wrong email",Toast.LENGTH_SHORT).show()
                                }


                            }
                        }

                    }
                }
            }
        }
    }
    override fun onStart(){
        super.onStart()
        if(shared.getBoolean(Constant.LOGIN,false)){
            findNavController().navigate(R.id.action_loginFragment_to_homepageFragment)
        }
    }


    private fun loginSession(email: String, password: String) {
        shared.apply {
            put(Constant.EMAIL, email)
            put(Constant.PASSWORD,password)
            put(Constant.LOGIN, true)
        }
    }

}
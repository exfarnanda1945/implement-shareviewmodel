package com.example.belajar_sharedviewmodel.fragment

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.belajar_sharedviewmodel.R
import com.example.belajar_sharedviewmodel.databinding.FragmentFirstBinding
import com.example.belajar_sharedviewmodel.model.UserModel
import com.example.belajar_sharedviewmodel.viewModel.SharedMainViewModel

class FirstFragment : Fragment() {
    private var _binding:FragmentFirstBinding? = null
   private val binding get() = _binding!!

    private val mSharedMainViewModel:SharedMainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(layoutInflater,container,false)

        val view = binding.root

        mSharedMainViewModel.user.observe(viewLifecycleOwner) { user ->
            binding.edtNameFirst.setText(user.name)
            binding.edtAgeFirst.setText(user.age.toString())
        }

        binding.btnSendFirst.setOnClickListener {
            validateAndSendForm()
        }

        return view
    }

    private fun validateAndSendForm() {
        val nameTextField = binding.edtNameFirst.text
        val ageTextField = binding.edtAgeFirst.text

        if(TextUtils.isEmpty(nameTextField) || TextUtils.isEmpty(ageTextField)){
            Toast.makeText(requireContext(),"Please input all fields",Toast.LENGTH_SHORT).show()
        }else{
            val user = UserModel(nameTextField.toString(),Integer.parseInt(ageTextField.toString()))
            mSharedMainViewModel.setUser(user)
            findNavController().navigateUp()
            Toast.makeText(requireContext(),"Send to SharedViewModel",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.belajar_sharedviewmodel.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.belajar_sharedviewmodel.R
import com.example.belajar_sharedviewmodel.databinding.FragmentSecondBinding
import com.example.belajar_sharedviewmodel.viewModel.SharedMainViewModel

class SecondFragment : Fragment() {
   private var _binding:FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private val mSharedMainViewModel:SharedMainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(layoutInflater,container,false)
        val view = binding.root

        mSharedMainViewModel.user.observe(viewLifecycleOwner){user ->
            binding.tvName.text = user.name
            binding.tvAge.text = user.age.toString()

            if(user.name == getString(R.string.unknown)){
                binding.btnClear.isEnabled = false
            }else{
                binding.btnClear.setOnClickListener {
                    mSharedMainViewModel.clearUser()
                    findNavController().navigateUp()
                    Toast.makeText(requireContext(),"User cleared !",Toast.LENGTH_SHORT).show()
                }
            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
package com.example.belajar_sharedviewmodel.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.belajar_sharedviewmodel.R
import com.example.belajar_sharedviewmodel.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    // _binding to handle when fragment not already inflate
    private var _binding:FragmentMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        val view = binding.root

        binding.btnToFirstFragment.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_firstFragment)
        }

        binding.btnToSecondFragment.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_secondFragment)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
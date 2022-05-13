package com.judahben149.feedbacklogger.ui.homescreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.judahben149.feedbacklogger.R
import com.judahben149.feedbacklogger.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        handleFragmentNavigation()
        return binding.root
    }

    private fun handleFragmentNavigation() {
        binding.btnMakeAComplaint.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_homeFragment_to_makeComplaintFragment)
        }

        binding.btnViewComplaints.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_homeFragment_to_viewComplaintsFragment)
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
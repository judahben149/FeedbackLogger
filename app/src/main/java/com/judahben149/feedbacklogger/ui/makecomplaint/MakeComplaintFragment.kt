package com.judahben149.feedbacklogger.ui.makecomplaint

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.judahben149.feedbacklogger.R
import com.judahben149.feedbacklogger.databinding.FragmentHomeBinding
import com.judahben149.feedbacklogger.databinding.FragmentMakeComplaintBinding
import com.judahben149.feedbacklogger.model.Complaint
import com.judahben149.feedbacklogger.repository.MainRepository
import com.judahben149.feedbacklogger.ui.ViewModelFactory
import com.judahben149.feedbacklogger.utils.hideKeyboard

class MakeComplaintFragment : Fragment() {

    private lateinit var makeComplaintViewModel: MakeComplaintViewModel

    private var _binding: FragmentMakeComplaintBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMakeComplaintBinding.inflate(inflater, container, false)

        setupViewModel()

        binding.btnLogComplaint.setOnClickListener {
            logComplaint()
        }
        observeComplaint()

        return binding.root
    }

    private fun observeComplaint() {
        makeComplaintViewModel.complaintResponse.observe(viewLifecycleOwner) { status ->
            if (status.body()?.status.toString() == "successful") {
                Snackbar.make(binding.root, "Complaint logged successfully", Snackbar.LENGTH_SHORT).show()
                binding.btnLogComplaint.apply {
                    text = "FINISH"
                    setOnClickListener {
                        Navigation.findNavController(binding.root).navigate(R.id.action_makeComplaintFragment_to_homeFragment)
                    }
                }
            }
        }
    }

    private fun logComplaint() {
        val id = binding.etCustomerId.text.toString()
        val name = binding.etCustomerName.text.toString()
        val complaintBody = binding.etComplaint.text.toString()

        val myComplaint = Complaint(id, name, complaintBody)
        makeComplaintViewModel.logComplaint(myComplaint)
        hideKeyboard()
    }

    private fun setupViewModel() {
        val repository = MainRepository()
        val factory = ViewModelFactory(repository)

        makeComplaintViewModel = ViewModelProvider(this, factory)[MakeComplaintViewModel::class.java]
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
package com.judahben149.feedbacklogger.ui.viewcomplaints

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.judahben149.feedbacklogger.databinding.FragmentViewComplaintsBinding
import com.judahben149.feedbacklogger.repository.MainRepository
import com.judahben149.feedbacklogger.ui.ViewModelFactory
import com.judahben149.feedbacklogger.ui.makecomplaint.MakeComplaintViewModel

class ViewComplaintsFragment : Fragment() {

    private var _binding: FragmentViewComplaintsBinding? = null
    val binding get() = _binding!!

    private lateinit var viewModel: ViewComplaintsViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ViewComplaintsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentViewComplaintsBinding.inflate(inflater, container, false)

        setupViewModel()
        setupRecyclerView()
        getComplaintList()
        return binding.root
    }

    private fun setupViewModel() {
        val repository = MainRepository()
        val factory = ViewModelFactory(repository)

        viewModel = ViewModelProvider(this, factory)[ViewComplaintsViewModel::class.java]
    }

    private fun getComplaintList() {
        viewModel.getComplaintList()
        viewModel.complaintList.observe(viewLifecycleOwner) { complaintList ->
            binding.progressBar.visibility = View.INVISIBLE
            adapter.setData(complaintList.complaint)
        }
    }

    private fun setupRecyclerView() {
        recyclerView = binding.rvComplaintsList
        adapter = ViewComplaintsAdapter()

        recyclerView.adapter = adapter
        val layoutManager = LinearLayoutManager(
            requireContext(),
            RecyclerView.VERTICAL,
            false
        )
        recyclerView.layoutManager = layoutManager
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
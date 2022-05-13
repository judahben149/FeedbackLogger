package com.judahben149.feedbacklogger.ui.viewcomplaints

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.judahben149.feedbacklogger.databinding.ComplaintItemBinding
import com.judahben149.feedbacklogger.model.Complaint

class ViewComplaintsAdapter: RecyclerView.Adapter<ViewComplaintsAdapter.ViewComplaintsViewHolder>() {

    var complaintList = emptyList<Complaint>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewComplaintsViewHolder {
        val binding = ComplaintItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewComplaintsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewComplaintsViewHolder, position: Int) {
        holder.bindItem(position)
    }

    override fun getItemCount(): Int {
        return complaintList.size
    }

    inner class ViewComplaintsViewHolder(private val binding: ComplaintItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bindItem(position: Int) {
            val currentComplaint = complaintList[position]

            binding.tvComplaintName.text = currentComplaint.name
            binding.tvComplaintBody.text = currentComplaint.complaintBody
        }
    }

    fun setData(complaint: List<Complaint>) {
        this.complaintList = complaint
        notifyDataSetChanged()
    }
}

package com.judahben149.feedbacklogger.ui.viewcomplaints

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.judahben149.feedbacklogger.model.Complaint
import com.judahben149.feedbacklogger.model.ComplaintList
import com.judahben149.feedbacklogger.repository.MainRepository
import kotlinx.coroutines.launch

class ViewComplaintsViewModel(private val repository: MainRepository): ViewModel() {

    val complaintList = MutableLiveData<ComplaintList>()

    fun getComplaintList() {
        viewModelScope.launch {
            val response = repository.getComplaintsList()

            if (response.isSuccessful) {
                complaintList.value = response.body()
            }
        }
    }
}
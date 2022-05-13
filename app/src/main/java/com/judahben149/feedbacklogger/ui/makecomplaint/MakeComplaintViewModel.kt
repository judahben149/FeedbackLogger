package com.judahben149.feedbacklogger.ui.makecomplaint

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.judahben149.feedbacklogger.model.Complaint
import com.judahben149.feedbacklogger.model.Status
import com.judahben149.feedbacklogger.repository.MainRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MakeComplaintViewModel(private val repository: MainRepository): ViewModel() {

    val complaintResponse : MutableLiveData<Response<Status>> = MutableLiveData()

    fun logComplaint(complaint: Complaint) {
        viewModelScope.launch {
            val incomingComplaintResponse = repository.logComplaint(complaint)
            complaintResponse.value = incomingComplaintResponse
        }
    }

    fun getComplaintsList() {
        viewModelScope.launch {
            repository.getComplaintsList()
        }
    }
}
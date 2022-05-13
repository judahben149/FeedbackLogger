package com.judahben149.feedbacklogger.repository

import com.judahben149.feedbacklogger.api.ApiClient
import com.judahben149.feedbacklogger.model.Complaint
import com.judahben149.feedbacklogger.model.ComplaintList
import com.judahben149.feedbacklogger.model.Status
import retrofit2.Response

class MainRepository {

    suspend fun logComplaint(complaint: Complaint) : Response<Status> {
        return ApiClient.apiService.logComplaint(complaint)
    }

    suspend fun getComplaintsList() : Response<ComplaintList> {
        return ApiClient.apiService.getComplaintList()
    }
}
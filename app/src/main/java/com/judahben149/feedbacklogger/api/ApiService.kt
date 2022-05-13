package com.judahben149.feedbacklogger.api

import com.judahben149.feedbacklogger.model.Complaint
import com.judahben149.feedbacklogger.model.ComplaintList
import com.judahben149.feedbacklogger.model.Status
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("complaints/create")
    suspend fun logComplaint(
        @Body complaint: Complaint
    ): Response<Status>

    @GET("/complaints")
    suspend fun getComplaintList(): Response<ComplaintList>

}
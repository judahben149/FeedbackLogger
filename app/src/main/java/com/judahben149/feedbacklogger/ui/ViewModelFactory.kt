

package com.judahben149.feedbacklogger.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.judahben149.feedbacklogger.repository.MainRepository
import com.judahben149.feedbacklogger.ui.makecomplaint.MakeComplaintViewModel
import com.judahben149.feedbacklogger.ui.viewcomplaints.ViewComplaintsViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: MainRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(MakeComplaintViewModel::class.java) -> {
             MakeComplaintViewModel(repository) as T
            }
            modelClass.isAssignableFrom(ViewComplaintsViewModel::class.java) -> {
                ViewComplaintsViewModel(repository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
package com.binartest.praktek.ui.home

import android.view.View
import androidx.lifecycle.ViewModel
import com.binartest.praktek.data.repositories.UserRepository
import com.binartest.praktek.utils.startLoginActivity

class HomeViewModel(
    private val repository: UserRepository
) : ViewModel() {

    val user by lazy {
        repository.currentUser()
    }
    
    fun logout(view: View){
        repository.logout()
        view.context.startLoginActivity()
    }
}
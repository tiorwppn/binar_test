package com.binartest.praktek.ui.inputItem

import android.view.View
import androidx.lifecycle.ViewModel
import com.binartest.praktek.data.repositories.UserRepository
import com.binartest.praktek.utils.startHomeActivity

class InputItemViewModel (
    private val repository: UserRepository
    ) : ViewModel() {


    fun backBtn(view: View) {
        view.context.startHomeActivity()
    }

}
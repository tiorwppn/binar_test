package com.binartest.praktek.ui.inputItem

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.binartest.praktek.data.repositories.UserRepository

@Suppress("UNCHECKED_CAST")
class InputItemViewModelFactory(
    private val repository: UserRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return InputItemViewModel(repository) as T
    }

}
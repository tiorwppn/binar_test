package com.binartest.praktek.ui.home

import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.binartest.praktek.data.repositories.DataItem
import com.binartest.praktek.data.repositories.UserRepository
import com.binartest.praktek.ui.inputItem.InputItemActivity
import com.binartest.praktek.utils.startInputBarangActivity
import com.binartest.praktek.utils.startLoginActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeViewModel (
    private val repository: UserRepository,
    private val barang: MutableLiveData<List<DataItem>> = MutableLiveData()
) : ViewModel() {

    val user by lazy {
        repository.currentUser()
    }
    
    fun logout(view: View){
        repository.logout()
        view.context.startLoginActivity()
    }

    fun InputBarang(view: View) {
        view.context.startInputBarangActivity()
    }

    fun getData() {

    }
}
package com.binartest.praktek.ui.home

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.binartest.praktek.data.repositories.Goods
import com.binartest.praktek.data.repositories.GoodsRepository
import com.binartest.praktek.data.repositories.UserRepository
import com.binartest.praktek.utils.startLoginActivity
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.QuerySnapshot

class HomeViewModel(
    private val repository: UserRepository
) : ViewModel() {

    var goodsRepository = GoodsRepository()
    var goods: MutableLiveData<List<Goods>> = MutableLiveData()

    val user by lazy {
        repository.currentUser()
    }
    
    fun logout(view: View){
        repository.logout()
        view.context.startLoginActivity()
    }

    fun addGoods(goods: Goods) {
        goodsRepository.addGoods(goods)
    }

    fun getGoods(): LiveData<List<Goods>> {
        goodsRepository.getGoods().addSnapshotListener(EventListener<QuerySnapshot> { value, e ->
            if (e != null) {
                goods.value = null
                return@EventListener
            }
            goods.value = value?.toObjects(Goods::class.java)
        })
        return goods
    }
}
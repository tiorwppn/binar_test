package com.binartest.praktek.data.repositories

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class GoodsRepository {

    var db = FirebaseFirestore.getInstance()

    fun addGoods(goods: Goods) {
        val documentReference = db.collection("goods")
        documentReference.add(goods)
    }

    fun getGoods(): CollectionReference {
        return db.collection("goods")
    }
}
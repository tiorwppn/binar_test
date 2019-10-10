package com.binartest.praktek.data.repositories

import com.binartest.praktek.data.firebase.FirebaseSource

class UserRepository (
    private val firebase: FirebaseSource
){
    fun login(email: String, password: String) = firebase.login(email, password)

    fun register(email: String, password: String) = firebase.register(email, password)

    fun currentUser() = firebase.currentUser()

    fun logout() = firebase.logout()

    fun getData() = firebase.getData()

    fun inputData() = firebase.inputData(DataItem())
}
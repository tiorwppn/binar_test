package com.binartest.praktek

import android.app.Application
import com.binartest.praktek.data.firebase.FirebaseSource
import com.binartest.praktek.data.repositories.UserRepository
import com.binartest.praktek.ui.auth.AuthViewModelFactory
import com.binartest.praktek.ui.home.HomeViewModelFactory
import com.binartest.praktek.ui.inputItem.InputItemActivity
import com.binartest.praktek.ui.inputItem.InputItemViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class FirebaseApplication : Application(), KodeinAware{

    override val kodein = Kodein.lazy {
        import(androidXModule(this@FirebaseApplication))

        bind() from singleton { FirebaseSource() }
        bind() from singleton { UserRepository(instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { HomeViewModelFactory(instance()) }
        bind() from provider { InputItemViewModelFactory(instance()) }

    }
}
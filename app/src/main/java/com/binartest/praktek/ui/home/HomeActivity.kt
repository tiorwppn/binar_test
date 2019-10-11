package com.binartest.praktek.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.binartest.praktek.R
import com.binartest.praktek.data.repositories.DataItem
import com.binartest.praktek.databinding.ActivityHomeBinding
import com.binartest.praktek.ui.inputItem.InputItemActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class HomeActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory : HomeViewModelFactory by instance()

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val binding: ActivityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        viewModel = ViewModelProviders.of(this, factory).get(HomeViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel = ViewModelProviders.of(this)
            .get(viewModel::class.java)

    }


    //private fun getData() {
    //    viewModel.getData()
    //        list_goods.layoutManager = LinearLayoutManager(this)
    //        list_goods.adapter = HomeAdapter(DataItem)
    //}

}

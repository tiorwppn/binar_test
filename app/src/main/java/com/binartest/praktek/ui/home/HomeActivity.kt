package com.binartest.praktek.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.binartest.praktek.R
import com.binartest.praktek.databinding.ActivityHomeBinding
import com.binartest.praktek.ui.inputBarang.inputBarangActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class HomeActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory : HomeViewModelFactory by instance()

    private lateinit var goodsViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupUI()

        val binding: ActivityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        goodsViewModel = ViewModelProviders.of(this, factory).get(HomeViewModel::class.java)
        binding.viewmodel = goodsViewModel

    }

    override fun onResume() {
        super.onResume()
        getGoods()
    }

    private fun getGoods() {
        goodsViewModel.getGoods().observe(this, Observer { goods ->
            list_goods.layoutManager = LinearLayoutManager(this)
            list_goods.adapter = GoodsAdapter(goods)
        })
    }

    private fun setupUI() {
        fab_add.setOnClickListener {
            startActivity(Intent(this, inputBarangActivity::class.java))
        }
    }

}

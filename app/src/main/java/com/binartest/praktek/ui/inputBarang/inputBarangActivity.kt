package com.binartest.praktek.ui.inputBarang

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.binartest.praktek.R
import com.binartest.praktek.data.repositories.Goods
import com.binartest.praktek.ui.home.HomeActivity
import com.binartest.praktek.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.activity_add_goods.*

class inputBarangActivity : AppCompatActivity() {

    private lateinit var goodsViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_goods)
        goodsViewModel = ViewModelProviders.of(this)
            .get(HomeViewModel::class.java)
        setupUI()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun addGoods(goods: Goods) {
        goodsViewModel.addGoods(goods)
        startActivity(Intent(this, HomeActivity::class.java))
    }

    private fun setupUI() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        button_add.setOnClickListener {
            val goods = Goods(
                text_input_name.text.toString().toInt(),
                text_input_quantity.text.toString(),
                text_input_supplier.text.toString(),
                text_input_date.text.toString()
            )
            addGoods(goods)
        }
    }
}
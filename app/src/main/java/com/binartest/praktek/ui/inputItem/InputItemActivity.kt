package com.binartest.praktek.ui.inputItem

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.binartest.praktek.R
import com.binartest.praktek.databinding.ActivityTambahBarangBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class InputItemActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()

    private val factory : InputItemViewModelFactory by instance()

    private lateinit var viewModel: InputItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_barang)

        val binding: ActivityTambahBarangBinding = DataBindingUtil.setContentView(this, R.layout.activity_tambah_barang)
        viewModel = ViewModelProviders.of(this, factory).get(InputItemViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel = ViewModelProviders.of(this)
            .get(viewModel::class.java)
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

}
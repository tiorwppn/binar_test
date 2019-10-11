package com.binartest.praktek.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.binartest.praktek.R
import com.binartest.praktek.data.repositories.DataItem
import com.binartest.praktek.databinding.ItemBarangBinding

class HomeAdapter (private val dataSet: List<DataItem>) :
RecyclerView.Adapter<HomeAdapter.BarangViewHolder>() {

    class BarangViewHolder(binding: ItemBarangBinding) : RecyclerView.ViewHolder(binding.root) {
        val itemBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarangViewHolder {
        val goodsBinding: ItemBarangBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_barang, parent, false
            )
        return BarangViewHolder(
            goodsBinding
        )
    }

    override fun onBindViewHolder(holder: BarangViewHolder, position: Int) {
        val barang = dataSet[position]
        holder.itemBinding.barang = barang
    }

    override fun getItemCount() = dataSet.size
}
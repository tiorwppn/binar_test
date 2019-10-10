package com.binartest.praktek.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.binartest.praktek.R
import com.binartest.praktek.data.repositories.Goods
import com.binartest.praktek.databinding.ItemGoodsBinding

class GoodsAdapter(private val dataSet: List<Goods>) :
    RecyclerView.Adapter<GoodsAdapter.GoodsViewHolder>() {

    class GoodsViewHolder(binding: ItemGoodsBinding) : RecyclerView.ViewHolder(binding.root) {
        val itemBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsViewHolder {
        val goodsBinding: ItemGoodsBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_goods, parent, false
            )
        return GoodsViewHolder(
            goodsBinding
        )
    }

    override fun onBindViewHolder(holder: GoodsViewHolder, position: Int) {
        val goods = dataSet[position]
        holder.itemBinding.goods = goods
    }

    override fun getItemCount() = dataSet.size
}
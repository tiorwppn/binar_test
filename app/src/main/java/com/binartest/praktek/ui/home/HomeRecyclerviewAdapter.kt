package com.binartest.praktek.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binartest.praktek.data.repositories.DataItem
import java.text.NumberFormat

class HomeRecyclerviewAdapter (private val contactList: ArrayList<ContactViewModel>) :
    RecyclerView.Adapter<ContactAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.Holder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val contactBinding: ContactBinding = DataBindingUtil
            .inflate(layoutInflater, R.layout.contact_item_layout, parent, false)

        return Holder(contactBinding)
    }

    class Holder(private val contactBinding: ContactBinding) : RecyclerView.ViewHolder(contactBinding.root) {
        fun bindItem(contactViewModel: ContactViewModel) {
            this.contactBinding.viewModel = contactViewModel
            contactBinding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: ContactAdapter.Holder, position: Int) {
        val contactViewModel = contactList[position]
        holder.bindItem(contactViewModel)
    }


    override fun getItemCount(): Int {
        return contactList.size
    }
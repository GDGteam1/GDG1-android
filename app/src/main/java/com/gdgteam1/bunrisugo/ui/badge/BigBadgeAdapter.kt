package com.gdgteam1.bunrisugo.ui.badge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gdgteam1.bunrisugo.R
import com.gdgteam1.bunrisugo.databinding.ItemBigBadgeBinding

class BigBadgeAdapter : RecyclerView.Adapter<BigBadgeAdapter.BigBadgeViewHolder>() {

    private val items = arrayListOf<Any>(1, 2, 3, 4, 5)
    fun setItems(items: ArrayList<Any>) {
        this.items.clear()
        this.items.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BigBadgeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemBigBadgeBinding>(inflater, R.layout.item_big_badge, parent, false)
        return BigBadgeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BigBadgeViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = items.size

    inner class BigBadgeViewHolder(private val binding: ItemBigBadgeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {

        }
    }

}
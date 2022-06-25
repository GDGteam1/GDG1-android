package com.gdgteam1.bunrisugo.ui.main

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gdgteam1.bunrisugo.R
import com.gdgteam1.bunrisugo.databinding.ItemBadgeBinding

class BadgeAdapter : RecyclerView.Adapter<BadgeAdapter.BadgeViewHolder>() {

    private val items = arrayListOf<Any>(1, 2, 3, 4, 5)
    fun setItems(items: ArrayList<Any>) {
        this.items.clear()
        this.items.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BadgeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemBadgeBinding>(inflater, R.layout.item_badge, parent, false)
        return BadgeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BadgeViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = items.size

    inner class BadgeViewHolder(private val binding: ItemBadgeBinding) : RecyclerView.ViewHolder(binding.root) {
        private fun setViewHolderMargin() {
            val layoutParams = binding.root.layoutParams as RecyclerView.LayoutParams
            when (adapterPosition) {
                0 -> layoutParams.setMargins(20.dp, 0, 10.dp, 0)
                itemCount - 1 -> layoutParams.setMargins(0, 0, 20.dp, 0)
                else -> layoutParams.setMargins(0, 0, 10.dp, 0)
            }
        }
        fun bind() {
            setViewHolderMargin()
        }
    }

}

val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
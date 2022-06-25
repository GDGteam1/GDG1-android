package com.gdgteam1.bunrisugo.ui.guide

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gdgteam1.bunrisugo.R
import com.gdgteam1.bunrisugo.databinding.ItemGuideBinding

class GuideAdapter : RecyclerView.Adapter<GuideAdapter.GuideViewHolder>() {

    private val items = arrayListOf<Any>(1, 2, 3)
    fun setItems(items: ArrayList<Any>) {
        this.items.clear()
        this.items.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemGuideBinding>(inflater, R.layout.item_guide, parent, false)
        return GuideViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GuideViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = items.size

    inner class GuideViewHolder(private val binding: ItemGuideBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
        }
    }

}
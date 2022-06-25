package com.gdgteam1.bunrisugo.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gdgteam1.bunrisugo.R
import com.gdgteam1.bunrisugo.databinding.ItemBigCategoryBinding

class BigCategoryAdapter : RecyclerView.Adapter<BigCategoryAdapter.BigCategoryViewHolder>() {

    private val items = arrayListOf<Any>(1, 2, 3, 4, 5, 6,6,6,6,6,6,6,6,6,6)
    fun setItems(items: ArrayList<Any>) {
        this.items.clear()
        this.items.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BigCategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemBigCategoryBinding>(inflater, R.layout.item_big_category, parent, false)
        return BigCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BigCategoryViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = items.size

    inner class BigCategoryViewHolder(private val binding: ItemBigCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
        }
    }

}
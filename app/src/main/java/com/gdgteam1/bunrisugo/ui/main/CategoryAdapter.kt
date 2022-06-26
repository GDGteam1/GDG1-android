package com.gdgteam1.bunrisugo.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gdgteam1.bunrisugo.R
import com.gdgteam1.bunrisugo.data.remote.model.Category
import com.gdgteam1.bunrisugo.databinding.ItemCategoryBinding

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private val items = arrayListOf<Category>(Category(1, R.drawable.ic_empty, "얻은게 없어요", true))
    fun setItems(items: ArrayList<Category>) {
        this.items.clear()
        this.items.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemCategoryBinding>(inflater, R.layout.item_category, parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        private fun setViewHolderMargin() {
            val layoutParams = binding.root.layoutParams as RecyclerView.LayoutParams
            when (adapterPosition) {
                0 -> layoutParams.setMargins(20.dp, 0, 10.dp, 0)
                itemCount - 1 -> layoutParams.setMargins(0, 0, 20.dp, 0)
                else -> layoutParams.setMargins(0, 0, 10.dp, 0)
            }
        }
        fun bind(category: Category) {
            binding.category = category
            binding.ivImage.setImageResource(category.iconUrl)
            setViewHolderMargin()
        }
    }

}
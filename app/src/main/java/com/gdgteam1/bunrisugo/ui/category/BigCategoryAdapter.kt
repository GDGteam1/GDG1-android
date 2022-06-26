package com.gdgteam1.bunrisugo.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gdgteam1.bunrisugo.R
import com.gdgteam1.bunrisugo.data.remote.model.Category
import com.gdgteam1.bunrisugo.databinding.ItemBigCategoryBinding

class BigCategoryAdapter : RecyclerView.Adapter<BigCategoryAdapter.BigCategoryViewHolder>() {

    private val items = arrayListOf<Category>(
        Category(1, R.drawable.ic_pet, "페트병", true),
        Category(1, R.drawable.ic_bottle, "유리병", false),
        Category(1, R.drawable.ic_can, "캔류", false),
        Category(1, R.drawable.ic_qwer, "비닐", false),
        Category(1, R.drawable.ic_pet, "페트병", false),
        Category(1, R.drawable.ic_bottle, "유리병", false),
        Category(1, R.drawable.ic_can, "캔류", false),
        Category(1, R.drawable.ic_qwer, "비닐", false),
        Category(1, R.drawable.ic_pet, "페트병", false),
        Category(1, R.drawable.ic_bottle, "유리병", false),
        Category(1, R.drawable.ic_can, "캔류", false),
        Category(1, R.drawable.ic_qwer, "비닐", false),
        Category(1, R.drawable.ic_pet, "페트병", false),
        Category(1, R.drawable.ic_bottle, "유리병", false),
        Category(1, R.drawable.ic_can, "캔류", false)
    )
    fun setItems(items: ArrayList<Category>) {
        this.items.clear()
        this.items.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BigCategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemBigCategoryBinding>(inflater, R.layout.item_big_category, parent, false)
        return BigCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BigCategoryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class BigCategoryViewHolder(private val binding: ItemBigCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.category = category
            binding.ivImage.setImageResource(category.iconUrl)
        }
    }

}
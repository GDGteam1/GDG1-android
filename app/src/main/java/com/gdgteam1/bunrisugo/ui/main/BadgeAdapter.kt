package com.gdgteam1.bunrisugo.ui.main

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gdgteam1.bunrisugo.R
import com.gdgteam1.bunrisugo.data.remote.model.Badge
import com.gdgteam1.bunrisugo.databinding.ItemBadgeBinding

class BadgeAdapter : RecyclerView.Adapter<BadgeAdapter.BadgeViewHolder>() {

    private val items = arrayListOf<Badge>(Badge(1, "얻은 뱃지가 없어요", R.drawable.ic_empty, "분리수거를 시작해보세요", true))
    fun setItems(items: ArrayList<Badge>) {
        this.items.clear()
        this.items.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BadgeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemBadgeBinding>(inflater, R.layout.item_badge, parent, false)
        return BadgeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BadgeViewHolder, position: Int) {
        holder.bind(items[position])
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
        fun bind(badge: Badge) {
            binding.badge = badge
            binding.ivImage.setImageResource(badge.badgeIconUrl)
            setViewHolderMargin()
        }
    }

}

val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
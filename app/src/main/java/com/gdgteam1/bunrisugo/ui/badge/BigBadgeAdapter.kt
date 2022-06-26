package com.gdgteam1.bunrisugo.ui.badge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gdgteam1.bunrisugo.R
import com.gdgteam1.bunrisugo.data.remote.model.Badge
import com.gdgteam1.bunrisugo.databinding.ItemBigBadgeBinding

class BigBadgeAdapter : RecyclerView.Adapter<BigBadgeAdapter.BigBadgeViewHolder>() {

    private val items = arrayListOf<Badge>(
        Badge(1, "공병 수집가", R.drawable.ic_bottle, "유리병 분리수거 방법을 배우셨군요", false),
        Badge(2, "플라스틱 여왕", R.drawable.ic_pet, "플라스틱 분리수거 방법을 배우셨군요", true),
        Badge(3, "분리수거학과 교수님", R.drawable.ic_professor, "모두 배우셨네요! 학생들에게 가르쳐 주세요", false),
        Badge(4, "분리왕 김분리", R.drawable.ic_book, "절반 이상 배우셨네요! 조금만 더 하면 되겠어요. ", false),
    )
    fun setItems(items: ArrayList<Badge>) {
        this.items.clear()
        this.items.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BigBadgeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemBigBadgeBinding>(inflater, R.layout.item_big_badge, parent, false)
        return BigBadgeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BigBadgeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class BigBadgeViewHolder(private val binding: ItemBigBadgeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(badge: Badge) {
            binding.badge = badge
            binding.ivImage.setImageResource(badge.badgeIconUrl)
        }
    }

}
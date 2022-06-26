package com.gdgteam1.bunrisugo.ui.guide

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gdgteam1.bunrisugo.R
import com.gdgteam1.bunrisugo.data.remote.model.Step
import com.gdgteam1.bunrisugo.databinding.ItemGuideBinding

class GuideAdapter : RecyclerView.Adapter<GuideAdapter.GuideViewHolder>() {

    private val items = arrayListOf<Step>(
        Step("Step 1. 헹구기",
            "https://user-images.githubusercontent.com/37768791/175788624-015fafb3-42bc-4c0b-a4bd-47eb0c8199ad.jpeg",
            "용기에 담긴 내용물을 다 비우고 깨끗하게 헹굽니다.\n"),
    Step("Step 2. 라벨 벗기기",
        "https://user-images.githubusercontent.com/37768791/175788649-c999d692-4b47-437f-97bd-70590ca2cc34.jpeg",
        "라벨지는 제거하고 찌그려뜨려 뚜껑을 닫습니다.\n"),
        Step("Step 3. 버리기",
            "https://user-images.githubusercontent.com/37768791/175788652-b9ad9c6e-735f-4d4f-982b-fe929e3e53d8.jpeg",
            "전용배출 수거함에 버립니다."
        ))
    fun setItems(items: ArrayList<Step>) {
        this.items.clear()
        this.items.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemGuideBinding>(inflater, R.layout.item_guide, parent, false)
        return GuideViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GuideViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class GuideViewHolder(private val binding: ItemGuideBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(step: Step) {
            binding.step = step
            Glide.with(binding.ivImage)
                .load(step.imgUrl)
                .into(binding.ivImage)
        }
    }

}
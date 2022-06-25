package com.gdgteam1.bunrisugo.ui.badge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gdgteam1.bunrisugo.R
import com.gdgteam1.bunrisugo.databinding.ActivityBadgeBinding

class BadgeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBadgeBinding
    private val adapter by lazy { BigBadgeAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityBadgeBinding>(this, R.layout.activity_badge).apply {
            binding = this
            lifecycleOwner = this@BadgeActivity
        }
        binding.rv.adapter = adapter
    }
}
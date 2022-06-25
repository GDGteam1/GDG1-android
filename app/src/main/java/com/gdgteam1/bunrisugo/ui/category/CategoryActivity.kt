package com.gdgteam1.bunrisugo.ui.category

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gdgteam1.bunrisugo.R
import com.gdgteam1.bunrisugo.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryBinding
    private val adapter by lazy { BigCategoryAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityCategoryBinding>(this, R.layout.activity_category).apply {
            binding = this
            lifecycleOwner = this@CategoryActivity
        }
        binding.rv.adapter = adapter
    }
}
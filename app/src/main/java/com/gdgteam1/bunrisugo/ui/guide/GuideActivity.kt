package com.gdgteam1.bunrisugo.ui.guide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gdgteam1.bunrisugo.R
import com.gdgteam1.bunrisugo.databinding.ActivityGuideBinding

class GuideActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGuideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityGuideBinding>(this, R.layout.activity_guide).apply {

        }
    }
}
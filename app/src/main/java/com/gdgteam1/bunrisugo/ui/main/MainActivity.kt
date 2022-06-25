package com.gdgteam1.bunrisugo.ui.main

import android.net.Uri
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.databinding.DataBindingUtil
import com.gdgteam1.bunrisugo.R
import com.gdgteam1.bunrisugo.databinding.ActivityMainBinding
import java.io.File


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private lateinit var uri: Uri

    private val badgeAdapter by lazy { BadgeAdapter() }
    private val categoryAdapter by lazy { CategoryAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            binding = this
            lifecycleOwner = this@MainActivity
        }



//        val file = File(filesDir, "cameraImg")
//        val uri: Uri = FileProvider.getUriForFile(this, applicationContext.packageName + ".provider", file)


        binding.btnStart.setOnClickListener {
            startCamera.launch(initUri())
        }

        binding.rvBadge.adapter = badgeAdapter
        binding.rvBunri.adapter = categoryAdapter

    }
    private val startCamera = registerForActivityResult(ActivityResultContracts.TakePicture()) {
        if (it) {
            // api call
        }
    }

    private fun initUri(): Uri {
        val tempImagesDir = File(
            applicationContext.filesDir,
            "temp_images")

        tempImagesDir.mkdir()

        val tempImage = File(
            tempImagesDir,
            "temp_image.jpg")

        return FileProvider.getUriForFile(
            applicationContext,
           "com.gdgteam1.bunrisugo.fileprovider",
            tempImage)
    }
}
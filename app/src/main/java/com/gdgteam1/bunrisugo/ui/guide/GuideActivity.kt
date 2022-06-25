package com.gdgteam1.bunrisugo.ui.guide

import android.content.Intent
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.databinding.DataBindingUtil
import com.gdgteam1.bunrisugo.R
import com.gdgteam1.bunrisugo.databinding.ActivityGuideBinding
import java.io.File

class GuideActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGuideBinding
    private val guideAdapter by lazy { GuideAdapter() }
    private lateinit var uri: Uri

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityGuideBinding>(this, R.layout.activity_guide).apply {
            binding = this
            lifecycleOwner = this@GuideActivity
        }
        binding.rvGuide.adapter = guideAdapter

        binding.btnHome.setOnClickListener {
            finish()
        }

        binding.btnRetry.setOnClickListener {
            uri = initUri()
            startCamera.launch(uri)
        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private val startCamera = registerForActivityResult(ActivityResultContracts.TakePicture()) {
        if (it) {
            uri.let { uri ->
                val bitmap = ImageDecoder.decodeBitmap(ImageDecoder.createSource(contentResolver, uri))
//                binding.ivLogo.setImageBitmap(bitmap)
                startActivity(
                    Intent(this, GuideActivity::class.java).apply {

                    }
                )
                finish()
            }

//            val bitmap: Bitmap = MediaStore.Images.Media.getBitmap(c.getContentResolver(), Uri.parse(imageUri))
//            val my_img_view = findViewById(R.id.my_img_view) as Imageview
//            my_img_view.setImageBitmap(bitmap)
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
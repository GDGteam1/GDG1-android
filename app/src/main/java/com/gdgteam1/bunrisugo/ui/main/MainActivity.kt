package com.gdgteam1.bunrisugo.ui.main

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
import com.gdgteam1.bunrisugo.data.remote.DataSource
import com.gdgteam1.bunrisugo.databinding.ActivityMainBinding
import com.gdgteam1.bunrisugo.ui.badge.BadgeActivity
import com.gdgteam1.bunrisugo.ui.category.CategoryActivity
import com.gdgteam1.bunrisugo.ui.guide.GuideActivity
import java.io.File


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var uri: Uri
    private val dataSource = DataSource()

    private val badgeAdapter by lazy { BadgeAdapter() }
    private val categoryAdapter by lazy { CategoryAdapter() }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            binding = this
            lifecycleOwner = this@MainActivity
        }

//        val file = File(filesDir, "cameraImg")
//        val uri: Uri = FileProvider.getUriForFile(this, applicationContext.packageName + ".provider", file)

        binding.showAllBadge.setOnClickListener {
            startActivity(
                Intent(this, BadgeActivity::class.java).apply {
                }
            )
        }

        binding.showAllBunri.setOnClickListener {
            startActivity(
                Intent(this, CategoryActivity::class.java).apply {

                }
            )
        }

        binding.btnStart.setOnClickListener {
            uri = initUri()
            startCamera.launch(uri)
        }

        binding.rvBadge.adapter = badgeAdapter
        binding.rvBunri.adapter = categoryAdapter

//        lifecycleScope.launch(Dispatchers.IO) {
//
//            val a = withContext(Dispatchers.Default) {
//                dataSource.getRecentBadgeList()
//            }
//            Toast.makeText(this@MainActivity, "a :: ${a.data.size}", Toast.LENGTH_SHORT).show()
//
//        }

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
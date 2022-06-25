package com.gdgteam1.bunrisugo.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.gdgteam1.bunrisugo.R
import com.gdgteam1.bunrisugo.data.remote.DataSource
import com.gdgteam1.bunrisugo.databinding.ActivitySplashBinding
import com.gdgteam1.bunrisugo.ui.main.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val dataSource = DataSource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivitySplashBinding>(this, R.layout.activity_splash).apply {
            binding = this
            lifecycleOwner = this@SplashActivity
        }
        lifecycleScope.launch {
//            dataSource.getRecentBadgeList()
            delay(1000)
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // 스플래쉬 화면 띄우고 1초 뒤에 MainActivity 화면 실행
//        val backgroundExecutor : ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()
//        val mainExecutor : Executor = ContextCompat.getMainExecutor(this)
//        backgroundExecutor.schedule({
//            mainExecutor.execute {
//
//            }
//        }, 1, TimeUnitmeUnit.SECONDS)

    }
}
package com.gdgteam1.bunrisugo.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.gdgteam1.bunrisugo.R
import com.gdgteam1.bunrisugo.databinding.ActivitySplashBinding
import com.gdgteam1.bunrisugo.ui.login.LoginActivity
import com.gdgteam1.bunrisugo.ui.main.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivitySplashBinding>(this, R.layout.activity_splash).apply {
            binding = this
            lifecycleOwner = this@SplashActivity
        }
        lifecycleScope.launch {
            delay(1000)
            val intent = Intent(applicationContext, LoginActivity::class.java)
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
package com.gdgteam1.bunrisugo.ui.login

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.gdgteam1.bunrisugo.R
import com.gdgteam1.bunrisugo.databinding.ActivityLoginBinding
import com.gdgteam1.bunrisugo.databinding.ActivitySplashBinding
import com.gdgteam1.bunrisugo.ui.main.MainActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login).apply {
            binding = this
            lifecycleOwner = this@LoginActivity
        }

        binding.nameEditText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (binding.nameEditText.text.toString().length > 0) {
                    binding.loginButton.isClickable = true
                    binding.loginButton.setBackgroundColor(Color.BLUE);
                } else {
                    binding.loginButton.isClickable = true
                    binding.loginButton.setBackgroundColor(Color.GRAY)
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.nameEditText.text.toString().length > 0) {
                    binding.loginButton.isClickable = true
                    binding.loginButton.setBackgroundColor(Color.BLUE);
                } else {
                    binding.loginButton.isClickable = true
                    binding.loginButton.setBackgroundColor(Color.GRAY)
                }
            }

        /*binding.loginButton.setOnClickListener {

        })*/
            /*
            if (binding.nameEditText.text.toString().isNotEmpty()) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "이름을 입력해주세요!", Toast.LENGTH_SHORT).show()
            }
             */
        })

    }

}
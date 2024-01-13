package com.example.healthyapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.healthyapp.R
import com.example.healthyapp.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    
    private lateinit var binding : ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.introBtn.setOnClickListener{
            val navigate = Intent(this, MainActivity::class.java)
            startActivity(navigate)
        }
       
    }
}
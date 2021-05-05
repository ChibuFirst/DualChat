package com.example.dualchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dualchat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_DualChat)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.apply {
            buttonUser1.setOnClickListener { mainIntent(Constants.USER1) }
            buttonUser2.setOnClickListener { mainIntent(Constants.USER2) }
        }
    }

    private fun mainIntent(user: String) {
        val intent = Intent(this, ChatActivity::class.java)
        intent.putExtra(Constants.USER, user)
        startActivity(intent)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
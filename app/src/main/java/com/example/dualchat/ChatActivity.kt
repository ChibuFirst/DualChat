package com.example.dualchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dualchat.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {

    private var binding: ActivityChatBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        intent?.let {
            Toast.makeText(this, "Welcome ${it.getStringExtra(Constants.USER)}", Toast.LENGTH_LONG).show()
        }
        binding?.imageBack?.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
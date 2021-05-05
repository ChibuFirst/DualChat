package com.example.dualchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dualchat.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {

    private var binding: ActivityChatBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        var user = ""

        intent?.let {
            user = it.getStringExtra(Constants.USER)!!
            Toast.makeText(this, "Welcome $user", Toast.LENGTH_LONG).show()
            val receiver = if (user == Constants.USER1) "To User 2" else "To User 1"
            binding?.textUser?.text = receiver
        }

        val adapter = ChatsRecyclerAdapter(DummyData.chatList, user)

        binding?.apply {
            imageBack.setOnClickListener {
                startActivity(Intent(this@ChatActivity, MainActivity::class.java))
                finish()
            }
            recyclerChats.apply {
                val linear = LinearLayoutManager(this@ChatActivity)
                linear.stackFromEnd = true
                layoutManager = linear
                setHasFixedSize(true)
                setAdapter(adapter)
            }
            imageSend.setOnClickListener {
                if (editMessage.text.toString().isNotEmpty()) {
                    adapter.addChat(user, editMessage.text.toString())
                    editMessage.text = null
                    recyclerChats.smoothScrollToPosition(adapter.itemCount - 1)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
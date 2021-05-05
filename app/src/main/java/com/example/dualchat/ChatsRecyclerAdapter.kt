package com.example.dualchat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ChatsRecyclerAdapter(private val chatsList: ArrayList<Chats>, private val currentUser: String) : RecyclerView.Adapter<ChatsRecyclerAdapter.ChatsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatsViewHolder {
        return ChatsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.chat_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ChatsViewHolder, position: Int) {
        val chats = chatsList[position]
        holder.bind(chats, currentUser)
    }

    override fun getItemCount(): Int = chatsList.size

    fun addChat(sender: String, message: String) {
        val newChat = Chats(sender, message)
        chatsList.add(newChat)
        notifyDataSetChanged()
    }

    class ChatsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val cardSender: CardView = itemView.findViewById(R.id.card_sender)
        private val textChatSender: TextView = itemView.findViewById(R.id.text_chat_sender)
        private val cardReceiver: CardView = itemView.findViewById(R.id.card_receiver)
        private val textChatReceiver: TextView = itemView.findViewById(R.id.text_chat_receiver)

        fun bind(chats: Chats, currentUser: String) {
            if (chats.sender == currentUser) {
                cardReceiver.visibility = View.GONE
                cardSender.visibility = View.VISIBLE
                textChatSender.text = chats.message
            } else {
                cardSender.visibility = View.GONE
                cardReceiver.visibility = View.VISIBLE
                textChatReceiver.text = chats.message
            }
        }
    }
}
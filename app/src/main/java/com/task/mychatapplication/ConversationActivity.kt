package com.task.mychatapplication

import android.content.Intent
import android.os.Bundle

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import com.cometchat.chat.constants.CometChatConstants
import com.cometchat.chat.models.Conversation
import com.cometchat.chat.models.Group
import com.cometchat.chat.models.User
import com.cometchat.chatuikit.conversations.CometChatConversations
/**
 * Activity to display a list of conversations using CometChat UI Kit.
 * Allows users to click on a conversation and navigate to the chat screen.
 */

class ConversationActivity : AppCompatActivity() {

    private lateinit var conversationsView: CometChatConversations

    /**
     * Called when the activity is first created.
     * Sets up the UI and listeners.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_conversation)

        initView()
        setListeners()
    }

    /**
     * Initializes the view components used in this activity.
     * Finds the CometChatConversations view by its ID.
     */
    private fun initView() {
        conversationsView = findViewById(R.id.conversation_view)
    }
    /**
     * Sets up listeners for the views.
     * Handles click events on conversations to open the respective chat.
     */
    private fun setListeners() {
        conversationsView.setOnItemClick { _, _, conversation ->
            startMessageActivity(conversation)
        }
    }
/**
 * Starts the MessageActivity based on the selected conversation.
 */
    private fun startMessageActivity(conversation: Conversation) {
        val intent = Intent(this, MessageActivity::class.java).apply {
            when (conversation.conversationType) {
                CometChatConstants.CONVERSATION_TYPE_GROUP -> {
                    val group = conversation.conversationWith as Group
                    putExtra("guid", group.guid)
                }
                else -> {
                    val user = conversation.conversationWith as User
                    putExtra("uid", user.uid)
                }
            }
        }
        startActivity(intent)
    }
}
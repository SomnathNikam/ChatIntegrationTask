package com.task.mychatapplication

import android.app.Application
import android.util.Log
import com.cometchat.chat.core.AppSettings
import com.cometchat.chat.core.CometChat
import com.cometchat.chat.exceptions.CometChatException

/**
 * Custom [Application] class used to initialize CometChat SDK when the app starts.
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        /**
         * Called when the application is starting, before any other application objects have been created.
         * Initializes CometChat SDK with the provided App ID and Region.
         */
         val appID = "2738108fe25d4e55" // Replace with your App ID
         val region = "in" // Replace with your App Region

        // Build the AppSettings object with desired configurations
        val settings = AppSettings.AppSettingsBuilder()
            .subscribePresenceForAllUsers()
            .setRegion(region)
            .build()

        // Initialize CometChat SDK
        CometChat.init(
            this,
            appID,
            settings,
            object : CometChat.CallbackListener<String>() {
            override fun onSuccess(p0: String?) {
                Log.d("CometChatInit", "Initialization completed successfully")
            }

            override fun onError(e: CometChatException) {
                Log.e("CometChatInit", "Initialization failed with exception: ${e.message}")
            }
        })
    }
}

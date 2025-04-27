package com.task.mychatapplication

import android.app.Application
import android.util.Log
import com.cometchat.chat.core.AppSettings
import com.cometchat.chat.core.CometChat
import com.cometchat.chat.exceptions.CometChatException

/*class MyApplication:Application() {
    val appID: String = "APP_ID" // Replace with your App ID
    val region: String = "REGION" // Replace with your App Region ("eu" or "us")

    val appSettings = AppSettings.AppSettingsBuilder()
        .subscribePresenceForAllUsers()
        .setRegion(region)
        .autoEstablishSocketConnection(true)
        .build()

//    CometChat.init(
//    this,
//    appID,
//    appSettings,
//    object : CometChat.CallbackListener<String>() {
//        override fun onSuccess(p0: String?) {
//            Log.d(TAG, "Initialization completed successfully")
//        }
//
//        override fun onError(p0: CometChatException?) {
//            Log.d(TAG, "Initialization failed with exception: " + p0?.message)
//        }
//    }
//    )

}*/
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

         val appID = "2738108fe25d4e55" // Replace with your App ID
         val region = "in" // Replace with your App Region
        val settings = AppSettings.AppSettingsBuilder()
            .subscribePresenceForAllUsers()
            .setRegion(region)
            .build()

        CometChat.init(this, appID, settings, object : CometChat.CallbackListener<String>() {
            override fun onSuccess(p0: String?) {
                Log.d("CometChatInit", "Initialization completed successfully")
            }

            override fun onError(e: CometChatException) {
                Log.e("CometChatInit", "Initialization failed with exception: ${e.message}")
            }
        })
    }
}

package com.debopam.firebase

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class FirebaseTokenGenerator {

    fun generateToken(callback: OnTokenGenerated) {
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                callback.onGenerated("")
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result
            callback.onGenerated(token!!)
        })
    }
}
package com.app.autofetchotp.receiver

import android.content.Intent

interface SMSListener {
    fun onSuccessListener(intent: Intent?)
    fun onFailureListener()
}
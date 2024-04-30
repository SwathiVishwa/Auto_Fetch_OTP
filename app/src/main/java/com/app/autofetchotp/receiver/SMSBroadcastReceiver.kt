package com.app.autofetchotp.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.common.api.Status

class SMSBroadcastReceiver : BroadcastReceiver() {
    var smsBroadcastReceiverListener: SMSListener? = null
    override fun onReceive(context: Context, intent: Intent) {

        if (intent.action === SmsRetriever.SMS_RETRIEVED_ACTION) {

            val extras = intent.extras
            val smsRetrieverStatus = extras!![SmsRetriever.EXTRA_STATUS] as Status?
            when (smsRetrieverStatus!!.statusCode) {
                CommonStatusCodes.SUCCESS -> {
                    val messageIntent = extras.getParcelable<Intent>(SmsRetriever.EXTRA_CONSENT_INTENT)
                    smsBroadcastReceiverListener!!.onSuccessListener(messageIntent)
                }

                CommonStatusCodes.TIMEOUT -> smsBroadcastReceiverListener!!.onFailureListener()
            }
        }
    }


}
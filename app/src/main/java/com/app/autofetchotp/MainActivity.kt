package com.app.autofetchotp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.auth.api.phone.SmsRetrieverClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startSmsUserConsent()
    }

    private fun startSmsUserConsent() {

//        private void startSmsUserConsent() {
        val client: SmsRetrieverClient = SmsRetriever.getClient(this);
        //We can add sender phone number or leave it blank
        // I'm adding null here
        client.startSmsUserConsent(null).addOnSuccessListener {
            Toast.makeText(
                applicationContext,
                "On Success",
                Toast.LENGTH_LONG
            ).show();
        }.addOnFailureListener {
            Toast.makeText(
                applicationContext,
                "On OnFailure",
                Toast.LENGTH_LONG
            ).show();
        }
    }
}
package com.example.sendorderedbroadcastex

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class Receiver1 : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if ("action1".equals(intent?.action)){
            var it = intent?.getStringExtra("name")
            Toast.makeText(context,"$it",Toast.LENGTH_LONG).show()
        }
    }
}
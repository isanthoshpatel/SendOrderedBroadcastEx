package com.example.sendorderedbroadcastex

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class Receiver4 : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if ("ordered_action".equals(intent?.action)) {
            var it = intent?.getStringExtra("name")
            var code = resultCode
            var data = resultData
            var extras = getResultExtras(true).getString("one")
            Toast.makeText(context, "$it\n $code\n $data\n $extras\n", Toast.LENGTH_LONG).show()
        }
    }
}
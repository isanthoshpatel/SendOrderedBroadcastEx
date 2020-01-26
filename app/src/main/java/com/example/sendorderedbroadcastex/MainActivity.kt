package com.example.sendorderedbroadcastex

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.putString
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var r1: Receiver1? = null
    var r2: Receiver2? = null
    var r3: Receiver3? = null
    var r4: Receiver4? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var iff = IntentFilter("action1")
        r1 = Receiver1()
        registerReceiver(r1, iff)
        var iff2 = IntentFilter("action2")
        r2 = Receiver2()
        registerReceiver(r2, iff2)

        var iff3 = IntentFilter("ordered_action")
        iff3.priority = 2
        r3 = Receiver3()
        registerReceiver(r3, iff3)
        var iff4 = IntentFilter("ordered_action")
        iff4.priority = 1
        r4 = Receiver4()
        registerReceiver(r4, iff4)

        bt1.setOnClickListener {
            var i = Intent("action1")
            i.putExtra("name", "Receiver1 triggered")
            sendBroadcast(i)
        }
        bt2.setOnClickListener {
            var i = Intent("action2")
            i.putExtra("name", "Receiver2 triggered")
            sendBroadcast(i)
        }
        bt3.setOnClickListener {
            var i = Intent("ordered_action")
            i.putExtra("name", "ordered_Receiver3_Receiver4")
            var b = Bundle()
            b.putString("zero", "zero")
            sendOrderedBroadcast(i,null, null, null, 0, "Zero", b)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(r1)
        unregisterReceiver(r2)
        unregisterReceiver(r3)
        unregisterReceiver(r4)
    }


}

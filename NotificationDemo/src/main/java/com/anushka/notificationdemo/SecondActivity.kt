package com.anushka.notificationdemo

import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import org.w3c.dom.Text

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        receiveInput()
    }

    private fun receiveInput() {

        val KEY_REPLY = "key_reply"

        val intent = this.intent
        val remoteInput = RemoteInput.getResultsFromIntent(intent)
        if (remoteInput != null) {
            val inputString = remoteInput.getCharSequence(KEY_REPLY).toString()
            val result_text = findViewById<TextView>(R.id.tv_remote)

            result_text.text = inputString

            val channelID = "com.anushka.notificationdemo.channel1"
            val notificationId = 45

            val repliedNotification = NotificationCompat.Builder(this, channelID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentText("Your reply received")
                .build()

            val notificationManager : NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(notificationId, repliedNotification)

        }
    }
}
package com.cdv.pokemongo

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.location.Location
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import java.util.Timer


class LocationService: Service() {

    override fun onCreate() {
        ContextCompat.startForegroundService(this, Intent(this, LocationService::class.java))

        super.onCreate()
        val isServiceStarted = true
        val builder: NotificationCompat.Builder =
            NotificationCompat.Builder(this, NotificationManager.EXTRA_NOTIFICATION_CHANNEL_GROUP_ID)
                .setOngoing(false)
                .setSmallIcon(R.drawable.ic_launcher_background)

            val notificationManager: NotificationManager =
                getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val notificationChannel = NotificationChannel(
                NotificationManager.EXTRA_NOTIFICATION_CHANNEL_GROUP_ID,
                NotificationManager.EXTRA_NOTIFICATION_CHANNEL_GROUP_ID, NotificationManager.IMPORTANCE_LOW
            )
            notificationChannel.description = NotificationManager.EXTRA_NOTIFICATION_CHANNEL_ID
            notificationChannel.setSound(null, null)
            notificationManager.createNotificationChannel(notificationChannel)
            startForeground(1, builder.build())


    }
     fun start(context: Context, updateCallback:(lat: Double, lon: Double)-> Unit) {
        val timer = Timer()
        LocationHelper().startListeningUserLocation(
            context, object : MyLocationListener {
                override fun onLocationChanged(location: Location?) {
                    if(location != null) {
                        updateCallback(location.latitude, location.longitude)
                    }
                }
            })
        return
    }
    override fun onBind(intent: Intent): IBinder? {
        return null
    }
    override fun onDestroy() {
        super.onDestroy()
    }

}
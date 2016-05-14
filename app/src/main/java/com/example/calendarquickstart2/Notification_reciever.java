package com.example.calendarquickstart2;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Helene on 08-05-2016.
 */
public class Notification_reciever extends BroadcastReceiver{
    public static String eventMorning;
    public static long wakeUpMorningHour;
    public static long wakeUpMorningMinute;

    @Override
    public void onReceive(Context context, Intent intent) {
        //lav notificationManager
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        //nåt mantrykker bliver man sendt videre til en intent som har repeating activity


        Intent repeating_intent = new Intent(context, Repeating_activity.class);
        //dette gør at vores nye intent vil overskrive hvis en anden activitet er åben eller hvis den ikke kører så åbner den henover.
        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        //vi skalhave en ny instans af pending intent for at kunne vise intenten i notificationen
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 100, repeating_intent, PendingIntent.FLAG_UPDATE_CURRENT);

        eventMorning = "Lege med vennerne";
        wakeUpMorningHour = 12;
        wakeUpMorningMinute = 30;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent)
                .setSmallIcon(android.R.drawable.ic_lock_idle_alarm)//Virker på telefonen, selvom den brokker sig her.
                .setContentTitle("Din alarm er sat til kl. " + wakeUpMorningHour + ":" + wakeUpMorningMinute)
                .setContentText("Da du skal til eventet: " + eventMorning)
                .setAutoCancel(true);
        notificationManager.notify(100, builder.build());
    }
}

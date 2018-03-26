package com.example.android.pulse.gcm;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.android.pulse.MainClasses.Home;
import com.example.android.pulse.R;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * Created by android on 28/10/15.
 */

    public class GcmIntentService extends IntentService {
        public static final int NOTIFICATION_ID = 1;
        private static final String TAG = "GcmIntentService";
        private NotificationManager mNotificationManager;
        NotificationCompat.Builder builder;
    Date date1;
        public GcmIntentService() {
            super("GcmIntentService");
        }

        @Override
        protected void onHandleIntent(Intent intent) {
            Bundle extras = intent.getExtras();
            String ptime=intent.getStringExtra("time");

            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

            String message = intent.getStringExtra("message");
            String status = intent.getStringExtra("status");
            GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
            // The getMessageType() intent parameter must be the intent you received
            // in your BroadcastReceiver.
            String messageType = gcm.getMessageType(intent);

            if (!extras.isEmpty()) {  // has effect of unparcelling Bundle
            /*
             * Filter messages based on message type. Since it is likely that GCM
             * will be extended in the future with new message types, just ignore
             * any message types you're not interested in, or that you don't
             * recognize.
             */
                if (GoogleCloudMessaging.
                        MESSAGE_TYPE_SEND_ERROR.equals(messageType)) {
                    sendNotification("Send error: " + extras.toString(),status);
                } else if (GoogleCloudMessaging.
                        MESSAGE_TYPE_DELETED.equals(messageType)) {
                    sendNotification("Deleted messages on server: " +
                           extras.toString(),status);
// extras.toString(),status,pushtime
                    // If it's a regular GCM message, do some work.
                } else if (GoogleCloudMessaging.
                        MESSAGE_TYPE_MESSAGE.equals(messageType)) {
                    // This loop represents the service doing some work.
                    for (int i = 0; i < 5; i++) {
                        Log.i(TAG, "Working... " + (i + 1)
                                + "/5 @ " + SystemClock.elapsedRealtime());
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                        }
                    }
                    Log.i(TAG, "Completed work @ " + SystemClock.elapsedRealtime());
                    // Post notification of received message.
//                    sendNotification(extras.getString("Notice"));
                    sendNotification(message,status);
                    Log.i(TAG, "Received: " + extras.toString());
                }
            }
            // Release the wake lock provided by the WakefulBroadcastReceiver.
            GcmBroadcastReceiver.completeWakefulIntent(intent);
        }

    private void sendNotification(String message, String status) {
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        mNotificationManager = (NotificationManager)
                   this.getSystemService(Context.NOTIFICATION_SERVICE);
//        if(status.equals("0")) {
            PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                    new Intent(this, Home.class), 0);

            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this)
                            // .setSmallIcon(R.drawable.ic_stat_gcm)
                            .setContentTitle("Mark Attendence")
                            .setSmallIcon(R.drawable.ic_launcher)
                            .setStyle(new NotificationCompat.BigTextStyle()
                                    .bigText(message))
                            .setContentText(message);


            mBuilder.setContentIntent(contentIntent);

            mBuilder.setSound(alarmSound);
            mBuilder.setAutoCancel(true);
            mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
        }





}






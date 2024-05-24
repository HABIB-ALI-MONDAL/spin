package org.cocos2dx.javascript;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.core.app.g;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.u0;
import org.cocos2dx.lib.R;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";

    private void handleNow() {
        Log.d(TAG, "Short lived task is done.");
    }

    private void scheduleJob() {
    }

    private void sendNotification(String str, String str2) {
        Intent intent = new Intent(this, AppActivity.class);
        intent.addFlags(67108864);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 67108864);
        String string = getString(R.string.default_notification_channel_id);
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        g.e eVar = new g.e(this, string);
        eVar.u(R.drawable.ic_stat_ic_notification);
        eVar.k(str2);
        eVar.j(str);
        eVar.f(true);
        eVar.v(defaultUri);
        eVar.i(activity);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel(string, "Channel human readable title", 3));
        }
        notificationManager.notify(0, eVar.b());
    }

    private void sendRegistrationToServer(String str) {
        PlatformAndroidApi.firebaseMsgToken = str;
    }

    public void onMessageReceived(u0 u0Var) {
        Log.d(TAG, "From: " + u0Var.i());
        if (u0Var.g().size() > 0) {
            Log.d(TAG, "Message data payload: " + u0Var.g());
            handleNow();
        }
        if (u0Var.j() != null) {
            sendNotification(u0Var.j().a(), u0Var.j().c());
            Log.d(TAG, "Message Notification Body: " + u0Var.j().a());
        }
    }

    public void onNewToken(String str) {
        Log.d(TAG, "Refreshed token: " + str);
        sendRegistrationToServer(str);
    }
}

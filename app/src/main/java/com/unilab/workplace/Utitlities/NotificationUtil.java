package com.unilab.workplace.Utitlities;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import java.util.Date;

public class NotificationUtil {

	Context mContext;
	NotificationCompat.Builder mBuilder = null;
	NotificationManager noti;
	boolean isFirstNotif = true;

	int mNotifId;
	String mTitle;
	int mIcon;
	Class<?> mCls;
	NotificationCompat.InboxStyle inboxStyle;
	int lineCount = 0;

	public NotificationUtil(Context context, int notifId, String title,
			int icon, Class<?> cls) {
		mContext = context;
		mNotifId = notifId;
		mTitle = title;
		mIcon = icon;
		mCls = cls;
	}

	@SuppressLint("NewApi")
	public void show(String newMsg) {

		lineCount++;
		
		if (isFirstNotif == true) {
			Uri alarmSound = RingtoneManager
					.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

			noti = (NotificationManager) mContext.getApplicationContext()
					.getSystemService(Context.NOTIFICATION_SERVICE);
			Intent i = new Intent(mContext, mCls);
			TaskStackBuilder stackBuilder = TaskStackBuilder.create(mContext);
			stackBuilder.addNextIntent(i);
			PendingIntent resultPending = stackBuilder.getPendingIntent(0,
					PendingIntent.FLAG_UPDATE_CURRENT);

			inboxStyle = new NotificationCompat.InboxStyle();
			inboxStyle.setBigContentTitle("Workplace Conduct");
			inboxStyle.addLine(newMsg);
			inboxStyle.setSummaryText("Check Workplace Conduct");

			mBuilder = new NotificationCompat.Builder(mContext);

			mBuilder.setSmallIcon(mIcon);
			mBuilder.setContentTitle(mTitle);
			mBuilder.setContentText(newMsg);
			mBuilder.setContentIntent(resultPending);
			mBuilder.setAutoCancel(true);
			mBuilder.setSound(alarmSound);

			mBuilder.setStyle(inboxStyle);
			mBuilder.setWhen(new Date().getTime());
			mBuilder.setTicker(newMsg);
			mBuilder.setNumber(lineCount);

			noti.notify(mNotifId, mBuilder.build());
			isFirstNotif = false;

			Log.i("NotificationUtil", "show: isFirst: " + newMsg);

		} else {
			Log.i("NotificationUtil", "show: isNotFirst:" + newMsg);

			inboxStyle.addLine(newMsg);

			mBuilder.setStyle(inboxStyle);
			mBuilder.setWhen(new Date().getTime());
			mBuilder.setTicker(newMsg);
			mBuilder.setNumber(lineCount);

			noti.notify(mNotifId, mBuilder.build());
		}

	}
}

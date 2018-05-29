package com.unilab.workplace.Utitlities;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

public class NotificationHandler {
	public static void ShowOpenAct(Context context,String title,String msg,int icon,Class<?>cls) {
		 NotificationManager noti = (NotificationManager) context.getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
		 Intent i = new Intent(context,cls);
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
		stackBuilder.addNextIntent(i);
		PendingIntent resultPending = stackBuilder
				.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
				.setSmallIcon(icon)
				.setContentTitle(title)
				.setContentText(msg)
				.setContentIntent(resultPending);
		noti.notify(0, mBuilder.build());
	}
	public static void Show(Context context,String title,String msg,int icon) {
		 NotificationManager noti = (NotificationManager) context.getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
				.setSmallIcon(icon)
				.setContentTitle(title)
				.setContentText(msg);
		noti.notify(0, mBuilder.build());
	}
	public static void ShowWithSound(Context context,String title,String msg,int icon) {
		Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		 NotificationManager noti = (NotificationManager) context.getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
				.setSmallIcon(icon)
				.setContentTitle(title)
				.setContentText(msg);
		mBuilder.setSound(alarmSound);
		noti.notify(0, mBuilder.build());
	}
	public static void ShowWithSoundVibrate(Context context,String title,String msg,int icon) {
		Vibrator vibrator = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
		Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		 NotificationManager noti = (NotificationManager) context.getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
				.setSmallIcon(icon)
				.setContentTitle(title)
				.setContentText(msg);
		mBuilder.setSound(alarmSound);
		vibrator.vibrate(300);
		noti.notify(0, mBuilder.build());
	}
	public static void ShowOpenActWithSoundVibrate(Context context,String title,String msg,int icon,Class<?>cls) {
		Vibrator vibrator = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
		Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		NotificationManager noti = (NotificationManager) context.getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
		 Intent i = new Intent(context,cls);
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
		stackBuilder.addNextIntent(i);
		PendingIntent resultPending = stackBuilder
				.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
				.setSmallIcon(icon)
				.setContentTitle(title)
				.setContentText(msg)
				.setContentIntent(resultPending);
		mBuilder.setSound(alarmSound);
		vibrator.vibrate(300);
		noti.notify(0, mBuilder.build());
	}
}

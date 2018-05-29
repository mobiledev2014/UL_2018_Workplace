package com.unilab.workplace.Utitlities;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;


public class Alarm {


    PendingIntent pendingIntent;
//    public static void initAlarmNotif(Context context) {
//        // Set calendar
//        Calendar cal = Calendar.getInstance();
//        cal.setTimeInMillis(System.currentTimeMillis());
//        int minute = cal.get(Calendar.SECOND);
//        cal.set(Calendar.SECOND, minute + 10);
//
//        Calendar calNow = Calendar.getInstance();
//        calNow.setTimeInMillis(System.currentTimeMillis());
//        SimpleDateFormat date = new SimpleDateFormat(Constants.G_SDF_FORMAT_DATEONLY);
//        Date d_now = new Date();
//        String asd = date.format(d_now);
//
//        if (asd.split("/")[1].equals("07")) {
//            NotificationHandler.Show(context, "Workplace", "message", R.drawable.logo);
//            NotificationHandler.ShowWithSound(context, "Workplace", "message", R.drawable.logo);
//
//        }
//
//
////        if (calNow.after(cal)) {
////            cal.add(Calendar.DATE, 1);
////        }
//
//        SimpleDateFormat sdf = new SimpleDateFormat(Constants.G_SDF_FORMAT_MONTHNAME + " hh:mm:ss a");
//        Log.i("Alarm", "initAlarmNotif: cal5am - " + sdf.format(cal.getTime()));
//
//        Intent intent = new Intent(context, BroadcastNotification.class);
//        // Set pending intent
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(
//                context.getApplicationContext(), 1234, intent,
//                PendingIntent.FLAG_UPDATE_CURRENT | Intent.FILL_IN_DATA);
//
//        // Set Alarm Manager
//        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//        am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
//                AlarmManager.INTERVAL_DAY, pendingIntent);
//    }

    public static void initAlarmCheckDue(Context context) {
        // Set calendar
        PendingIntent pendingIntent;
        AlarmManager am;
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        int minute = cal.get(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, minute + 7);

        Intent intent = new Intent(context, BroadcastR.class);
        // Set pending intent
        pendingIntent = PendingIntent.getBroadcast(
                context.getApplicationContext(), 1234, intent,
                PendingIntent.FLAG_UPDATE_CURRENT | Intent.FILL_IN_DATA);

        // Set Alarm Manager
        am = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
        am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
    }

}

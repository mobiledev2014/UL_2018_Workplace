package com.unilab.workplace.Utitlities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootBroadcast extends BroadcastReceiver {

    Context context;

    @Override
    public void onReceive(Context ctx, Intent intent) {
        context = ctx;

        Log.i("BootBroadcast", "BootBroadcast STARTED");

        Alarm.initAlarmCheckDue(context);

    }

}
package com.unilab.workplace.Utitlities;

import android.content.Context;
import android.content.SharedPreferences;

import com.unilab.workplace.view.login.MainActivity;

/**
 * Added by c_alraygon on 9/22/2016.
 *
 * Description: A utility that uses thread to check idle times of an app
 * Makes use of Thread/Application/Activity - Android Classes
 * Reference: http://stackoverflow.com/questions/4075180/application-idle-time/4075857#comment-7234627
 */
public class Waiter extends Thread  {
    private static final String TAG= Waiter.class.getName();
    private long lastUsed;
    private long period;
    private boolean stop;

    public Waiter(long period)

    {
        this.period=period;
        stop=false;
    }

    public void run()
    {
        //TODO: Google play store reports it to have crashing issues on waiter thread, Please see report and fix on next phase.
        long idle=0;
        this.touch();
        do
        {
            idle=System.currentTimeMillis()-lastUsed;
            //Log.d(TAG, "Application is idle for "+idle +" ms");
            try
            {
//                Waiter.sleep(30000);//300000 //check every 5minutes
                Waiter.sleep(5000);//5000 //check every 5 seconds 30000=5minutes
            }
            catch (InterruptedException e)
            {
                //Log.d(TAG, "Waiter interrupted!");
            }
            if(idle > period)
            {
                idle=0;

                //Log.d(TAG,"do something here - In this Project-> Apps exit");

                Context applicationContext = MainActivity.getContextOfApplication();
                SharedPreferences prefs = applicationContext.getSharedPreferences("sharedpref",Context.MODE_PRIVATE);
                prefs.edit().putBoolean("didExitFromIdle", true).commit();

                stopThread();
                System.exit(0);
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        }
        while(!stop);

        //Log.d(TAG, "Finishing Waiter thread");
    }

    public synchronized void touch()
    {
        //Log.d("Waiter","touch thread");
        lastUsed=System.currentTimeMillis();

    }

    public synchronized void forceInterrupt()
    {

        this.forceInterrupt();
    }

    //soft stopping of thread
    public synchronized void stopThread()
    {
//        Log.d("Waiter","stopping thread");
        stop=true;
    }

    public synchronized void setPeriod(long period)
    {
        this.period=period;
    }

}


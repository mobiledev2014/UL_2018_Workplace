package com.unilab.workplace;

import android.app.Application;

import com.unilab.workplace.Utitlities.Waiter;

/**
 * Created by c_alraygon on 9/22/2016.
 */
public class ControlApplication extends Application
{

    private static final String TAG=ControlApplication.class.getName();
    private Waiter waiter;  //Thread which controls idle time


    // only lazy initializations here!
    @Override
    public void onCreate()
    {
        super.onCreate();
//        Log.d(TAG, "Starting application"+this.toString());

        //Change this to 30 mins (30*60*1000) for Production
        //1*60*1000->1min - For Testing/Development
        waiter=new Waiter(30*60*1000);
//        waiter=new Waiter(1*30*1000);
        waiter.start();
    }

    public void touch()
    {
        waiter.touch();
    }
}

package com.unilab.workplace;

import android.app.Activity;

/**
 * Created by c_alraygon on 9/22/2016.
 */
public class ControlActivity extends Activity {
    private static final String TAG = ControlActivity.class.getName();

    /**
     * Gets reference to global Application
     *
     * @return must always be type of ControlApplication! See AndroidManifest.xml
     */
    public ControlApplication getApp() {

        return (ControlApplication) this.getApplication();
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        getApp().touch();

//        Log.d(TAG, "User interaction to " + this.toString());

    }
}
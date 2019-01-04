package com.unilab.workplace.view.login;

import android.Manifest;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.unilab.workplace.ControlActivity;
import com.unilab.workplace.R;
import com.unilab.workplace.Utitlities.BroadcastR;
import com.unilab.workplace.Utitlities.DateUtil;
import com.unilab.workplace.Utitlities.Exiter;
import com.unilab.workplace.constants.Constants;
import com.unilab.workplace.controller.FragmentController;
import com.unilab.workplace.database.AppDb;
import com.unilab.workplace.database.DatabaseHelper;
import com.unilab.workplace.database.table.EmpTable;
import com.unilab.workplace.view.menu.FragmentLogin;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends ControlActivity {

    public static Context l_context;
    Typeface tf;
    View v;

    PendingIntent pendingIntent;
    AlarmManager am;
    int daysbetween;
    public static SharedPreferences sharedPref;
    String prevd, temp, temp1, tag;
    private SimpleDateFormat dateFormatter;
    public String sharedPrefString = "sharedpref";
    boolean jake = false;

    public EmpTable empTable;

    TextView tv_header_confirm;
    TextView tv_prompt_confirm;
    Dialog dialog;
    Button btn_ok_confirm, btn_no;
    String act = "";
    Dialog logout_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        v = View.inflate(getApplicationContext(), R.layout.fragment_layout_login, null);
        setContentView(v);

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_NETWORK_STATE,Manifest.permission.ACCESS_WIFI_STATE,Manifest.permission.INTERNET,
                        Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},
                1);

        sharedPref = this.getSharedPreferences(sharedPrefString, MODE_PRIVATE);

        /*SharedPreferences.Editor editor1 = sharedPref.edit();
        editor1.putString("didExitFromIdle", "false");
        editor1.commit();*/

        dateFormatter = new SimpleDateFormat("MM/dd/yyyy", Locale.US);


        l_context = this;
        ButterKnife.bind(this);

        dialog = new Dialog(l_context);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_yesno);

        getdate();
        if (daysbetween >= 90) {

//            uninstall();
            jake = true;

        } else {
            jake = true;

        }

        if (savedInstanceState == null) {

            FragmentController.addFragment(getFragmentManager(), new FragmentLogin());

        }

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Candara.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());


        //databasecreate
        DatabaseHelper.createDatabase(l_context, new AppDb());
        //open class

        tf = Typeface.createFromAsset(l_context.getAssets(), "fonts/Myriad_Pro_Regular.ttf");


    }

    public static Context getContextOfApplication(){
        return l_context;
    }

    /**********
     * c_alraygon on 9/22/2016.
     * Override methods for app idle times
     **********/
    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        getApp().touch();
//        Log.d("MainActivity", "User interaction to " + this.toString());
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

//    private void uninstall() {
//        DialogUtil
//                .showAlertDialog(
//                        l_context,
//                        "Application Expired",
//                        "You have not logged in for 3 months. This application will be uninstalled now.",
//                        new DialogInterface.OnDismissListener() {
//
//                            @Override
//                            public void onDismiss(DialogInterface dialog) {
//                                // TODO Auto-generated method stub
//                                String app_pkg_name = "com.unilab.workplace";
//                                int UNINSTALL_REQUEST_CODE = 1;
//
//                                Intent intent = new Intent(Intent.ACTION_UNINSTALL_PACKAGE);
//                                intent.setData(Uri.parse("package:" + app_pkg_name));
//                                intent.putExtra(Intent.EXTRA_RETURN_RESULT, true);
//                                startActivityForResult(intent, UNINSTALL_REQUEST_CODE);
//
//
//                            }
//                        });
//    }


    private void getdate() {
        String date = new DateUtil().getDate("MM-dd-yyyy", System.currentTimeMillis());
        Date dateDate = new DateUtil().parseDate("MM-dd-yyyy", date);

        temp = date;

        String lastDate = sharedPref.getString("prevdate", "");

        if (lastDate != null) {
            try {
                String fromSF = lastDate;
                Date dateDate1 = new DateUtil().parseDate("MM-dd-yyyy", fromSF);
                daysbetween = DateUtil.daysBetween(dateDate1, dateDate);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }

        if (lastDate.equals("")) {
            SharedPreferences.Editor editor1 = sharedPref.edit();
            editor1.putString("prevdate", temp);
            editor1.commit();
        }


    }

    private void RegisterAlarmBroadcast() {

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        int day = cal.get(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, day + 7);

        Intent intent = new Intent(this, BroadcastR.class);
        // Set pending intent
        pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 1234, intent,
                PendingIntent.FLAG_UPDATE_CURRENT | Intent.FILL_IN_DATA);

        // Set Alarm Manager
        am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntent);
    }

    private void UnregisterAlarmBroadcast() {
        if (am != null) {
            am.cancel(pendingIntent);
        }
        // getBaseContext().unregisterReceiver(mReceiver);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        RegisterAlarmBroadcast();

//            logout_dialog.dismiss();


    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        UnregisterAlarmBroadcast();
//        Log.e("check","onresume");

//        logout_dialog.dismiss();

    }


    //
    public void dialog_confirm(Context context, String header, String prompt,
                               String action) {

        logout_dialog = new Dialog(l_context);
        logout_dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        logout_dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        logout_dialog.setContentView(R.layout.dialog_logout);
        logout_dialog.setCancelable(false);
        logout_dialog.show();

        this.act = action;
        tv_header_confirm = (TextView) logout_dialog.findViewById(R.id.tv_header);
        tv_prompt_confirm = (TextView) logout_dialog.findViewById(R.id.tv_prompt);
        btn_ok_confirm = (Button) logout_dialog.findViewById(R.id.btn_ok);
        btn_no = (Button) logout_dialog.findViewById(R.id.btn_no);

        tv_header_confirm.setText(header);
        tv_prompt_confirm.setText(prompt);

        btn_ok_confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                Constants.t_birthdateholder = null;
                finishAndHide();
                clearBackStack();

                System.exit(0);

                startActivity(intent);

                android.os.Process.killProcess(android.os.Process.myPid());

                logout_dialog.dismiss();
            }

        });

        btn_no.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.e("AAA", "BBB");
                logout_dialog.dismiss();
            }
        });


    }


    // Hide softinput keyboard on touch outside
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        View view = getCurrentFocus();
        boolean ret = super.dispatchTouchEvent(event);

        if (view instanceof EditText) {
            View w = getCurrentFocus();
            int scrcoords[] = new int[2];
            w.getLocationOnScreen(scrcoords);
            float x = event.getRawX() + w.getLeft() - scrcoords[0];
            float y = event.getRawY() + w.getTop() - scrcoords[1];

            if (event.getAction() == MotionEvent.ACTION_UP && (x < w.getLeft() || x >= w.getRight() || y < w.getTop() || y > w
                    .getBottom())) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
            }
        }
        return ret;
    }


    //exiter

    public void clearBackStack() {

        FragmentManager manager = getFragmentManager();
        if (manager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry first = manager
                    .getBackStackEntryAt(0);
            manager.popBackStack(first.getId(),
                    FragmentManager.POP_BACK_STACK_INCLUSIVE);

        }

    }

    public void finishAndHide() {
        // We don't call finish() explicitly. FLAG_ACTIVITY_CLEAR_TASK should
        // take care of it.

        // Replace the current task with one that is excluded from the recent
        // apps and that will finish itself immediately. It's critical that this
        // activity get launched in the task that you want to hide.
        // super.onBackPressed();
        super.onBackPressed();

        final Intent relaunch = new Intent(this, Exiter.class)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK // CLEAR_TASK requires
                        // this
                        | Intent.FLAG_ACTIVITY_CLEAR_TASK // finish everything
                        // else in the task
                        | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS); // hide
        // (remove,
        // in
        // this
        // case)
        // task
        // from
        // recents
        startActivity(relaunch);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        logout_dialog.dismiss();
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
//		super.onBackPressed();

        String header = "Exit";
        String question = "Are you sure you want to exit Workplace Conduct App?";
        String action = "exit";
        dialog_confirm(l_context, header, question, action);

    }


}
package com.unilab.workplace.view.menu;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.text.format.Time;
import android.widget.DatePicker;
import android.widget.TextView;

import com.unilab.workplace.constants.Constants;

import java.util.Calendar;
import java.util.Date;
//c_alraygon
@SuppressLint("ValidFragment")
public class SelectDateFragment extends DialogFragment implements
        DatePickerDialog.OnDateSetListener {
    TextView text;
    int checkerButton;
    String tempDefaultDate = null;

    public SelectDateFragment(TextView text, int checkerButton) {
        this.text = text;
        this.checkerButton = checkerButton;
    }

    //create an instance of the datepicker dialog
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar cal = Calendar.getInstance();
        int yy;
        int mm;
        int dd;
        //get the copy of date
        tempDefaultDate = Constants.t_birthdateholder;

        if(tempDefaultDate==null||tempDefaultDate.equals("0")){
//            Log.d(CUSTOMDATEFRAGMENTTAG,"tempDefaultDate+"+tempDefaultDate);
            yy = cal.get(Calendar.YEAR);
            mm = cal.get(Calendar.MONTH);
            dd = cal.get(Calendar.DAY_OF_MONTH);
        }else{
            String formattedString = tempDefaultDate;
//            Log.d(CUSTOMDATEFRAGMENTTAG,"tempDefaultDate-"+tempDefaultDate);
            mm = Integer.parseInt(formattedString.substring(0,2));
            mm = mm-1;
            dd = Integer.parseInt(formattedString.substring(3,5));
            yy = Integer.parseInt(formattedString.substring(6,10));
        }

        return new DatePickerDialog(getActivity(), this, yy, mm, dd);

    }
    //sets the date
    public void onDateSet(DatePicker view, int yy, int mm, int dd) {
        Time time = new Time();
        time.set(dd,mm,yy);
        String s_date = time.format("%m/%d/%Y");
//        Log.d(CUSTOMDATEFRAGMENTTAG,"s_date"+s_date);
        //save a copy of the set date
        Constants.t_birthdateholder = s_date;
//        Log.d(CUSTOMDATEFRAGMENTTAG,"t_birthdateholder"+Constants.t_birthdateholder);
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM/dd/yyyy");
        Date temp_date = null;

        try {
            temp_date = sdf.parse(s_date);
        }catch (Exception e){
            e.printStackTrace();
        }
        //put formatted date to your view eg. TextView
        text.setText(sdf.format(temp_date));
    }
}

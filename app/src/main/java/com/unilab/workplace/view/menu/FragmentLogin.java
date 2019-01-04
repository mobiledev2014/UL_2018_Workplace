package com.unilab.workplace.view.menu;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.unilab.workplace.R;
import com.unilab.workplace.Utitlities.CustomDialog;
import com.unilab.workplace.Utitlities.DateUtil;
import com.unilab.workplace.Utitlities.Utils;
import com.unilab.workplace.constants.Constants;
import com.unilab.workplace.controller.FragmentController;
import com.unilab.workplace.database.AppDb;
import com.unilab.workplace.database.DatabaseHelper;
import com.unilab.workplace.database.model.EmpModel;
import com.unilab.workplace.database.table.EmpTable;
import com.unilab.workplace.retrofit.API.EmployeeIdModel;
import com.unilab.workplace.retrofit.API.EmployeeIdResult;
import com.unilab.workplace.retrofit.API.WorkplacePostInterFaceApi;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentLogin extends Fragment implements Callback<EmployeeIdResult> {

    View view;
    Context l_context;
    Typeface tf;

    //Bind
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.edt_emp_number)
    EditText edtEmpNumber;
    @Bind(R.id.llt_fragmentmain)
    LinearLayout llt_fragmentmain;
    @Bind(R.id.tv_date)
    TextView tv_date;
    @Bind(R.id.llt_emp_number)
    LinearLayout llt_emp_number;
    @Bind(R.id.llt_emp_number_2)
    LinearLayout llt_emp_number_2;

    @Bind(R.id.iv_logo)
    ImageView iv_logo;

    //date
    public int checker = 0;
    SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    private String TAG = this.getClass().getSimpleName();
    public EmpModel myEmp = new EmpModel();

    //boss alden
    EmpTable empTable;
    String prevd;
    String value = "";
    boolean userHasResult = false;
    String employee_number;
    TextView tv_header_confirm;
    TextView tv_prompt_confirm;
    String act = "";
    PackageInfo l_pInfo;
    ProgressDialog progressDialog;
    Dialog dialog, useLocalData_dialog;
    Button btn_ok_confirm, btn_no;
    String tempId = "";
    String temp_status = "";
    String temp_agreement = "";
    String temp_birthdate = "";
    boolean verifiedUser = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_layout_login, container, false);
        l_context = getActivity();
        ButterKnife.bind(this, view);

        // set type face
        tf = Typeface.createFromAsset(l_context.getAssets(), "fonts/MyriadPro-Regular.otf");
        btnLogin.setTypeface(tf);
        btnLogin.setText("Log In");

        //databasecreate
        DatabaseHelper.createDatabase(l_context, new AppDb());
        //open class
        empTable = new EmpTable(l_context);
//        empTable.getAllElements();//debug

        //dialog no connection
        dialog = new Dialog(l_context);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_no_connection);
//        HttpsTrustManager.allowAllSSL();
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onDestroyView() {

        super.onDestroyView();
        ButterKnife.unbind(this);

    }

    //decides if the id should be save or not to localdb
    public void validateIdToSql(String temp, EmpModel tempModel) throws SQLException {

        int v = Integer.parseInt(temp);
        if (v < 0) {
            throw new SQLException("Entered Value is less than 0");
        }
        boolean shouldCreateUser = empTable.getUserCredentials(temp);
        if (!shouldCreateUser) {
//            Log.i(TAG, "validateIdtoSql: Validating user+" + v);
            empTable.addUser(temp, tempModel.getEmp_birthdate(), tempModel.getStatus(),
                    tempModel.getEmp_created(), tempModel.getEmp_agreement(), tempModel.getEmp_readterms(),
                    tempModel.getEmp_modified(), null);
//            Log.i(TAG, "count - " + empTable.getCount() + "agreement-" + Constants.t_empagreement);

            Constants.t_empagreement = tempModel.getEmp_agreement();

//            Log.i(TAG, "adding user" + value + " to db.." + Constants.t_empagreement);

        } else {
            //user already exist just update column modified
//            Log.i(TAG, "validateIdToSql-" + v);
            Constants.t_empagreement = tempModel.getEmp_agreement();
//            Log.i(TAG, "count - " + empTable.getCount() + "agreement-" + Constants.t_empagreement);
            empTable.getDateModified(temp);

//            Log.i(TAG, "validateIdToSql-user already exist.." + Constants.t_empagreement);
        }
    }

    //gets date
    public String getDateToday() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");//yyyy-MM-dd HH:mm:ss
        return sdf.format(c.getTime());
    }

    /**
     * Added by: Alvin Raygon Sept 2016
     * <p/>
     * Login Validations
     */
    @OnClick({R.id.edt_emp_number, R.id.btn_login, R.id.tv_date
//            , R.id.iv_logo
    })
    public void onClick(View view) {
        switch (view.getId()) {
            //for debugging only
//            case R.id. iv_logo:
////
//                FragmentController.replaceFragment(getFragmentManager(), new FragmentMain());
////
//                break;

            case R.id.edt_emp_number:
                break;

            case R.id.btn_login:
                employee_number = edtEmpNumber.getText().toString();
                Constants.t_id = employee_number;

                //online
                if (Utils.isNetworkAvailable(l_context)) {

//                    if (employee_number.trim().length() > 0 && tv_date.getText().length() > 0) {

                        //api level
//                            new HttpAsyncTask2().execute(employee_number);

                        progressDialog = new ProgressDialog(l_context);
                        progressDialog.setMessage("Validating user account... Please wait.");
                        progressDialog.setCancelable(false);
                        progressDialog.show();
                        //initializeRetrofit();

                        Call<EmployeeIdResult> call = initializeRetrofit().postUser(employee_number);
                        call.enqueue(this);

//                    } else {
//
//                        String title = "Login Error";
//                        String msg = "Employee number and/or date of birth are empty.";
//                        CustomDialog alertDialog = new CustomDialog(l_context, title, msg);
//                        alertDialog.show();
//                        Utils.animShake(l_context, llt_emp_number);
//                        Utils.animShake(l_context, llt_emp_number_2);
//                    }

                } else {
                    // MARK : 031317 RFC REMOVED OFFLINE LOGIN FROM APP
//                        validateofflineLogin();

//                        Toast.makeText(l_context , "Walang Internet", Toast.LENGTH_SHORT).show();
                    String title = "Login Error";
                    String msg = "There is no internet connection detected. Please check your internet connection and try again.";
                    CustomDialog alertDialog = new CustomDialog(l_context, title, msg);
                    alertDialog.show();
                }

                break;

            case R.id.tv_date:

                DialogFragment newFragment = new SelectDateFragment(
                        tv_date, checker);
                newFragment.show(getFragmentManager(), "DatePicker");

                break;
        }
    }
    public void postUser(EmployeeIdResult user, Callback<EmployeeIdResult> callback) {
        Call<EmployeeIdResult> userCall = initializeRetrofit().postUser(employee_number);
        userCall.enqueue(callback);
    }
    /**
     * Modified by: Alvin Raygon
     * <p/>
     * Checks if user lasts login was 90 days ago.
     *
     * @return bool
     */
    private boolean isUserExceedMaximumOfflineDays() {
        prevd = empTable.getDateModified(Constants.t_id);
        String t_prevd = prevd.replace("/", "-");
        String dateToday = new DateUtil().getDate("MM-dd-yyyy", System.currentTimeMillis());
        Date previousDate;
        int d;
        previousDate = DateUtil.parseDate("MM-dd-yyyy", t_prevd);
        Date recentDate = DateUtil.parseDate("MM-dd-yyyy", dateToday);
        d = new DateUtil().daysBetween(previousDate, recentDate);
        if (d > 90) {
            return true;
        } else
            return false;
    }

    public void useLocalData_confirm(Context context, String header, String prompt,
                                     String action) {

        useLocalData_dialog = new Dialog(l_context);
        useLocalData_dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        useLocalData_dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        useLocalData_dialog.setContentView(R.layout.dialog_logout);
        useLocalData_dialog.setCancelable(false);
        useLocalData_dialog.show();

        this.act = action;
        tv_header_confirm = (TextView) useLocalData_dialog.findViewById(R.id.tv_header);
        tv_prompt_confirm = (TextView) useLocalData_dialog.findViewById(R.id.tv_prompt);
        btn_ok_confirm = (Button) useLocalData_dialog.findViewById(R.id.btn_ok);
        btn_no = (Button) useLocalData_dialog.findViewById(R.id.btn_no);

        tv_header_confirm.setText(header);
        tv_prompt_confirm.setText(prompt);

        btn_ok_confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                validateAndConnectUsingOfflineData();
                useLocalData_dialog.dismiss();
            }

        });

        btn_no.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
//                Log.i(TAG, "useLocalData_confirm btn_no selected");
                useLocalData_dialog.dismiss();
            }
        });

    }

    private void validateAndConnectUsingOfflineData() {
        //Connect user with offline data
        Constants.t_empagreement = empTable.getEmp_Agreement(employee_number);
        Constants.t_birthdate = empTable.getEmp_Birthdate(employee_number);
        if (isUserExceedMaximumOfflineDays()) {
//
//            edtEmpNumber.setText("");
//            tv_date.setText("");
//                                    Utils.dialogAlert(l_context, "Confirmation", "You haven't signed in for a long time.\nPlease connect to the internet", null, null, true);

//            Constants.t_birthdateholder = null;
            String title = "Confirmation";
            String msg = "You haven't signed in for a long time.\n" +
                    "Please connect to the internet.";
            CustomDialog alertDialog = new CustomDialog(l_context, title, msg);
            alertDialog.show();

            Utils.animShake(l_context, llt_emp_number);

        } else {
            //User is valid and not exceed max days
            if (Constants.t_birthdate.equals(tv_date.getText().toString()) && Constants.t_birthdate != null) {
                //each time user logs in we will update localdb for emp_modified
                empTable.updateEmpModified(getDateToday(), employee_number);
                FragmentController.replaceFragment(getFragmentManager(), new FragmentMain());

            } else if (!Constants.t_birthdate.equals(tv_date.getText().toString()) || Constants.t_birthdate == null) {
                Utils.animShake(l_context, llt_emp_number_2);
                //Validation where id is correct but bdate is incorrect/empty.
//                tv_date.setText("");
//                Constants.t_birthdateholder = null;
                String title = "Login Error";
                String msg = "Please enter a valid date of birth.";

                CustomDialog alertDialog = new CustomDialog(l_context, title, msg);
                alertDialog.show();
            }
        }
    }


    //retrofit
    public static WorkplacePostInterFaceApi initializeRetrofit() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").setLenient().create();
        // https://13.251.94.215/GetAllVersion.php
        // old url  http://161.202.23.41/
        String baseUrl = "https://mobileworkplace.unilab.com.ph/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory
                .create(gson)).build();

        WorkplacePostInterFaceApi interfaceApi = retrofit.
                create(WorkplacePostInterFaceApi.class);

        return interfaceApi;
    }

    @Override
    public void onResponse(Call<EmployeeIdResult> call, Response<EmployeeIdResult> response) {



        progressDialog.dismiss();

        Log.e(TAG, "onResponseApi: "+ response.body());
        //try catch here

        try {

            List<EmployeeIdModel> data = response.body().getData();
            //Log.e(TAG, "" + data.toString());

            Log.e(TAG, "onResponse: " + data.toString());



            //Log.e(TAG, "size:" + data.size());
            for (int x = 0; x < data.size(); x++) {
                tempId = data.get(x).getEmpId();
                temp_birthdate = data.get(x).getEmpBirthdate();
                temp_status = data.get(x).getEmpStatus();
                temp_agreement = data.get(x).getEmpAgreement();
            }

            if (!temp_status.equals("0")) {
                verifiedUser = true;
                myEmp.setEmp_id(tempId);
                myEmp.setEmp_birthdate(temp_birthdate);
                myEmp.setStatus(temp_status);
                myEmp.setEmp_agreement(temp_agreement);
                Constants.t_birthdate = temp_birthdate;
                Constants.t_empagreement = temp_agreement;

                Constants.t_id = tempId;
                empTable.updateEmp_Specifics(temp_agreement, tempId);
                //Log.i(TAG, "e_agr : " + temp_agreement + "bday-" + temp_birthdate);

                //local
                myEmp.setEmp_readterms("0");
                validateDataReceived();
            } else if (temp_status == null || temp_status.equals("")) {

                String title = "Login Error";
                String msg = "Unable to validate user account due to no internet connection detected. Please check your connection and try again.";
                CustomDialog alertDialog = new CustomDialog(l_context, title, msg);
                alertDialog.show();

                Utils.animShake(l_context, llt_emp_number);
                Utils.animShake(l_context, llt_emp_number_2);
            } else {
                //Log.i(TAG, "e_agr : " + temp_agreement + "bday-" + temp_birthdate);
                verifiedUser = false;
                validateDataReceived();
            }
        } catch (Exception e) {

            e.printStackTrace();
            //Log.e(TAG,"catch entered");
            String title = "Login Error";
            String msg = "Unable to validate user account due to no internet connection detected. Please check your connection and try again.";
            CustomDialog alertDialog = new CustomDialog(l_context, title, msg);
            alertDialog.show();
            Utils.animShake(l_context, llt_emp_number);
            Utils.animShake(l_context, llt_emp_number_2);
        }


    }

    @Override
    public void onFailure(Call<EmployeeIdResult> call, Throwable throwable) {
        progressDialog.dismiss();
        // MARK : 031317 RFC REMOVED OFFLINE LOGIN FROM APP
//        if (!empTable.getUserCredentials(Constants.t_id)) {
//                    Constants.t_birthdateholder = null;
            String title = "Login Error";
            String msg = "Unable to validate user account. Please check your connection and try again.";
            CustomDialog alertDialog = new CustomDialog(l_context, title, msg);
            alertDialog.show();

            Utils.animShake(l_context, llt_emp_number);
            Utils.animShake(l_context, llt_emp_number_2);
//        } else {
            // Match found in local data. Ask to login offline
//            String header = "Login Offline";
//            String question = "Unable to communicate on the server. \n" +
//                    "Would you like to log in offline?";
//            String action = "confirm";
//            useLocalData_confirm(l_context, header, question, action);

//        }

    }

    //validation
    public void validateDataReceived() {
        if (verifiedUser) {
            if (Constants.t_birthdate.equals(tv_date.getText().toString()) && Constants.t_birthdate != null) {
                try {

                    //check if user should be save to db/ if it already exist
                    if (empTable.getUserCredentials(Constants.t_id)) {
                        myEmp.setEmp_modified(getDateToday());
                        //Log.d(TAG, "validate:" + myEmp.toString());
                        validateIdToSql(tempId, myEmp);
                    } else {
                        myEmp.setEmp_created(getDateToday());
                        myEmp.setEmp_modified(getDateToday());
                        validateIdToSql(tempId, myEmp);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

                FragmentController.replaceFragment(getFragmentManager(), new FragmentMain());

            } else {
                //Log.e(TAG,"oh my");
                String title = "Login Error";
                String msg = "Employee number and date of birth do not match. Please make sure that your login credentials are correct.";
                //clear input
//                    edtEmpNumber.setText("");
//                    tv_date.setText("");
//                    Constants.t_birthdateholder = null;
                CustomDialog alertDialog = new CustomDialog(l_context, title,
                        msg);
                alertDialog.show();
            }

        } else {
            //Log.e(TAG,"meh");
            String title = "Login Error";
            String msg = "Employee number and date of birth do not match. Please make sure that your login credentials are correct.";
            //clear input
//                    edtEmpNumber.setText("");
//                    tv_date.setText("");
//                    Constants.t_birthdateholder = null;
            CustomDialog alertDialog = new CustomDialog(l_context, title,
                    msg);
            alertDialog.show();
        }

    }

    //validate offline
    public void validateofflineLogin() {

        if (employee_number.trim().length() > 0 && tv_date.getText().length() > 0) {
            //trying to connect while offline, check/validate db if user has existing record
            if (!empTable.getUserCredentials(employee_number)) {
                //Bug ID: WPC#0024

//                                Constants.t_birthdateholder = null;
                String title = "Login Error";
                String msg = "Unable to validate user account due to no internet connection detected. Please check your connection and try again.";
                CustomDialog alertDialog = new CustomDialog(l_context, title, msg);
                alertDialog.show();

                Utils.animShake(l_context, llt_emp_number);
                Utils.animShake(l_context, llt_emp_number_2);
            } else {
                //User is Valid
                //Log.i(TAG, "App is connecting offline. Success." + empTable.getUserCredentials(employee_number));
                Constants.t_empagreement = empTable.getEmp_Agreement(employee_number);
                Constants.t_birthdate = empTable.getEmp_Birthdate(employee_number);
                if (isUserExceedMaximumOfflineDays()) {
//
//                                    edtEmpNumber.setText("");
//                                    tv_date.setText("");
//                                    Utils.dialogAlert(l_context, "Confirmation", "You haven't signed in for a long time.\nPlease connect to the internet", null, null, true);

//                                    Constants.t_birthdateholder = null;
                    String title = "Confirmation";
                    String msg = "You haven't signed in for a long time.\n" +
                            "Please connect to the internet.";
                    CustomDialog alertDialog = new CustomDialog(l_context, title, msg);
                    alertDialog.show();

                    Utils.animShake(l_context, llt_emp_number);

                } else {
                    //User is valid and not exceed max days
                    if (Constants.t_birthdate.equals(tv_date.getText().toString()) && Constants.t_birthdate != null) {
                        //each time user logs in we will update db for emp_modified
                        empTable.updateEmpModified(getDateToday(), employee_number);
                        FragmentController.replaceFragment(getFragmentManager(), new FragmentMain());

                    } else if (!Constants.t_birthdate.equals(tv_date.getText().toString()) || Constants.t_birthdate == null) {

//                                        Constants.t_birthdateholder = null;
                        String title = "Login Error";
                        String msg = "Please enter a valid employee number and date of birth.";
                        CustomDialog alertDialog = new CustomDialog(l_context, title, msg);
                        alertDialog.show();
                    }
                }
            }
        } else {
//Utils.dialogAlert(l_context, "Confirmation", "Access denied.\n Please fill out necessary fields.", null, null, true);
            String title = "Login Error";
            String msg = "Employee number and date of birth and/or are empty.";
            CustomDialog alertDialog = new CustomDialog(l_context, title, msg);
            alertDialog.show();

//                            Constants.t_birthdateholder = null;
            Utils.animShake(l_context, llt_emp_number);
            Utils.animShake(l_context, llt_emp_number_2);
        }

    }
}
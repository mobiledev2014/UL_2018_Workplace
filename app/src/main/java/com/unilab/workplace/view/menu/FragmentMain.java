package com.unilab.workplace.view.menu;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Process;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.unilab.workplace.R;
import com.unilab.workplace.Utitlities.CustomDialog;
import com.unilab.workplace.Utitlities.Utils;
import com.unilab.workplace.constants.Constants;
import com.unilab.workplace.controller.FragmentController;
import com.unilab.workplace.database.table.EmpTable;
import com.unilab.workplace.retrofit.API.EmployeeIdResult;
import com.unilab.workplace.retrofit.API.WorkplacePostUserAgreementInterFaceApi;
import com.unilab.workplace.view.codeofconduct.HowToUseCode;
import com.unilab.workplace.view.grievancehandling.FragmentGrievanceHandlingProcessList;
import com.unilab.workplace.view.handlingadministrative.FragmentHandlingAdministrativeList;
import com.unilab.workplace.view.otherpolicies.FragmentOtherPoliciesList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentMain extends Fragment implements Callback<EmployeeIdResult> {

    View view;

    Context l_context;
    @Bind(R.id.iv_codeofconduct)
    ImageView iv_codeofconduct;

    @Bind(R.id.iv_guidlinesinhandling)
    ImageView iv_guidlinesinhandling;


    @Bind(R.id.iv_guidelinesingrievance)
    ImageView iv_guidelinesingrievance;

    @Bind(R.id.iv_otherpolicies)
    ImageView iv_otherpolicies;

    @Bind(R.id.iv_logout)
    ImageView iv_logout;


    ProgressDialog progress;
    @Bind(R.id.iv_sync)
    ImageView ivSync;

    @Bind(R.id.fragment_id_menu)
    RelativeLayout fragmentIdMenu;

    @Bind(R.id.iv_search)
    ImageView IvSearch;

    @Bind(R.id.edt_search)
    EditText edt_search;

    @Bind(R.id.iv_close)
    ImageView iv_close;


    @Bind(R.id.iv_back)
    ImageView iv_back;
////iv_logo
//
//    @Bind(R.id.iv_logo)
//    ImageView iv_logo;

    @Bind(R.id.llt_search)
    LinearLayout llt_search;

    TextView tv_header_confirm;
    TextView tv_prompt_confirm;
    String act = "";
    PackageInfo l_pInfo;
    Dialog dialog, dialog2;
    Button btn_ok_confirm, btn_no;
    PopupWindow pw;
    @Bind(R.id.llt_dropdown)
    LinearLayout dropdown;

    public String TAG = this.getClass().getSimpleName();
    public EmpTable obj_EmpTable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_layout_menu, container, false);
        l_context = getActivity();
        ButterKnife.bind(this, view);

//        Log.e("Test", "Load Fragment Main");

        SharedPreferences prefs = l_context.getSharedPreferences("sharedpref",Context.MODE_PRIVATE);
        if(prefs.getBoolean("didExitFromIdle",false)){
            //Go back to login
            FragmentController.replaceFragment(getFragmentManager(), new FragmentLogin());
            prefs.edit().putBoolean("didExitFromIdle", false).apply();

            //Log.e("Test","Must go to Login Screen");
        }else{
            //Log.e("Test","elseasd"+prefs.getBoolean("didExitFromIdle",false));

            llt_search.setVisibility(View.INVISIBLE);
            obj_EmpTable = new EmpTable(l_context);

            Constants.backToPage = 0;

            //handle visibility of search
            if (!Constants.search_string.equals("")) {//FragmentMain
                //Log.d(TAG,"search string is"+Constants.search_string+""+llt_search.getVisibility());
                llt_search.setVisibility(View.VISIBLE);
                edt_search.setText(Constants.search_string);
                iv_close.setVisibility(view.VISIBLE);
    //            edt_search.isFocused();
    //            ivSync.setVisibility(View.VISIBLE);

            } else {
                llt_search.setVisibility(View.INVISIBLE);

            }

            //agreement
            dialog2 = new Dialog(l_context);
            dialog2.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog2.setContentView(R.layout.dialog_agreement);

            dialog = new Dialog(l_context);
            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialog.setContentView(R.layout.dialog_yesno);

            //DEBUGGING PURPOSES: start to comment here to override login
            /**
             * Added by: Alvin Raygon 5/25  /2017
             * handling of terms and condition
             */

            if (!Constants.t_didDialogShowedUp) {
                if (Constants.t_empagreement.equals("1")) {
                    dialog = new Dialog(l_context);
                    dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                    dialog.setContentView(R.layout.dialog_yesno);
                    dialog.setContentView(R.layout.dialog_acknowledgement);

    //                Log.d(TAG, "emp agreement is 1 " + temp_agreement);
                    String header = "Acknowledgement";
                    String question = "Read and certify acknowlegement of understanding and agreement.";
                    String action = "update";
                    dialog_acknowledgement(l_context, header, question, action);
                }

            }// up to here


            edt_search.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if (edt_search.getText().toString().length() >= 1) {

                        iv_close.setVisibility(view.VISIBLE);
                        edt_search.isFocused();
                    } else {
                        Constants.search_string = "";
                        iv_close.setVisibility(view.GONE);
                        ivSync.setVisibility(View.GONE);
                        iv_back.setVisibility(View.VISIBLE);

                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            edt_search.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {
                    if (b) {
                        ivSync.setVisibility(View.GONE);
                        iv_back.setVisibility(View.VISIBLE);
                    }
                }
            });


            edt_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {


                        if (edt_search.getText().length() <= 0) {

                            Utils.toast(l_context, "Search field is empty.");
                            String title = "Confirmation";
                            String msg = "Search field is empty.";

                            CustomDialog alertDialog = new CustomDialog(l_context, title, msg);
                            alertDialog.show();


                        } else {
                            Constants.search_string = edt_search.getText().toString();
                            FragmentController.replaceFragment(getFragmentManager(), new FragmentSearch());

                            if (view != null) {
                                InputMethodManager imm = (InputMethodManager) l_context.getSystemService(Context.INPUT_METHOD_SERVICE);
                                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                            }
                        }


                        return true;
                    }
                    return false;
                }
            });

    }


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

    @OnClick({R.id.iv_logout, R.id.iv_codeofconduct, R.id.iv_guidlinesinhandling, R.id.iv_guidelinesingrievance, R.id.iv_otherpolicies,R.id.iv_search,R.id.iv_close,R.id.iv_back})

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_logout:
//                initiatePopUpMenu();

                FragmentController.replaceFragment(getFragmentManager(), new FragmentDisclaimer());
                break;
            case R.id.iv_codeofconduct:
                FragmentController.replaceFragment(getFragmentManager(), new HowToUseCode());
                break;
            case R.id.iv_guidlinesinhandling:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentOtherPoliciesList());

                break;
            case R.id.iv_guidelinesingrievance:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentGrievanceHandlingProcessList());
                break;
            case R.id.iv_otherpolicies:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentHandlingAdministrativeList());
                break;
            case R.id.iv_search:

                if (llt_search.getVisibility() == View.VISIBLE) {


                    if (edt_search.getText().length() <= 0) {
//                        Utils.toast(l_context, "Search field is empty.");
                        String title = "Confirmation";
                        String msg = "Search field is empty.";

                        CustomDialog alertDialog = new CustomDialog(l_context, title,
                                msg);
                        alertDialog.show();

                    } else {

                        Constants.search_string = edt_search.getText().toString();
                        FragmentController.replaceFragment(getFragmentManager(), new FragmentSearch());
                    }
                } else {

                    llt_search.setVisibility(View.VISIBLE);
                    iv_back.setVisibility(View.VISIBLE);
                    ivSync.setVisibility(View.GONE);
                }

                break;
            case R.id.edt_search:

                ivSync.setVisibility(View.GONE);
                iv_back.setVisibility(View.VISIBLE);

                Constants.search_string = edt_search.getText().toString();

                break;

            case R.id.iv_back:
                Constants.search_string="";
                FragmentController.replaceFragment(getFragmentManager(), new FragmentMain());


                break;

//            case R.id.iv_logo:
//                FragmentController.replaceFragment(getFragmentManager(), new FragmentMain());
//                break;
            case R.id.iv_close:
                iv_back.setVisibility(View.GONE);
                edt_search.setText("");
                break;


        }
    }

    @OnClick(R.id.iv_sync)
    public void onClick() {

        if (isConnected()) {
            // change url

            String header = "CONFIRMATION";
            String question = "Would you like to check for an update?";
            String action = "update";
            dialog_confirm(l_context, header, question, action);

            // new HttpAsyncTask().execute(Constants.g_updateurl);
        } else {
            String title = "Connection Error";
            String msg = "Unable to check for any update. \n Please check your connection"
                    + " \n and try again.";
            CustomDialog alertDialog = new CustomDialog(l_context, title,
                    msg);
            alertDialog.show();
        }

    }


    public void dialog_confirm(Context context, String header, String prompt,
                               String action) {
        this.act = action;
        tv_header_confirm = (TextView) dialog.findViewById(R.id.tv_header);
        tv_prompt_confirm = (TextView) dialog.findViewById(R.id.tv_prompt);
        btn_ok_confirm = (Button) dialog.findViewById(R.id.btn_ok);
        btn_no = (Button) dialog.findViewById(R.id.btn_no);

        tv_header_confirm.setText(header);
        tv_prompt_confirm.setText(prompt);

        btn_ok_confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if (act.equals("exit")) {
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    System.exit(0);

                    startActivity(intent);

                    Process.killProcess(Process.myPid());
                } else {
//                    String url = "http://172.16.11.28:1111/ErxServiceFunction.svc/GetAllVersion";
                    new HttpAsyncTask().execute();
                    dialog.dismiss();
                }
            }

        });

        btn_no.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dialog.dismiss();

            }
        });

        dialog.setCancelable(false);
        dialog.show();
    }

    //logout

    public void dialog_confirm2(Context context, String header, String prompt,
                                String action) {
        this.act = action;
        tv_header_confirm = (TextView) dialog.findViewById(R.id.tv_header);
        tv_prompt_confirm = (TextView) dialog.findViewById(R.id.tv_prompt);
        btn_ok_confirm = (Button) dialog.findViewById(R.id.btn_ok);
        btn_no = (Button) dialog.findViewById(R.id.btn_no);

        tv_header_confirm.setText(header);
        tv_prompt_confirm.setText(prompt);

        btn_ok_confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Constants.t_didDialogShowedUp = true;
                FragmentController.replaceFragment(getFragmentManager(), new FragmentLogin());
                pw.dismiss();
                dialog.dismiss();
            }

        });

        btn_no.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dialog.dismiss();

            }
        });

        dialog.setCancelable(false);
        dialog.show();
    }


    public void dialog_acknowledgement(Context context, String header, String prompt,
                                       String action) {
        this.act = action;
        tv_header_confirm = (TextView) dialog.findViewById(R.id.tv_header);
        tv_prompt_confirm = (TextView) dialog.findViewById(R.id.tv_prompt);
        btn_ok_confirm = (Button) dialog.findViewById(R.id.btn_ok);
        btn_no = (Button) dialog.findViewById(R.id.btn_no);

        tv_header_confirm.setText(header);
        tv_prompt_confirm.setText(prompt);

        btn_ok_confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


//                Utils.toast(l_context, "Agreement");
                //VALIDATION: added t_didDialogShowedUp to check if dialog already been showed from first login
                Constants.t_didDialogShowedUp = true;

                String header = "Acknowledgement";
                String question = "I hereby acknowledge and certify that I have read and fully understood the contents of this application. I hereby declare and undertake that I shall at all times uphold and abide by the contents of the said policies and guidelines.\n\nFurther, I acknowledge that in case of separation, this application will be uninstalled from my electronic device.";
                String action = "update";
                dialog_agreement(l_context, header, question, action);


                dialog.dismiss();
            }

        });

        btn_no.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Constants.t_didDialogShowedUp = true;
//                Utils.toast(l_context, "Later");
                dialog.dismiss();

            }
        });

        dialog.setCancelable(false);
        dialog.show();
    }

    /**
     * Modified by: Alvin Raygon
     * <p/>
     * custom dialog for employee agreement(Settings)
     *
     * @param context context use
     * @param header  title
     * @param prompt  msg
     * @param action  tag
     */
    public void dialog_agreement(Context context, String header, String prompt,
                                 String action) {

        this.act = action;
        tv_header_confirm = (TextView) dialog2.findViewById(R.id.tv_header);
        tv_prompt_confirm = (TextView) dialog2.findViewById(R.id.tv_prompt);
        btn_ok_confirm = (Button) dialog2.findViewById(R.id.btn_ok);

        tv_header_confirm.setText(header);
        tv_prompt_confirm.setText(prompt);

        btn_ok_confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Log.d(TAG, "Constants.t_id " + Constants.t_id);
                //NOTE: 0 is set to true in the api
                //show progress dialog

                progress = new ProgressDialog(l_context);
                progress.setMessage("Acknowledging... Please wait.");
                progress.setCancelable(false);
                progress.show();

                //0 is set to true in the api, 0 is agreed.
                Call<EmployeeIdResult> call = initializeRetrofitAgreement().postAgreement(Constants.t_id,"0");
                call.enqueue(FragmentMain.this);

//                Utils.toast(l_context, "Agree");
            }

        });

        dialog2.setCancelable(false);
        dialog2.show();
    }
    //retropwet


    public static WorkplacePostUserAgreementInterFaceApi initializeRetrofitAgreement() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://161.202.23.41/").addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        WorkplacePostUserAgreementInterFaceApi interfaceApi = retrofit.create(WorkplacePostUserAgreementInterFaceApi.class);

        return interfaceApi;

    }

    @Override
    public void onResponse(Call<EmployeeIdResult> call, Response<EmployeeIdResult> response) {
        //Log.d(TAG,"onResponse");

        //RFC : 031317 Removed offline data transactions
        obj_EmpTable.updateEmp_Specifics("0", Constants.t_id);

        progress.dismiss();
        dialog2.dismiss();

    }

    @Override
    public void onFailure(Call<EmployeeIdResult> call, Throwable throwable) {
        progress.dismiss();
        dialog2.dismiss();
        //Log.e(TAG,"onFailure"+throwable.toString());
        String title = "Error";
        String msg = "Check your configuration settings \n and try again.";

        CustomDialog alertDialog = new CustomDialog(l_context, title,
                msg);

        alertDialog.show();

    }


    public boolean isConnected() {
        ConnectivityManager connMgr = (ConnectivityManager) l_context.getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected())

            return true;
        else

            return false;
    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {

        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(l_context);
            dialog.setMessage("Checking updates... Please wait.");
            dialog.setCancelable(false);
            dialog.show();
        }

        @SuppressWarnings("deprecation")
        @Override
        protected String doInBackground(String... params) {

            DefaultHttpClient httpclient = new DefaultHttpClient(
                    new BasicHttpParams());

//            HttpPost httppost = new HttpPost("http://jhunleo.hol.es/workplace/GetAllVersion.php");
            HttpPost httppost = new HttpPost("http://161.202.23.41/GetAllVersion.php");
            InputStream inputStream = null;
            String result = "";
            try {
// Add your data
                List<NameValuePair> nameValuePairs = new ArrayList<>(
                        2);
                nameValuePairs
                        .add(new BasicNameValuePair("app_code", "UL_WORKPLACE"));
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                // Execute HTTP Post Request
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();

                inputStream = entity.getContent();
                // json is UTF-8 by default
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(inputStream, "UTF-8"), 8);
                StringBuilder sb = new StringBuilder();

                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                result = sb.toString();
            } catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
            } catch (IOException e) {
                // TODO Auto-generated catch block
            }
            //Log.i(TAG, "result:" + result);
            return result;
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            // Toast.makeText(getBaseContext(), "Received!",
            // Toast.LENGTH_LONG).show();
            //Log.d(TAG, "onPostExecute:" + result);
            try {
                dialog.dismiss();
//                Log.d("neckkkk", "" + result);
                JSONObject json = new JSONObject(result);
//                JSONObject content = json.getJSONObject("GetAllVersionResult");
                JSONArray articles = json.getJSONArray("data"); // get
                String a = articles.getJSONObject(0).getString("version_code");
                Constants.l_version = Double.parseDouble(a);
                Constants.g_apk_path = articles.getJSONObject(0).getString("apk_path");
                autoUpdate();

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                String title = "Error";
                String msg = "Check your configuration settings \n and try again.";
                CustomDialog alertDialog = new CustomDialog(l_context, title, msg);
                alertDialog.show();
            }
        }
    }

    public void autoUpdate() {

        // getting information about the application package
        try {

            l_pInfo = l_context.getPackageManager().getPackageInfo(l_context.getPackageName(), 0);

        } catch (Exception e) {

        }
        String p_version = l_pInfo.versionName;
//        Log.d("Version Name", p_version);
//        Log.i("Version Code", "Online Version Code: " + Constants.l_version);
//        Log.i("Version Code",
//                "Offline Version Code: " + Double.parseDouble(p_version));
        // comparison of updated version code and version code of installed
        // application

        if (Constants.l_version <= Double.parseDouble(p_version)) {
            String title = "Update";
            String msg = "There is no available update.";

            CustomDialog alertDialog = new CustomDialog(l_context, title, msg);

            alertDialog.show();

        } else {

            Runnable updateFunction = new Runnable() {
                private AsyncTask<String, Void, Void> execute;

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    // UpdateApp update_app = new UpdateApp();
                    // update_app.setContext(getApplicationContext());
                    // update_app.execute(Constants.g_apk_path);
                        Update_app updteApp = new Update_app();
                        updteApp.execute(Constants.g_apk_path);
                    }

            };
            if (Constants.g_apk_path.equals("")) {

            } else {

                String title = "Update";
                String msg = "An update is available for Workplace Conduct application. Would you like to proceed?";
                CustomDialog alertDialog = new CustomDialog(l_context, title, msg, updateFunction, null, false);
                alertDialog.setCancelable(false);
                alertDialog.show();

            }
        }

    }

    public class Update_app extends AsyncTask<String, String, String> {
        private ProgressDialog progressDialogUpdate;
        boolean conn_error = false;
        Exception exception = null;
        int lenghtOfFile, progress;
        File outputFile;

        protected void onPreExecute() {

            progressDialogUpdate = new ProgressDialog(l_context);
            progressDialogUpdate.setMessage("Downloading... \nPlease wait...");
            progressDialogUpdate.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialogUpdate.setCancelable(false);
            progressDialogUpdate.setProgress(0);
            progressDialogUpdate.show();

        }

        @Override
        protected String doInBackground(String... arg0) {
//            Log.v(TAG,"entered doInBackground");
            try {
//                Log.e(TAG, "Error trap! " + arg0[0]);
                // File c = new File(arg0[0]);

                URL url = new URL(arg0[0]);
                HttpURLConnection c = (HttpURLConnection) url.openConnection();
                // c.setRequestMethod("GET");
                // c.setDoOutput(true);
                c.connect();

                lenghtOfFile = c.getContentLength();
                 //Log.e("Error Trap", "Error trap! " + c.getResponseMessage());
                 //Log.e("Error Trap", "Error trap! " + c.getResponseCode());

                //Log.e("Error Trap", "Error trap! " + c.toString());
                String PATH = System.getenv("EXTERNAL_STORAGE") + "/WORKPLACE/apk";
//                Log.e(TAG, "Path: " + PATH);
                File file = new File(PATH);
//                Log.e(TAG, "File! " + file.toString());
                file.mkdirs();
                outputFile = new File(PATH, "update.apk");
                if (outputFile.exists()) {
                    outputFile.delete();
                }
                FileOutputStream fos = new FileOutputStream(outputFile);
                //Log.e("Error Trap", "pass " + c.toString());
                InputStream is = c.getInputStream();

                // InputStream is = new
                // FileInputStream("file:///172.16.9.244/website/Bayanihan_Files/APK/UL_R_RX.apk");
//                Log.e("Error Trap", "passed " + c.toString());
                byte[] buffer = new byte[1024];
                int len1 = 0;
                progress = 0;
                while ((len1 = is.read(buffer)) != -1) {
                    // publishing the progress....
                    // After this onProgressUpdate will be called
                    progress += len1;
                    progressDialogUpdate
                            .setProgress((int) ((progress * 100) / lenghtOfFile));
                    fos.write(buffer, 0, len1);
                    //
                }
                fos.close();
                is.close();

            } catch (Exception e) {
//                Log.e(TAG, "Update error! " + e.getMessage());
                e.printStackTrace();
                progressDialogUpdate.dismiss();
                conn_error = true;
            }
            return "";
        }

        protected void onPostExecute(String s) {

            progressDialogUpdate.dismiss();
            Log.e(TAG, "POST EXECUTE conn_error"+conn_error);

            if (conn_error) {
                String title = "Connection error";
                String msg = "Check your connection and try again.";

                CustomDialog alertDialog = new CustomDialog(l_context, title,
                        msg);

                alertDialog.show();
                conn_error = false;
            } else {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // without this
                // flag
                // android
                // returned
                // a intent
                // error!
                // intent.setDataAndType(Uri.fromFile(new
                // File(PATH,"update.apk")),
                // "application/vnd.android.package-archive");

                // intent.setDataAndType(Uri.parse(PATH+"/update.apk"),
                // "application/vnd.android.package-archive");
                // intent.setDataAndType(Uri.parse(System.getenv("EXTERNAL_STORAGE").toString()+"/apk"+"/update.apk"),
                // "application/vnd.android.package-archive");
                intent.setDataAndType(Uri.fromFile(outputFile),
                        "application/vnd.android.package-archive");
                startActivity(intent);

            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("Test","onpause started");
        //new MainActivity().clearBackStack();
    }
}
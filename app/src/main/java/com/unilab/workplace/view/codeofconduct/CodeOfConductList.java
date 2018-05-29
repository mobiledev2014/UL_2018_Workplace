package com.unilab.workplace.view.codeofconduct;

import android.app.ActionBar;
import android.app.Dialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.unilab.workplace.R;
import com.unilab.workplace.Utitlities.Utils;
import com.unilab.workplace.constants.Constants;
import com.unilab.workplace.controller.FragmentController;
import com.unilab.workplace.view.menu.FragmentDisclaimer;
import com.unilab.workplace.view.menu.FragmentLogin;
import com.unilab.workplace.view.menu.FragmentMain;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CodeOfConductList extends Fragment {

    View view;
    Context l_context;
    Typeface tf;
    @Bind(R.id.iv_home)
    ImageView ivHome;
    @Bind(R.id.title_code_of_conduct)
    TextView titleCodeOfConduct;
    @Bind(R.id.iv_settings)
    ImageView ivSettings;

    @Bind(R.id.tv_code_1)
    TextView tvCode1;
    @Bind(R.id.tv_code_2)
    TextView tvCode2;
    @Bind(R.id.tv_code_3)
    TextView tvCode3;
    @Bind(R.id.tv_code_4)
    TextView tvCode4;
    @Bind(R.id.tv_code_5)
    TextView tvCode5;
    @Bind(R.id.tv_code_6)
    TextView tvCode6;
    @Bind(R.id.tv_code_7)
    TextView tvCode7;
    @Bind(R.id.tv_code_8)
    TextView tvCode8;
    @Bind(R.id.tv_code_9)
    TextView tvCode9;
    @Bind(R.id.lv_code_list_1)
    LinearLayout lvCodeList1;
    @Bind(R.id.lv_code_list_2)
    LinearLayout lvCodeList2;
    @Bind(R.id.lv_code_list_3)
    LinearLayout lvCodeList3;
    @Bind(R.id.lv_code_list_4)
    LinearLayout lvCodeList4;
    @Bind(R.id.lv_code_list_5)
    LinearLayout lvCodeList5;
    @Bind(R.id.lv_code_list_6)
    LinearLayout lvCodeList6;
    @Bind(R.id.lv_code_list_7)
    LinearLayout lvCodeList7;
    @Bind(R.id.lv_code_list_8)
    LinearLayout lvCodeList8;
    @Bind(R.id.lv_code_list_9)
    LinearLayout lvCodeList9;
    @Bind(R.id.llt_dropdown)
    LinearLayout dropdown;
    PopupWindow pw;

    TextView tv_header_confirm;
    TextView tv_prompt_confirm;
    Button btn_ok_confirm, btn_no;
    Dialog dialog;
    String act = "";
    public static ProgressDialog progressDialog;
    public static Dialog dialogProgress;

    FragmentMain fragmentMain;

    public CountDownTimer CDT;
    public ProgressDialog TempDialog;
    public int i =2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_code_of_conduct_list, container, false);

        l_context = getActivity();

        ButterKnife.bind(this, view);

//        Log.d(TAG,"Constants.backToPage"+Constants.backToPage);
        Constants.backToPage = 1;
        fonts();
        dialog = new Dialog(l_context);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_yesno);

//        dialogProgress = new Dialog(l_context);
//        dialogProgress.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//        dialogProgress.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialogProgress.setContentView(R.layout.dialog_progress);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
//                    Log.d("FragmentOther","test1");
                    if (getFragmentManager().getBackStackEntryCount() == 0) {
//                        Log.d("FragmentOther","getBackStackEntryCount is 0");
                    } else {
                        getFragmentManager().popBackStack();
                    }
                    return true;
                }
                return false;
            }
        });
    }




    public void fonts() {
        tf = Typeface.createFromAsset(l_context.getAssets(), "fonts/Rileyson_W01_Born.ttf");
        titleCodeOfConduct.setTypeface(tf);
        tvCode1.setTypeface(tf);
        tvCode2.setTypeface(tf);
        tvCode3.setTypeface(tf);
        tvCode4.setTypeface(tf);
        tvCode5.setTypeface(tf);
        tvCode6.setTypeface(tf);
        tvCode7.setTypeface(tf);
        tvCode8.setTypeface(tf);
        tvCode9.setTypeface(tf);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }



    // pop up

    private void initiatePopUpMenu() {

        LayoutInflater inflater = (LayoutInflater) l_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout layout_menu = (RelativeLayout) inflater.inflate(R.layout.dropdown_menu, (ViewGroup) view.findViewById(R.id.rlt_layout));


        Button btnDisclaimer = ButterKnife.findById(layout_menu, R.id.btn_disclaimer);
        Button btnLogout = ButterKnife.findById(layout_menu, R.id.btn_logout);

        btnDisclaimer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Utils.toast(l_context, "Disclaimer");
                pw.dismiss();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String header = "Logout";
                String question = "Are you sure you want to logout?";
                String action = "update";
                dialog_confirm2(l_context, header, question, action);
                pw.dismiss();


            }
        });

        pw = new PopupWindow(layout_menu, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
        pw.setBackgroundDrawable(new BitmapDrawable());
        pw.setTouchable(true);
        pw.setOutsideTouchable(true);
        pw.setTouchInterceptor(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    pw.dismiss();
                    return true;
                }
                return false;
            }
        });

        pw.setContentView(layout_menu);
        pw.showAsDropDown(dropdown);

    }


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


    @OnClick({R.id.iv_home, R.id.iv_settings, R.id.lv_code_list_1, R.id.lv_code_list_2, R.id.lv_code_list_3, R.id.lv_code_list_4, R.id.lv_code_list_5, R.id.lv_code_list_6, R.id.lv_code_list_7, R.id.lv_code_list_8, R.id.lv_code_list_9})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_home:

                FragmentController.replaceFragment(getFragmentManager(), new FragmentMain());
                break;
            case R.id.iv_settings:

                FragmentController.replaceFragment(getFragmentManager(), new FragmentDisclaimer());
                break;
            case R.id.lv_code_list_1:
//                new HttpAsyncTask().execute();
//                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentHealthAndSanitation());
//                progressDialog.dismiss();
                break;
            case R.id.lv_code_list_2:
//                dialogProgress.setCancelable(false);
//                dialogProgress.show();
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentSafetyAndSecurity());
                break;
            case R.id.lv_code_list_3:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentCompanyPropertyAndPropertyRights());
                break;
            case R.id.lv_code_list_4:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentBusinessAndWorkplaceConduct());
                break;
            case R.id.lv_code_list_5:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentProductivity());
                break;
            case R.id.lv_code_list_6:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentHandlingInformation());
                break;
            case R.id.lv_code_list_7:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentBusinessAndTransactionalIntegrity());
                break;
            case R.id.lv_code_list_8:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentUnauthorizedActivities());
                break;
            case R.id.lv_code_list_9:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentOtherPolicies());
                break;
        }

    }
    //Progress dialog
//    public void //showProgressBar(){
//        TempDialog = new ProgressDialog(l_context);
//        TempDialog.setMessage("Please wait...");
//        TempDialog.setCancelable(false);
//        TempDialog.setIndeterminate(true);
//        TempDialog.setProgress(i);
//        TempDialog.show();
//
//        CDT = new CountDownTimer(5000, 1000)
//        {
//            public void onTick(long millisUntilFinished)
//            {
//
//                TempDialog.setMessage("Please wait...");
//                i--;
//            }
//
//            public void onFinish()
//            {
//                TempDialog.dismiss();
//
//            }
//        }.start();
//    }


}
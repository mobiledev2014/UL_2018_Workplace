package com.unilab.workplace.view.grievancehandling;

import android.app.ActionBar;
import android.app.Dialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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

public class FragmentGrievanceHandlingProcessList extends Fragment {

    View view;
    Context l_context;
    Typeface tf;
    @Bind(R.id.iv_home)
    ImageView ivHome;
    @Bind(R.id.iv_settings)
    ImageView ivSettings;
    @Bind(R.id.title_code_of_conduct)
    TextView titleCodeOfConduct;
    @Bind(R.id.tv_other_1)
    TextView tvOther1;
    @Bind(R.id.tv_other_2)
    TextView tvOther2;
    @Bind(R.id.tv_other_3)
    TextView tvOther3;
    @Bind(R.id.tv_other_4)
    TextView tvOther4;
    @Bind(R.id.tv_other_5)
    TextView tvOther5;
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


    @Bind(R.id.llt_dropdown)
    LinearLayout dropdown;
    PopupWindow pw;

    TextView tv_header_confirm;
    TextView tv_prompt_confirm;
    Button btn_ok_confirm, btn_no;
    Dialog dialog;
    String act = "";

    public CountDownTimer CDT;
    public ProgressDialog TempDialog;
    public int i = 5;

    //    private CodeOfConductList codeOfConductList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_grievance_list, container, false);
//        codeOfConductList = new CodeOfConductList();
        l_context = getActivity();
        ButterKnife.bind(this, view);
//        Log.d(TAG,"Constants.backToPage"+Constants.backToPage);
        Constants.backToPage = 14;
        fonts();


        return view;
    }

    /**
     * Updated by: Alvin Raygon 10/7/16
     */
    //Overriding onResume() pressing back button in a fragment
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
        tvOther1.setTypeface(tf);
        tvOther2.setTypeface(tf);
        tvOther3.setTypeface(tf);
        tvOther4.setTypeface(tf);
        tvOther5.setTypeface(tf);


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

    @OnClick({R.id.iv_home, R.id.iv_settings, R.id.lv_code_list_1, R.id.lv_code_list_2, R.id.lv_code_list_3, R.id.lv_code_list_4, R.id.lv_code_list_5})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_home:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentMain());
                break;
            case R.id.iv_settings:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentDisclaimer());
                break;
            case R.id.lv_code_list_1:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentGrievanceHandlingProcess());
                break;
            case R.id.lv_code_list_2:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentRolesAndResponsibilities());
                break;
            case R.id.lv_code_list_3:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentMediationMeeting());
                break;
            case R.id.lv_code_list_4:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentConfidentialityOfInformation());
                break;
            case R.id.lv_code_list_5:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentOthers());
                break;
        }
    }

    //Progress dialog
//    public void //showProgressBar() {
//        TempDialog = new ProgressDialog(l_context);
//        TempDialog.setMessage("Please wait...");
//        TempDialog.setCancelable(false);
//        TempDialog.setIndeterminate(true);
//        TempDialog.setProgress(i);
//        TempDialog.show();
//
//        CDT = new CountDownTimer(5000, 1000) {
//            public void onTick(long millisUntilFinished) {
//
//                TempDialog.setMessage("Please wait...");
//                i--;
//            }
//
//            public void onFinish() {
//                TempDialog.dismiss();
//
//            }
//        }.start();
//    }
}
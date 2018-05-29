package com.unilab.workplace.view.grievancehandling;

import android.app.ActionBar;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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
import com.unilab.workplace.Utitlities.TextViewEx;
import com.unilab.workplace.Utitlities.Utils;
import com.unilab.workplace.constants.Constants;
import com.unilab.workplace.controller.FragmentController;
import com.unilab.workplace.view.menu.FragmentDisclaimer;
import com.unilab.workplace.view.menu.FragmentLogin;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentGrievanceHandlingProcess extends Fragment {

    View view;
    Context l_context;
    Typeface tf;
    @Bind(R.id.iv_list)
    ImageView ivList;

    @Bind(R.id.llt_dropdown)
    LinearLayout dropdown;

    @Bind(R.id.tv_eight_rules_a_text)
    TextViewEx tv_eight_rules_a_text;

    @Bind(R.id.tv_eight_rules_b_text)
    TextViewEx tv_eight_rules_b_text;

    @Bind(R.id.tv_eight_rules_c_text)
    TextViewEx tv_eight_rules_c_text;

    @Bind(R.id.tv_eight_rules_d_text)
    TextViewEx tv_eight_rules_d_text;


    PopupWindow pw;

    TextView tv_header_confirm;
    TextView tv_prompt_confirm;
    Button btn_ok_confirm, btn_no;
    Dialog dialog;
    String act = "";
    @Bind(R.id.tv_grievance_1_1)
    TextViewEx tvGrievance11;
    @Bind(R.id.tv_grievance_1_2)
    TextViewEx tvGrievance12;
    @Bind(R.id.tv_grievance_1_3)
    TextViewEx tvGrievance13;
    @Bind(R.id.tv_grievance_1_4)
    TextViewEx tvGrievance14;
    @Bind(R.id.tv_grievance_1_5)
    TextViewEx tvGrievance15;
    @Bind(R.id.tv_grievance_1_6)
    TextViewEx tvGrievance16;
    @Bind(R.id.tv_grievance_1_7)
    TextViewEx tvGrievance17;
    @Bind(R.id.tv_grievance_1_8)
    TextViewEx tvGrievance18;
    @Bind(R.id.tv_grievance_1_9)
    TextViewEx tv_grievance_1_9;
    @Bind(R.id.tv_grievance_1_10)
    TextViewEx tvGrievance110;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        view = inflater.inflate(R.layout.fragment_grievance_handling_process_1, container, false);

        l_context = getActivity();
        ButterKnife.bind(this, view);

//        Log.d(TAG,"Constants.backToPage"+Constants.backToPage);
        Constants.backToPage = 13;
        tf = Typeface.createFromAsset(l_context.getAssets(), "fonts/OpenSans_Regular.ttf");

//        titleCodeOfConduct.setTypeface(tf);

        dialog = new Dialog(l_context);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_yesno);

        tvGrievance11.setText(true);
        tvGrievance12.setText(true);
        tvGrievance13.setText(true);
        tvGrievance14.setText(true);
        tvGrievance15.setText(true);
        tvGrievance16.setText(true);
        tvGrievance17.setText(true);
        tvGrievance18.setText(true);
        tvGrievance110.setText(true);
        tv_grievance_1_9.setText(true);

        tv_eight_rules_a_text.setText(true);
        tv_eight_rules_b_text.setText(true);
        tv_eight_rules_c_text.setText(true);
        tv_eight_rules_d_text.setText(true);
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


    //pop up
    @OnClick({R.id.iv_list, R.id.iv_settings})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.iv_list:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentGrievanceHandlingProcessList());
                break;

            case R.id.iv_settings:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentDisclaimer());
                break;
        }
    }
}
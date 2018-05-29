package com.unilab.workplace.view.otherpolicies;

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

public class FragmentOtherPoliciesPolicyOnBusinessConduct extends Fragment {

    View view;
    Context l_context;
    Typeface tf;
    @Bind(R.id.iv_list)
    ImageView ivList;

    @Bind(R.id.llt_dropdown)
    LinearLayout dropdown;
    PopupWindow pw;
    //policy_text

    TextView tv_header_confirm;
    TextView tv_prompt_confirm;
    Button btn_ok_confirm, btn_no;
    Dialog dialog;
    String act = "";

    @Bind(R.id.tv_policy_business)
    TextViewEx tvPolicyBusiness;
    @Bind(R.id.tv_conflict_of_interest_a)
    TextViewEx tvConflictOfInterestA;
    @Bind(R.id.tv_conflict_of_interest_a1)
    TextViewEx tvConflictOfInterestA1;
    @Bind(R.id.tv_conflict_of_interest_a2)
    TextViewEx tvConflictOfInterestA2;
    @Bind(R.id.tv_conflict_of_interest_a3)
    TextViewEx tvConflictOfInterestA3;
    @Bind(R.id.tv_conflict_of_interest_b)
    TextViewEx tvConflictOfInterestB;
    @Bind(R.id.tv_conflict_of_interest_b1)
    TextViewEx tvConflictOfInterestB1;
    @Bind(R.id.tv_conflict_of_interest_b2)
    TextViewEx tvConflictOfInterestB2;
    @Bind(R.id.tv_conflict_of_interest_b2_a)
    TextViewEx tvConflictOfInterestB2A;
    @Bind(R.id.tv_conflict_of_interest_b2_b)
    TextViewEx tvConflictOfInterestB2B;
    @Bind(R.id.tv_conflict_of_interest_b3)
    TextViewEx tvConflictOfInterestB3;
    @Bind(R.id.tv_conflict_of_interest_b4)
    TextViewEx tvConflictOfInterestB4;
    @Bind(R.id.tv_conflict_of_interest_b5)
    TextViewEx tvConflictOfInterestB5;
    @Bind(R.id.tv_conflict_of_interest_c)
    TextViewEx tvConflictOfInterestC;
    @Bind(R.id.tv_handling_information_1)
    TextViewEx tvHandlingInformation1;
    @Bind(R.id.tv_handling_information_2)
    TextViewEx tvHandlingInformation2;
    @Bind(R.id.tv_handling_information_3)
    TextViewEx tvHandlingInformation3;
    @Bind(R.id.tv_political_civic_professional_activities)
    TextViewEx tvPoliticalCivicProfessionalActivities;
    @Bind(R.id.tv_duty_seek_guidance)
    TextViewEx tvDutySeekGuidance;
    @Bind(R.id.tv_policy_business_conduct_violations)
    TextViewEx tvPolicyBusinessConductViolations;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = inflater.inflate(R.layout.fragment_other_policies_policy_on_business_conduct, container, false);

        l_context = getActivity();
        ButterKnife.bind(this, view);
//        Log.d(TAG,"Constants.backToPage"+Constants.backToPage);
        Constants.backToPage = 34;
        dialog = new Dialog(l_context);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_yesno);

        tvPolicyBusiness.setText(true);
        tvConflictOfInterestA.setText(true);
        tvConflictOfInterestA1.setText(true);
        tvConflictOfInterestA2.setText(true);
        tvConflictOfInterestA3.setText(true);
        tvConflictOfInterestB.setText(true);
        tvConflictOfInterestB1.setText(true);
        tvConflictOfInterestB2.setText(true);
        tvConflictOfInterestB2A.setText(true);
        tvConflictOfInterestB2B.setText(true);
        tvConflictOfInterestB3.setText(true);
        tvConflictOfInterestB4.setText(true);
        tvConflictOfInterestB5.setText(true);
        tvConflictOfInterestC.setText(true);
        tvHandlingInformation1.setText(true);
        tvHandlingInformation2.setText(true);
        tvHandlingInformation3.setText(true);
        tvPoliticalCivicProfessionalActivities.setText(true);
        tvDutySeekGuidance.setText(true);
        tvPolicyBusinessConductViolations.setText(true);

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
                FragmentController.replaceFragment(getFragmentManager(), new FragmentOtherPoliciesList());
                break;

            case R.id.iv_settings:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentDisclaimer());
                break;
        }
    }
}
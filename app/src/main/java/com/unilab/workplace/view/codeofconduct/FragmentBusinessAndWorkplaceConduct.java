package com.unilab.workplace.view.codeofconduct;

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

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentBusinessAndWorkplaceConduct extends Fragment {

    View view;
    Context l_context;
    Typeface tf;
    @Bind(R.id.iv_list)
    ImageView ivList;

    @Bind(R.id.tv_code_sec_4_policy_text)
    TextViewEx tv_code_sec_4_policy_text;

    @Bind(R.id.tv_code_sec_4_rationale_text)
    TextViewEx tv_code_sec_4_rationale_text;

    @Bind(R.id.tv_code_sec_4_scope_text)
    TextViewEx tv_code_sec_4_scope_text;

    @Bind(R.id.tv_code_sec_4_rules_text_1)
    TextViewEx tv_code_sec_4_rules_text_1;

    @Bind(R.id.tv_code_sec_4_rules_text_2)
    TextViewEx tv_code_sec_4_rules_text_2;

    @Bind(R.id.tv_code_sec_4_rules_text_3)
    TextViewEx tv_code_sec_4_rules_text_3;

    @Bind(R.id.tv_code_sec_4_rules_text_4)
    TextViewEx tv_code_sec_4_rules_text_4;

    @Bind(R.id.tv_code_sec_4_rules_text_5)
    TextViewEx tv_code_sec_4_rules_text_5;

    @Bind(R.id.tv_code_sec_4_rules_text_6)
    TextViewEx tv_code_sec_4_rules_text_6;

    @Bind(R.id.tv_code_sec_4_rules_text_7)
    TextViewEx tv_code_sec_4_rules_text_7;

    @Bind(R.id.tv_code_sec_4_rules_text_8)
    TextViewEx tv_code_sec_4_rules_text_8;

    @Bind(R.id.tv_code_sec_4_rules_text_9)
    TextViewEx tv_code_sec_4_rules_text_9;

    @Bind(R.id.tv_code_sec_4_rules_text_10)
    TextViewEx tv_code_sec_4_rules_text_10;

    @Bind(R.id.tv_code_sec_4_rules_text_11)
    TextViewEx tv_code_sec_4_rules_text_11;

    @Bind(R.id.tv_code_sec_4_rules_text_12)
    TextViewEx tv_code_sec_4_rules_text_12;

    @Bind(R.id.tv_code_sec_4_rules_text_13)
    TextViewEx tv_code_sec_4_rules_text_13;

    @Bind(R.id.tv_code_sec_4_rules_text_14)
    TextViewEx tv_code_sec_4_rules_text_14;

    @Bind(R.id.tv_code_sec_4_rules_text_15)
    TextViewEx tv_code_sec_4_rules_text_15;


    @Bind(R.id.iv_settings)
    ImageView ivSettings;

    @Bind(R.id.llt_dropdown)
    LinearLayout dropdown;
    PopupWindow pw;

    TextView tv_header_confirm;
    TextView tv_prompt_confirm;
    Button btn_ok_confirm, btn_no;
    Dialog dialog;
    String act = "";

    ArrayList<TextView> textViews = new ArrayList<TextView>();

    FragmentHealthAndSanitation fragmentHealthAndSanitation = new FragmentHealthAndSanitation();


    @Bind(R.id.tv_first_violation)
    TextView tvFirstViolation;
    @Bind(R.id.tv_penalties_1_first_offense)
    TextView tvPenalties1FirstOffense;
    @Bind(R.id.tv_penalties_1_first_offense_text)
    TextView tvPenalties1FirstOffenseText;
    @Bind(R.id.tv_penalties_1_second_offense)
    TextView tvPenalties1SecondOffense;
    @Bind(R.id.tv_penalties_1_second_offense_text)
    TextView tvPenalties1SecondOffenseText;
    @Bind(R.id.tv_penalties_1_third_offense)
    TextView tvPenalties1ThirdOffense;
    @Bind(R.id.tv_penalties_1_third_offense_text)
    TextView tvPenalties1ThirdOffenseText;
    @Bind(R.id.tv_penalties_1_four_offense)
    TextView tvPenalties1FourOffense;
    @Bind(R.id.tv_penalties_1_four_offense_text)
    TextView tvPenalties1FourOffenseText;
    @Bind(R.id.tv_second_violation)
    TextView tvSecondViolation;
    @Bind(R.id.tv_penalties_2_first_offense)
    TextView tvPenalties2FirstOffense;
    @Bind(R.id.tv_penalties_2_first_offense_text)
    TextView tvPenalties2FirstOffenseText;
    @Bind(R.id.tv_penalties_2_second_offense)
    TextView tvPenalties2SecondOffense;
    @Bind(R.id.tv_penalties_2_second_offense_text)
    TextView tvPenalties2SecondOffenseText;
    @Bind(R.id.tv_penalties_2_third_offense)
    TextView tvPenalties2ThirdOffense;
    @Bind(R.id.tv_penalties_2_third_offense_text)
    TextView tvPenalties2ThirdOffenseText;
    @Bind(R.id.tv_penalties_2_fourth_offense)
    TextView tvPenalties2FourthOffense;
    @Bind(R.id.tv_penalties_2_fourth_offense_text)
    TextView tvPenalties2FourthOffenseText;
    @Bind(R.id.tv_penalties_3)
    TextView tvPenalties3;
    @Bind(R.id.tv_third_violation)
    TextView tvThirdViolation;
    @Bind(R.id.tv_penalties_3_first_offense)
    TextView tvPenalties3FirstOffense;
    @Bind(R.id.tv_penalties_3_first_offense_text)
    TextView tvPenalties3FirstOffenseText;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_code_company_business_and_workplace_conduct, container, false);

        l_context = getActivity();
        ButterKnife.bind(this, view);
//        Log.d(TAG,"Constants.backToPage"+Constants.backToPage);
        Constants.backToPage = 3;
        fonts();

        dialog = new Dialog(l_context);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_yesno);
        tv_code_sec_4_policy_text.setText(true);
        tv_code_sec_4_rationale_text.setText(true);
        tv_code_sec_4_scope_text.setText(true);
        tv_code_sec_4_rules_text_1.setText(true);
        tv_code_sec_4_rules_text_2.setText(true);
        tv_code_sec_4_rules_text_3.setText(true);
        tv_code_sec_4_rules_text_4.setText(true);
        tv_code_sec_4_rules_text_5.setText(true);
        tv_code_sec_4_rules_text_6.setText(true);
        tv_code_sec_4_rules_text_7.setText(true);
        tv_code_sec_4_rules_text_8.setText(true);
        tv_code_sec_4_rules_text_9.setText(true);
        tv_code_sec_4_rules_text_10.setText(true);
        tv_code_sec_4_rules_text_11.setText(true);
        tv_code_sec_4_rules_text_12.setText(true);
        tv_code_sec_4_rules_text_13.setText(true);
        tv_code_sec_4_rules_text_14.setText(true);
        tv_code_sec_4_rules_text_15.setText(true);


        textViews.add(tvFirstViolation);
        textViews.add(tvPenalties1FirstOffense);
        textViews.add(tvPenalties1FirstOffenseText);
        textViews.add(tvPenalties1SecondOffense);
        textViews.add(tvPenalties1SecondOffenseText);
        textViews.add(tvPenalties1ThirdOffense);
        textViews.add(tvPenalties1ThirdOffenseText);
        textViews.add(tvPenalties1FourOffense);
        textViews.add(tvPenalties1FourOffenseText);
        textViews.add(tvSecondViolation);
        textViews.add(tvPenalties2FirstOffense);
        textViews.add(tvPenalties2FirstOffenseText);
        textViews.add(tvPenalties2SecondOffense);
        textViews.add(tvPenalties2SecondOffenseText);
        textViews.add(tvPenalties2ThirdOffense);
        textViews.add(tvPenalties2ThirdOffenseText);
        textViews.add(tvPenalties2FourthOffense);
        textViews.add(tvPenalties2FourthOffenseText);
        textViews.add(tvPenalties3);
        textViews.add(tvThirdViolation);
        textViews.add(tvPenalties3FirstOffense);
        textViews.add(tvPenalties3FirstOffenseText);


        fragmentHealthAndSanitation.colorizeTextview(textViews, Constants.search_string);


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

//        tf = Typeface.createFromAsset(l_context.getAssets(), "fonts/OpenSans_Regular.ttf");
//        titleCodeOfConduct.setTypeface(tf);
//        titleHowToUseTheCode.setTypeface(tf);
//        policy.setTypeface(tf);
//        policyText.setTypeface(tf);
//        rationale.setTypeface(tf);
//        scope.setTypeface(tf);
//        rules.setTypeface(tf);
//        rulesTitle1.setTypeface(tf);
//        rules1.setTypeface(tf);
//        rulesTitle2.setTypeface(tf);
//        rules2.setTypeface(tf);
//        rulesTitle3.setTypeface(tf);
//        rules3.setTypeface(tf);
//        rulesTitle4.setTypeface(tf);
//        rules4.setTypeface(tf);
//        rulesTitle5.setTypeface(tf);
//        rules5.setTypeface(tf);
//        rulesTitle6.setTypeface(tf);
//        rules6.setTypeface(tf);
//        rulesTitle7.setTypeface(tf);
//        rules7.setTypeface(tf);
//        rulesTitle8.setTypeface(tf);
//        rules8.setTypeface(tf);
//        rulesTitle9.setTypeface(tf);
//        rules9.setTypeface(tf);
//        rulesTitle10.setTypeface(tf);
//        rules10.setTypeface(tf);
//        policy.setTypeface(tf);
//        policyText.setTypeface(tf);
//        tvPenalties.setTypeface(tf);
//        tvPenalties1.setTypeface(tf);
//        tvPenalties1FirstOffense.setTypeface(tf);
//        tvPenalties1SecondOffense.setTypeface(tf);
//        tvPenalties1FirstOffenseText.setTypeface(tf);
//        tvPenalties1SecondOffenseText.setTypeface(tf);
//        tvPenalties1ThirdOffense.setTypeface(tf);
//        tvPenalties1ThirdOffenseText.setTypeface(tf);
//        tvPenalties1FourOffense.setTypeface(tf);
//        tvPenalties1FourOffenseText.setTypeface(tf);
//        tvSecondViolation.setTypeface(tf);
//        tvPenalties2FirstOffense.setTypeface(tf);
//        tvPenalties2FirstOffenseText.setTypeface(tf);
//        tvThirdViolation.setTypeface(tf);
//        tvPenalties3FirstOffense.setTypeface(tf);
//        tvPenalties3FirstOffenseText.setTypeface(tf);
//        tvFirstViolation.setTypeface(tf);
//        rulesTitle11.setTypeface(tf);
//        rules11.setTypeface(tf);
//        rulesTitle12.setTypeface(tf);
//        rules12.setTypeface(tf);
//        rulesTitle13.setTypeface(tf);
//        rules13.setTypeface(tf);
//        tvPenalties2.setTypeface(tf);
//        tvPenalties2SecondOffense.setTypeface(tf);
//        tvPenalties2SecondOffenseText.setTypeface(tf);
//        tvPenalties2ThirdOffense.setTypeface(tf);
//        tvPenalties2ThirdOffenseText.setTypeface(tf);
//        tvPenalties2FourthOffense.setTypeface(tf);
//        tvPenalties2FourthOffenseText.setTypeface(tf);
//        tvPenalties3.setTypeface(tf);
//        rulesTitle14.setTypeface(tf);
//        rules14.setTypeface(tf);
//        rulesTitle15.setTypeface(tf);
//        rules15.setTypeface(tf);
//        tvPenalties3SecondOffense.setTypeface(tf);
//        tvPenalties3SecondOffenseText.setTypeface(tf);


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
                FragmentController.replaceFragment(getFragmentManager(), new CodeOfConductList());
                break;
            case R.id.iv_settings:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentDisclaimer());
                break;
        }
    }
}
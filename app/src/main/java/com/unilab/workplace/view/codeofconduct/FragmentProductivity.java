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

public class FragmentProductivity extends Fragment {

    View view;
    Context l_context;
    Typeface tf;
    @Bind(R.id.iv_list)
    ImageView ivList;

    @Bind(R.id.iv_settings)
    ImageView ivSettings;


    @Bind(R.id.tv_code_sec_5_policy_text)
    TextViewEx tv_code_sec_5_policy_text;

    @Bind(R.id.tv_code_sec_5_rationale_text)
    TextViewEx tv_code_sec_5_rationale_text;


    @Bind(R.id.tv_code_sec_5_scope_text)
    TextViewEx tv_code_sec_5_scope_text;


    @Bind(R.id.tv_code_sec_5_rules_text_1)
    TextViewEx tv_code_sec_5_rules_text_1;

    @Bind(R.id.tv_code_sec_5_rules_text_2)
    TextViewEx tv_code_sec_5_rules_text_2;

    @Bind(R.id.tv_code_sec_5_rules_text_3)
    TextViewEx tv_code_sec_5_rules_text_3;

    @Bind(R.id.tv_code_sec_5_rules_text_4)
    TextViewEx tv_code_sec_5_rules_text_4;

    @Bind(R.id.tv_code_sec_5_rules_text_5)
    TextViewEx tv_code_sec_5_rules_text_5;

    @Bind(R.id.tv_code_sec_5_rules_text_6)
    TextViewEx tv_code_sec_5_rules_text_6;

    @Bind(R.id.tv_code_sec_5_rules_text_7)
    TextViewEx tv_code_sec_5_rules_text_7;

    @Bind(R.id.tv_code_sec_5_rules_text_8)
    TextViewEx tv_code_sec_5_rules_text_8;

    @Bind(R.id.tv_code_sec_5_rules_text_9)
    TextViewEx tv_code_sec_5_rules_text_9;

    @Bind(R.id.tv_code_sec_5_rules_text_10)
    TextViewEx tv_code_sec_5_rules_text_10;

    @Bind(R.id.tv_code_sec_5_rules_text_11)
    TextViewEx tv_code_sec_5_rules_text_11;

    @Bind(R.id.tv_code_sec_5_rules_text_12)
    TextViewEx tv_code_sec_5_rules_text_12;


    @Bind(R.id.llt_dropdown)
    LinearLayout dropdown;
    PopupWindow pw;

    TextView tv_header_confirm;
    TextView tv_prompt_confirm;
    Button btn_ok_confirm, btn_no;
    Dialog dialog;
    String act = "";

//    @Bind(R.id.tv_penalties_3_first_offense)
//    TextViewEx tv_penalties_3_first_offense;

//    @Bind(R.id.tv_penalties_4_first_offense)
//    TextViewEx tv_penalties_4_first_offense;

//    @Bind(R.id.tv_penalties_5_first_offense)
//    TextViewEx tv_penalties_5_first_offense;
//
//    @Bind(R.id.tv_penalties_6_first_offense)
//    TextViewEx tv_penalties_6_first_offense;


    @Bind(R.id.tv_third_violation_3)
    TextViewEx tv_third_violation_3;
    //

    ArrayList<TextView> textViews = new ArrayList<TextView>();

    FragmentHealthAndSanitation fragmentHealthAndSanitation = new FragmentHealthAndSanitation();

    @Bind(R.id.tv_first_violation)
    TextView tvFirstViolation;
    @Bind(R.id.tv_penalties_1_first_offense)
    TextView tvPenalties1FirstOffense;
//    @Bind(R.id.tv_penalties_1_first_offense_text)
//    TextView tvPenalties1FirstOffenseText;
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
    @Bind(R.id.tv_third_violation)
    TextView tvThirdViolation;
    @Bind(R.id.tv_third_violation_1)
    TextView tvThirdViolation1;
    @Bind(R.id.tv_penalties_3_first_offense_text)
    TextView tvPenalties3FirstOffenseText;
    @Bind(R.id.tv_penalties_3_second_offense_text)
    TextView tvPenalties3SecondOffenseText;
    @Bind(R.id.tv_penalties_3_third_offense_text)
    TextView tvPenalties3ThirdOffenseText;
    @Bind(R.id.tv_penalties_4_fourth_offense_text)
    TextView tvPenalties4FourthOffenseText;
    @Bind(R.id.tv_productivity_4)
    TextView tvProductivity4;
    @Bind(R.id.tv_penalties_4_first_offense)
    TextView tvPenalties4FirstOffense;
    @Bind(R.id.tv_penalties_4_first_offense_text)
    TextView tvPenalties4FirstOffenseText;
    @Bind(R.id.tv_productivity_5)
    TextView tvProductivity5;
    @Bind(R.id.tv_penalties_5_first_offense)
    TextView tvPenalties5FirstOffense;
    @Bind(R.id.tv_penalties_5_first_offense_text)
    TextView tvPenalties5FirstOffenseText;

    @Bind(R.id.tv_penalties_3_first_offense)
    TextView tv_penalties_3_first_offense;

    @Bind(R.id.tv_penalties_3_4_first_offense)
    TextView tv_penalties_3_4_first_offense;

    @Bind(R.id.tv_penalties_3_5_first_offense)
    TextView tv_penalties_3_5_first_offense;

    @Bind(R.id.tv_penalties_6_first_offense)
    TextView tv_penalties_6_first_offense;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_code_productivity, container, false);

        l_context = getActivity();
        ButterKnife.bind(this, view);
//        Log.d(TAG,"Constants.backToPage"+Constants.backToPage);
        Constants.backToPage = 8;
//        fonts();

        dialog = new Dialog(l_context);

        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_yesno);
        tv_code_sec_5_policy_text.setText(true);
        tv_code_sec_5_rationale_text.setText(true);
        tv_code_sec_5_scope_text.setText(true);
        tv_code_sec_5_rules_text_1.setText(true);
        tv_code_sec_5_rules_text_2.setText(true);
        tv_code_sec_5_rules_text_3.setText(true);
        tv_code_sec_5_rules_text_4.setText(true);
        tv_code_sec_5_rules_text_5.setText(true);
        tv_code_sec_5_rules_text_6.setText(true);
        tv_code_sec_5_rules_text_7.setText(true);
        tv_code_sec_5_rules_text_8.setText(true);
        tv_code_sec_5_rules_text_9.setText(true);
        tv_code_sec_5_rules_text_10.setText(true);
        tv_code_sec_5_rules_text_11.setText(true);
        tv_code_sec_5_rules_text_12.setText(true);

        tv_third_violation_3.setText(true);


        textViews.add(tvFirstViolation);
        textViews.add(tvPenalties1FirstOffense);
//        textViews.add(tvPenalties1FirstOffenseText);
        textViews.add(tvPenalties1SecondOffense);
        textViews.add(tvPenalties1SecondOffenseText);
        textViews.add(tvPenalties1ThirdOffense);
        textViews.add(tvPenalties1ThirdOffenseText);
        textViews.add(tvPenalties1FourOffense);
        textViews.add(tvPenalties1FourOffenseText);
        textViews.add(tvSecondViolation);
        textViews.add(tvPenalties2FirstOffense);
        textViews.add(tvPenalties2FirstOffenseText);
        textViews.add(tvPenalties2ThirdOffense);
        textViews.add(tvPenalties2ThirdOffenseText);
        textViews.add(tvThirdViolation);
        textViews.add(tvThirdViolation1);
        textViews.add(tvPenalties3FirstOffenseText);
        textViews.add(tvPenalties3SecondOffenseText);
        textViews.add(tvPenalties3ThirdOffenseText);
        textViews.add(tvPenalties4FourthOffenseText);
        textViews.add(tvProductivity4);
        textViews.add(tvPenalties4FirstOffense);
        textViews.add(tvPenalties4FirstOffenseText);
        textViews.add(tvProductivity5);
        textViews.add(tvPenalties5FirstOffense);
        textViews.add(tvPenalties5FirstOffenseText);
        textViews.add(tvPenalties2SecondOffense);
        textViews.add(tvPenalties2SecondOffenseText);
        textViews.add(tv_penalties_3_first_offense);
        textViews.add(tv_penalties_3_4_first_offense);
        textViews.add(tv_penalties_3_5_first_offense);
        textViews.add(tv_penalties_6_first_offense);


        fragmentHealthAndSanitation.colorizeTextview(textViews, Constants.search_string);


        return view;
    }

    /**
     * Updated by: Alvin Raygon
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
                FragmentController.replaceFragment(getFragmentManager(), new CodeOfConductList());
                break;
            case R.id.iv_settings:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentDisclaimer());
                break;
        }
    }
}
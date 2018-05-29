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

public class FragmentSafetyAndSecurity extends Fragment {

    View view;
    Context l_context;
    Typeface tf;
    @Bind(R.id.iv_list)
    ImageView ivList;

    @Bind(R.id.iv_settings)
    ImageView ivSettings;


    @Bind(R.id.tv_code_sec_2_policy_text)
    TextViewEx tv_code_sec_2_policy_text;
    @Bind(R.id.tv_code_sec_2_rationale_text)
    TextViewEx tv_code_sec_2_rationale_text;
    @Bind(R.id.tv_code_sec_2_scope_text)
    TextViewEx tv_code_sec_2_scope_text;
//
    @Bind(R.id.tv_code_sec_2_rules_1)
    TextViewEx tv_code_sec_2_rules_1;
    @Bind(R.id.tv_code_sec_2_rules_2)
    TextViewEx tv_code_sec_2_rules_2;
    @Bind(R.id.tv_code_sec_2_rules_3)
    TextViewEx tv_code_sec_2_rules_3;
    @Bind(R.id.tv_code_sec_2_rules_4)
    TextViewEx tv_code_sec_2_rules_4;
    @Bind(R.id.tv_code_sec_2_rules_5)
    TextViewEx tv_code_sec_2_rules_5;
    @Bind(R.id.tv_code_sec_2_rules_6)
    TextViewEx tv_code_sec_2_rules_6;
    @Bind(R.id.tv_code_sec_2_rules_7)
    TextViewEx tv_code_sec_2_rules_7;
    @Bind(R.id.tv_code_sec_2_rules_8)
    TextViewEx tv_code_sec_2_rules_8;
//
//
    @Bind(R.id.tv_code_sec_2_rules_8_a)
    TextViewEx tv_code_sec_2_rules_8_a;
    @Bind(R.id.tv_code_sec_2_rules_8_b)
    TextViewEx tv_code_sec_2_rules_8_b;
    @Bind(R.id.tv_code_sec_2_rules_8_c)
    TextViewEx tv_code_sec_2_rules_8_c;
    @Bind(R.id.tv_code_sec_2_rules_8_d)
    TextViewEx tv_code_sec_2_rules_8_d;
    @Bind(R.id.tv_code_sec_2_rules_8_e)
    TextViewEx tv_code_sec_2_rules_8_e;
    @Bind(R.id.tv_code_sec_2_rules_8_f)
    TextViewEx tv_code_sec_2_rules_8_f;
    //
    @Bind(R.id.penalties_text)
    TextView penalties_text;
    @Bind(R.id.tv_penalties_1_first_offense)
    TextView tv_penalties_1_first_offense;
    @Bind(R.id.tv_penalties_1_first_offense_text)
    TextView tv_penalties_1_first_offense_text;
    @Bind(R.id.tv_penalties_1_second_offense)
    TextView tv_penalties_1_second_offense;
    @Bind(R.id.tv_penalties_1_second_offense_text)
    TextView tv_penalties_1_second_offense_text;
    @Bind(R.id.tv_penalties_1_third_offense)
    TextView tv_penalties_1_third_offense;
    @Bind(R.id.tv_penalties_1_third_offense_text)
    TextView tv_penalties_1_third_offense_text;
    @Bind(R.id.tv_penalties_1_four_offense)
    TextView tv_penalties_1_four_offense;
    @Bind(R.id.tv_penalties_1_four_offense_text)
    TextView tv_penalties_1_four_offense_text;
    @Bind(R.id.tv_second_violation)
    TextView tv_second_violation;
    @Bind(R.id.tv_penalties_2_first_offense)
    TextView tv_penalties_2_first_offense;
    @Bind(R.id.tv_penalties_2_second_offense_text)
    TextView tv_penalties_2_second_offense_text;
    @Bind(R.id.tv_penalties_2_second_offense)
    TextView tv_penalties_2_second_offense;
    @Bind(R.id.tv_penalties_2_third_offense)
    TextView tv_penalties_2_third_offense;
    @Bind(R.id.tv_penalties_2_first_offense_text)
    TextView tv_penalties_2_first_offense_text;
    @Bind(R.id.tv_penalties_2_third_offense_text)
    TextView tv_penalties_2_third_offense_text;
    @Bind(R.id.tv_penalties_2_four_offense)
    TextView tv_penalties_2_four_offense;
    @Bind(R.id.tv_penalties_2_four_offense_text)
    TextView tv_penalties_2_four_offense_text;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_code_safety_and_security, container, false);

        l_context = getActivity();
        ButterKnife.bind(this, view);
//        Log.d(TAG,"Constants.backToPage"+Constants.backToPage);
        Constants.backToPage = 9;
//        fonts();
        dialog = new Dialog(l_context);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_yesno);


//        CodeOfConductList.dialogProgress.dismiss();
        tv_code_sec_2_policy_text.setText(true);
        tv_code_sec_2_rationale_text.setText(true);
        tv_code_sec_2_scope_text.setText(true);
//
        tv_code_sec_2_rules_1.setText(true);
        tv_code_sec_2_rules_2.setText(true);
        tv_code_sec_2_rules_3.setText(true);
        tv_code_sec_2_rules_4.setText(true);

        tv_code_sec_2_rules_5.setText(true);
        tv_code_sec_2_rules_6.setText(true);
        tv_code_sec_2_rules_7.setText(true);
        tv_code_sec_2_rules_8.setText(true);
//
        tv_code_sec_2_rules_8_a.setText(true);
        tv_code_sec_2_rules_8_b.setText(true);
        tv_code_sec_2_rules_8_c.setText(true);
        tv_code_sec_2_rules_8_d.setText(true);
        tv_code_sec_2_rules_8_e.setText(true);
        tv_code_sec_2_rules_8_f.setText(true);

        textViews.add(penalties_text);
        textViews.add(tv_penalties_1_first_offense);
        textViews.add(tv_penalties_1_first_offense_text);
        textViews.add(tv_penalties_1_second_offense);
        textViews.add(tv_penalties_1_second_offense_text);
        textViews.add(tv_penalties_1_third_offense);
        textViews.add(tv_penalties_1_third_offense_text);
        textViews.add(tv_penalties_1_four_offense);
        textViews.add(tv_penalties_1_four_offense_text);
        textViews.add(tv_second_violation);
        textViews.add(tv_penalties_2_first_offense);
        textViews.add(tv_penalties_2_first_offense_text);
        textViews.add(tv_penalties_2_second_offense);
        textViews.add(tv_penalties_2_second_offense_text);
        textViews.add(tv_penalties_2_third_offense);
        textViews.add(tv_penalties_2_third_offense_text);
        textViews.add(tv_penalties_2_four_offense);
        textViews.add(tv_penalties_2_four_offense_text);

        fragmentHealthAndSanitation.colorizeTextview(textViews,Constants.search_string);

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
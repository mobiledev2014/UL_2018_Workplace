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

import com.bluejamesbond.text.DocumentView;
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

public class FragmentOtherPoliciesDigitized extends Fragment {

    View view;
    Context l_context;
    Typeface tf;
    @Bind(R.id.iv_list)
    ImageView ivList;

    @Bind(R.id.tv_eight_rules_a_text)
    TextViewEx tv_eight_rules_a_text;


    @Bind(R.id.tv_eight_rules_b_text)
    TextViewEx tv_eight_rules_b_text;

    @Bind(R.id.tv_i)
    TextViewEx tv_i;


    @Bind(R.id.tv_ii)
    TextViewEx tv_ii;

    @Bind(R.id.tv_iii)
    TextViewEx tv_iii;

    @Bind(R.id.tv_a)
    TextViewEx tv_a;

    @Bind(R.id.tv_b)
    TextViewEx tv_b;

    @Bind(R.id.tv_iv)
    TextViewEx tv_iv;

    @Bind(R.id.tv_v)
    TextViewEx tv_v;


    @Bind(R.id.tv_further)
    TextViewEx tv_further;

    @Bind(R.id.llt_dropdown)
    LinearLayout dropdown;
    PopupWindow pw;


    @Bind(R.id.tv_other_policies_digitized_rationale_text)
    TextViewEx tv_other_policies_digitized_rationale_text;

    @Bind(R.id.tv_other_policies_digitized_scope_text)
    TextViewEx tv_other_policies_digitized_scope_text;

    @Bind(R.id.tv_other_policies_digitized_coverage_text)
    TextViewEx tv_other_policies_digitized_coverage_text;

    TextView tv_header_confirm;
    TextView tv_prompt_confirm;
    Button btn_ok_confirm, btn_no;
    Dialog dialog;
    String act = "";


    ///


    @Bind(R.id.tv_other_policies_digitized_definitions_text)
    TextViewEx tv_other_policies_digitized_definitions_text;

    @Bind(R.id.tv_other_policies_digitized_emp_text)
    TextViewEx tv_other_policies_digitized_emp_text;

    @Bind(R.id.tv_other_policies_digitized_emp_text_1)
    TextViewEx tv_other_policies_digitized_emp_text_1;


    @Bind(R.id.tv_other_policies_digitized_emp_text_2)
    TextViewEx tv_other_policies_digitized_emp_text_2;


    @Bind(R.id.tv_other_policies_digitized_emp_text_3)
    TextViewEx tv_other_policies_digitized_emp_text_3;


    @Bind(R.id.tv_other_policies_digitized_emp_text_4)
    TextViewEx tv_other_policies_digitized_emp_text_4;

    @Bind(R.id.tv_other_policies_digitized_emp_text_5)
    TextViewEx tv_other_policies_digitized_emp_text_5;


    @Bind(R.id.tv_other_policies_digitized_prohibited_text)
    TextViewEx tv_other_policies_digitized_prohibited_text;

    @Bind(R.id.tv_other_policies_digitized_prohibited_text_1)
    TextViewEx tv_other_policies_digitized_prohibited_text_1;

    @Bind(R.id.tv_other_policies_digitized_prohibited_text_2)
    TextViewEx tv_other_policies_digitized_prohibited_text_2;

    @Bind(R.id.tv_other_policies_digitized_violations)
    TextViewEx tv_other_policies_digitized_violations;

    @Bind(R.id.tv_other_policies_digitized_effectivity)
    TextViewEx tv_other_policies_digitized_effectivity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DocumentView documentView = new DocumentView(getActivity(), DocumentView.PLAIN_TEXT);


        view = inflater.inflate(R.layout.fragment_other_policies_policy_digitized_signatures, container, false);

        l_context = getActivity();
        ButterKnife.bind(this, view);
//        Log.d(TAG,"Constants.backToPage"+Constants.backToPage);
        Constants.backToPage = 29;
        dialog = new Dialog(l_context);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_yesno);
        tv_other_policies_digitized_coverage_text.setText(true);
        tv_other_policies_digitized_rationale_text.setText(true);
        tv_other_policies_digitized_scope_text.setText(true);
        tv_eight_rules_a_text.setText(true);
        tv_eight_rules_b_text.setText(true);
        tv_i.setText(true);
        tv_ii.setText(true);
        tv_iii.setText(true);
        tv_a.setText(true);
        tv_b.setText(true);
        tv_iv.setText(true);
        tv_other_policies_digitized_emp_text_5.setText(true);
        tv_v.setText(true);
        tv_further.setText(true);

        tv_other_policies_digitized_definitions_text.setText(true);
        tv_other_policies_digitized_emp_text.setText(true);
        tv_other_policies_digitized_emp_text_1.setText(true);
        tv_other_policies_digitized_emp_text_2.setText(true);
        tv_other_policies_digitized_emp_text_3.setText(true);
        tv_other_policies_digitized_emp_text_4.setText(true);
        tv_other_policies_digitized_prohibited_text.setText(true);
        tv_other_policies_digitized_prohibited_text_1.setText(true);
        tv_other_policies_digitized_prohibited_text_2.setText(true);
        tv_other_policies_digitized_violations.setText(true);
        tv_other_policies_digitized_effectivity.setText(true);
        return view;
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
}
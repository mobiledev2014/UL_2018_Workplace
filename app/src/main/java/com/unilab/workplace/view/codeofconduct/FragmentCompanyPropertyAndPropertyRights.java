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

public class FragmentCompanyPropertyAndPropertyRights extends Fragment {
    ///
    View view;
    Context l_context;
    Typeface tf;
    @Bind(R.id.iv_list)
    ImageView ivList;
    @Bind(R.id.title_code_of_conduct)
    TextView titleCodeOfConduct;
    @Bind(R.id.iv_settings)
    ImageView ivSettings;

    @Bind(R.id.tv_code_sec_3_policy_text)
    TextViewEx tv_code_sec_3_policy_text;

    @Bind(R.id.tv_code_sec_3_rationale_text)
    TextViewEx tv_code_sec_3_rationale_text;

    @Bind(R.id.tv_code_sec_3_rationale_text_i)
    TextViewEx tv_code_sec_3_rationale_text_i;

    @Bind(R.id.tv_code_sec_3_rationale_text_ii)
    TextViewEx tv_code_sec_3_rationale_text_ii;

    @Bind(R.id.tv_code_sec_3_rationale_text_iii)
    TextViewEx tv_code_sec_3_rationale_text_iii;

    @Bind(R.id.tv_code_sec_3_rationale_text_iv)
    TextViewEx tv_code_sec_3_rationale_text_iv;


    @Bind(R.id.tv_code_sec_3_scope_text)
    TextViewEx tv_code_sec_3_scope_text;

    @Bind(R.id.tv_code_sec_3_scope_text_a)
    TextViewEx tv_code_sec_3_scope_text_a;

    @Bind(R.id.tv_code_sec_3_scope_text_b)
    TextViewEx tv_code_sec_3_scope_text_b;


    @Bind(R.id.tv_code_sec_3_scope_text_c)
    TextViewEx tv_code_sec_3_scope_text_c;


    @Bind(R.id.tv_code_sec_3_scope_text_d)
    TextViewEx tv_code_sec_3_scope_text_d;

    @Bind(R.id.tv_code_sec_3_scope_text_e)
    TextViewEx tv_code_sec_3_scope_text_e;

    @Bind(R.id.tv_code_sec_3_scope_text_f)
    TextViewEx tv_code_sec_3_scope_text_f;

    @Bind(R.id.tv_code_sec_3_scope_text_g)
    TextViewEx tv_code_sec_3_scope_text_g;

    @Bind(R.id.tv_code_sec_3_scope_text_h)
    TextViewEx tv_code_sec_3_scope_text_h;

    @Bind(R.id.tv_code_sec_3_scope_text_i)
    TextViewEx tv_code_sec_3_scope_text_i;

    @Bind(R.id.tv_code_sec_3_scope_text_j)
    TextViewEx tv_code_sec_3_scope_text_j;


    @Bind(R.id.tv_code_sec_3_scope_text_k)
    TextViewEx tv_code_sec_3_scope_text_k;

    @Bind(R.id.tv_code_sec_3_scope_text_l)
    TextViewEx tv_code_sec_3_scope_text_l;

    @Bind(R.id.tv_code_sec_3_scope_text_last)
    TextViewEx tv_code_sec_3_scope_text_last;

    @Bind(R.id.tv_code_sec_3_rules_text_1)
    TextViewEx tv_code_sec_3_rules_text_1;

    @Bind(R.id.tv_code_sec_3_rules_text_2)
    TextViewEx tv_code_sec_3_rules_text_2;

    @Bind(R.id.tv_code_sec_3_rules_text_3)
    TextViewEx tv_code_sec_3_rules_text_3;

    @Bind(R.id.tv_code_sec_3_rules_text_4)
    TextViewEx tv_code_sec_3_rules_text_4;

    @Bind(R.id.tv_code_sec_3_rules_text_5)
    TextViewEx tv_code_sec_3_rules_text_5;

    @Bind(R.id.tv_code_sec_3_rules_text_6)
    TextViewEx tv_code_sec_3_rules_text_6;

    @Bind(R.id.tv_code_sec_3_rules_text_7)
    TextViewEx tv_code_sec_3_rules_text_7;

    @Bind(R.id.tv_code_sec_3_rules_text_8)
    TextViewEx tv_code_sec_3_rules_text_8;

    @Bind(R.id.tv_code_sec_3_rules_text_9)
    TextViewEx tv_code_sec_3_rules_text_9;

    @Bind(R.id.tv_code_sec_3_rules_text_10)
    TextViewEx tv_code_sec_3_rules_text_10;

    @Bind(R.id.tv_code_sec_3_rules_text_11)
    TextViewEx tv_code_sec_3_rules_text_11;

    @Bind(R.id.tv_code_sec_3_rules_text_12)
    TextViewEx tv_code_sec_3_rules_text_12;

    @Bind(R.id.tv_code_sec_3_rules_text_13)
    TextViewEx tv_code_sec_3_rules_text_13;


    @Bind(R.id.tv_penalties_1_first_offense_text)
    TextViewEx tv_penalties_1_first_offense_text;


    @Bind(R.id.llt_dropdown)
    LinearLayout dropdown;

    //
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
//    @Bind(R.id.tv_penalties_1_first_offense_text)
//    TextView tvPenalties1FirstOffenseText;
    @Bind(R.id.tv_penalties_2)
    TextView tvPenalties2;
    @Bind(R.id.tv_second_violation)
    TextView tvSecondViolation;
    @Bind(R.id.tv_penalties_2_first_offense)
    TextView tvPenalties2FirstOffense;
    @Bind(R.id.tv_penalties_2_first_offense_text)
    TextView tvPenalties2FirstOffenseText;
    @Bind(R.id.tv_penalties_3)
    TextView tvPenalties3;
    @Bind(R.id.tv_third_violation)
    TextView tvThirdViolation;
    @Bind(R.id.tv_penalties_3_first_offense)
    TextView tvPenalties3FirstOffense;
    @Bind(R.id.tv_penalties_3_first_offense_text)
    TextView tvPenalties3FirstOffenseText;
    @Bind(R.id.tv_penalties_3_second_offense)
    TextView tvPenalties3SecondOffense;
    @Bind(R.id.tv_penalties_3_second_offense_text)
    TextView tvPenalties3SecondOffenseText;
    @Bind(R.id.tv_penalties_3_third_offense)
    TextView tvPenalties3ThirdOffense;
    @Bind(R.id.tv_penalties_3_third_offense_text)
    TextView tvPenalties3ThirdOffenseText;
    @Bind(R.id.tv_penalties_3_four_offense)
    TextView tvPenalties3FourOffense;
    @Bind(R.id.tv_penalties_3_four_offense_text)
    TextView tvPenalties3FourOffenseText;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_code_company_property_and_property_rights, container, false);

        l_context = getActivity();
        ButterKnife.bind(this, view);
//        Log.d(TAG,"Constants.backToPage"+Constants.backToPage);
        Constants.backToPage = 4;
//        fonts();
        dialog = new Dialog(l_context);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_yesno);

        tv_penalties_1_first_offense_text.setText(true);
        tv_code_sec_3_policy_text.setText(true);
        tv_code_sec_3_rationale_text.setText(true);
        tv_code_sec_3_rationale_text_i.setText(true);
        tv_code_sec_3_rationale_text_ii.setText(true);
        tv_code_sec_3_rationale_text_iii.setText(true);
        tv_code_sec_3_rationale_text_iv.setText(true);
        tv_code_sec_3_scope_text.setText(true);
        tv_code_sec_3_scope_text_a.setText(true);
        tv_code_sec_3_scope_text_b.setText(true);
        tv_code_sec_3_scope_text_c.setText(true);
        tv_code_sec_3_scope_text_d.setText(true);
        tv_code_sec_3_scope_text_e.setText(true);
        tv_code_sec_3_scope_text_f.setText(true);
        tv_code_sec_3_scope_text_g.setText(true);
        tv_code_sec_3_scope_text_h.setText(true);
        tv_code_sec_3_scope_text_i.setText(true);
        tv_code_sec_3_scope_text_j.setText(true);
        tv_code_sec_3_scope_text_k.setText(true);
        tv_code_sec_3_scope_text_l.setText(true);
        tv_code_sec_3_scope_text_last.setText(true);
        tv_code_sec_3_rules_text_1.setText(true);
        tv_code_sec_3_rules_text_2.setText(true);

        tv_code_sec_3_rules_text_3.setText(true);

        tv_code_sec_3_rules_text_4.setText(true);

        tv_code_sec_3_rules_text_5.setText(true);

        tv_code_sec_3_rules_text_6.setText(true);

        tv_code_sec_3_rules_text_7.setText(true);

        tv_code_sec_3_rules_text_8.setText(true);

        tv_code_sec_3_rules_text_9.setText(true);

        tv_code_sec_3_rules_text_10.setText(true);

        tv_code_sec_3_rules_text_11.setText(true);

        tv_code_sec_3_rules_text_12.setText(true);

        tv_code_sec_3_rules_text_13.setText(true);


        //penalties higlightling
        textViews.add(tvFirstViolation);
        textViews.add(tvPenalties1FirstOffense);
        textViews.add(tvPenalties2FirstOffenseText);
        textViews.add(tvPenalties3);
        textViews.add(tvThirdViolation);
        textViews.add(tvPenalties3FirstOffense);
        textViews.add(tvPenalties3FirstOffenseText);
        textViews.add(tvPenalties3SecondOffense);
        textViews.add(tvPenalties3SecondOffenseText);
        textViews.add(tvPenalties3ThirdOffense);
        textViews.add(tvPenalties3ThirdOffenseText);
        textViews.add(tvPenalties3FourOffense);
        textViews.add(tvPenalties3FourOffenseText);
        textViews.add(tvPenalties2);
        textViews.add(tvSecondViolation);
        textViews.add(tvPenalties2FirstOffense);

        fragmentHealthAndSanitation.colorizeTextview(textViews,Constants.search_string);


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
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

public class FragmentHandlingInformation extends Fragment {

    View view;
    Context l_context;
    Typeface tf;
    @Bind(R.id.iv_list)
    ImageView ivList;

    @Bind(R.id.iv_settings)
    ImageView ivSettings;


    @Bind(R.id.llt_dropdown)
    LinearLayout dropdown;


    @Bind(R.id.tv_code_sec_6_policy_text)
    TextViewEx tv_code_sec_6_policy_text;

    @Bind(R.id.tv_code_sec_6_rationale_text)
    TextViewEx tv_code_sec_6_rationale_text;

    @Bind(R.id.tv_code_sec_6_scope_text_last)
    TextViewEx tv_code_sec_6_scope_text_last;

    @Bind(R.id.tv_code_sec_6_rules_text_1)
    TextViewEx tv_code_sec_6_rules_text_1;

    @Bind(R.id.tv_code_sec_6_rules_text_2)
    TextViewEx tv_code_sec_6_rules_text_2;

    @Bind(R.id.tv_code_sec_6_rules_text_3)
    TextViewEx tv_code_sec_6_rules_text_3;

    @Bind(R.id.tv_code_sec_6_rules_text_4)
    TextViewEx tv_code_sec_6_rules_text_4;

    @Bind(R.id.tv_code_sec_6_rules_text_5)
    TextViewEx tv_code_sec_6_rules_text_5;

    @Bind(R.id.tv_code_sec_6_rules_text_6)
    TextViewEx tv_code_sec_6_rules_text_6;

    @Bind(R.id.tv_code_sec_6_rules_text_7)
    TextViewEx tv_code_sec_6_rules_text_7;

    @Bind(R.id.tv_code_sec_6_rules_text_8)
    TextViewEx tv_code_sec_6_rules_text_8;

    @Bind(R.id.tv_code_sec_6_rules_text_9)
    TextViewEx tv_code_sec_6_rules_text_9;

    @Bind(R.id.tv_code_sec_6_rules_text_10)
    TextViewEx tv_code_sec_6_rules_text_10;

    @Bind(R.id.tv_code_sec_6_rules_text_11)
    TextViewEx tv_code_sec_6_rules_text_11;

    @Bind(R.id.tv_code_sec_6_rules_text_12)
    TextViewEx tv_code_sec_6_rules_text_12;

    @Bind(R.id.tv_code_sec_6_rules_text_13)
    TextViewEx tv_code_sec_6_rules_text_13;


    @Bind(R.id.tv_handling_a_text)
    TextViewEx tv_handling_a_text;

    @Bind(R.id.tv_handling_b_text)
    TextViewEx tv_handling_b_text;


    @Bind(R.id.tv_handling_c_text)
    TextViewEx tv_handling_c_text;


    @Bind(R.id.tv_handling_d_text)
    TextViewEx tv_handling_d_text;


    @Bind(R.id.tv_handling_e_text)
    TextViewEx tv_handling_e_text;

    @Bind(R.id.tv_handling_f_text)
    TextViewEx tv_handling_f_text;
    @Bind(R.id.tv_handling_g_text)
    TextViewEx tv_handling_g_text;

    @Bind(R.id.tv_handling_h_text)
    TextViewEx tv_handling_h_text;

    @Bind(R.id.tv_handling_i_text)
    TextViewEx tv_handling_i_text;


    @Bind(R.id.tv_handling_j_text)
    TextViewEx tv_handling_j_text;


    @Bind(R.id.tv_handling_k_text)
    TextViewEx tv_handling_k_text;


    @Bind(R.id.tv_handling_l_text)
    TextViewEx tv_handling_l_text;


    @Bind(R.id.tv_handling_m_text)
    TextViewEx tv_handling_m_text;


    @Bind(R.id.tv_handling_n_text)
    TextViewEx tv_handling_n_text;


    @Bind(R.id.tv_handling_o_text)
    TextViewEx tv_handling_o_text;


    @Bind(R.id.tv_handling_p_text)
    TextViewEx tv_handling_p_text;


    @Bind(R.id.tv_handling_q_text)
    TextViewEx tv_handling_q_text;


    @Bind(R.id.tv_handling_r_text)
    TextViewEx tv_handling_r_text;


    @Bind(R.id.tv_handling_s_text)
    TextViewEx tv_handling_s_text;

    @Bind(R.id.tv_handling_t_text)
    TextViewEx tv_handling_t_text;


    @Bind(R.id.tv_handling_u_text)
    TextViewEx tv_handling_u_text;


    @Bind(R.id.tv_handling_v_text)
    TextViewEx tv_handling_v_text;


    @Bind(R.id.tv_handling_w_text)
    TextViewEx tv_handling_w_text;


    @Bind(R.id.tv_handling_x_text)
    TextViewEx tv_handling_x_text;


    @Bind(R.id.tv_handling_y_text)
    TextViewEx tv_handling_y_text;


    @Bind(R.id.policy_text_scope)
    TextViewEx policy_text_scope;
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
    @Bind(R.id.tv_second_violation)
    TextView tvSecondViolation;
    @Bind(R.id.tv_penalties_2_first_offense)
    TextView tvPenalties2FirstOffense;
    @Bind(R.id.tv_penalties_2_first_offense_text)
    TextView tvPenalties2FirstOffenseText;
    @Bind(R.id.tv_penalties_second_offense)
    TextView tvPenaltiesSecondOffense;
    @Bind(R.id.tv_penalties_2_second_offense_text)
    TextView tvPenalties2SecondOffenseText;
    @Bind(R.id.tv_penalties_3_third_offense)
    TextView tvPenalties3ThirdOffense;
    @Bind(R.id.tv_penalties_3_third_offense_text)
    TextView tvPenalties3ThirdOffenseText;
    @Bind(R.id.tv_penalties_2_fourth_offense)
    TextView tvPenalties2FourthOffense;
    @Bind(R.id.tv_penalties_2_fourth_offense_text)
    TextView tvPenalties2FourthOffenseText;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_code_handling_information, container, false);

        l_context = getActivity();
        ButterKnife.bind(this, view);
//        Log.d(TAG,"Constants.backToPage"+Constants.backToPage);
        Constants.backToPage = 5;
//        fonts();

        dialog = new Dialog(l_context);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_yesno);


        tv_handling_a_text.setText(true);
        tv_handling_b_text.setText(true);
        tv_handling_c_text.setText(true);
        tv_handling_d_text.setText(true);
        tv_handling_e_text.setText(true);
        tv_handling_f_text.setText(true);
        tv_handling_g_text.setText(true);
        tv_handling_h_text.setText(true);
        tv_handling_i_text.setText(true);
        tv_handling_j_text.setText(true);
        tv_handling_k_text.setText(true);
        tv_handling_l_text.setText(true);
        tv_handling_m_text.setText(true);
        tv_handling_n_text.setText(true);
        tv_handling_o_text.setText(true);
        tv_handling_p_text.setText(true);
        tv_handling_q_text.setText(true);
        tv_handling_r_text.setText(true);
        tv_handling_s_text.setText(true);
        tv_handling_t_text.setText(true);
        tv_handling_u_text.setText(true);
        tv_handling_v_text.setText(true);
        tv_handling_w_text.setText(true);
        tv_handling_x_text.setText(true);
        tv_handling_y_text.setText(true);
        policy_text_scope.setText(true);
        tv_code_sec_6_policy_text.setText(true);
        tv_code_sec_6_rationale_text.setText(true);
        tv_code_sec_6_scope_text_last.setText(true);
        tv_code_sec_6_rules_text_1.setText(true);
        tv_code_sec_6_rules_text_2.setText(true);
        tv_code_sec_6_rules_text_3.setText(true);
        tv_code_sec_6_rules_text_4.setText(true);
        tv_code_sec_6_rules_text_5.setText(true);
        tv_code_sec_6_rules_text_6.setText(true);
        tv_code_sec_6_rules_text_7.setText(true);
        tv_code_sec_6_rules_text_8.setText(true);
        tv_code_sec_6_rules_text_9.setText(true);
        tv_code_sec_6_rules_text_10.setText(true);
        tv_code_sec_6_rules_text_11.setText(true);
        tv_code_sec_6_rules_text_12.setText(true);
        tv_code_sec_6_rules_text_13.setText(true);


        textViews.add(tvFirstViolation);
        textViews.add(tvPenalties1FirstOffense);
        textViews.add(tvPenalties1FirstOffenseText);
        textViews.add(tvSecondViolation);
        textViews.add(tvPenalties2FirstOffense);
        textViews.add(tvPenalties2FirstOffenseText);
        textViews.add(tvPenaltiesSecondOffense);
        textViews.add(tvPenalties2SecondOffenseText);
        textViews.add(tvPenalties3ThirdOffense);
        textViews.add(tvPenalties3ThirdOffenseText);
        textViews.add(tvPenalties2FourthOffense);
        textViews.add(tvPenalties2FourthOffenseText);

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
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

public class FragmentUnauthorizedActivities extends Fragment {

    View view;
    Context l_context;
    Typeface tf;
    @Bind(R.id.iv_list)
    ImageView ivList;

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
    @Bind(R.id.tv_penalties_1_first_offense)
    TextView tvPenalties1FirstOffense;
    @Bind(R.id.tv_penalties_1_first_offense_text)
    TextView tvPenalties1FirstOffenseText;
    @Bind(R.id.tv_code_sec_8_policy_text)
    TextViewEx tv_code_sec_8_policy_text;

    @Bind(R.id.tv_code_sec_8_rationale_text)
    TextViewEx tv_code_sec_8_rationale_text;

    @Bind(R.id.tv_code_sec_8_scope_text)
    TextViewEx tv_code_sec_8_scope_text;

    @Bind(R.id.tv_code_sec_8_rules_text)
    TextViewEx tv_code_sec_8_rules_text;


    @Bind(R.id.tv_eight_rules_a_text)
    TextViewEx tv_eight_rules_a_text;

    @Bind(R.id.tv_eight_rules_b_text)
    TextViewEx tv_eight_rules_b_text;

    @Bind(R.id.tv_eight_rules_c_text)
    TextViewEx tv_eight_rules_c_text;

    @Bind(R.id.tv_eight_rules_d_text)
    TextViewEx tv_eight_rules_d_text;

    @Bind(R.id.tv_eight_rules_e_text)
    TextViewEx tv_eight_rules_e_text;

    @Bind(R.id.tv_eight_rules_f_text)
    TextViewEx tv_eight_rules_f_text;
    @Bind(R.id.tv_eight_rules_g_text)
    TextViewEx tv_eight_rules_g_text;

    @Bind(R.id.tv_eight_rules_h_text)
    TextViewEx tv_eight_rules_h_text;
    @Bind(R.id.tv_eight_rules_i_text)
    TextViewEx tv_eight_rules_i_text;

    @Bind(R.id.tv_eight_rules_j_text)
    TextViewEx tv_eight_rules_j_text;

    @Bind(R.id.tv_eight_rules_k_text)
    TextViewEx tv_eight_rules_k_text;

    @Bind(R.id.tv_eight_rules_l_text)
    TextViewEx tv_eight_rules_l_text;
    @Bind(R.id.tv_eight_rules_m_text)
    TextViewEx tv_eight_rules_m_text;

    @Bind(R.id.tv_eight_rules_n_text)
    TextViewEx tv_eight_rules_n_text;

    @Bind(R.id.tv_eight_rules_o_text)
    TextViewEx tv_eight_rules_o_text;


    @Bind(R.id.tv_eight_rules_p_text)
    TextViewEx tv_eight_rules_p_text;

    @Bind(R.id.tv_eight_rules_q_text)
    TextViewEx tv_eight_rules_q_text;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_code_unauthorized_activities, container, false);

        l_context = getActivity();
        ButterKnife.bind(this, view);
//        Log.d(TAG,"Constants.backToPage"+Constants.backToPage);
        Constants.backToPage = 10;
//        fonts();
        dialog = new Dialog(l_context);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_yesno);


        tv_code_sec_8_policy_text.setText(true);
        tv_code_sec_8_rationale_text.setText(true);
        tv_code_sec_8_scope_text.setText(true);
        tv_code_sec_8_rules_text.setText(true);
        tv_eight_rules_a_text.setText(true);
        tv_eight_rules_b_text.setText(true);
        tv_eight_rules_c_text.setText(true);
        tv_eight_rules_d_text.setText(true);
        tv_eight_rules_e_text.setText(true);
        tv_eight_rules_f_text.setText(true);
        tv_eight_rules_g_text.setText(true);
        tv_eight_rules_h_text.setText(true);
        tv_eight_rules_i_text.setText(true);
        tv_eight_rules_j_text.setText(true);
        tv_eight_rules_k_text.setText(true);
        tv_eight_rules_l_text.setText(true);
        tv_eight_rules_m_text.setText(true);
        tv_eight_rules_n_text.setText(true);
        tv_eight_rules_o_text.setText(true);
        tv_eight_rules_p_text.setText(true);
        tv_eight_rules_q_text.setText(true);

        textViews.add(tvPenalties1FirstOffense);
        textViews.add(tvPenalties1FirstOffenseText);

        fragmentHealthAndSanitation.colorizeTextview(textViews,Constants.search_string);
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
                FragmentController.replaceFragment(getFragmentManager(), new CodeOfConductList());
                break;
            case R.id.iv_settings:
//                initiatePopUpMenu();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentDisclaimer());
                break;
        }
    }
}
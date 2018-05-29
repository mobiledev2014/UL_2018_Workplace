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
import android.widget.ScrollView;
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

public class FragmentBusinessAndTransactionalIntegrity extends Fragment {

    View view;
    Context l_context;
    Typeface tf;
    @Bind(R.id.iv_list)
    ImageView ivList;

    @Bind(R.id.iv_settings)
    ImageView ivSettings;
    @Bind(R.id.title_code_of_conduct)
    TextView titleCodeOfConduct;
    @Bind(R.id.title_how_to_use_the_code)
    TextView titleHowToUseTheCode;
    @Bind(R.id.policy)
    TextView policy;


    @Bind(R.id.tv_handling_b_text)
    TextViewEx tv_handling_b_text;

    @Bind(R.id.tv_handling_a_text)
    TextViewEx tv_handling_a_text;


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


    @Bind(R.id.policy_text)
    public TextViewEx policy_text;
//    public MyJustifiedTextView policy_text;

    @Bind(R.id.llt_dropdown)
    LinearLayout dropdown;

    @Bind(R.id.rationale_text)
    TextViewEx rationale_text;


    @Bind(R.id.parent_scrollView)
    public ScrollView m_scrollView;

    @Bind(R.id.parentLayout)
    public LinearLayout parent_Layout;


    @Bind(R.id.tv_code_sec_7_scope_text)
    TextViewEx tv_code_sec_7_scope_text;

    @Bind(R.id.tv_code_sec_7_scope_text_last)
    TextViewEx tv_code_sec_7_scope_text_last;


    @Bind(R.id.tv_code_sec_7_rules_text_1)
    TextViewEx tv_code_sec_7_rules_text_1;

    @Bind(R.id.tv_code_sec_7_rules_text_2)
    TextViewEx tv_code_sec_7_rules_text_2;

    @Bind(R.id.tv_code_sec_7_rules_text_3)
    TextViewEx tv_code_sec_7_rules_text_3;

    @Bind(R.id.tv_code_sec_7_rules_text_4)
    TextViewEx tv_code_sec_7_rules_text_4;
    @Bind(R.id.tv_code_sec_7_rules_text_5)
    TextViewEx tv_code_sec_7_rules_text_5;

    @Bind(R.id.tv_code_sec_7_rules_text_6)
    TextViewEx tv_code_sec_7_rules_text_6;

    @Bind(R.id.tv_code_sec_7_rules_text_7)
    TextViewEx tv_code_sec_7_rules_text_7;


    @Bind(R.id.tv_code_sec_7_rules_text_8)
    TextViewEx tv_code_sec_7_rules_text_8;

    @Bind(R.id.tv_code_sec_7_rules_text_9)
    TextViewEx tv_code_sec_7_rules_text_9;

    @Bind(R.id.tv_code_sec_7_rules_text_10)
    TextViewEx tv_code_sec_7_rules_text_10;

    @Bind(R.id.tv_code_sec_7_rules_text_11)
    TextViewEx tv_code_sec_7_rules_text_11;

    @Bind(R.id.tv_code_sec_7_rules_text_12)
    TextViewEx tv_code_sec_7_rules_text_12;

    @Bind(R.id.tv_code_sec_7_rules_text_13)
    TextViewEx tv_code_sec_7_rules_text_13;

    @Bind(R.id.tv_code_sec_7_rules_text_14)
    TextViewEx tv_code_sec_7_rules_text_14;

    @Bind(R.id.tv_code_sec_7_rules_text_15)
    TextViewEx tv_code_sec_7_rules_text_15;

    @Bind(R.id.tv_code_sec_7_rules_text_16)
    TextViewEx tv_code_sec_7_rules_text_16;

    @Bind(R.id.tv_code_sec_7_rules_text_17)
    TextViewEx tv_code_sec_7_rules_text_17;

    @Bind(R.id.tv_code_sec_7_rules_text_18)
    TextViewEx tv_code_sec_7_rules_text_18;
//

    @Bind(R.id.tv_penalties_1_first_offense_text)
    TextView tvPenalties1FirstOffenseText;
    @Bind(R.id.tv_penalties_1_first_offense)
    TextView tv_penalties_1_first_offense;


    PopupWindow pw;

    TextView tv_header_confirm;
    TextView tv_prompt_confirm;
    Button btn_ok_confirm, btn_no;
    Dialog dialog;
    String act = "";

    ArrayList<TextView> textViews = new ArrayList<TextView>();
    FragmentHealthAndSanitation fragmentHealthAndSanitation = new FragmentHealthAndSanitation();
    ; //parent layout
    public static int x;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_code_business2_and_transactional_integrity, container, false);

        l_context = getActivity();
        ButterKnife.bind(this, view);
//        Log.d(TAG,"Constants.backToPage"+Constants.backToPage);
        Constants.backToPage = 2;
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

        policy_text.setText(true);
        rationale_text.setText(true);
        tv_code_sec_7_rules_text_1.setText(true);
        tv_code_sec_7_rules_text_2.setText(true);
        tv_code_sec_7_rules_text_3.setText(true);
        tv_code_sec_7_rules_text_4.setText(true);
        tv_code_sec_7_rules_text_5.setText(true);
        tv_code_sec_7_rules_text_6.setText(true);
        tv_code_sec_7_rules_text_7.setText(true);
        tv_code_sec_7_rules_text_8.setText(true);
        tv_code_sec_7_rules_text_9.setText(true);
        tv_code_sec_7_rules_text_10.setText(true);
        tv_code_sec_7_rules_text_11.setText(true);
        tv_code_sec_7_rules_text_12.setText(true);
        tv_code_sec_7_rules_text_13.setText(true);
        tv_code_sec_7_rules_text_14.setText(true);
        tv_code_sec_7_rules_text_15.setText(true);
        tv_code_sec_7_rules_text_16.setText(true);
        tv_code_sec_7_rules_text_17.setText(true);
        tv_code_sec_7_rules_text_18.setText(true);
        tv_code_sec_7_scope_text.setText(true);
        tv_code_sec_7_scope_text_last.setText(true);

        textViews.add(tv_penalties_1_first_offense);
        textViews.add(tvPenalties1FirstOffenseText);

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
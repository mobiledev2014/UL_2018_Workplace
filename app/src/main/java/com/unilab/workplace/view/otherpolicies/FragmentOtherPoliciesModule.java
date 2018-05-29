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

public class FragmentOtherPoliciesModule extends Fragment {

    View view;
    Context l_context;
    Typeface tf;
    @Bind(R.id.iv_list)
    ImageView ivList;

    @Bind(R.id.iv_settings)
    ImageView ivSettings;


    @Bind(R.id.tv_title)
    TextViewEx tv_title;

    @Bind(R.id.tv_purpose_text)
    TextViewEx tv_purpose_text;

    @Bind(R.id.tv_guide_1_text)
    TextViewEx tv_guide_1_text;


    @Bind(R.id.llt_dropdown)
    LinearLayout dropdown;
    PopupWindow pw;

    TextView tv_header_confirm;
    TextView tv_prompt_confirm;
    Button btn_ok_confirm, btn_no;
    Dialog dialog;
    String act = "";
    @Bind(R.id.policy_text)
    TextViewEx policyText;
    @Bind(R.id.tv_definitions_1_text)
    TextViewEx tvDefinitions1Text;
    @Bind(R.id.tv_definitions_2_text)
    TextViewEx tvDefinitions2Text;
    @Bind(R.id.tv_definitions_3_text)
    TextViewEx tvDefinitions3Text;
    @Bind(R.id.tv_definitions_4_text)
    TextViewEx tvDefinitions4Text;
    @Bind(R.id.tv_definitions_5_text)
    TextViewEx tvDefinitions5Text;
    @Bind(R.id.tv_definitions_6_text)
    TextViewEx tvDefinitions6Text;
    @Bind(R.id.tv_definitions_7_text)
    TextViewEx tvDefinitions7Text;
    @Bind(R.id.tv_definitions_8_text)
    TextViewEx tvDefinitions8Text;
    @Bind(R.id.tv_definitions_9_text)
    TextViewEx tvDefinitions9Text;
    @Bind(R.id.tv_a_text)
    TextViewEx tvAText;
    @Bind(R.id.tv_b_text)
    TextViewEx tvBText;
    @Bind(R.id.tv_c_text)
    TextViewEx tvCText;
    @Bind(R.id.tv_d_text)
    TextViewEx tvDText;
    @Bind(R.id.tv_e_text)
    TextViewEx tvEText;
    @Bind(R.id.tv_definitions_10_text)
    TextViewEx tvDefinitions10Text;
    @Bind(R.id.tv_definitions_11_text)
    TextViewEx tvDefinitions11Text;
    @Bind(R.id.tv_guide_2_text)
    TextViewEx tvGuide2Text;
    @Bind(R.id.tv_guide_3_text)
    TextViewEx tvGuide3Text;
    @Bind(R.id.tv_guide_4_text)
    TextViewEx tvGuide4Text;

    @Bind(R.id.tv_guide_5_text)
    TextViewEx tvGuide5Text;
    @Bind(R.id.tv_guide_6_text)
    TextViewEx tvGuide6Text;
    @Bind(R.id.tv_guide_7_text)
    TextViewEx tvGuide7Text;
    @Bind(R.id.tv_guide_8_text)
    TextViewEx tvGuide8Text;
    @Bind(R.id.tv_guide_9_text)
    TextViewEx tvGuide9Text;
    @Bind(R.id.tv_guide_10_text)
    TextViewEx tvGuide10Text;
    @Bind(R.id.tv_guide_11_text)
    TextViewEx tvGuide11Text;

    @Bind(R.id.tv_guide_12_text)
    TextViewEx tvGuide12Text;
    @Bind(R.id.tv_guide_13_text)
    TextViewEx tvGuide13Text;
    @Bind(R.id.tv_13_a_text)
    TextViewEx tv13AText;
    @Bind(R.id.tv_13_b_text)
    TextViewEx tv13BText;
    @Bind(R.id.tv_13_c_text)
    TextViewEx tv13CText;
    @Bind(R.id.tv_13_d_text)
    TextViewEx tv13DText;
    @Bind(R.id.tv_13_e_text)
    TextViewEx tv13EText;
    @Bind(R.id.tv_guide_14_text)
    TextViewEx tvGuide14Text;
    @Bind(R.id.tv_guide_15_text)
    TextViewEx tvGuide15Text;
    @Bind(R.id.tv_guide_16_text)
    TextViewEx tvGuide16Text;
    @Bind(R.id.tv_guide_17_text)
    TextViewEx tvGuide17Text;
    @Bind(R.id.tv_definitions_program_1_text)
    TextViewEx tvDefinitionsProgram1Text;
    @Bind(R.id.tv_13_program_a_text)
    TextViewEx tv13ProgramAText;
    @Bind(R.id.tv_13_program_b_text)
    TextViewEx tv13ProgramBText;
    @Bind(R.id.tv_13_program_d_text)
    TextViewEx tv13ProgramDText;
    @Bind(R.id.tv_13_program_e_text)
    TextViewEx tv13ProgramEText;
    @Bind(R.id.tv_definitions_guide_2_text)
    TextViewEx tvDefinitionsGuide2Text;
    @Bind(R.id.tv_definitions_guide_3_text)
    TextViewEx tvDefinitionsGuide3Text;
    @Bind(R.id.tv_definitions_guide_4_text)
    TextViewEx tvDefinitionsGuide4Text;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_other_policies_dangerous_drug_free, container, false);

        l_context = getActivity();
        ButterKnife.bind(this, view);
//        Log.d(TAG,"Constants.backToPage"+Constants.backToPage);
        Constants.backToPage = 31;
//        fonts();
        dialog = new Dialog(l_context);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_yesno);


        tv_guide_1_text.setText(true);
        tvGuide6Text.setText(true);
        tvDefinitions2Text.setText(true);
        tv_title.setText(true);
        tv_purpose_text.setText(true);
        policyText.setText(true);
        tvDefinitions1Text.setText(true);
        tvDefinitions3Text.setText(true);
        tvDefinitions4Text.setText(true);
        tvDefinitions5Text.setText(true);
        tvDefinitions6Text.setText(true);
        tvDefinitions7Text.setText(true);
        tvDefinitions8Text.setText(true);
        tvDefinitions9Text.setText(true);
        tvAText.setText(true);
        tvBText.setText(true);
        tvCText.setText(true);
        tvDText.setText(true);
        tvEText.setText(true);
        tvDefinitions10Text.setText(true);
        tvDefinitions11Text.setText(true);

        tvGuide2Text.setText(true);

        tvGuide3Text.setText(true);

        tvGuide4Text.setText(true);

        tvGuide5Text.setText(true);

        tvGuide7Text.setText(true);

        tvGuide8Text.setText(true);

        tvGuide9Text.setText(true);

        tvGuide10Text.setText(true);

        tvGuide11Text.setText(true);

        tvGuide12Text.setText(true);

        tvGuide13Text.setText(true);

        tv13AText.setText(true);

        tv13BText.setText(true);

        tv13CText.setText(true);

        tv13DText.setText(true);

        tv13AText.setText(true);

        tvGuide14Text.setText(true);

        tvGuide15Text.setText(true);

        tvGuide16Text.setText(true);

        tvGuide17Text.setText(true);

        tvDefinitionsProgram1Text.setText(true);

        tv13ProgramAText.setText(true);

        tv13ProgramBText.setText(true);

        tv13ProgramDText.setText(true);

        tv13ProgramEText.setText(true);

        tvDefinitionsGuide2Text.setText(true);

        tvDefinitionsGuide3Text.setText(true);

        tvDefinitionsGuide4Text.setText(true);


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

    public void fonts() {

        tf = Typeface.createFromAsset(l_context.getAssets(), "fonts/OpenSans_Regular.ttf");

//        TextView[] jake = {titleCodeOfConduct,titleHowToUseTheCode};
//
//        for (TextView v : jake){
//            v.setTypeface(tf);
//        }
//

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
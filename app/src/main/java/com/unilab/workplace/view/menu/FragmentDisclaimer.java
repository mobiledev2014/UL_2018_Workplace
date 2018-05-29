package com.unilab.workplace.view.menu;

import android.app.Dialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.unilab.workplace.R;
import com.unilab.workplace.Utitlities.CustomDialog;
import com.unilab.workplace.constants.Constants;
import com.unilab.workplace.controller.FragmentController;
import com.unilab.workplace.database.table.EmpTable;
import com.unilab.workplace.retrofit.API.EmployeeIdResult;
import com.unilab.workplace.retrofit.API.WorkplacePostUserAgreementInterFaceApi;
import com.unilab.workplace.view.codeofconduct.CodeOfConductList;
import com.unilab.workplace.view.codeofconduct.FragmentBusinessAndTransactionalIntegrity;
import com.unilab.workplace.view.codeofconduct.FragmentBusinessAndWorkplaceConduct;
import com.unilab.workplace.view.codeofconduct.FragmentCompanyPropertyAndPropertyRights;
import com.unilab.workplace.view.codeofconduct.FragmentHandlingInformation;
import com.unilab.workplace.view.codeofconduct.FragmentHealthAndSanitation;
import com.unilab.workplace.view.codeofconduct.FragmentOtherPolicies;
import com.unilab.workplace.view.codeofconduct.FragmentProductivity;
import com.unilab.workplace.view.codeofconduct.FragmentSafetyAndSecurity;
import com.unilab.workplace.view.codeofconduct.FragmentUnauthorizedActivities;
import com.unilab.workplace.view.codeofconduct.HowToUseCode;
import com.unilab.workplace.view.grievancehandling.FragmentConfidentialityOfInformation;
import com.unilab.workplace.view.grievancehandling.FragmentGrievanceHandlingProcess;
import com.unilab.workplace.view.grievancehandling.FragmentGrievanceHandlingProcessList;
import com.unilab.workplace.view.grievancehandling.FragmentMediationMeeting;
import com.unilab.workplace.view.grievancehandling.FragmentOthers;
import com.unilab.workplace.view.grievancehandling.FragmentRolesAndResponsibilities;
import com.unilab.workplace.view.handlingadministrative.FragmentAdministrativeHearingProcess;
import com.unilab.workplace.view.handlingadministrative.FragmentAdministrativeOther;
import com.unilab.workplace.view.handlingadministrative.FragmentDisciplinaryProcedures;
import com.unilab.workplace.view.handlingadministrative.FragmentDivisionalDisciplinaryCommittee;
import com.unilab.workplace.view.handlingadministrative.FragmentEnforcementOfPenalties;
import com.unilab.workplace.view.handlingadministrative.FragmentEvidenceHandling;
import com.unilab.workplace.view.handlingadministrative.FragmentHandlingAdministrativeList;
import com.unilab.workplace.view.handlingadministrative.FragmentLegalAdvice;
import com.unilab.workplace.view.handlingadministrative.FragmentTheEmployeeDisciplineBoard;
import com.unilab.workplace.view.otherpolicies.FragmentOtherPoliciesAntiHarassmentPolicy;
import com.unilab.workplace.view.otherpolicies.FragmentOtherPoliciesBreast;
import com.unilab.workplace.view.otherpolicies.FragmentOtherPoliciesDigitized;
import com.unilab.workplace.view.otherpolicies.FragmentOtherPoliciesList;
import com.unilab.workplace.view.otherpolicies.FragmentOtherPoliciesModule;
import com.unilab.workplace.view.otherpolicies.FragmentOtherPoliciesPolicyOnBusinessConduct;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentDisclaimer extends Fragment implements Callback<EmployeeIdResult> {

    View view;
    Context l_context;
    Typeface tf;
    @Bind(R.id.btn_agreement)
    Button btnAgreement;

    @Bind(R.id.iv_back)
    ImageView ivBack;

    @Bind(R.id.btn_logout)
    Button btnLogin;

    public String TAG = this.getClass().getSimpleName();
    TextView tv_header_confirm;
    TextView tv_prompt_confirm;
    String act = "";
    ProgressDialog dialog3;
    Dialog dialog, dialog2;
    Button btn_ok_confirm, btn_no;
    ImageView iv_close;

    public EmpTable empTable;
    public FragmentMain fragmentMain;
    public static final String TAG_FRAGMENTDISCLAIMER = "FRAGMENTDISCLAIMER";
    boolean btn_logout = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        view = inflater.inflate(R.layout.fragment_layout_disclaimer, container, false);

        l_context = getActivity();
        ButterKnife.bind(this, view);

        empTable = new EmpTable(l_context);
        fragmentMain = new FragmentMain();

        dialog = new Dialog(l_context);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_yesno);
        dialog.setContentView(R.layout.dialog_logout);


        //acknowledge
        dialog2 = new Dialog(l_context);
        dialog2.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog2.setContentView(R.layout.dialog_agreementno);

        return view;
    }
    /**
     * Updated by: Alvin Raygon 10/7/16
     * */
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

    //logout

    public void dialog_confirm2(Context context, String header1, String prompt1,
                                String action1) {
        this.act = action1;
        tv_header_confirm = (TextView) dialog.findViewById(R.id.tv_header);
        tv_prompt_confirm = (TextView) dialog.findViewById(R.id.tv_prompt);
        btn_ok_confirm = (Button) dialog.findViewById(R.id.btn_ok);
        btn_no = (Button) dialog.findViewById(R.id.btn_no);

        tv_header_confirm.setText(header1);
        tv_prompt_confirm.setText(prompt1);

        if (btn_logout)
        {
            btn_ok_confirm.setText("Yes");
            btn_logout = false;
        }


        btn_ok_confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //c_alraygon Sept 27, 2016
                //clear all temporary data upon user logout
                Constants.t_didDialogShowedUp = false;
                Constants.t_birthdateholder = null;
//                Constants.t_id
//                Constants.t_birthdate
                FragmentController.replaceFragment(getFragmentManager(), new FragmentLogin());
                dialog.dismiss();
            }

        });
        btn_no.setText("No");
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
    //agreement dialog
    public void dialog_agreement(Context context, String header, String prompt,
                                 String action) {
        empTable.getEmp_Agreement(Constants.t_id);
//        Log.d(TAG_FRAGMENTDISCLAIMER,"empTable.getEmp_Agreement(Constants.t_id)="+empTable.getEmp_Agreement(Constants.t_id));
        this.act = action;
        tv_header_confirm = (TextView) dialog2.findViewById(R.id.tv_header);
        tv_prompt_confirm = (TextView) dialog2.findViewById(R.id.tv_prompt);
        btn_ok_confirm = (Button) dialog2.findViewById(R.id.btn_ok);
        iv_close = (ImageView) dialog2.findViewById(R.id.iv_close);

        tv_header_confirm.setText(header);
        tv_prompt_confirm.setText(prompt);
//Validation:
        //disable btn if user already agreed/concur to the terms or agreement
        if (Constants.t_empagreement.equals("0")||empTable.getEmp_Agreement(Constants.t_id).equals("0")) {
//            Log.d(TAG_FRAGMENTDISCLAIMER,"Constants.t_empagreement"+Constants.t_empagreement);
            btn_ok_confirm.setEnabled(false);
            btn_ok_confirm.setBackgroundColor(Color.GRAY);
            iv_close.setEnabled(true);
            iv_close.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    FragmentController.replaceFragment(getFragmentManager(), new FragmentDisclaimer());
                    dialog2.dismiss();
                }

            });
        } else {
            btn_ok_confirm.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    dialog3 = new ProgressDialog(l_context);
                    dialog3.setMessage("Acknowledging... Please wait.");
                    dialog3.setCancelable(false);
                    dialog3.show();
                    //postagreement

                    Call<EmployeeIdResult> call = initializeRetrofitAgreementDisclaimer().postAgreement(Constants.t_id,"0");
                    call.enqueue(FragmentDisclaimer.this);
                }

            });
            iv_close.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    FragmentController.replaceFragment(getFragmentManager(), new FragmentDisclaimer());
                    dialog2.dismiss();

                }

            });
            dialog2.setCancelable(false);
        }
        dialog2.show();
    }

    @OnClick({R.id.btn_agreement, R.id.btn_logout, R.id.iv_back})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_agreement:
                String header = "Acknowledgement";
                String question = "I hereby acknowledge and certify that I have read and fully understood the contents of this application. I hereby declare and undertake that I shall at all times uphold and abide by the contents of the said policies and guidelines.\n\nFurther, I acknowledge that in case of separation, this application will be uninstalled from my electronic device.";
                String action = "update";
                dialog_agreement(l_context, header, question, action);

                break;
            case R.id.btn_logout:

//                Utils.toast(l_context,"Disclaimer");
                String header1 = "Logout";
                String question1 = "Are you sure you want to logout?";
                String action1 = "update";
                btn_logout = true;
                dialog_confirm2(l_context, header1, question1, action1);

                break;
            case R.id.iv_back:
                fragmentId(Constants.backToPage);

                break;

        }
    }
    //c_alraygon
    //workaround in Back btn functionality, goingbackto last visited fragment, base on global variables
    public void fragmentId(int position) {
        switch (position) {
            case 0:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentMain());
                break;
            case 1:
                FragmentController.replaceFragment(getFragmentManager(), new CodeOfConductList());
                break;
            case 2:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentBusinessAndTransactionalIntegrity());
                break;
            case 3:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentBusinessAndWorkplaceConduct());
                break;
            case 4:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentCompanyPropertyAndPropertyRights());
                break;
            case 5:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentHandlingInformation());
                break;
            case 6:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentHealthAndSanitation());
                break;
            case 7:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentOtherPolicies());
                break;
            case 8:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentProductivity());
                break;
            case 9:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentSafetyAndSecurity());
                break;
            case 10:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentUnauthorizedActivities());
                break;
            case 11:
                FragmentController.replaceFragment(getFragmentManager(), new HowToUseCode());
                break;
            //grievancehandling
            case 12:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentConfidentialityOfInformation());
                break;
            case 13:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentGrievanceHandlingProcess());
                break;
            case 14:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentGrievanceHandlingProcessList());
                break;
            case 15:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentMediationMeeting());
                break;
            case 16:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentOthers());
                break;
            case 17:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentRolesAndResponsibilities());
                break;
            //handlingadministrative
            case 18:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentAdministrativeHearingProcess());
                break;
            case 19:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentAdministrativeOther());
                break;
            case 20:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentConfidentialityOfInformation());
                break;
            case 21:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentDisciplinaryProcedures());
                break;
            case 22:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentDivisionalDisciplinaryCommittee());
                break;
            case 23:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentEnforcementOfPenalties());
                break;
            case 24:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentEvidenceHandling());
                break;
            case 25:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentHandlingAdministrativeList());
                break;
            case 26:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentLegalAdvice());
                break;
            case 27:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentTheEmployeeDisciplineBoard());
                break;
            //otherpolicies
            case 28:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentOtherPoliciesAntiHarassmentPolicy());
                break;
            case 29:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentOtherPoliciesDigitized());
                break;
            case 30:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentOtherPoliciesList());
                break;
            case 31:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentOtherPoliciesModule());
                break;//FragmentOtherPoliciesBreast
            case 32:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentOtherPoliciesBreast());
                break;
            case 33:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentSearch());
                break;
            case 34:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentOtherPoliciesPolicyOnBusinessConduct());
                break;
        }

    }
    public static WorkplacePostUserAgreementInterFaceApi initializeRetrofitAgreementDisclaimer() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://161.202.23.41/").addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        WorkplacePostUserAgreementInterFaceApi interfaceApi = retrofit.create(WorkplacePostUserAgreementInterFaceApi.class);
        //Log.i("j2", "j2");
        return interfaceApi;
    }

    @Override
    public void onResponse(Call<EmployeeIdResult> call, Response<EmployeeIdResult> response) {
        //Log.d(TAG,"onResponse");
        dialog2.dismiss();
        dialog3.dismiss();
//        empTable.updateEmp_Specifics(Constants.t_empagreement,Constants.t_id);
                        String title = "Confirmation";
                        String msg = "You have already agreed.";
                        Constants.t_empagreement ="0";
                        empTable.updateEmp_Specifics(Constants.t_empagreement,Constants.t_id);
                        CustomDialog alertDialog = new CustomDialog(l_context, title,
                                msg);
                        alertDialog.show();
    }
    @Override
    public void onFailure(Call<EmployeeIdResult> call, Throwable throwable) {
        //Log.e(TAG,"onFailure");
        dialog2.dismiss();
        dialog3.dismiss();
        String title = "Error";
        String msg = "Check your configuration settings \n and try again.";

        CustomDialog alertDialog = new CustomDialog(l_context, title,
                msg);

        alertDialog.show();

    }
}
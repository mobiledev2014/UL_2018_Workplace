package com.unilab.workplace.view.menu;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.unilab.workplace.R;
import com.unilab.workplace.Utitlities.Utils;
import com.unilab.workplace.constants.Constants;
import com.unilab.workplace.controller.FragmentController;
import com.unilab.workplace.database.model.SearchModel;
import com.unilab.workplace.database.table.ContentTable;
import com.unilab.workplace.database.table.EmpTable;
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
import com.unilab.workplace.view.grievancehandling.FragmentGrievanceHandlingProcess;
import com.unilab.workplace.view.grievancehandling.FragmentMediationMeeting;
import com.unilab.workplace.view.grievancehandling.FragmentOthers;
import com.unilab.workplace.view.grievancehandling.FragmentRolesAndResponsibilities;
import com.unilab.workplace.view.handlingadministrative.FragmentAdministrativeHearingProcess;
import com.unilab.workplace.view.handlingadministrative.FragmentAdministrativeOther;
import com.unilab.workplace.view.handlingadministrative.FragmentConfidentialityOfInformation;
import com.unilab.workplace.view.handlingadministrative.FragmentDisciplinaryProcedures;
import com.unilab.workplace.view.handlingadministrative.FragmentDivisionalDisciplinaryCommittee;
import com.unilab.workplace.view.handlingadministrative.FragmentEnforcementOfPenalties;
import com.unilab.workplace.view.handlingadministrative.FragmentEvidenceHandling;
import com.unilab.workplace.view.handlingadministrative.FragmentLegalAdvice;
import com.unilab.workplace.view.handlingadministrative.FragmentTheEmployeeDisciplineBoard;
import com.unilab.workplace.view.otherpolicies.FragmentOtherPoliciesAntiHarassmentPolicy;
import com.unilab.workplace.view.otherpolicies.FragmentOtherPoliciesBreast;
import com.unilab.workplace.view.otherpolicies.FragmentOtherPoliciesDigitized;
import com.unilab.workplace.view.otherpolicies.FragmentOtherPoliciesModule;
import com.unilab.workplace.view.otherpolicies.FragmentOtherPoliciesPolicyOnBusinessConduct;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentSearch extends Fragment {

    public String TAG = this.getClass().getSimpleName();

    View view;

    Context l_context;

    @Bind(R.id.iv_logout)
    ImageView iv_logout;


    ProgressDialog progress;

    @Bind(R.id.fragment_id_menu)
    RelativeLayout fragmentIdMenu;

    @Bind(R.id.iv_back)
    ImageView iv_back;


    @Bind(R.id.lv_list)
    ListView LvListView;

    @Bind(R.id.llt_dropdown)
    LinearLayout dropdown;

    @Bind(R.id.edt_search)
    EditText edt_search;

    String t_id, temp_agreement;

    ContentTable contentTable;

    ArrayList<String> sc_name = new ArrayList<>(); //subcategory name
    ArrayList<String> sc_id = new ArrayList<>();//sub category id
    ArrayList<String> sc_title_desc = new ArrayList<>();//title desc
    ArrayList<String> sc_content = new ArrayList<>();//content

    public CountDownTimer CDT;
    public ProgressDialog TempDialog;
    public int i = 5;
    public EmpTable obj_EmpTable;

    AdapterSearch adapterSearch;
    ArrayList<SearchModel> arr_search;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_layout_search, container, false);
        l_context = getActivity();
        ButterKnife.bind(this, view);

        contentTable = new ContentTable(l_context);
        obj_EmpTable = new EmpTable(l_context);
        arr_search = new ArrayList<>();
        arr_search.clear();
        adapterSearch = new AdapterSearch(l_context, arr_search);

        //Log.d(TAG, "searching for:" + Constants.search_string);
        setDataOnViews();

        Constants.backToPage = 33;
        return view;
    }

    //prepare the view
    private void setDataOnViews() {
        String x;
        //workaround to prevent apostrophe in sql execute
        if(Constants.search_string.contains("\'")){

            String temp = Constants.search_string;
            x = temp.replace("\'","\'\'");
            //Log.d(TAG,"temp:"+x);
            //Log.d(TAG,"OriginalString:"+Constants.search_string);
            executeSearch(x);
        }else{
            executeSearch(Constants.search_string);
            //Log.d(TAG,"you are safe:"+Constants.search_string);
        }
    }

    public void executeSearch(String searchString)
    {


        arr_search = contentTable.doSearch(searchString);

        if (arr_search.size() <= 0) {
            SearchModel sModel = new SearchModel();
            sModel.setDescription("");
            sModel.setCat_id("No result/s found.");
            sModel.setId("");
            sModel.setTitle_desc("");
            arr_search.add(sModel);
        } else {
            Utils.toast(l_context, arr_search.size() + " Result/s found.");
        }
        adapterSearch = new AdapterSearch(l_context, arr_search);
        LvListView.setAdapter(adapterSearch);
        adapterSearch.notifyDataSetChanged();

        //handle clicks
        LvListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onItemClick(AdapterView<?> adapterView, View arg1,
                                    int position, long arg3) {

                if (!arr_search.get(position).getCat_id().equals("No result/s found."))
                {
                    String c = arr_search.get(position).getCat_id();
                    lookupFragment(c);
                }
            }
        });

    }

    //proceed to page
    public void lookupFragment(String sub_cat_id) {
        int d = Integer.parseInt(sub_cat_id);
        switch (d) {
            case 1:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentHealthAndSanitation());
                break;
            case 2:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentSafetyAndSecurity());
                break;
            case 3:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentCompanyPropertyAndPropertyRights());
                break;
            case 4:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentBusinessAndWorkplaceConduct());

                break;
            case 5:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentProductivity());
                break;
            case 6:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentHandlingInformation());
                break;
            case 7:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentBusinessAndTransactionalIntegrity());

                break;
            case 8:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentUnauthorizedActivities());
                break;
            case 9:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentOtherPolicies());
                break;
            case 10:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentDisciplinaryProcedures());
                break;
            case 11:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentDivisionalDisciplinaryCommittee());

                break;
            case 12:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentTheEmployeeDisciplineBoard());

                break;
            case 13:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentEvidenceHandling());
                break;
            case 14:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentAdministrativeHearingProcess());

                break;
            case 15:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentConfidentialityOfInformation());

                break;
            case 16:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentLegalAdvice());
                break;
            case 17:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentEnforcementOfPenalties());

                break;
            case 18:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentAdministrativeOther());

                break;
            case 19:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentGrievanceHandlingProcess());

                break;
            case 20:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentRolesAndResponsibilities());

                break;
            case 21:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentMediationMeeting());

                break;
            case 22:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new com.unilab.workplace.view.grievancehandling.FragmentConfidentialityOfInformation());
                break;
            case 23:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentOthers());

                break;
            case 24:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentOtherPoliciesModule());
                break;
            case 25:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentOtherPoliciesAntiHarassmentPolicy());

                break;
            case 26:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentOtherPoliciesDigitized());

                break;
            case 27:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentOtherPoliciesBreast());

                break;
            case 28:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new HowToUseCode());

                break;
            case 29:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentOtherPoliciesPolicyOnBusinessConduct());

                break;


            default:
                //showProgressBar();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentMain());
        }
    }

    public void clearAllArrayListSearch() {
        sc_name.clear();
        sc_id.clear(); //sub category id
        sc_title_desc.clear(); //title desc
        sc_content.clear();
    }

    /**
     * Updated by: Alvin Raygon 10/14/16
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

    @OnClick({R.id.iv_logout, R.id.iv_back})

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_logout:
                FragmentController.replaceFragment(getFragmentManager(), new FragmentDisclaimer());
                break;


            case R.id.iv_back:
                //lets clear the data
                clearAllArrayListSearch();
                FragmentController.replaceFragment(getFragmentManager(), new FragmentMain());

                break;

        }
    }


}
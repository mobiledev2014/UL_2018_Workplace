package com.unilab.workplace.controller;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.unilab.workplace.R;


public class FragmentController {

    public static void replaceFragment(FragmentManager fm, Fragment fragment) {

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.llt_fragmentmain, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_NONE);
        ft.addToBackStack(null);
        ft.commit();

    }

    public static void addFragment(FragmentManager fm, Fragment fragment) {

        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.llt_fragmentmain, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_NONE);
        ft.addToBackStack(null);
        ft.commit();

    }

}

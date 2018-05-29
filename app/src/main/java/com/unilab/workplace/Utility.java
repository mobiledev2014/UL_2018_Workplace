package com.unilab.workplace;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;


/**
 * Created by Rachel on 24 Jul 2016.
 */
public class Utility {
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService( Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }


/*    public void PdfReader(PDFView pdfView, String Path, int page) {

        pdfView.fromAsset(Path) // all pages are displayed by default
                .enableSwipe(true)
                .enableDoubletap(true)
                .swipeVertical(true)
                .defaultPage(page)
                .showMinimap(false)
//                .showPageWithAnimation(true)
                .load();

    }*/
}

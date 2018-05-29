/* 
 *	Created by Rhys Anton Gabion April 13, 2015
 *	Copyright (c) Unilab. All rights reserved.
 */
package com.unilab.workplace.Utitlities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;

import com.unilab.workplace.constants.Button;

/**
 * @author c_glparreno
 *
 */
/**
 * @author c_glparreno
 *
 */
/**
 * @author c_glparreno
 *
 */
/**
 * @author c_glparreno
 *
 */
/**
 * @author c_glparreno
 *
 */
/**
 * @author c_glparreno
 *
 */
public class DialogUtil {

	/**
	 * create an error dialog - Default value of button is "OK"
	 * @param context
	 * @param title - title of dialog
	 * @param message - message of dialog
	 * @return dialog - you need to use ".show()" method to display this dialog
	 */
	public static Dialog createErrorDialog(Context context , String title, String message ) {
	
		AlertDialog.Builder builder = new AlertDialog.Builder( context );
		builder.setTitle( title );
		builder.setMessage( message );
		builder.setPositiveButton( Button.OK , null );
		
		return builder.create();
	
	}
	
	/**
	 * Create a progress dialog - usable when connecting to web 
	 * service combined with asynchronous task
	 * @param context
	 * @param title - title of dialog
	 * @param message - message (e.g., Connecting to web service)
	 * @param maxProgress - max value of progress
	 * @return ProgressDialog 
	 * 
	 */
	public static ProgressDialog createProgressDialog( Context context, String title , String message , int maxProgress ) {
		
		ProgressDialog dialog = new ProgressDialog( context );
		dialog.setTitle( title );
		dialog.setMessage( message );
		dialog.setCancelable( false );
		dialog.setProgressStyle( ProgressDialog.STYLE_HORIZONTAL );
		dialog.setProgress( 0 );
		dialog.setMax( maxProgress );
		
		return dialog;
		
	}
	
	
	
	/**
	 * Create a confirmation dialog
	 * @param context
	 * @param title - title of dialog
	 * @param message - message of dialog
	 * @param listener - handles the positive button
	 * @return Dialog
	 */
	public static Dialog createConfirmationDialog(Context context , String title , String message , final OnClickListener listener) {
		
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
		dialogBuilder.setTitle(title);
		dialogBuilder.setMessage(message);
		dialogBuilder.setCancelable(false);
		dialogBuilder.setPositiveButton( "OK" , new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				listener.onClick(dialog, Dialog.BUTTON_POSITIVE );
			}
		} );
		dialogBuilder.setNegativeButton( "Cancel" , new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				listener.onClick(dialog, Dialog.BUTTON_NEGATIVE );
			}
		} );
		
		return dialogBuilder.create();
	}
	
	/**
	 * Create a dialog that handles the names of positive and negative buttons and handles listener to positive button press
	 * @param context
	 * @param title - title of dialog 
	 * @param message - message of dialog
	 * @param button1 - positive button name 
	 * @param button2 - negative button name
	 * @param listener - handles positive button press
	 * @return Dialog
	 */
	public static Dialog createConfirmationDialog(Context context , String title , String message , String button1, String button2, final OnClickListener listener) {
		
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
		dialogBuilder.setTitle(title);
		dialogBuilder.setMessage(message);
		dialogBuilder.setCancelable(false);

		dialogBuilder.setPositiveButton( button1 , new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				listener.onClick(dialog, Dialog.BUTTON_POSITIVE );
			}
		} );
		dialogBuilder.setNegativeButton( button2 , new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				listener.onClick(dialog, Dialog.BUTTON_NEGATIVE );
			}
		} );
		
		return dialogBuilder.create();
	}

    /**
     * Create a dialog that handles the names of positive and negative buttons and handles listener to positive and negative button press
     * @param context
     * @param title - title of dialog 
	 * @param message - message of dialog
	 * @param button1 - positive button name 
	 * @param button2 - negative button name
	 * @param listener - handles positive button press
     * @param dismiss - handles the dismissal of dialog
     * @return
     */
    public static Dialog createConfirmationDialog(Context context , String title , String message , String button1, String button2, final OnClickListener listener, final OnClickListener dismiss) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setTitle(title);
        dialogBuilder.setMessage(message);
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton( button1 , new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onClick(dialog, Dialog.BUTTON_POSITIVE );
            }
        } );
        dialogBuilder.setNegativeButton( button2 , new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss.onClick(dialog, Dialog.BUTTON_NEGATIVE );
            }
        } );

        return dialogBuilder.create();
    }
	
	/**
	 * Create an alert dialog that automatically shows
	 * @param context
	 * @param title - title of alert dialog
	 * @param message - message of alert dialog
	 * @param listener - handles the on press of button
	 */
	public static void showAlertDialog(Context context, String title, String message, OnDismissListener listener) {
		
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
		dialogBuilder.setTitle(title);
		dialogBuilder.setMessage(message);
		dialogBuilder.setCancelable(false);
		dialogBuilder.setPositiveButton("OK", new OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
									dialog.dismiss();
								}
								   
							   });
		
		AlertDialog dialog = dialogBuilder.create();
		dialog.setOnDismissListener(listener);
		dialog.show();				   	
		
	}
	
	/**
	 * Create an alert dialog without title that automatically shows
	 * 
	 * @param context
	 * @param message - message of alert dialog
	 * @param listener - on click handler
	 */
	public static void showAlertDialog(Context context, String message, OnDismissListener listener) {
		
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
		dialogBuilder.setMessage(message);
		dialogBuilder.setCancelable(false);
		dialogBuilder.setPositiveButton("OK", new OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
									dialog.dismiss();
								}
								   
							   });
		
		AlertDialog dialog = dialogBuilder.create();
		dialog.setOnDismissListener(listener);
		dialog.show();				   	
		
	}
	
	/**
	 * Create an alert dialog without title and changeable button name that automatically shows
	 * @param context
	 * @param message - message of alert dialog
	 * @param listener - on click listener of alert dialog
	 * @param buttonName - positive button name
	 */
	public static void showAlertDialog(Context context, String message, OnDismissListener listener, String buttonName ) {
		
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
		dialogBuilder.setMessage(message);
		dialogBuilder.setCancelable(false);
		dialogBuilder.setPositiveButton( buttonName , new OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
									dialog.dismiss();
								}
								   
							   });
		
		AlertDialog dialog = dialogBuilder.create();
		dialog.setOnDismissListener(listener);
		dialog.show();				   	
		
	}
	
	/**
	 * Create an alert dialog with changeable button name that automatically shows
	 * @param context
	 * @param title - title of alert dialog
	 * @param message - message of alert dialog
	 * @param buttonName - positive button name
	 * @param listener - on click listener of alert dialog
	 
	 */
	public static void showAlertDialog(Context context, String title , String message, String buttonName, OnDismissListener listener ) {
		
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
		dialogBuilder.setTitle(title);
		dialogBuilder.setMessage(message);
		dialogBuilder.setCancelable(false);
		dialogBuilder.setPositiveButton( buttonName , new OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
									dialog.dismiss();
								}
								   
							   });
		
		AlertDialog dialog = dialogBuilder.create();
		dialog.setOnDismissListener(listener);
		dialog.show();				   	
		
	}

}

/* 
 *	Created by Rhys Anton Gabion April 13, 2015
 *	Copyright (c) Unilab. All rights reserved.
 */
package com.unilab.workplace.Utitlities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

	
	/* Helper methods for getting dates */
	public static String getDate(String format, long timestamp) {
		SimpleDateFormat dateFormat = new SimpleDateFormat( format, Locale.US );
        return dateFormat.format( new Date(timestamp) );
	}
	public static String getDate(String format, Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat( format, Locale.US );
        return dateFormat.format( date );
	}
	
	public static String getDate(String format, Date date, Locale locale) {
		SimpleDateFormat dateFormat = new SimpleDateFormat( format,locale );
        return dateFormat.format( date );
	}
	
	/* function to parse string to date format */
	public static Date parseDate(String format,String date) {
		try {
			if(date == ""){
				date = "0";
			}
			return new SimpleDateFormat(format,Locale.US).parse( date );

		}
		catch(ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/* Helper methods for getting dates */
	public static String getDateLocale(String format, long timestamp, Locale local) {
		SimpleDateFormat dateFormat = new SimpleDateFormat( format, local );
        return dateFormat.format( new Date(timestamp) );
	}
	
	public static String getDateLocale(String format, Date date, Locale local) {
		SimpleDateFormat dateFormat = new SimpleDateFormat( format, local );
        return dateFormat.format( date );
	}
	
	/* function to parse string to date format */
	public static Date parseDateLocale(String format,String date, Locale local) {
		try {
			return new SimpleDateFormat(format,local).parse( date );
		}
		catch(ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/* function to convert date */
	public static Calendar getDatePart(Date date){
	    Calendar cal = Calendar.getInstance();       // get calendar instance
	    cal.setTime(date);      
	    cal.set(Calendar.HOUR_OF_DAY, 0);            // set hour to midnight
	    cal.set(Calendar.MINUTE, 0);                 // set minute in hour
	    cal.set(Calendar.SECOND, 0);                 // set second in minute
	    cal.set(Calendar.MILLISECOND, 0);            // set millisecond in second

	    return cal;                                  // return the date part
	}
	
	/* function to compute date difference for updating */
	public static int daysBetween(Date startDate, Date endDate) {
		  Calendar sDate = getDatePart(startDate);
		  Calendar eDate = getDatePart(endDate);

		  int daysBetween = 0;
		  while ( sDate.before(eDate) ) {
		      sDate.add( Calendar.DAY_OF_MONTH, 1 );
		      daysBetween++;
		  }
		  return daysBetween;
	}
	
	/**	function to get the count of the compared dates	**/
	public static long compareDates( Date startDate , Date endDate ) {
		Calendar sDate	= getDatePart( startDate );
		Calendar eDate	= getDatePart( endDate );
		
		long milis1 = sDate.getTimeInMillis();
        long milis2 = eDate.getTimeInMillis();
        
        long diff = milis2 - milis1;
        
        long diffDays = diff / (24 * 60 * 60 * 1000);
        
        return diffDays;
	}
	
	public static String getDate(String format, long timestamp, Locale locale ) {
		SimpleDateFormat dateFormat = new SimpleDateFormat( format, locale );
        return dateFormat.format( new Date(timestamp) );
	}
}

package com.israluci.ch04objectsandclasses.ex01;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateComparor
{
    static int count = 0;


    public int computeDaysBetweenDates( Date first, Date second )
    {

        GregorianCalendar date = new GregorianCalendar();
        date.setTime( first );

        GregorianCalendar date2 = new GregorianCalendar();
        date2.setTime( second );

        int daysBetween = 0;
        while ( date.before( date2 ) ) {
            date.add( Calendar.DAY_OF_MONTH, 1 );
            daysBetween++;
        }

        while ( date2.before( date ) ) {
            date2.add( Calendar.DAY_OF_MONTH, 1 );
            daysBetween++;
        }

        count++;
        return daysBetween;
    }

    public int computeMonthsBetweenDates( Date first, Date second )
    {
    	GregorianCalendar date = new GregorianCalendar();
        date.setTime( first );

        GregorianCalendar date2 = new GregorianCalendar();
        date2.setTime( second );

        int numOfMonths = 0;
        if (date.before( date2 )){
	        while ( date.before( date2 ) ) {	        	
	        	date.add( Calendar.MONTH, 1 );
	            //System.out.println(numOfMonths++);
	        	numOfMonths++;
	        }
        }else{
	        while ( date2.before( date ) ) {	        	
	            date2.add( Calendar.MONTH, 1 );
	            //System.out.println(numOfMonths++);
	            numOfMonths++;
	        }
        }
        count++;
        return numOfMonths;
    }


    public int computeYearsBetweenDates( Date first, Date second )
    {
        GregorianCalendar calendar = new GregorianCalendar();

        // Since Date doesn't know about calendars. A calendar object is
        // needed to retrieve day, month and year.
        calendar.setTime( first );
        int firstYear = calendar.get( Calendar.YEAR );

        // System.out.println(firstYear);
        calendar.setTime( second );
        int secondYear = calendar.get( Calendar.YEAR );
        // System.out.println(secondYear);
        int diff = 0;
        if ( secondYear > firstYear )
            diff = secondYear - firstYear;
        else
            diff = firstYear - secondYear;

        count++; // getNumberOfCallsToCompute();
        return diff;
    }


    public static int getNumberOfCallsToCompute()
    {
        return count;
    }
}

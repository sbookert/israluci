package com.israluci.ch04objectsandclasses.ex01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class DateComparorTest
{
    public static void main( String[] args )
    {
        // Declarations and initializations
        SimpleDateFormat sdf = new SimpleDateFormat( "MM/dd/yyyy" ); // Month,day,year
        Scanner s1 = new Scanner( System.in );
        String input;
        DateComparor dateComp = new DateComparor();

        System.out.println( "Hello, insert 2 or more dates separated by commas:" );
        input = s1.nextLine();

        // Split string based on delimeter
        String[] input2 = input.split( "," );
        System.out.println( "\nThanks!\n" );

        // for (String e:input2)
        // System.out.println(e);

        // Declare array to hold dates based on number of splits
        Date[] datesEntered = new Date[input2.length];
        for ( int i = 0; i < datesEntered.length; i++ ) {
            try {
                // System.out.println(sdf.parse(input2[i]));
                datesEntered[i] = sdf.parse( input2[i] );
            } catch ( ParseException e ) {
                // TODO Auto-generated catch block
                System.out.println( "Please make sure to enter dates in MM/dd/yyyy format." );
                // e.printStackTrace();
            }
        }// end of for loop

        int numOfDays = 0, numOfMonths = 0, numOfYears = 0, j = 1;

        //System.out.println( "datesEntered.length: " + datesEntered.length );
        for ( int i = 0; i < datesEntered.length - 1; i++ ) {

            numOfDays = dateComp.computeDaysBetweenDates( datesEntered[i], datesEntered[j] );
            numOfMonths = dateComp.computeMonthsBetweenDates( datesEntered[i], datesEntered[j] );
            numOfYears = dateComp.computeYearsBetweenDates( datesEntered[i], datesEntered[j] );

            System.out.println( "There is/are the number of day(s) between date " + input2[i] + " and " + input2[j] + " : "
                + numOfDays );

            System.out.println( "There is/are the number of month(s) between date " + input2[i] + " and " + input2[j] + " : "
                + numOfMonths );

            System.out.println( "There is/are the number of year(s) between date " + input2[i] + " and " + input2[j] + " : "
                + numOfYears );
            j++;
            System.out.println();
        }// end of for loop

        System.out.println( "Class DateComparor received " + DateComparor.getNumberOfCallsToCompute()
            + " calls to the compute methods." );
        s1.close(); // close scanner
        System.out.println( "\nBye!\n" );
    }// EO main
}// EO DateComparorTest


class DateComparor
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

/*
    public int computeMonthsBetweenDates2( Date first, Date second )
    {
        GregorianCalendar calendar = new GregorianCalendar();

        // Since Date doesn't know about calendars. A calendar object is
        // needed to retrieve day, month and year.
        calendar.setTime( first );
        int firstMonth = calendar.get( Calendar.MONTH );

        calendar.setTime( second );
        int secondMonth = calendar.get( Calendar.MONTH );

        int diff = 0;
        //calls to computeYearsBetweenDates will add +2 to number of calls
        if ( secondMonth > firstMonth )
            diff = computeYearsBetweenDates( first, second ) * 12 + secondMonth - firstMonth;
        else
            diff = computeYearsBetweenDates( first, second ) * 12 + firstMonth - secondMonth;

        count++; // getNumberOfCallsToCompute();
        return diff;
    } */
    
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

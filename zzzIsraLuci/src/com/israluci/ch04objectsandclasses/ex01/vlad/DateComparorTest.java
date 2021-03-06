package com.israluci.ch04objectsandclasses.ex01.vlad;

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
        System.out.println( "Hello, insert 2 or more dates separated by commas:" );

        
        //get input
        Scanner s1 = new Scanner( System.in );
        String input = s1.nextLine();
        s1.close();

        
        System.out.println( "\nThanks!\n" );
        
        
        //convert the input to dates
        String[] datesAsStrings = input.split( "," );
        Date[] datesEntered = getDatesFromInput( datesAsStrings );
        
        
        //calculate and display the number of days, months, and years
        int numOfDays = 0, numOfMonths = 0, numOfYears = 0, j = 1;
        DateComparor dateComp = new DateComparor();
        for ( int i = 0; i < datesEntered.length - 1; i++, j++ ) 
        {
            numOfDays = dateComp.computeDaysBetweenDates( datesEntered[i], datesEntered[j] );
            numOfMonths = dateComp.computeMonthsBetweenDates( datesEntered[i], datesEntered[j] );
            numOfYears = dateComp.computeYearsBetweenDates( datesEntered[i], datesEntered[j] );

            printOutput( datesAsStrings[i], datesAsStrings[j], numOfDays, numOfMonths, numOfYears );
            
            System.out.println();
        }

        
        System.out.println( "Class DateComparor received " + DateComparor.getNumberOfCallsToCompute()
            + " calls to the compute methods.\nBye!\n" );
    }


    private static Date[] getDatesFromInput( String[] datesAsStrings )
    {
        SimpleDateFormat sdf = new SimpleDateFormat( "MM/dd/yyyy" );

        // create dates from each date string
        Date[] datesEntered = new Date[datesAsStrings.length];
        int index = 0;
        for ( String s : datesAsStrings ) 
        {
            try {
                datesEntered[index] = sdf.parse( s );
                index++;
            } catch ( ParseException e ) {
                System.out.println( "Please make sure to enter dates in MM/dd/yyyy format." );
            }
        }

        return datesEntered;
    }
    
    private static void printOutput(String date1, String date2, int numOfDays, int numOfMonths, int numOfYears)
    {
        System.out.println( "There is/are the number of day(s) between date " + date1 + " and " + date2 + " : " + numOfDays );
        System.out.println( "There is/are the number of month(s) between date " + date1 + " and " + date2 + " : " + numOfMonths );
        System.out.println( "There is/are the number of year(s) between date " + date1 + " and " + date2 + " : " + numOfYears );
    }
    
}


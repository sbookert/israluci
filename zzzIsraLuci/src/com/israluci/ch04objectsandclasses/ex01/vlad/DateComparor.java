package com.israluci.ch04objectsandclasses.ex01.vlad;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateComparor
{
    //keeps track how many times instance methods of this class are called
    private static int count = 0;
    
    private static final long MILLI_SECONDS_IN_ONE_DAY = 1000 * 60 * 60 * 24;

    /**
     */
    public int computeDaysBetweenDates( Date first, Date second )
    {
        int daysBetween = (int)( (second.getTime() - first.getTime()) / MILLI_SECONDS_IN_ONE_DAY );

        count++;
        return daysBetween;
    }


    public int computeMonthsBetweenDates( Date first, Date second )
    {
        GregorianCalendar calendar = new GregorianCalendar();
        
        calendar.setTime( first );
        int firstMonth = calendar.get( Calendar.MONTH );

        calendar.setTime( second );
        int secondMonth = calendar.get( Calendar.MONTH );

        int diff = 0;
        if ( secondMonth > firstMonth )
            diff = computeYearsBetweenDates( first, second ) * 12 + secondMonth - firstMonth;
        else
            diff = computeYearsBetweenDates( first, second ) * 12 + firstMonth - secondMonth;

        count++; 
        return diff;
    }


    public int computeYearsBetweenDates( Date first, Date second )
    {
        GregorianCalendar calendar = new GregorianCalendar();

        calendar.setTime( first );
        int firstYear = calendar.get( Calendar.YEAR );

        calendar.setTime( second );
        int secondYear = calendar.get( Calendar.YEAR );
        
        int diff = 0;
        if ( secondYear > firstYear )
            diff = secondYear - firstYear;
        else
            diff = firstYear - secondYear;

        count++;
        return diff;
    }


    public static int getNumberOfCallsToCompute()
    {
        return count;
    }
}

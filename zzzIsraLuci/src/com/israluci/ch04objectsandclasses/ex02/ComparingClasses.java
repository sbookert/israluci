package com.israluci.ch04objectsandclasses.ex02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.israluci.ch04objectsandclasses.ex01.DateComparor;

public class ComparingClasses
{
	public static void main( String[] args )
	{
		System.out.print( "Testing DateComparator classes with dates:" );

		//get input
		Scanner s1 = new Scanner( System.in );
		String input = s1.nextLine();
		s1.close();		

		//convert the input to dates
		String[] datesAsStrings = input.split( "," );
		Date[] datesEntered = getDatesFromInput( datesAsStrings );

		com.israluci.ch04objectsandclasses.ex01.vlad.DateComparor dateComp = new com.israluci.ch04objectsandclasses.ex01.vlad.DateComparor();
		
		System.out.println();
		System.out.println("The output below is for class: com.israluci.ch04objectsandclasses.ex01.vlad.DateComparor");
		calcTimeVlad(dateComp,datesEntered[0],datesEntered[1]);
		
		System.out.println();		
		System.out.println("The output below is for class: com.israluci.ch04objectsandclasses.ex01.DateComparor");
		DateComparor myDateComp = new DateComparor();
		calcTime(myDateComp,datesEntered[0],datesEntered[1]);	

		System.out.println();
		System.out.println("Bye!!");       
	}


	private static void calcTime(DateComparor d, Date datesEntered1, Date datesEntered2) {	

		int numOfDays = 0, numOfMonths = 0, numOfYears = 0, j = 1;
		
		// calculate the time it takes to compute days between dates
		long timeDay1=System.currentTimeMillis();
		numOfDays = d.computeDaysBetweenDates( datesEntered1, datesEntered2 );
		long timeDay2=System.currentTimeMillis();
		
		long timeForDays=timeDay2-timeDay1;
		
		// calculate the time it takes to compute months between dates
		long timeMonth1=System.currentTimeMillis();
		numOfMonths = d.computeMonthsBetweenDates( datesEntered1, datesEntered2 );
		long timeMonth2=System.currentTimeMillis();
		
		long timeForMonths=timeMonth2-timeMonth1;
		
		// calculate the time it takes to compute years between dates
		long timeYear1=System.currentTimeMillis();
		numOfYears = d.computeYearsBetweenDates( datesEntered1, datesEntered2 );
		long timeYear2=System.currentTimeMillis();
		
		long timeForYears=timeYear2-timeYear1;
		
		printOutput(timeForDays,timeForMonths,timeForYears,numOfDays,numOfMonths,numOfYears);
		
	}

	private static void calcTimeVlad(com.israluci.ch04objectsandclasses.ex01.vlad.DateComparor d, Date datesEntered1, Date datesEntered2) {	

		int numOfDays = 0, numOfMonths = 0, numOfYears = 0;
		
		// calculate the time it takes to compute days between dates
		long timeDay1=System.currentTimeMillis();
		numOfDays = d.computeDaysBetweenDates( datesEntered1, datesEntered2 );
		long timeDay2=System.currentTimeMillis();
		
		long timeForDays=timeDay2-timeDay1;
		
		// calculate the time it takes to compute months between dates
		long timeMonth1=System.currentTimeMillis();
		numOfMonths = d.computeMonthsBetweenDates( datesEntered1, datesEntered2 );
		long timeMonth2=System.currentTimeMillis();
		
		long timeForMonths=timeMonth2-timeMonth1;
		
		// calculate the time it takes to compute years between dates
		long timeYear1=System.currentTimeMillis();
		numOfYears = d.computeYearsBetweenDates( datesEntered1, datesEntered2 );
		long timeYear2=System.currentTimeMillis();
		
		long timeForYears=timeYear2-timeYear1;
		
		printOutput(timeForDays,timeForMonths,timeForYears,numOfDays,numOfMonths,numOfYears);
		
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

	private static void printOutput(long msToCalcDays, long msToCalcMonths, long msToCalcYears,int d, int m, int y)
	{			
		//calculate the mins, secs and ms it took to compute days between dates
		long secsToCalcDays=(msToCalcDays/1000)%60;
		long minsToCalcDays=(msToCalcDays/(1000*60))%60;
		msToCalcDays=msToCalcDays%1000;
		
		//calculate the mins, secs and ms it took to compute months between dates
		long secsToCalcMonths=(msToCalcMonths/1000)%60;
		long minsToCalcMonths=(msToCalcMonths/(1000*60))%60;
		msToCalcMonths=msToCalcMonths%1000;
		
		//calculate the mins, secs and ms it took to compute years between dates
		long secsToCalcYears=(msToCalcYears/1000)%60;
		long minsToCalcYears=(msToCalcYears/(1000*60))%60;
		msToCalcYears=msToCalcYears%1000;
		
		System.out.println("Method computeDaysBetweenDates was called. It ran for "+minsToCalcDays+" minutes "+secsToCalcDays+" seconds "+ msToCalcDays +" milliseconds and returned: "+d);
		System.out.println("Method computeMonthsBetweenDates was called. It executed for "+minsToCalcMonths+" minutes "+secsToCalcMonths+" seconds "+msToCalcMonths+" milliseconds and returned: "+m);
		System.out.println("Method computeYearsBetweenDates was called. It executed for "+minsToCalcYears+" minutes "+secsToCalcYears+" seconds "+msToCalcYears+" milliseconds and returned: "+y);
	}
}

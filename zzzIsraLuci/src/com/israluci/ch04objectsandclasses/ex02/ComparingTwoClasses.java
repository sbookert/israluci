package com.israluci.ch04objectsandclasses.ex02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.israluci.ch04objectsandclasses.ex01.DateComparor;

public class ComparingTwoClasses {

	public static void main(String[] args) {

		System.out.print("Testing DateComparator classes with dates:");

		// get input
		Scanner s1 = new Scanner(System.in);
		String input = s1.nextLine();
		s1.close();

		// convert the input to dates
		String[] datesAsStrings = input.split(",");
		Date[] datesEntered = getDatesFromInput(datesAsStrings);

		System.out.println();
		System.out.println("The output below is for class: com.israluci.ch04objectsandclasses.ex01.vlad.DateComparor");		

		// calculate and display the number of days, months, and years
		int numOfDays = 0, numOfMonths = 0, numOfYears = 0, j = 1;

		com.israluci.ch04objectsandclasses.ex01.vlad.DateComparor dateComp = new com.israluci.ch04objectsandclasses.ex01.vlad.DateComparor();		
		DateComparor myDateComp = new DateComparor();

		//create first date			
		GregorianCalendar t = new GregorianCalendar();						
		t=createDate();

		int min = t.get(Calendar.MINUTE);
		int sec = t.get(Calendar.SECOND);
		int msec = t.get(Calendar.MILLISECOND);

		numOfDays = dateComp.computeDaysBetweenDates(datesEntered[0],datesEntered[1]);

		//create second date
		GregorianCalendar t2 = new GregorianCalendar();			
		t2=createDate();

		int min2 = t2.get(Calendar.MINUTE);
		int sec2 = t2.get(Calendar.SECOND);
		int msec2 = t2.get(Calendar.MILLISECOND);

		//Calculate time
		int totMins = 0, totSecs = 0, totmSecs = 0;
		totMins = min - min2;
		totSecs = sec - sec2; 
		totmSecs = msec - msec2;

		printOutputDays(numOfDays,totMins, totSecs, totmSecs);

		//create first date			
		t=createDate();

		min = t.get(Calendar.MINUTE);
		sec = t.get(Calendar.SECOND);
		msec = t.get(Calendar.MILLISECOND);

		numOfMonths = dateComp.computeMonthsBetweenDates(datesEntered[0],datesEntered[1]);

		//create 2nd date			
		t2=createDate();

		min2 = t2.get(Calendar.MINUTE);
		sec2 = t2.get(Calendar.SECOND);
		msec2 = t2.get(Calendar.MILLISECOND);

		//Calculate time
		totMins = 0; totSecs = 0; totmSecs = 0;
		totMins = min - min2;
		totSecs = sec - sec2; 
		totmSecs = msec - msec2;

		printOutputMonths(numOfMonths,totMins, totSecs, totmSecs);

		//create first date
		t=createDate();

		min = t.get(Calendar.MINUTE);
		sec = t.get(Calendar.SECOND);
		msec = t.get(Calendar.MILLISECOND);

		numOfYears = dateComp.computeYearsBetweenDates(datesEntered[0],datesEntered[1]);		

		//create 2nd date
		t2=createDate();

		min2 = t2.get(Calendar.MINUTE);
		sec2 = t2.get(Calendar.SECOND);
		msec2 = t2.get(Calendar.MILLISECOND);

		//Calculate time
		totMins = 0; totSecs = 0; totmSecs = 0;
		totMins = min - min2;
		totSecs = sec - sec2; 
		totmSecs = msec - msec2;

		printOutputYears(numOfYears,totMins, totSecs, totmSecs);

		System.out.println("The output below is for class: com.israluci.ch04objectsandclasses.ex01.DateComparor");
		
		//create first date										
		t=createDate();

		min = t.get(Calendar.MINUTE);
		sec = t.get(Calendar.SECOND);
		msec = t.get(Calendar.MILLISECOND);

		numOfDays = myDateComp.computeDaysBetweenDates(datesEntered[0],datesEntered[1]);

		//create second date					
		t2=createDate();

		min2 = t2.get(Calendar.MINUTE);
		sec2 = t2.get(Calendar.SECOND);
		msec2 = t2.get(Calendar.MILLISECOND);

		//Calculate time
		totMins = 0; totSecs = 0; totmSecs = 0;
		totMins = min2 - min;
		totSecs = sec2 - sec; 
		totmSecs = msec2 - msec;

		printOutputDays(numOfDays,totMins,totSecs,totmSecs);

		//create first date			
		t=createDate();

		min = t.get(Calendar.MINUTE);
		sec = t.get(Calendar.SECOND);
		msec = t.get(Calendar.MILLISECOND);

		numOfMonths = myDateComp.computeMonthsBetweenDates(datesEntered[0],datesEntered[1]);

		//create 2nd date			
		t2=createDate();

		//calculate
		min2 = t2.get(Calendar.MINUTE);
		sec2 = t2.get(Calendar.SECOND);
		msec2 = t2.get(Calendar.MILLISECOND);

		//Calculate time
		totMins = 0; totSecs = 0; totmSecs = 0;
		totMins = min2 - min;
		totSecs = sec2 - sec; 
		totmSecs = msec2 - msec;

		printOutputMonths(numOfMonths,totMins,totSecs,totmSecs);

		//create first date
		t=createDate();

		min = t.get(Calendar.MINUTE);
		sec = t.get(Calendar.SECOND);
		msec = t.get(Calendar.MILLISECOND);

		numOfYears = myDateComp.computeYearsBetweenDates(datesEntered[0],datesEntered[1]);		

		//create 2nd date
		t2=createDate();

		min2 = t2.get(Calendar.MINUTE);
		sec2 = t2.get(Calendar.SECOND);
		msec2 = t2.get(Calendar.MILLISECOND);
		//Calculate time
		totMins = 0; totSecs = 0; totmSecs = 0;
		totMins = min2 - min;
		totSecs = sec2 - sec; 
		totmSecs = msec2 - msec;

		printOutputYears(numOfYears,totMins,totSecs,totmSecs);	
		System.out.println("Bye!");
	}	

	private static Date[] getDatesFromInput(String[] datesAsStrings) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

		// create dates from each date string
		Date[] datesEntered = new Date[datesAsStrings.length];
		int index = 0;
		for (String s : datesAsStrings) {
			try {
				datesEntered[index] = sdf.parse(s);
				index++;
			} catch (ParseException e) {
				System.out.println("Please make sure to enter dates in MM/dd/yyyy format.");
			}
		}
		return datesEntered;
	}

	private static void printOutputDays(int numOfDays,int totMins, int totSecs, int totmSecs) {
		System.out.println("Method computeDaysBetweenDates was called. It ran for "
				+ totMins + " minutes " + totSecs + " seconds " + totmSecs + " milliseconds and returned: " + numOfDays);		
	}

	private static void printOutputMonths(int numOfMonths, int totMins, int totSecs, int totmSecs) {		
		System.out.println("Method computeMonthsBetweenDates was called. It ran for "
				+ totMins + " minutes " + totSecs + " seconds " + totmSecs + " milliseconds and returned: " + numOfMonths);
	}

	private static void printOutputYears(int numOfYears, int totMins, int totSecs, int totmSecs) {	
		System.out.println("Method computeYearsBetweenDates was called. It ran for " + totMins + " minutes "
				+ totSecs + " seconds " + totmSecs + " milliseconds and returned: " + numOfYears);

	}

	private static GregorianCalendar createDate(){		
		Date d = new Date();
		GregorianCalendar t = new GregorianCalendar();	

		t.setTime(d);				
		return t;		
	}
}

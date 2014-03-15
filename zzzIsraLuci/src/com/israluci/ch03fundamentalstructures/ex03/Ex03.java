package com.israluci.ch03fundamentalstructures.ex03;

import java.util.Arrays;
import java.util.Scanner;


public class Ex03
{
    public static void main( String[] args )
    {
        Scanner s1 = new Scanner( System.in );
        String input, answer; //initialization		
        answer = "NO";//declaration

        do {
            // Read input
            System.out.println( "Hello, insert some numbers separated by commas:" );
            input = s1.nextLine();

            //Split string based on delimeter
            String[] input2 = input.split( "," );
            System.out.println( "\nThanks!\n" );

            //Declare array to hold the numbers based on number of splits
            int[] numbers = new int[input2.length];
            for ( int i = 0; i < numbers.length; i++ ) {
                numbers[i] = Integer.parseInt( input2[i] );
            }
            System.out.println( "Here is/are your number(s) in ascending order:" );
            Arrays.sort( numbers );

            //Sum the numbers and print them out to the console
            int sum = 0;
            for ( int j = 0; j < numbers.length; j++ ) {
                sum = sum + numbers[j];
                if ( j == ( numbers.length - 1 ) ) {
                    System.out.print( numbers[j] + "\n" );
                    break;
                }
                System.out.print( numbers[j] + "," );
            }
            double average; // declaration
            average = (double) sum / numbers.length; //average calculation

            System.out.println( "Here is/are your number(s) in descending order:" );

            // Reveres the sort order and prints them to the console
            for ( int i = numbers.length - 1; i >= 0; i-- ) {
                if ( i == 0 ) {
                    System.out.print( numbers[i] + "\n" );
                    break;
                }
                System.out.print( numbers[i] + "," );
            }
            //Display total numbers and average
            System.out.println( "Total number(s): " + numbers.length );
            System.out.printf( "The average is: %.2f \n", average );//fix 2 dec pts

            double median = numbers.length % 2;

            if ( median == 0 ) { // Output median based on evern/odd number
                //even
                median = (double) ( numbers[( numbers.length / 2 ) - 1] + numbers[numbers.length / 2] ) / 2;
                System.out.printf( "The median is: %.2f\n", median );
            } else {
                //odd
                median = numbers[numbers.length / 2];
                System.out.printf( "The median is: %.2f\n", median );
            }

            //User input to quit or continue
            System.out.println( "Would you like to enter a new list? (Enter YES or NO)\n" );
            answer = s1.nextLine();

        } while ( answer.equalsIgnoreCase( "yes" ) );

        System.out.println( "\nBye!\n" );
        s1.close();
    }
}

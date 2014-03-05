package com.israluci.ch03fundamentalstructures.ex02;

import java.util.Arrays;
import java.util.Scanner;

public class OrderNumbers2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		String input;		

		// Read input
		System.out.println("Hello, insert some numbers separated by commas:");
		input = s1.nextLine();
		
		//Split string based on delimeter
		String[] input2 = input.split(",");

		System.out.println("Thanks!");
		
		//Declare array to hold the numbers based on number of splits
		int[] numbers = new int[input2.length];
		for (int i=0;i<numbers.length;i++){
			numbers[i]=Integer.parseInt(input2[i]);
			System.out.print(numbers[i]+",");
		}		
		
		System.out.println("\nHere are your numbers in ascending order:");

		Arrays.sort(numbers);
		for (int n : numbers)
			System.out.print(n+",");
			
		System.out.println("\nHere are your numbers in descending order:");
			
		// Reveres the sort order
		for (int i=numbers.length-1;i>=0;i--){
			System.out.print(numbers[i]+",");
		}
			
		s1.close();
	}
}

package com.israluci.ch03fundamentalstructures.ex02;

import java.util.Arrays;
import java.util.Scanner;

public class OrderNumbers01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		String input;
		int[] numbers = new int[5];

		// TODO Auto-generated method stub
		System.out.println("Hello, insert some numbers separated by commas:");
		input = s1.nextLine();

		System.out.println("Thanks!");
		Scanner s = new Scanner(input).useDelimiter(",");

		int j = 0;
		while (s.hasNextInt()) {
			numbers[j] = s.nextInt();
			j++;
		}
		
		System.out.println("Here is are your numbers in ascending order:");

		Arrays.sort(numbers);
		for (int n : numbers)
			System.out.print(n+",");
			
		System.out.println("\nHere is are your numbers in descending order:");
			
		for (int i=numbers.length-1;i>=0;i--){
			System.out.print(numbers[i]+",");
		}
			
		s1.close();
		s.close();
	}
}

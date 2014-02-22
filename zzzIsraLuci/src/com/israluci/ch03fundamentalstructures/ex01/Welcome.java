package com.israluci.ch03fundamentalstructures.ex01;

import java.util.*;


/**

 * This program displays a greeting from the authors.

 * @version 1.20 2004-02-28

 * @author Cay Horstmann

 */

public class Welcome

{

   public static void main(String[] args)

   {

	   Scanner s = new Scanner(System.in);

      System.out.println("Hello there!");

      System.out.println("Enter some something come on");

      String name = s.nextLine();

      System.out.println("you entered: " + new StringBuilder(name).reverse());

   }

}
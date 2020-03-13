/* Purpose : Calculate gross pay, savings and investment
Kha Nguyen
Assignment 2
jGrasp
Discomfit- Cause to lose one's composure
"The best preperation for tomorrow is doing your best today."
 H. Jackson Brown Jr. (b. 1940)
*/

import java.util.Scanner;
 
public class KhaNguyen_4_02 {
 
   public static void main (String [] args) {
   
      Scanner console = new Scanner(System.in);
      double grossPay;        // Input values for gross pay
      double savingsRate;     // Input values for savings rate
      double iraSavings;      // Input values for IRA savings
      
      
      double savings;         // Savings amount
      double iraInvestment;   // IRA investment amount
      double total;           // Sum of the total amount of Savings amount and IRA amount
      
      // Explain the program to the user
      System.out.println("This program calculates savings, investment, and the total.");
      
      // Input the three numbers that are gross pay, savings rate and ira savings.
      System.out.print(" Input your gross pay: " );
      grossPay = console.nextDouble();
      System.out.print(" Input your savings rate: " );
      savingsRate = console.nextDouble();
      System.out.print( " Input IRA investment rate: ");
      iraSavings = console.nextDouble();
      
      // Calculate the percentages and total for the program
      savings  = (savingsRate / 100.0) * grossPay ;
      iraInvestment  = (iraSavings / 100.0) * grossPay;
      total = iraInvestment + savings;
      
      // Output results that calculated gross pay, savings and investment.
      System.out.print( " The gross pay is " + grossPay );
      System.out.println( ", the savings percentage rate is " + savingsRate + "%");
      System.out.println( " and the IRA investment rate is " + iraSavings + "%. " );
      System.out.println( " Here is what goes into savings: " + savings );  
      System.out.println( " Here is what goes into IRA investment account: " 
            + iraInvestment  );
      System.out.println( " and here is what goes into both accounts: " + total + ".");
      System.out.println( " Kha Nguyen  ");
      
      
      // Close files and exit
      console.close();
      System.exit(0);
   } // End main
} // End class

/* Interactive Average Program
      This program asks the user to input two real numbers,
      calculates the average of these numbers, and prints the results.
   Kha Nguyen
   Program #1, CS 1050, Section 4
   JGrasp 2.0.3, Lenovo Y-50 series, and Window OS
   Laburious - requiring much work, exertion or perseverence
   "Everyday bring new choices" Martha Beck (b. 1962)  
   
*/


import java.util.Scanner;

public class KhaNguyen_4_01 {

   public static void main (String [] args) {
   
      Scanner console = new Scanner(System.in);
      double num1 = 0.0;         // Input value 1
      double num2 = 0.0;         // Input value 2
      double average = 0.0;      // Average of the input values
      
      // Explain the program to the user
      System.out.println("This program averages two real numbers.");
      
      // Input the two numbers
      System.out.print("Input your first number: ");
      num1 = console.nextDouble();
      System.out.print("Input your second number: " );
      num2 = console.nextDouble();
      
      // Calculate the average of the two numbers
      average = (num1 + num2)/2.0;
      
      // Output the results
      System.out.print("The average of " + num1);
      System.out.println(" and " + num2 + " is " + average);
      System.out.println("Kha Nguyen");
      
      // Close files and exit
      console.close();
      System.exit(0);
    }// End main
  }// End class
/* Purpose : Work with ArrayLists, sum and average ArrayList entries
Kha Nguyen
Assignment 11
jGrasp Windows 10 on Lenovo y50 series
clarion - Clear and shrill
"Failure will never overtake me if my determination to succeed is strong enough."
Og Mandino (1923-1996)
*/


import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class KhaNguyen_4_11 {
            
   static Toolkit tools = new Toolkit();
         
   
   public static void main(String[ ] args) throws IOException {
      
               
      Scanner value = new Scanner(System.in);
      // User gets information whatever is in the addString
      getString();
            
   }    
//*********************************************************************************  
// This method tells the user to put in a series of numbers to calculate
// the averages and the sume of the numbers given only after they put in a "0".   
   public static void getString() {
      ArrayList<Integer> userNums = new ArrayList<Integer>();
      Scanner value = new Scanner(System.in);
      // Set the number that can go into the arraylist, can be changed anytime
      int[] NUM_ELEMENTS = new int[5];
   
      double sumVal = 0.0;     // The value to calculate the sum
      double averageVal = 0.0; // The value to calculate the average of the values
      int i = 0;               // Value created to loop what is in the loop
      
      
      System.out.println("Enter " + NUM_ELEMENTS.length + " numbers");
      int count = 0;
      for (i = 0; i < NUM_ELEMENTS.length; i++) {
         
         int nextValue = value.nextInt();
         if (nextValue == 0) {
         break;
         }
         userNums.add(nextValue);
         count++;
      }     
      // Determine average value    
      for (i = 0; i < count; ++i) {
      // Calculates the sum and gives it to the computer to use   
         sumVal = sumVal + userNums.get(i); 
      }     
      // Calculates the average and gives it to the computer to use
      averageVal = sumVal / count; 
        
      System.out.println("Average: " +  tools.leftPad(averageVal, 10, "0.00"));
      System.out.println("Sum of values: " + sumVal);
      return;
   }     
      
}
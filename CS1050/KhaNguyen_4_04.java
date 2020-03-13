/* Purpose : Calculate gross pay, savings and investment and then show it on dialog box.
Kha Nguyen
Assignment 4
jGrasp
Toil - Work hard
"Nothing will work unless you do" Maya Angelou
*/


import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;
public class KhaNguyen_4_04 {
 
   public static void main (String [] args) throws IOException {
   
      final String INPUT_FILE = "KhaNguyen_1_04.Input.txt";
      final String OUTPUT_FILE = "KhaNguyen_1_04.Output.txt";
     DecimalFormat mask = new DecimalFormat("#,###.00");
     
      int numInputLines = 0;          // Number of lines in the input file
      int validLines = 0;             // Number of valide lines in the input file
      double grossPay = 0.0;          // Input file for gross pay
      double savingsRate = 0.0;       // Input file for savings rate
      double iraRate = 0.0;           // Input file for IRA investment rate
      
      
      double sumGrossPay = 0.0;        // Sum of all valid gross pay
      double sumSavings = 0.0;         // Sum of all valid the savings amount
      double sumIra = 0.0;             // Sum of all valid IRA investment amount
      double sumAverage = 0.0;         // Sum of the average
      
      
      double sumGrossPayAverage = 0.0; // GrossPay average
      double sumSavingsAverage = 0.0;  // Savings average
      double sumIraAverage = 0.0;      // Ira average
      
   
      
      //
      File inputDataFile = new File(INPUT_FILE);
      Scanner inputFile = new Scanner(inputDataFile);
         
      FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter(outputDataFile);
      
      // Beginning of the program
      System.out.println ("Reading file " + INPUT_FILE + "\r\n" + 
         "Creating file " + OUTPUT_FILE + "\r\n");
      
            
      
      // Read the input and sum the value
     
      while (inputFile.hasNext()) {
         numInputLines++;
         grossPay = inputFile.nextDouble();
         savingsRate = inputFile.nextDouble();
         iraRate = inputFile.nextDouble ();
            
         if ( grossPay > 0 &&
                 savingsRate > 0 &&
                 iraRate > 0) {
            validLines++;
                  //Running summation of the three input values
            sumGrossPay += grossPay;
            sumIra += iraRate;
            sumSavings += savingsRate;
         
                  //Calculates the averages for the averages of the input values
            sumSavingsAverage  = (savingsRate / validLines) * grossPay ;
            sumIraAverage   = (iraRate / validLines) * grossPay;
            sumAverage = ((sumIra + sumSavings + sumGrossPay) / 3.0);
            
                  
                 
         }
         else   {
            
         }
            
           
            
                    
            
      //This tells the program not to print out the values if it is negative         
         if ( sumSavings > 0 && 
               sumIra > 0) {
               
            System.out.println (" " + sumSavings + " " +
               " " + sumIra + " "  );
         }
                        
      }
            
            
            
            
            
      //Execution and print out of the values
      System.out.println("The number of input lines is " + numInputLines);
      System.out.println("The number of valid input line is " + validLines);
      System.out.println("***********************");
      System.out.println("The sum of the gross pay is " + mask.format(sumGrossPay) +
                        "\nThe sum of the savings amount is " + mask.format(sumSavings) +
                        "\nThe sum of the ira is " + mask.format(sumIra));
                            
      System.out.println ("The savings average is " + mask.format(sumSavingsAverage) + " " +
            "\nThe ira investment average is " + mask.format(sumIraAverage) + " " +
            "\nThe average gross pay is " + mask.format(sumGrossPay) +
            "\nThe sum of the average is " + mask.format(sumAverage) );                 
                                  
      // Close files and exit
      inputFile.close();
      outputFile.close();
      System.exit(0);
   } // End main
} 


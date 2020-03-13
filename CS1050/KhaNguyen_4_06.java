/* Purpose : Print out the result of reimbursement and miles using input values 
Kha Nguyen
Assignment 6
jGrasp Windows 10 on Lenovo y50 series
Empirical - relying on experiment
"I will sleep when Im dead" Warren Zevon (1947-2003)

*/

import java.io.*;
import java.util.Scanner;
import java.text.DecimalFormat;

   public class KhaNguyen_4_06 {
      
      static final String NUMBER_ALLIGN = "#,##0.0";
      static final String MONEY_ALLIGN = "#,##0.00";
      static final int ROW_LENGTH = 25;
      
      
      
       public static void main(String[] args) throws IOException {
       
       
       Scanner console = new Scanner (System.in);
      
      
      int lineInput = 0;               //Numbers of input file numbers
      int lineInputNum = 0;            // Number of lines in the input
      int lineMileage = 0;             // Numbers of mileage in the input file
     
     
      double reimbursementMile;        // Tells us how much reimbursement per mile
      double mileageTaken;             // Tells us how many miles were used
      double reimbursementAll = 0.0;   //sum of reimbursement
      double mileageAll = 0.0;         //sum of mileage
      
      
      final String INPUT_FILE = "KhaNguyen_4_06_Input.txt";
      final String OUTPUT_FILE = "KhaNguyen_4_06_Output.txt";
      
      
      Scanner inputFile = new Scanner (new File(INPUT_FILE));
      
      //Put the numbers and money variables into a set decimal format
      DecimalFormat numbers = new DecimalFormat(NUMBER_ALLIGN);
      DecimalFormat money = new DecimalFormat(MONEY_ALLIGN);
      
      //Tell file to get input file
      File inputDataFile = new File(INPUT_FILE);
      Scanner InputFile = new Scanner(inputDataFile);
      
      //Tell file to get output file
      FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter(outputDataFile);
      
      //Get the set of miles and reimbursement together in rows
      String milesRolling = "Miles Traveled";
      String rollingReimb = "Reimbursement";
      String everythingTogether = "";
      
      //Create the file to print out the input and output
      System.out.println ("Reading file " + INPUT_FILE + "\nCreating file " +
      OUTPUT_FILE + "\n");
      
      //The heading of the file with respected strings
      printRolling(milesRolling, rollingReimb, outputFile);
      
      lineMileage = inputFile.nextInt();
      
      while (inputFile.hasNext() && lineInput < lineMileage) {
      mileageTaken = inputFile.nextDouble();
      lineInput++;
      
      //Calculations provided 
      if (mileageTaken <= 0) { reimbursementMile = 0; }
      else if (mileageTaken < 400) {reimbursementMile = 0.18 * mileageTaken; }
      else if (mileageTaken < 900) {
         reimbursementMile = 65 + 0.15 * (mileageTaken - 400); }
      else if (mileageTaken < 1300) {
         reimbursementMile = 115 + 0.12 * (mileageTaken - 900); }
      else if (mileageTaken < 1900) {
         reimbursementMile = 140 + 0.10 * (mileageTaken - 1300); }
      else if (mileageTaken < 2600) {
         reimbursementMile = 165 + 0.08 * (mileageTaken - 1900); }
      else { reimbursementMile = 195 + 0.06 * (mileageTaken - 2600); }
     
      //Loop telling us to increment the input line and summing up the total
      if (mileageTaken > 0) {
      lineInputNum++;
      mileageAll += mileageTaken;
      reimbursementAll += reimbursementMile;
      
      }
      
      outputLine (mileageTaken, reimbursementMile, outputFile);
      }
      
      //Print out the results 
      everythingTogether += "Total Reimbursement is $" + money.format(reimbursementAll);
      everythingTogether += "\nNumber of lines proccesed is " + lineInput;
      everythingTogether += "\nNumber of valid lines is " + lineInputNum;
      
      System.out.println(everythingTogether);
      outputFile.println(everythingTogether);
      
      inputFile.close(); //end of inputfile
      outputFile.close(); //end of outputfile
      
      System.exit(0);
      }
      //Using imported toolkit to pad the string
      //*********************************************************************
      public static void printRolling(String milesRolling, String rollingReimb,
            PrintWriter outputFile){
            String oneLine= "";
            oneLine += Toolkit.padString (milesRolling, ROW_LENGTH, "", " " );
            oneLine += rollingReimb;
            
            System.out.println(oneLine);
            outputFile.println(oneLine);
            
      }
      //*********************************************************************
      //Telling output line to pad the string
      public static void outputLine(double mileageTaken, double reimbursementMile,
      PrintWriter outputFile) {
      
      //If there is no value for mileage print the stars
      String noMileage = "*****";
      
      if (reimbursementMile > 0) {
         System.out.println(Toolkit.leftPad(mileageTaken, 8, "0.0") + 
         Toolkit.leftPad(reimbursementMile, 25, "0.00"));
         outputFile.println(Toolkit.leftPad(mileageTaken, 8, "0.0") +
         Toolkit.leftPad(reimbursementMile, 25, "0.00"));
         }
         else { System.out.println(Toolkit.leftPad(mileageTaken, 8, "0.0") +
         Toolkit.padString(noMileage, 25, " ", ""));
         outputFile.println(Toolkit.leftPad(mileageTaken, 8, "0.0") + 
         Toolkit.padString(noMileage, 25, " ", ""));
         }
    }
    
 }
         
      
      
      
      
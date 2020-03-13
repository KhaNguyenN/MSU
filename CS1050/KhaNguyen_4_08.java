/* Purpose : Print out the result of reimbursement and miles using input values 
Kha Nguyen
Assignment 8
jGrasp Windows 10 on Lenovo y50 series
Nugatory - useless/futile
"Be who you are and say what you feel, because those who mind do not matter, 
and those who matter do not mind".
Bernard Baruch (1870-1965)
*/



import java.util.Scanner;
import java.io.*;

public class KhaNguyen_4_08 {

// importing tool kit
      static Toolkit tools = new Toolkit();

//Start of main method
      public static void main (String [] args) throws IOException {

//Creating file to read from
      final String INPUT_FILE = "KhaNguyen_4_08_Input.txt";
      final String OUTPUT_FILE = "KhaNguyen_4_08_Output.txt";

//Tap into the program
         FileInputStream inputDataFile = new FileInputStream(INPUT_FILE);
         Scanner inputFile = new Scanner(inputDataFile);
         FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
         PrintWriter outputFile = new PrintWriter(outputDataFile);

//Get numbers of miles to be accessed
      int numValues = inputFile.nextInt();
      double [] miles = new double[numValues];
      double [] money = new double[numValues];

   System.out.println("\nReading file " + INPUT_FILE +
   "\nCreating file " + OUTPUT_FILE);

//Reading the file
   readData(miles, inputFile, numValues);

//Calc reimbursemtnt
   payCalc(miles, money, numValues);

//Print out the heading
   printHeading(outputFile);

//print the table results
   printTable(outputFile, numValues, miles, money);

//Values
      int numValid = valCount(numValues, miles);
      double allMiles = sumCountMiles(numValues, miles);
      double allPay = sumCountPay(numValues, money);
      double avgPay = avgPayCalc(numValues, numValid, money, allPay);
      double avgMiles = avgMileCalc(numValues, numValid, miles, allMiles);

//summary of the program
   progSummary(outputFile, numValues, numValid, allMiles, allPay, avgMiles, avgPay);

//Close the program
outputFile.close();
inputFile.close();
   }

//***************************************************************************************
//Method to initialize the read of the data
   public static void readData(double [] miles, Scanner inputFile, int numValues) {
      for(int i = 0; i < numValues; i++) {
      miles [i] = inputFile.nextDouble();
    }
   return;
   }
//**************************************************************************************
//Method to print out the heading
   public static void printHeading(PrintWriter outputFile) {
      String heading = "\r\nMiles traveled" + "\t\t" + "Reimbursements";
   outputFile.println(heading);
   System.out.println(heading);
return;
}

//***************************************************************************************
//Method counts the valid input and return it for later uses
      public static int valCount (int numValues, double [] miles) {
      int numValid = 0;
  for (int i = 0; i < numValues; i++) {
      if (miles[i] > 0.00) {
   numValid++;
   }
 }
      return numValid;
   }

//***************************************************************************************   
//Calculate the data and ouputting the results   
   public static void printTable (PrintWriter outputFile, int numValues,
                              double [] miles, double [] money) {
      String outInfo = "";
      for (int i = 0; i < numValues; i++) {
      if (money[i] <= 0) {
   outInfo = tools.leftPad(miles [i], 10, "0.0") + "\t\t" +
 " ******";
          outputFile.println(outInfo);
          System.out.println(outInfo); }
       else {
          outInfo = tools.leftPad(miles[i], 10, "0.0") + "\t\t" +
          tools.leftPad(money[i], 8 , "$0.00");
          outputFile.println(outInfo);
          System.out.println(outInfo);
      }
    }
 return;
 }
 
//*************************************************************************************** 
//Calculate the sum of all valid reimbursement
      public static double sumCountMiles(int numValues, double [] miles) {
 double allMiles =0.0;
      for (int i = 0; i < numValues ; i++) {
   if(miles [i] > 0.0) {
   allMiles += miles[i];
      }
   }
 return allMiles;
 }
 
//***************************************************************************************
//Calculate the average reimbursement
      public static double sumCountPay(int numValues, double[] money) {
   double allPay = 0.0;
   for (int i = 0; i < numValues; i++) {
      if(money [i] > 0.0) {
    allPay += money [i];
       }
   }
 return allPay;
 }
 
//***************************************************************************************
//Calculate the average mileage
       public static double avgMileCalc (int numValues, int numValid, double [] miles, 
                                    double allMiles) {
      double avgMiles = 0.0;
               for (int i = 0; i < numValues; i++) {
      if (miles[i] > 0 ) {
      allMiles += miles[i];
       }
  }   
   avgMiles = (double)allMiles / numValid;
    return avgMiles;
  }
  
//***************************************************************************************  
//calculate the average of reimbursement amount
  public static double avgPayCalc (int numValues, int numValid, double [] money,
                                    double allPay) {
      double avgPay = 0.0;
                     for (int i = 0; i < numValues; i++) {
      if(money[i] > 0) {
   allPay += money [i];
       }
   }
   avgPay = allPay / numValid;
   return avgPay;
  }

//***************************************************************************************
//This method prints out the summary of the file, all averages, and all the total
public static void progSummary(PrintWriter outputFile, int numValues, int numValid,
                                double allMiles, double allPay, double avgMiles,
                                double avgPay) {
String summary = "\r\nTotal Mileage is" +
 tools.leftPad(allMiles, 8, "0.0") +
 "\nTotal Reimbursement is " + 
 tools.leftPad(allPay, 8, "$0.00") + 
 "\nThe average of all the valid miles is " +
 tools.leftPad(avgMiles, 8, "0.00") +
 "\nThe average of all the valid reimbursements is " + 
 tools.leftPad(avgPay, 8, "$0.00") + 
 "\nTotal input is " + numValues +
 "\nTotal of valid input is " + numValid;
 
 outputFile.println(summary);
 System.out.println(summary);
 return;
 }

//***************************************************************************************
//The method calculate the reinbursement amount
      public static double [] payCalc(double [] miles, double [] money, int numValues ) {
            for (int i = 0; i < numValues; i++) {
                   if(miles[i] < 0) {
                        money[i] = 0.0; }
                  else if ( miles[i] < 400) {
                         money[i] = miles[i] * 0.18; }
                   else if (miles[i] < 900) {
                         money [i] = 65.00 + 0.15 * (miles[i] - 400); }
                  else if (miles[i] < 1300) {
                        money[i] = 115.00 + 0.12 * (miles[i] -900); }
                  else if (miles[i] < 1900) {
                         money [i] = 140.00 +0.10 * (miles[i] -1300); }
                  else if (miles[i] < 2600) {
                        money[i] = 165.00 + 0.08 * (miles[i] - 1900); }
                  else if (miles[i] > 2600) {
                        money [i] = 195.00 + 0.06 * (miles [i] - 2600); }
      }
      return money;
   }
}


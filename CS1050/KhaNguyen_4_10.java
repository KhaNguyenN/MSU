/* Purpose : Calculate payroll data using classes
Kha Nguyen
Assignment 11
jGrasp Windows 10 on Lenovo y50 series
clarion - Clear and shrill
"Failure will never overtake me if my determination to succeed is strong enough."
Og Mandino (1923-1996)
*/

import java.util.Scanner;
import java.io.*;

public class KhaNguyen_4_10 {

   static Toolkit tools = new Toolkit();
   static final int MAX_EMPL = 30;

   public static void main(String[ ] args) throws IOException {

      EmployeeParameters emplParams = new EmployeeParameters();
      // Comment out because it was a test file
      Scanner input = new Scanner(new File("KhaNguyen_10_InputTest.txt"));
      
      // Read the input file text so the program can run it
      //Scanner input = new Scanner(new File("KhaNguyen_10_Input.txt"));
      
      Employee[] empl = new Employee[MAX_EMPL];
      int nRead = 0;
      int sortResult = 0;
      double savingsRate = 0.0;

      // Get the program parameters. If there's any argument in the
      // command line, display the parameters, too

      emplParams.getEmployeeParameters();
      savingsRate = emplParams.savingsRate;
      if (args.length > 0) {
         emplParams.displayEmployeeParameters();
         System.out.println();            // Blank line after parameters
      }
      
      // Read and display the imput file
      double iraRate = emplParams.iraRate;
      double fedHolding = emplParams.federalWithholdingRate;
      double stateHolding = emplParams.stateWithholdingRate;
      while (input.hasNext() && (nRead < empl.length)) {
         empl[nRead] = new Employee();
         empl[nRead].hoursWorked = input.nextDouble();
         empl[nRead].payRate = input.nextDouble();
         empl[nRead].name = input.nextLine().trim();
         empl[nRead].grossPay = calculateGrossPay
                               (empl[nRead].hoursWorked , empl[nRead].payRate);
         empl[nRead].iraAmount = calculateIraInvestmentAount
                                 (empl[nRead].grossPay,iraRate);
         empl[nRead].adjustedGrossPay = calculateAdjustedGrossPay
                                        (empl[nRead].grossPay,empl[nRead].iraAmount);
         empl[nRead].taxAmount = calculateTaxes
                                 (empl[nRead].adjustedGrossPay,stateHolding,fedHolding);
         empl[nRead].netPay = calculateNetPay
                              (empl[nRead].adjustedGrossPay,empl[nRead].taxAmount);
         empl[nRead].savingsAmount = calculateSavingAmount
                                      (empl[nRead].netPay,savingsRate);
         nRead++;
      } // End while


      System.out.println("\n# of rows read: " + nRead);
      input.close();




      createReport("Input", empl, nRead);

      // Sort by name and print, the sort by gross pay and print

      if(tools.selectionSortArrayOfClass(empl, nRead, "Name") == 0) {
         createReport("Name", empl, nRead);
      }

      if(tools.selectionSortArrayOfClass(empl, nRead, "Gross Pay") == 0) {
         createReport("Gross Pay", empl, nRead);
      }

   } // End main

//***************************************************************************************

   public static void displayData(String printOrder,Employee[] empl, int nEntries) {
      final String DOLLAR = "#,##0.00";

      System.out.println("\nPrint in " + printOrder.toLowerCase() + " order\n");

      for (int i = 0; i < nEntries; i++) {
         System.out.println(        tools.padString(empl[i].name,20) +
                 "   " + tools.leftPad(empl[i].payRate, 10, DOLLAR) +
                 "   " + tools.leftPad(empl[i].hoursWorked, 10, DOLLAR) +
                 "   " + tools.leftPad(empl[i].grossPay, 10, DOLLAR));
      } // End displayData
   } // End displayData



//***************************************************************************************
   // Method that calculates gross pay for the user to read later
   public static double calculateGrossPay( double hoursWorked, double payRate){
      double grossPay = 0.0;

      if(hoursWorked <= 40.0){
         grossPay = hoursWorked * payRate;
      } else if(hoursWorked > 40.0 && hoursWorked <= 50.0){
         double hoursGotPaidOneHalf = hoursWorked - 40.0;
         grossPay = (payRate * 40.0) + ( (payRate*1.5) * hoursGotPaidOneHalf);
      } else if(hoursWorked > 50.0 ) {
         double hoursGotPaidOneHalf = 50.0 - 40.0;
         double hoursGotPaidDouble = hoursWorked - 50.0;
         grossPay = (payRate * 40.0) + ((payRate*1.5) * hoursGotPaidOneHalf)  
                                     + ( (payRate * 2) * hoursGotPaidDouble);
      }

      return grossPay;
   }


//***************************************************************************************
   // Method that calculate IRA amount that we will use later.
   public static double calculateIraInvestmentAount(double grossPay, double iraRate){
      double iraAmount =  (grossPay * iraRate) / 100.0;
      return iraAmount;
   }



//***************************************************************************************
   // Method that calculates adjusted gross pay that we will use later.
   public static double calculateAdjustedGrossPay(double grossPay, double iraAmount) {
      double adjustedGrossPay = grossPay - iraAmount;
      return adjustedGrossPay;
   }

//***************************************************************************************
   // Method that calculates the taxes that we will use later.
   public static double calculateTaxes(double adjustedGrossPay, double stateWithHolding, 
                                       double federalWithholdingRate) {
      double taxAmount = adjustedGrossPay * 
                        ((stateWithHolding + federalWithholdingRate)/100.0);
      return taxAmount;
   }
 //**************************************************************************************
   // Method that calculates the net pay that we will use later.
   public static double calculateNetPay (double adjustedGrossPay, double taxAmount) {
      double netPay = adjustedGrossPay - taxAmount;
      return netPay;
   }

//***************************************************************************************
   // Method that calculates the savings amount that we will use later.
   public static double calculateSavingAmount(double grossPay, double savingsRate){
      double savingAmount =  (grossPay * savingsRate) / 100.0;
      return savingAmount;
   }
//***************************************************************************************
   // Method that prints summary to the user
   public static void createReport(String printOrder,Employee[] empl, int nEntries){
      printHeading(printOrder);
      printDetailLine(empl,nEntries);
      printSummary(empl,nEntries);

   }
//***************************************************************************************
   // Method that prints out the heading and the informations pretainning to it
   public static void printHeading(String printOrder){
      final String DOLLAR = "#,##0.00";
      System.out.println("\nPrint in " + printOrder.toLowerCase() + " order\n");
      System.out.println("                   Mobile Apps Galore, Inc. - Payroll Report"
      +          "\n");
      System.out.println(        tools.padString("Name",20) +
              "   " + tools.padString("Gross Pay", 10) +
              "   " + tools.padString("Net Pay", 10) +
              "   " + tools.padString("Wealth", 10) +
              "   " + tools.padString("Taxes", 10) +
              "   " + tools.padString("Hours", 10) +
              "   " + tools.padString("Pay rate", 10)) ;

      System.out.println(tools.padString("",10,"-","-") +
              "   " + tools.padString("",5,"-","-") +
              "   " + tools.padString("",5,"-","-") +
              "   " + tools.padString("",5,"-","-") +
              "   " + tools.padString("",5,"-","-") +
              "   " + tools.padString("",5,"-","-") +
              "   " + tools.padString("",5,"-","-")) ;
   }
//***************************************************************************************   
   // Method that allign the numbers for the user to read
   public static void printDetailLine(Employee[] empl,int nEntries){
      final String DOLLAR = "#,##0.00";
      for (int i = 0; i < nEntries; i++) {
         System.out.println(        tools.padString(empl[i].name,20) +
                 "   " + tools.leftPad(empl[i].grossPay, 10, DOLLAR) +
                 "   " + tools.leftPad(empl[i].netPay, 10, DOLLAR) +
                 "   " + tools.leftPad(empl[i].savingsAmount +
                                       empl[i].iraAmount, 10, DOLLAR) +
                 "   " + tools.leftPad(empl[i].taxAmount, 10, DOLLAR) +
                 "   " + tools.leftPad(empl[i].hoursWorked, 10, DOLLAR) +
                 "   " + tools.leftPad(empl[i].payRate, 10, DOLLAR)) ;
      }
   }
//***************************************************************************************
   // Method that assign the total value for calculations at the end
   public static void printSummary(Employee[] empl,int nEntries){
      final String DOLLAR = "#,##0.00";
      double totalGrossPay = 0.0;
      double totalNetPay = 0.0;
      double totalWealth = 0.0;
      double totalTaxes = 0.0;
      double totalHours = 0.0;

      double totalPayRate = 0.0;
      double averagePayRate = 0.0;

      for(int i =0; i < nEntries; i++){
         totalGrossPay += empl[i].grossPay;
         totalNetPay += empl[i].netPay;
         totalWealth += (empl[i].savingsAmount + empl[i].iraAmount);
         totalTaxes += empl[i].taxAmount;
         totalHours += empl[i].hoursWorked;
         totalPayRate += empl[i].payRate;
      }

      averagePayRate = totalPayRate / nEntries;

      System.out.println("\n    " + tools.padString("Totals: ",19)+
              "   " + tools.leftPad(totalGrossPay, 10, DOLLAR) +
              "   " + tools.leftPad(totalNetPay, 10, DOLLAR) +
              "   " + tools.leftPad(totalWealth, 10, DOLLAR) +
              "   " + tools.leftPad(totalTaxes, 10, DOLLAR) +
              "   " + tools.leftPad(totalHours, 10, DOLLAR)) ;
      System.out.println("\n    " + tools.padString("Average: ",19)+
              "   " + tools.leftPad(averagePayRate, 71, DOLLAR)) ;

   }

} // End class
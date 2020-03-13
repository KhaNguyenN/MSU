import java.util.Scanner;
import java.text.DecimalFormat;
import static java.lang.System.exit;

public class KhaNguyen_4_09_Calc {

   //Formatting input values
   DecimalFormat formatnum = new DecimalFormat ("###.00");

   // private instance variables for calculations
   private double grossPay = 0.0;
   private double savingsRate = 0.0;
   private double iraInvestmentRate = 0.0;
   private double savingAmount = 0.0;
   private double iraAmount = 0.0;
   
   //calculated field is not private variables

   
   //No parameter constructor that initializes  private variables to 0
   public KhaNguyen_4_09_Calc(){
      grossPay = 0.0;
      savingsRate = 0.0;
      iraInvestmentRate = 0.0;
      savingAmount = 0.0;
      iraAmount = 0.0;
      
   }
//*******************************************************************************************
   //Constructor with three parameters set the instance variables to parameter values
   public KhaNguyen_4_09_Calc(double inGrossPay, double inSavingRate, 
                              double inIraInvestmentRate){
      grossPay = inGrossPay;
      savingsRate = inSavingRate;
      iraInvestmentRate = inIraInvestmentRate;
   }
//*******************************************************************************************
   //Get user to input values for calculations
   public void getUserInput(){
      Scanner scan = new Scanner(System.in);
      System.out.print("Please enter the gross pay: ");
      grossPay = scan.nextDouble();
      System.out.print("Please enter the saving rate: ");
      savingsRate = scan.nextDouble();
      System.out.print("please enter the iraInvestment rate: ");
      iraInvestmentRate = scan.nextDouble();
   
   //If one of the input values is less than 0 tell user values less than 0 is not allow
   //then exit the program
      if(grossPay < 0.0 || savingsRate < 0.0 || iraInvestmentRate < 0.0 ){
         System.out.println("All input values must be greater than 0"
                 +          "\nExiting program");
         exit(1);
      }
   }
//*******************************************************************************************
   //Method to print out values
   public void displayInput(){
      System.out.print("The input gross pay is: $" + (formatnum.format (grossPay)) +
      "\nThe input saving rate is: " + (formatnum.format (savingsRate)) + "%" +
      "\nThe input ira investment rate is: " + (formatnum.format(iraInvestmentRate)) + "%");
      
   }
//*******************************************************************************************
   //Method return savings amount that take no parameter
   public double calculateSavingAmount(){
      double savingAmount =  (grossPay*savingsRate) / 100.0;
      return savingAmount;
   }
//*******************************************************************************************
   //Method return ira amount that take no parameter
   public double calculateIraInvestmentAount(){
      double iraAmount =  (grossPay*iraInvestmentRate) / 100.0;
      return iraAmount;
   }

   
}

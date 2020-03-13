import java.io.*;
import java.util.Scanner;


public class KhaNguyen_4_09_Calc {
      
      private double grossPay = 0.0;
      private double savingsRate = 0.0;
      private double iraRate = 0.0;
      private double itsSavings = 0.0;
      private double itsIRAinvestment = 0.0;
      private double itsTotal = 0.0;
                  
      
      
            
      
      
      public KhaNguyen_4_09_Calc () {
         grossPay = 0.0;
         savingsRate = 0.0;
         iraRate = 0.0;
         itsSavings = 0.0;
         itsIRAinvestment = 0.0;
         itsTotal = 0.0;   
      }
      
      public KhaNguyen_4_09_Calc (double inputGrossPay, double inputSavingsRate, double inputiraRate){
              grossPay = inputGrossPay;
              savingsRate = inputSavingsRate;
              iraRate = inputiraRate;
               }
      
      public void getInput(){
         Scanner console = new Scanner(System.in);
         System.out.print(" Input your gross pay : " );
         grossPay = console.nextDouble();
         System.out.print(" Input your savings rate : " );
         savingsRate = console.nextDouble();
         System.out.print( " Input IRA investment rate : ");
         iraRate = console.nextDouble();
         
     
     
         if ( grossPay > 0 &&
           savingsRate > 0 &&
           iraRate > 0) { 
            }
                    
      else { System.out.print(" Are you sure you want a negative? ");
         return;
         }
      }
      
      
      public void getOutput(){
         System.out.println("This program prompts the user to input all real non-negative numbers" +
         "for calculations." + "\nThe gross pay is " + grossPay + "\nThe savings rate is " +
         savingsRate + "\nThe IRA investment rate is " + iraRate + "\nThe savings amount is "
         + itsSavings + "\nThe IRA investment amount is " + itsIRAinvestment +
         "\nThe total of savings amount and IRA investment amount is " + itsTotal);
      }
     
      public  double itsSavings(double grossPay, double savingsRate){ 
            itsSavings =  (grossPay * savingsRate) / 100.0;
            return itsSavings;
           
      }
      public double itsIRAinvestment(double grossPay, double iraRate) {
           itsIRAinvestment = (grossPay * iraRate) / 100.0;      
           return itsIRAinvestment;}
     
     
      public double itsTotal (double itsSavings, double itsIRAinvestment) {
           itsTotal = (itsSavings + itsIRAinvestment);
           return itsTotal;
      }   
      
  } 
      
      
       
      
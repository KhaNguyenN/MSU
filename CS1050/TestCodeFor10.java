public static double calculateGrossPay(double hourWorked, double payRate){
     double grossPay = 0.0;
     double hoursGotPaidOneHalf = hourWorked - 40.0;
     
     if(hourWorked <= 40.0){
            grossPay = hourWorked * payRate;
     } else if(hourWorked > 40.0 && hourWorked <= 50.0){
            grossPay = (payRate * hoursWorked) + ( (payRate*1.5) * hoursGotPaidOneHalf);
     } else if(hourWorks > 50.0 ) {
            grossPay = (payRate * hoursWorked) + ( (payRate * 2) * hoursGotPaidOneHalf);
     }

     return grossPay;
  }






double grossPay;
                 double hoursPaidOneHalf = hourWorks - 40.0;
                 
                 if( hoursWorked <= 40) {grossPay = hoursWorked * payRate; }  
                 if else (hourWorks > 40 && hoursWorked <= 50) {grossPay = (hoursWorked * payRate) + ((payRate * 1.5) * hoursGotPaidOneHalf)};
                 else (hoursWorked > 50 ) {grossPay = (hoursWorked * payRate) + ((payRate * 2) * hoursGotPaidOneHalf)};
                 
                 return grossPay;
    }             
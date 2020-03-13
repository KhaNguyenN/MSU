/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knguyenhw2;
import java.util.Scanner;
import java.io.*;

/**
 * This program uses Student Class and Grade Item class to figure out, what 
 * the students have for their personal information. Also reading from a file
 * and comparing the two at the end, for a result.
 * @author Kha Nguyen
 * @Version 2/7/2017
 * 
 */
public class kNguyenHW21 {
    
    private static final Student student1 = new Student ("900123456","Joe","Doe","joedoe@msudenver.edu");
    String student2;
    private static final GradeItem gradeItem1 = new GradeItem (1,"900123456","23456","HW","20170112",100,95);
    String gradeItem2;
    
    
   //public static final String INPUT_FILENAME = "src\\input\\hw2inputx.txt";
    //public static final String OUTPUT_FILENAME = "output/hw2inputx.txt";
    
    public static void main(String[] args) {
     System.out.println("Test 1a");
     System.err.println(student1.toString());  
     System.out.println("Test 1b");
     System.err.println(gradeItem1.toString());    
     
        
    //try {    
       // Student student1 = new Student ("900123456","Joe","Doe","joedoe@msudenver.edu");
   
    
       // GradeItem gradeItem1 = new GradeItem (1,"900123456","23456","HW","20170112",100,95);
    
        
        
      //File inputDataFile = new File(INPUT_FILENAME);
      //Scanner inputFile = new Scanner(inputDataFile);
         
      //FileWriter outputDataFile = new FileWriter(OUTPUT_FILENAME);
      // outputFile = new PrintWriter(outputDataFile);
     //} catch(Exception e ){
     //       System.out.println("error:" + e);
     //} finally { 
             
     } 
     
    

    
    }
     
   // public static void processStudentData (String[] data) {
        
  //  }
   // public static void processGradeItemData (String[] data) {
   //     }
//}


 
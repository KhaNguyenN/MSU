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
 * @Version 2/9/2017
 * 
 */
public class kNguyenHW2 {
    
    private static Student student1 = new Student ("900123456","Joe","Doe","joedoe@msudenver.edu");
    private static Student student2;
    private static GradeItem gradeItem1 = new GradeItem (1,"900123456","23456","HW","20170112",100,95);
    private static GradeItem gradeItem2;
    
   //Finds the input file in the hw2inputx.txt to get read from
   public static final String INPUT_FILENAME = "src\\input\\hw2inputx.txtt";
   
    //Start of the main test, that runs through the methods to read
    public static void main(String[] args) {
     
    //This runs test 1a and prints it out
     System.err.println("Test 1a");
     System.err.println(student1.toString());
     
    //This runs test 1b and prints it out
     System.err.println("\nTest 1b");
     System.err.println(gradeItem1.toString());
     
     /**
     *This runs test 2a and make sure the conditions are correct, and when it is
     *prints out the student's information
     */
     System.err.println("\nTest 2a");
     System.err.println("Student Object Data");    
     System.err.println(student1.getStudentID());
     System.err.println(student1.getStudentFirstName());
     System.err.println(student1.getStudentLastName());
     System.err.println(student1.getStudentEmail());
     /**
      * This runs test 2b and make sure the conditions are correct, and when it is
      * it prints the students grade item.
      */
     System.err.println("\nTest 2b");
     System.err.println("Grade Item Data");
     System.err.println(gradeItem1.getGradeItemID());
     System.err.println(gradeItem1.getStudentID());
     System.err.println(gradeItem1.getCourseID());
     System.err.println(gradeItem1.getWorkType());
     System.err.println(gradeItem1.getDate());
     System.err.println(gradeItem1.getMaximumScore());
     System.err.println(gradeItem1.getActualScore());
     
     File inputDataFile = new File(INPUT_FILENAME);
     
     
     
   /**
    * The try clause here is for student and it splits out the string with a comma
    * and when the data seems true with testing for STUDENT, it will then print out
    * the information
    */
    try {    
       
         Scanner scnr = new Scanner (inputDataFile);
         String line = scnr.nextLine();
         String[] data = line.split(",");
            
            
         if(data[0].equals("STUDENT")){
                
            }
            
        student1 = new Student(data [2], data[3], data[4], data[5]);
           

       processStudentData(data);
   }
      
    catch(Exception e ){
            System.err.println("File for student not found" + e);
                 
                        }
   
    
   /**
    * The try clause here is for grade item and it splits out the string with a comma
    * and when the data seems true with testing for GRADE ITEM, it will then print out
    * the information
    */
   
     try {
         
         Scanner scnr = new Scanner (inputDataFile);
         String line = scnr.nextLine();
         String[] data = line.split(",");
         if(data[0].equals("GRADE ITEM"));
            
         gradeItem1 = new GradeItem (Integer.parseInt(data[0]), data[1], data[2], 
               data[3], data[4], Integer.parseInt(data[5]), Integer.parseInt (data[6]));
       
       processGradeItemData(data);    
       
     } 
     
     catch(Exception e){
         
     }
     
     
    /**
     * The if statements makes sure that the two students are equal if they are they
     * are they will print
     */  
    if(student1.equals(student2)){
         System.err.println("\nRunning Test 3a:");
         System.err.println("They are equal\n");
    }
   
    else {
        
        System.err.println("They are not equal");
         
         }
    /**
     * The if statements makes sure that the two grade item are equal if they are 
     * they will print
     */
    
    if(gradeItem1.equals(gradeItem2)){
        System.err.println("They are not equal");
    }
    
    else { 
        
        System.err.println("Running Test 3b:");
        System.err.println("They are equal");
        
        }
    }
    
    
    /**
     * This method makes sure that the student data has a file ADD and when it does
     * it makes sure that student 1 is now equals to student 2.
     * @param data 
     */
    public static void processStudentData (String[] data) {
    if (data[1].equals("ADD")){
        
               student2 = new Student (data [2], data [3], data [4], data [5]);
            }
    else if (!data[1].equals("ADD")){
        System.err.println("There is no ADD");
            }
    
   
      
      Student student1 = student2; 
    }
    
    
    
    
    
    /**
     * This method makes sure that the grade item data has a file ADD and when it does
     * it makes sure that grade item1 is now equals to grade item2
     * @param data 
     */
    public static void processGradeItemData (String[] data) {
    if (data[1].equals("ADD")){
        
               gradeItem2 = new GradeItem (Integer.parseInt(data[0]), data[1], data[2], 
               data[3], data[4], Integer.parseInt(data[5]), Integer.parseInt (data[6]));
            }
    else if (!data[1].equals("ADD")){
        
        System.err.println("There is no ADD");
    }
        System.err.println("Test 2b");
    
   
      GradeItem gradeItem1 = gradeItem2;
    }    
   }


 
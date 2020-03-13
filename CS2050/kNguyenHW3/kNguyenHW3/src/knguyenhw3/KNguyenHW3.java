/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knguyenhw3;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;




/**
 *
 * @author Kha Nguyen
 * @Version 3/1/2017
 */
public class KNguyenHW3 {

    //Uses mylist to get my list class to use methods
    private static MyList<Student> listOfStudent;
    private static MyList<GradeItem> listOfGradeItem;
    
    //Read from file and output it to an outputfile
    private static final String INPUT_FILE = "src\\input\\hw3input1.txt";
    private static final String OUTPUT_FILE = "src\\output\\hw3output1.txt";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
      listOfStudent = new MyList<Student>(100);
      listOfGradeItem = new MyList<GradeItem>(100);
        
        processInputFile();
      
        generateReport();
     
    }
    
    /**This runs the input file and process it through either Student or Grade Item,
     * if it does not match any of those things it will not run
     */
    
    private static void processInputFile()
    {
        try{
          
            Student temp;
            String line = null;
            String[] tempArray = null;
            
            File file1 = new File(INPUT_FILE);
            Scanner inFile = new Scanner(file1);
            
            while (inFile.hasNext()){
                
                line = inFile.nextLine();
                tempArray = line.split(",");
                if (tempArray[0].equals("STUDENT"))
                {
                    processStudentData (tempArray);
                }
                else if (tempArray[0].equals("GRADE ITEM"))
                        {
                        processGradeItemData (tempArray);
                        }
                
                else
                {
                    System.err.println (tempArray[0] + " is invalid data type.");
                }
                
                
            }
        }catch (FileNotFoundException e){
            System.err.println("File " + INPUT_FILE + " not found.");
        }
    }
    
    /**This process Student Data reads the entry from student, and later output it
     * 
     * @param tempArray 
     */
    private static void processStudentData (String[] tempArray)
    {
        
        Student temp = null;
        if (tempArray[1].equals("ADD")){
             try {   
                 
                         
              temp = new Student(tempArray[2], tempArray[3], tempArray[4],tempArray[5]);
               if (listOfStudent.add(temp)) {
                System.err.println(temp + " was added to the list");
            }
              
             }catch(Exception e) {
               System.err.println ("Error: " + e.getMessage());
               System.err.println(temp + " was not added to the list");
             }
           

        } else if (tempArray[1].equals("DEL")) {

            temp = new Student(tempArray[2], tempArray[3], tempArray[4],
            tempArray[5]);
            
            if (listOfStudent.remove(temp)) {
                System.err.println(temp + " was deleted from the list");
            } else {
                System.err.println(temp + " is not in the list");
            }
            
        } else {
            System.err.println(tempArray[1] + " is an invalid action.");
        }
        
       
            
    }
    
    
    /**This process Grade Item data and later process the data
     * 
     * @param tempArray 
     */
    private static void processGradeItemData (String[] tempArray)
    {
        
        GradeItem temp = null;
        if (tempArray[1].equals("ADD")){
                    
            try {
            temp = new GradeItem(Integer.parseInt(tempArray[2]), tempArray[3], tempArray[4], tempArray[5],
                    tempArray[6], Integer.parseInt(tempArray[7]), Integer.parseInt(tempArray[8]));
            if (listOfGradeItem.add(temp)) {
                System.err.println(temp + " was added to the list");
            }
            }catch(Exception e) {
                 System.err.println(temp + " was not added to the list");
            }    
           
              
        } else if (tempArray[1].equals("DEL")) {

           temp = new GradeItem(Integer.parseInt(tempArray[2]), tempArray[3], tempArray[4], tempArray[5],
                    tempArray[6], Integer.parseInt(tempArray[7]), Integer.parseInt(tempArray[8]));
            
            if (listOfGradeItem.remove(temp)) {
                System.err.println(temp + " was deleted from the list");
            } else {
                System.err.println(temp + " is not in the list");
            }
            
        } else {
            System.err.println(tempArray[1] + " is an invalid action.");
        }
        
        
    }
    /** This generates the data and later output, and it prints out the results when,
     * it calls for it later in the process input file.
     * 
     */
    public static void generateReport ()
    {
        File file = new File (OUTPUT_FILE);
        
        
        try
        {
        PrintWriter pw = new PrintWriter (file);
        //Display list of items added to the list.
        pw.println ("List of Student");
        pw.println();
        Object[] list = listOfStudent.toArray();
        Object[] list1 = listOfGradeItem.toArray();
        
       
        for (int i = 0; i < list.length; i++)
        {
              
                  Student temp1 = (Student) list[i]; 
                  
            
            
            
            pw.printf ("%s %3s %3s  %3s  %n" , temp1.getStudentID(),
                                  temp1.getStudentFirstName(),
                                  temp1.getStudentLastName(),
                                  temp1.getStudentEmail());
            
        pw.println("Grade Item");
        
        int maximumScore = 0;
        int actualScore = 0;
      
        for (int j = 0; j < list1.length; j++)
        {
            GradeItem temp2 = (GradeItem) list1 [j];
            if(temp1.getStudentID().equals(temp2.getStudentID())){
                pw.printf("%3s %8s %8s %1s %10d %5d %n",
                        temp2.getGradeItemID(), temp2.getCourseID(),
                        temp2.getWorkType(), temp2.getDate(), 
                        temp2.getMaximumScore(), temp2.getActualScore() );
                maximumScore = maximumScore + temp2.getMaximumScore();
                actualScore = actualScore + temp2.getActualScore();
            }
        }
        pw.println ("===================================================");
        pw.printf("Total %35s %5s", maximumScore, actualScore);
        pw.println("\n");
        }
        pw.close();
        }
        
        catch (FileNotFoundException ex)
        {
            System.err.println ("Cannot create the file: " + OUTPUT_FILE);
        }
    }
    
    
}

    
    


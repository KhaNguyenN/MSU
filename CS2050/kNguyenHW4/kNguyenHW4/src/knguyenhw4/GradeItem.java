/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knguyenhw4;

import java.util.Objects;

/**
 *Grade Class will calculate the students grade and calculate it accordingly
 * with the use of student ID, course ID, work type, date, maximum score and 
 * actual score.
 * @author Kha Nguyen
 * @version 1/24/17
 */

public class GradeItem {
    int gradeItemID;
    String studentID;
    String courseID;
    String workType;
    String date;
    int maximumScore;
    int actualScore;
   /**
    * This will initialize all the workings of the grade class, by implementing 
    * the values below
    * @param gradeItemID
    * @param studentID Student's ID number
    * @param courseID Student's course ID number
    * @param workType Student's work type
    * @param date Date of the assignment
    * @param maximumScore Possible maximum one can earn
    * @param actualScore Student's actual score
    * It will make sure at least on of the following types pass through before 
    * it
    * gets the numbers
    * @param HW Homework grade
    * @param Quiz Quiz grade
    * @param classWork Class work grade
    * @param Test Test grade
    * @param Final Final grade
    * @return 
    */
    

    public GradeItem(int gradeItemID, String studentID, String courseID, 
            String workType, String date, int maximumScore, int actualScore) {
        this.gradeItemID = gradeItemID;
        this.studentID = studentID;
        this.courseID = courseID;
        this.workType = workType;
        this.date = date;
        this.maximumScore = maximumScore;
        this.actualScore = actualScore;
        
         if (workType.equals("HW") ||
                workType.equals("Quiz") ||
                workType.equals("Test") ||
                workType.equals("Final")){
                this.workType = workType;
        
         this.workType = workType;
         } else {      
         throw new IllegalArgumentException("Must be in the form of "           
                 + "the allowed data type");
         }
         }

 

    
/**
 * Returns the graded ID
 * @return 
 */
    public int getGradeItemID() 
    {
        return gradeItemID;
    }
/**
 * 
 * @param gradeItemID 
 */
    public void setGradeItemID(int gradeItemID) 
    {
        this.gradeItemID = gradeItemID;
    }
/**
 * Returns the student ID number
 * @return student ID number
 */
    public String getStudentID() 
    {
        return studentID;
    }
/**
 * The course ID number
 * @return course ID number
 */
    public String getCourseID() 
    {
        return courseID;
    }
/**
 * The work type
 * @return the work type
 */
    public String getWorkType() 
    {
        return workType;
    }
/**
 *  The date
 * @return the date for students
 */
    public String getDate() 
    {
        return date;
    }
/**
 *  Get the maximum score
 * @return the maximum score
 */
    public int getMaximumScore() 
    {
        if (maximumScore < 0) 
        {
            throw new IllegalArgumentException ("Maximum score can "
                                                 + "not be less than 0");    
        }
        return maximumScore;
    }
/**
 *  Get the actual score
 * @return the actual score to students
 */
    public int getActualScore() 
    {
        if (actualScore <= maximumScore)
        {
        return actualScore;
        }
            throw new IllegalArgumentException("The score must "
                                               + "be a real number");
    }

    @Override
    public int hashCode() 
    {
        int hash = 5;
        hash = 53 * hash + this.gradeItemID;
        hash = 53 * hash + Objects.hashCode(this.studentID);
        hash = 53 * hash + Objects.hashCode(this.courseID);
        hash = 53 * hash + Objects.hashCode(this.workType);
        hash = 53 * hash + Objects.hashCode(this.date);
        hash = 53 * hash + this.maximumScore;
        hash = 53 * hash + this.actualScore;
        return hash;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) 
        {
            return true;
        }
        if (obj == null) 
        {
            return false;
        }
        if (getClass() != obj.getClass()) 
        {
            return false;
        }
        final GradeItem other = (GradeItem) obj;
        if (this.gradeItemID != other.gradeItemID) 
        {
            return false;
        }
        if (this.maximumScore != other.maximumScore) 
        {
            return false;
        }
        if (this.actualScore != other.actualScore) 
        {
            return false;
        }
        if (!Objects.equals(this.studentID, other.studentID)) 
        {
            return false;
        }
        if (!Objects.equals(this.courseID, other.courseID)) 
        {
            return false;
        }
        if (!Objects.equals(this.workType, other.workType)) 
        {
            return false;
        }
        return Objects.equals(this.date, other.date);
    }

    @Override
    public String toString() {
        return "GradeItem{" + "gradeItemID=" + gradeItemID + ", studentID=" 
                + studentID + ", courseID=" + courseID + ", workType=" 
                + workType + ", date=" + date + ", maximumScore=" + maximumScore + ", actualScore=" + actualScore + '}';
    }

    
}

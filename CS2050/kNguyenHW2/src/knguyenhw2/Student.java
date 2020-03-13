/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knguyenhw2;

import java.util.Objects;

/**
 * This class gets the students ID number, first name, last name, and email
 * address to sign them in to see their grades.
 * @author Kha Nguyen
 * @version 1/24/17
 */
public class Student {
    String studentID;
    String studentFirstName;
    String studentLastName;
    String studentEmail;
/**
 * This will get the students information and sign them in to see their grades
 * @param studentID Student's ID number
 * @param studentFirstName Student's first name
 * @param studentLastName Student's last name
 * @param studentEmail  Student's email address
 */
    public Student(String studentID, String studentFirstName, 
                    String studentLastName, String studentEmail) 
    {
        this.studentID = studentID;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentEmail = studentEmail;
    }

    Student(String string, String string0, double parseDouble) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Student() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getStudentID() 
    {
        return studentID;
    }

    public String getStudentFirstName() 
    {
        return studentFirstName;
    }

    public String getStudentLastName() 
    {
        return studentLastName;
    }

    public String getStudentEmail() 
    {
        if (studentEmail.contains("@"))
        {
            
        
        }
        else {
                     throw new IllegalArgumentException("There is no @ in your email");
                    }
        return studentEmail;
    }

    @Override
    public int hashCode() 
    {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.studentID);
        hash = 53 * hash + Objects.hashCode(this.studentFirstName);
        hash = 53 * hash + Objects.hashCode(this.studentLastName);
        hash = 53 * hash + Objects.hashCode(this.studentEmail);
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
        final Student other = (Student) obj;
        if (!Objects.equals(this.studentID, other.studentID)) 
        {
            return false;
        }
        if (!Objects.equals(this.studentFirstName, other.studentFirstName)) 
        {
            return false;
        }
        if (!Objects.equals(this.studentLastName, other.studentLastName)) 
        {
            return false;
        }
        if (!Objects.equals(this.studentEmail, other.studentEmail)) 
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", studentFirstName=" 
                + studentFirstName + ", studentLastName=" + studentLastName 
                + ", studentEmail=" + studentEmail + '}';
    }
    
    
}

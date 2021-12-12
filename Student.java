package SMSandCMS;

import java.util.Scanner;

public class Student {
    public int studentID;
    public String firstName;
    public String lastName;
    public String gradeLevel;
    public boolean status;

    public Student(String firstName, String lastName, String gradeLevel, int studentID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gradeLevel = gradeLevel;
        this.studentID = (int) (Math.random()*100);
        this.status = true;

    }




    public int getStudentID() {
        return studentID;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public String toString() {
        String activityMsg = "";
        if (status == true) {
            activityMsg = "Active";
        } else {
            activityMsg = "Inactive";
        }
        return String.format("First name: " + firstName + "\nLast name: " + lastName + "\nLevel: " + gradeLevel + "\nStatus: " + activityMsg + "\nID: " + studentID + "\n");


    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public String getStudentName() {
        return firstName + " " + lastName;
    }

    public String getStudentInfo() {
        String activityMsg2 = "";
        if (status == true) {
            activityMsg2 = "Active";
        } else {
            activityMsg2 = "Inactive";
        }
        return firstName + " " + lastName + "\nID: " + studentID + "\nGrade Level: " + gradeLevel + "\nStatus: " + activityMsg2 + "\n";


    }

}

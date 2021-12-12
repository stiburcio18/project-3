package SMSandCMS;

import java.util.*;


public class StudentEmployee extends Student {
    String job;
    int numberOfStudents;
    public StudentEmployee(String firstName, String lastName, String gradeLevel, int studentID, String job) {
        super(firstName, lastName, gradeLevel, studentID);
        this.job = job;
    }

    public void setJob(String job) {
        this.job = job;
        }

    public String toString() {
        String activityMsg = "";
        if (status == true) {
            activityMsg = "Active";
        } else {
            activityMsg = "Inactive";
        }
        return String.format("First name: " + firstName + "\nLast name: " + lastName + "\nLevel: " + gradeLevel + "\nStatus: " + activityMsg + "\nID: " + studentID + "\n" +
                "\nJob: " + job);


    }


}

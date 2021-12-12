package SMSandCMS;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class SamuelTiburcio_Section002_Project3 {

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to the Student and Course Management System \nHow many students will this system have? ");
        Scanner in = new Scanner(System.in);
        int numberOfStudents = in.nextInt();

        System.out.println("Press '1' to open the Student Management System \nPress '2' to open the Course Management System \nPress '0' to exit." );
        int choice = in.nextInt();

        while (choice == 1){

            Student[] students = new Student[numberOfStudents];
            int count = 0;
            System.out.println("Welcome to the Student Management System");

            System.out.println("Press '1' to add a student\nPress '2' to deactivate a student\nPress '3' to display all students\nPress '4' to search for a student by ID\nPress '5' to assign a job to a student\n" +
                    "Press '6' to display students with jobs\nPress '0' to exit the system");
            int function = in.nextInt();

            while (function != 0) {
                switch(function) {
                    case 1:
                        System.out.println("What is the student's first name? ");
                        String firstName = in.next();
                        System.out.println("What is the student's last name? ");
                        String lastName = in.next();
                        System.out.println("-Freshman\n-Sophomore\n-Junior\n-Senior\nWhat is the student's grade level?");
                        String gradeLevel = in.next();

                        if (count < numberOfStudents) {
                            students[count] = new Student (firstName, lastName, gradeLevel, 0);
                            System.out.println(firstName + " " + lastName + " has been added as a " + gradeLevel + ". Their student ID is " + students[count].getStudentID());
                            count++;

                        }



                        break;
                    case 2:
                        System.out.println("Enter the ID for the student you want to deactivate: ");
                        int getID = in.nextInt();
                        for (int n = 0; n<numberOfStudents; n++) {
                            Student temp = students[n];
                            if(temp.getStudentID() == getID) {
                                students[n].setStatus(false);
                                System.out.println(students[n].getStudentName() +" has been deactivated. ");

                            }


                        }
                        break;


                    case 3:
                        for (int n = 0; n<numberOfStudents; n++) {
                            System.out.println(students[n].toString());
                        }
                        break;

                    case 4:
                        System.out.println("Enter the ID for the student you want to search: ");
                        int searchID = in.nextInt();
                        for (int n = 0; n<numberOfStudents; n++) {
                            Student temp2 = students[n];
                            if(temp2.getStudentID() == searchID) {
                                System.out.println(students[n].getStudentInfo());

                            }

                            break;

                        }
                    case 5:

                        System.out.println("Enter the ID for the student you want to assign a job to: ");
                        int searchJobID = in.nextInt();
                        in.nextLine();


                        for (int n = 0; n < numberOfStudents; n++) {
                            Student temp3 = students[n];
                            if (temp3.getStudentID() == searchJobID) {
                                System.out.println("Enter the job you want to assign to the student: ");
                                String newJob = in.nextLine();
                                StudentEmployee newStudentEmployee = new StudentEmployee(temp3.getFirstName(), temp3.getLastName(), temp3.getGradeLevel(),
                                        temp3.getStudentID(), newJob);
                                students[n] = newStudentEmployee;


                                System.out.println(students[n].getFirstName() + " " + students[n].getLastName() + " has been assigned the " + newJob + " job.");


                            }
                            else {
                                // exception handler for if the student ID isn't in the system
                            }



                        }
                        break;

                    case 6:
                        for (int n = 0; n < numberOfStudents; n++) {
                            if (students[n] instanceof StudentEmployee) {
                                System.out.println(students[n].toString());

                                break;
                            }
                        }
                    case 0:
                        break;


                }
                System.out.println("Press '1' to add a student\nPress '2' to deactivate a student\nPress '3' to display all students\nPress '4' to search for a student by ID\nPress '5' to assign a job to a student\n" +
                        "Press '6' to display students with jobs\nPress '0' to exit the system");
                function = in.nextInt();

            }

            System.out.print("You have exited the system.");

            if (function == 0){

                System.out.println("\nPress '1' to open the Student Management System \nPress '2' to open the Course Management System \nPress '0' to exit." );
                choice = in.nextInt();
            }




        }
        if (choice == 2){

            System.out.println("Welcome to the Course Management System.");
            System.out.println("Press '1' to add a new course.\nPress '2' to add a student a new course\nPress '3' to display students with courses\nPress '0' to exit");

            int function2 = in.nextInt();

            while (function2 != 0) {

                switch(function2){
                    case 1:
                        try{
                            File courses = new File("courses.txt");
                                System.out.println("What are the courses that you would like to add?");
                                in.nextLine();
                                String course = in.nextLine();
                                FileWriter fw = new FileWriter(courses, true);
                                Course newCourse = new Course(course);
                                fw.write(newCourse.getName() + " " + newCourse.getCourseID() + "\n");
                                fw.close();
                        }catch (IOException e){
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                        }



                        break;
                    case 2:
                        try {
                            File courseAssignment = new File("courseAssignment.txt");
                            System.out.println("Enter student ID: ");
                            in.nextLine();
                            int studentID = in.nextInt();
                            System.out.println("Enter class name: ");
                            in.nextLine();
                            String courseName = in.nextLine();
                            FileWriter fw = new FileWriter(courseAssignment, true);
                            fw.write(studentID + " " + courseName + "\n");
                            fw.close();
                        } catch(IOException e) {
                            e.printStackTrace();

                            break;

                    }
                    case 3:
                        File file = new File("courseAssignment.txt");
                        Scanner scan = new Scanner(file);

                        while (scan.hasNextLine()){
                            System.out.println(scan.nextLine());
                        }
                    case 0:
                        break;
                }


                System.out.println("Press '1' to add a new course.\nPress '2' to add a student a new course\nPress '3' to display students with courses\nPress '0' to exit");
                function2 = in.nextInt();

            }

            System.out.println("You have exited the system.");

            if (function2 == 0) {

                System.out.println("\nPress '1' to open the Student Management System \nPress '2' to open the Course Management System \nPress '0' to exit.");
                choice = in.nextInt();

                if (choice == 0) {
                System.out.println("You have exited the whole system. Goodbye.");
                }

            }
        }

    }
}

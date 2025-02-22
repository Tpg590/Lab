/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191249_s04;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * S04 - Check student's data format.
 *
 * @author Le Thien Tri - CE191249 - Date: 11/2/2025
 */
class StudentInfo {

    // Declare a variable to stop while true loop.
    private boolean loop = true;
    // Declare a variable to store the user's choice (e.g., Y/N for continuing input)
    private String choice;
    // Declare a variable to store the student's name
    private String studentName;
    // Declare a variable to store the student's class name
    private String className;
    // Declare a temporary variable for validation checks
    private String check;
    // Declare variables to store subject marks
    private double total;
    private double mathMarks; // Stores math marks
    private double physicalMarks; // Stores physics marks
    private double chemistryMarks;  // Stores chemistry marks
    private int a = 0; // Stores A type Student.
    private int b = 0; // Stores B type Student.
    private int c = 0; // Stores C type Student.
    private int d = 0; // Stores D type Student.
    // Create a Scanner object for user input
    private Scanner sc = new Scanner(System.in);
    // Create an instance of IOChecking for input validation
    private IOChecking checkItem = new IOChecking();
    // Create an ArrayList to store student records
    private ArrayList<StudentClassification> save = new ArrayList<>();
    // Create an Object StudentClassification
    private StudentClassification student = new StudentClassification();

    /**
     * Method to display all student's information stored in the list
     */
    public void showStudent() {
        int i = 1; // Initialize student index
        for (StudentClassification studentClassification : save) {
            // Display student details
            System.out.printf("------ Student%d Info ------%n", i);
            System.out.println(studentClassification.studentData());
            i++; // Increment index for the next student

        }

        total = i - 1;
        // total - setTotal. setTotal into object StudentClassification.
        student.setTotal(total);
        System.out.println("--------Classification Info ----");
        // Print out Classification Info.
        System.out.println(student.totalPoint());
    }

    /**
     * Method to input multiple student's information
     */
    public void inputStudent() {
        do {
            // Collect student details
            studentName();
            className();
            mathMarks();
            physicalMarks();
            chemistryMarks();
            // Add new student object to the list
            collectStudentType();
            save.add(new StudentClassification(studentName, className, mathMarks, physicalMarks, chemistryMarks));
            // Ask user if they want to continue entering student information            
            System.out.print("Do you want to enter more student information!(Y/N):");
            // While (loop) used to loop choice when choice != "y", "Y", "n", "N".
            while (loop) {
                choice = sc.nextLine().trim();
                if (checkItem.checkYesNo(choice, "Please enter Y/N")) {

                } else if (choice.equals("n") || choice.equals("N")) {
                    showStudent();
                    loop = false;
                    break;
                } else {
                }

            }
        } while (choice.equals("Y") || "y".equals(choice)); // Continue if user inputs 'Y' or 'y'
        // Display all student records after input is completed

    }

    /**
     * Method to input and validate the student's name
     */
    public void studentName() {
        while (true) {
            System.out.print("Name: ");
            check = sc.nextLine().trim();
            // Validate name to ensure it does not contain special characters
            if (checkItem.checkSpecialCharacter(check, "Error please enter again.")) {
                // If the input is invalid, the loop continues
            } else {
                studentName = check; // Assign valid name
                break; // Exit loop
            }
        }
    }

    /**
     * Method to input the student's class name
     */
    public void className() {
        while (true) {
            System.out.print("Class: ");
            check = sc.nextLine().trim();
            // Validate name to ensure it does not contain special characters
            if (checkItem.checkSpecialCharacter(check, "Error please enter again.")) {
                // If the input is invalid, the loop continues
            } else {
                className = check; // Assign valid name
                break; // Exit loop
            }
        }
    }

    /**
     * Method to input and validate math marks
     */
    public void mathMarks() {
        while (true) { // Loop until valid input is provided
            System.out.print("Maths: "); // Prompt user to enter Math marks
            check = sc.nextLine().trim(); // Read input and remove any leading/trailing spaces

            // Validate that the input contains only digits (no letters or symbols)
            if (checkItem.checkContainCharacterAndSymbol(check, "Maths is digit")) {
                // If input is invalid, continue looping
            } // Check if the input is greater than 10
            else if (Double.parseDouble(check) > 10) {
                System.out.println("Maths is less than or equal to ten");
            } // Check if the input is less than 0
            else if (Double.parseDouble(check) < 0) {
                System.out.println("Maths is greater than or equal to zero");
            } // If the input is valid, assign it to mathMarks
            else {
                mathMarks = Double.parseDouble(check); // Convert input to double and store in mathMarks
                student.setMathMarks(mathMarks); // Set the Math marks for the student object
                break; // Exit the loop
            }
        }
    }

    /**
     * Method to input and validate physics marks
     */
    public void physicalMarks() {
        while (true) { // Loop until valid input is provided
            System.out.print("Physics: "); // Prompt user to enter Physics marks
            check = sc.nextLine().trim(); // Read input and remove any leading/trailing spaces

            // Validate that the input contains only digits (no letters or symbols)
            if (checkItem.checkContainCharacterAndSymbol(check, "Physics is digit")) {
                // If input is invalid, continue looping
            } // Check if the input is greater than 10
            else if (Double.parseDouble(check) > 10) {
                System.out.println("Physics is less than or equal to ten");
            } // Check if the input is less than 0
            else if (Double.parseDouble(check) < 0) {
                System.out.println("Physics is greater than or equal to zero");
            } // If the input is valid, assign it to physicalMarks
            else {
                physicalMarks = Double.parseDouble(check); // Convert input to double and store in physicalMarks
                student.setPhysicalMarks(physicalMarks); // Set the Physics marks for the student object
                break; // Exit the loop
            }
        }
    }

    /**
     * Method to input and validate Chemistry marks
     */
    public void chemistryMarks() {
        while (true) { // Loop until valid input is provided
            System.out.print("Chemistry: "); // Prompt user to enter Chemistry marks
            check = sc.nextLine().trim(); // Read input and remove any leading/trailing spaces

            // Validate that the input contains only digits (no letters or symbols)
            if (checkItem.checkContainCharacterAndSymbol(check, "Chemistry is digit")) {
                // If input is invalid, continue looping
            } // Check if the input is greater than 10
            else if (Double.parseDouble(check) > 10) {
                System.out.println("Chemistry is less than or equal to ten");
            } // Check if the input is less than 0
            else if (Double.parseDouble(check) < 0) {
                System.out.println("Chemistry is greater than or equal to zero");
            } // If the input is valid, assign it to chemistryMarks
            else {
                chemistryMarks = Double.parseDouble(check); // Convert input to double and store in chemistryMarks
                student.setChemistryMarks(chemistryMarks); // Set the Chemistry marks for the student object
                break; // Exit the loop
            }
        }
    }

    /**
     * This function used to count Type of Student A, B, C, D. collection to
     * output Classification Student info board.
     */
    public void collectStudentType() {
        // If Student type == "A" a++ and store into student.setA
        if (student.typeStudent().equals("A")) {
            a++;
            student.setA(a);
        } // If Student type == "B" b++ and store into student.setB
        else if (student.typeStudent().equals("B")) {
            b++;
            student.setB(b);
        } // If Student type == "C" c++ and store into student.setC
        else if (student.typeStudent().equals("C")) {
            c++;
            student.setC(c);
        } // d++ and store into student.setD
        else {
            d++;
            student.setD(d);
        }
    }

}

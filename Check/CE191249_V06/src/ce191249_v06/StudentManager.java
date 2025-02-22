/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191249_v06;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * V06 - Title: Array and string manipulations.
 *
 * @author Le Thien Tri _ CE191249 - Date: 15/02/2025
 */
public class StudentManager {

    // Variable to keep track of student count
    private int count;

    // Control variable for the main loop
    private boolean loop = true;

    // Control variable for inner loops
    private boolean miniLoop = true;

    // Stores the student's name input
    private String studentName;

    // Stores the user's choice from the menu
    private String choice;

    // Scanner object for user input
    private Scanner sc = new Scanner(System.in);

    // IOChecking instance for input validation
    private IOChecking check = new IOChecking();

    // Instance of StudentData to store student information
    private StudentData studentdata = new StudentData();

    // ArrayList to store multiple student records
    private ArrayList<StudentData> array = new ArrayList<>();

    /**
     * Displays the main menu with available options.
     */
    public void menu() {
        System.out.println("");
        System.out.println("**********************************");
        System.out.println("1 - Add a student.");
        System.out.println("2 - Remove a student.");
        System.out.println("3 - Search a student.");
        System.out.println("4 - Print student list in ascending order.");
        System.out.println("5 - Exit.");
        System.out.println("**********************************");
        System.out.println("");
        System.out.print("Enter your choice:");
    }

    /**
     * Main loop to handle student management operations. The loop continues
     * until the user chooses to exit.
     */
    public void run() {
        while (loop) {
            // Display menu options
            menu();
            // Read user choice
            choice = sc.nextLine().trim();

            // Validate choice input
            if (check.checkChoice(choice, "Please enter (1-5).")) {
                // If input is invalid, loop continues without executing any case
            } else {
                // Handle different user choices
                switch (choice) {

                    case "1": // Add a student
                        miniLoop = true;
                        while (miniLoop) {
                            System.out.print("Enter new student name:");
                            studentName = sc.nextLine().trim();

                            // Validate student name for special characters
                            if (check.checkSpecialCharacter(studentName, "Please enter a valid name.")) {
                                // If invalid, loop continues
                            } else {
                                miniLoop = false;

                                // Check if the list has reached the maximum limit
                                if (array.size() >= 100) {
                                    System.out.println("The list is full. Cannot add a new student.");
                                } else {
                                    // Add student to the list
                                    array.add(new StudentData(studentName));
                                    System.out.println("Student has been added successfully!");
                                }
                            }
                        }
                        break;

                    case "2": // Remove a student
                        if (array.isEmpty()) {
                            System.out.println("No students found. Please add a student first.");
                        } else {
                            miniLoop = true;
                            while (miniLoop) {
                                System.out.print("Enter student name to remove:");
                                studentName = sc.nextLine().trim();

                                // Validate input name
                                if (check.checkSpecialCharacter(studentName, "Please enter a valid name to remove.")) {
                                    // If invalid, loop continues
                                } else {
                                    miniLoop = false;

                                    // Remove student if found in the list
                                    boolean removed = array.removeIf(StudentData
                                            -> studentName.equalsIgnoreCase(StudentData.getStudentName()));

                                    if (removed) {
                                        System.out.println("Student has been removed successfully.");
                                    } else {
                                        System.out.println("Student not found in the list.");
                                    }
                                }
                            }
                        }
                        break;

                    case "3": // Search for a student
                        if (array.isEmpty()) {
                            System.out.println("No students found. Please add a student first.");
                        } else {
                            miniLoop = true;
                            while (miniLoop) {
                                System.out.print("Enter student name to search:");
                                studentName = sc.nextLine().trim();

                                // Validate input name
                                if (check.checkSpecialCharacter(studentName, "Please enter a valid name to search.")) {
                                    // If invalid, loop continues
                                } else {
                                    miniLoop = false;
                                    int i = 0;
                                    count = 1;

                                    // Iterate through the student list to find the student
                                    for (StudentData studentData : array) {
                                        i++;
                                        count++;
                                        if (studentData.getStudentName().equalsIgnoreCase(studentName)) {
                                            System.out.println("Student found at position: " + i);
                                            count = -1; // Break loop
                                        } else if (count > array.size()) {
                                            System.out.println("Student not found in the list.");
                                        }
                                    }
                                }
                            }
                        }
                        break;

                    case "4": // Sort and display students in ascending order
                        sortName();
                        printSortName();
                        break;

                    case "5": // Exit the program
                        loop = false;
                        break;
                }
            }
        }
    }

    /**
     * Sorts the student list in ascending order based on name length. Uses
     * Bubble Sort algorithm.
     */
    public void sortName() {
        // Outer loop: Controls the number of passes needed for sorting
        for (int i = 0; i < array.size() - 1; i++) {
            // Inner loop: Compares adjacent elements and swaps them if needed
            for (int j = 0; j < array.size() - 1 - i; j++) {
                // Compare student name lengths and swap if the current name is longer than the next
                if (array.get(j).getStudentLength() > array.get(j + 1).getStudentLength()) {
                    // Temporary variable to hold the current student data
                    StudentData temp = array.get(j);
                    // Move the smaller-length name to the current position
                    array.set(j, array.get(j + 1));
                    // Place the larger-length name in the next position
                    array.set(j + 1, temp);
                }
            }
        }

    }

    
    /**
     * Used to print all name of student in array with sortName.
     */
    public void printSortName() {
        // Loop through the sorted list and display each student's name
        for (StudentData studentData : array) {
            System.out.println(studentData.getStudentName());
        }
    }

}

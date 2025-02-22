/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191249_s07;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * S07 - Title: Company staff management.
 *
 * @author Le Thien Tri - CE191249 - Date: 18/2/2025
 */
public class Employee {

    // Private instance variables to store employee data
    private String choice;        // Stores user choice from menu
    private String input;         // Stores temporary input from user
    private String id;            // Stores employee ID
    private String name;          // Stores employee name
    private String maxEmployee;   // Stores the number of employees to be added
    private double salary;        // Stores employee salary
    private double COE;           // Stores coefficient of salary
    private boolean loop = true;  // Controls the main loop execution

    // Scanner object to take user input
    private Scanner sc = new Scanner(System.in);

    // Object to validate user input
    private IOChecking checking = new IOChecking();

    // List to store employee data
    private ArrayList<EmployeeData> array = new ArrayList<>();

    /**
     * Method to run the program, displaying the menu and handling user choices.
     */
    public void run() {
        while (loop) {
            menu();  // Display the menu
            System.out.print("Please choose: ");
            choice = sc.nextLine().trim(); // Read user input and remove leading/trailing spaces
            System.out.println("");

            // Handle user input with a switch statement
            switch (choice) {
                case "1":
                    create();  // Call method to input employee data
                    loop = true; // Continue the loop
                    break;
                case "2":
                    show();  // Call method to display employee data
                    loop = true; // Continue the loop
                    break;
                case "0":
                    System.out.println("");
                    System.out.println("SEE YOU AGAIN!"); // Exit message
                    loop = false; // Stop the loop
                    break;
                default:
                    System.out.println("Please enter 1, 2, or 0"); // Handle invalid input
            }
        }
    }

    /**
     * Method to display the menu options.
     */
    public void menu() {
        System.out.println("");
        System.out.println("----------MENU----------");
        System.out.println("1. Input employee.");
        System.out.println("2. Show list employee.");
        System.out.println("0. Exit.");
    }

    /**
     * Method to display the list of employees.
     */
    public void show() {
        System.out.println("");
        System.out.println("===================List Employee===================");
        System.out.println("|ID        |Name            |Salary     |COE"); // Table header
        for (EmployeeData employeeData : array) { // Loop through the employee list
            System.out.println(employeeData.getData()); // Print employee data
        }
        System.out.println("");
    }

    /**
     * Method to create and add employees to the list.
     */
    public void create() {
        while (loop) {
            System.out.print("+ Enter number of employees: ");
            maxEmployee = sc.nextLine().trim(); // Read input for number of employees
            if (checking.checkMax(maxEmployee, "Please enter a number.")) {
                // If input validation fails, loop continues
            } else {
                // Convert maxEmployee to an integer and iterate to create employees
                for (int i = 1; i <= Integer.parseInt(maxEmployee); i++) {
                    System.out.println("- Employee " + i + ":");
                    inputID();      // Call method to input employee ID
                    inputName();    // Call method to input employee name
                    inputSalary();  // Call method to input employee salary
                    inputCOE();     // Call method to input coefficient salary
                    array.add(new EmployeeData(id, name, salary, COE)); // Add employee to list
                    System.out.println("");
                }
                loop = false; // Exit loop after adding employees
            }
        }
    }

    /**
     * Method to input and validate Employee ID.
     */
    public void inputID() {
        System.out.print("--Please enter ID number: ");
        loop = true;
        while (loop) {
            input = sc.nextLine().trim(); // Read user input
            if (checking.checkID(input, "--------Error! Please enter ID number again (NVxxxx):")) {
                // If validation fails, loop continues
            } else {
                id = input; // Assign input to employee ID
                loop = false; // Exit loop
            }
        }
    }

    /**
     * Method to input and validate Employee Name.
     */
    public void inputName() {
        System.out.print("--Please enter name: ");
        loop = true;
        while (loop) {
            input = sc.nextLine().trim(); // Read user input
            if (input.isEmpty()) {
                System.out.print("--------Error! Please enter name again (Not Null):");
            } else if (checking.checkName(input, "--------Error! Please enter name again:")) {
                // If validation fails, loop continues
            } else {
                name = input; // Assign input to employee name
                loop = false; // Exit loop
            }
        }
    }

    /**
     * Method to input and validate Employee Salary.
     */
    public void inputSalary() {
        System.out.print("--Please enter salary: ");
        loop = true;
        while (loop) {
            input = sc.nextLine().trim(); // Read user input
            if (Double.parseDouble(input) <= 100) {
                System.out.print("--------Error! Please enter salary again (Salary > 100 USD):");
            } else if (checking.checkSalary(input, "--------Error! Please enter salary again (Must be a number and Not Null):")) {
                // If validation fails, loop continues
            } else {
                salary = Double.parseDouble(input); // Convert input to double and store in salary
                loop = false; // Exit loop
            }
        }
    }

    /**
     * Method to input and validate Coefficient of Salary (COE).
     */
    public void inputCOE() {
        System.out.print("--Please enter coefficient salary: ");
        loop = true;
        while (loop) {
            input = sc.nextLine().trim(); // Read user input
            if (Double.parseDouble(input) < 1 || Double.parseDouble(input) > 5) {
                System.out.print("--------Error! Please enter coefficient salary again (From 1 to 5):");
            } else if (checking.checkCOE(input, "--------Error! Please enter coefficient salary again (Must be a number and Not Null):")) {
                // If validation fails, loop continues
            } else {
                COE = Double.parseDouble(input); // Convert input to double and store in COE
                loop = false; // Exit loop
            }
        }
    }
}

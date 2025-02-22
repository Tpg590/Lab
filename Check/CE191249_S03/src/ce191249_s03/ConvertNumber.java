/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191249_s03;

import java.util.Scanner;

/**
 * S03 - Title Convert binary, octal and hexadecimal to decimal.
 *
 * @author Le Thien Tri - CE191249 11/02/2025
 */
public class ConvertNumber {
    // Declare a variable to store user choice for menu selection

    private String choice;

    // Declare a variable to store user input for validation
    private String check;

    // Create a Scanner object to read user input
    private Scanner sc = new Scanner(System.in);

    // Create an instance of IOChecking for input validation
    private IOChecking checkItem = new IOChecking();

    // Create instances of classes that handle different number conversions
    private BinaryNumber binary = new BinaryNumber();    // Handles binary to decimal conversion
    private OctalNumber octal = new OctalNumber();       // Handles octal to decimal conversion
    private HexaNumber hexadecimal = new HexaNumber();   // Handles hexadecimal to decimal conversion

    // Declare a boolean variable to control the loop
    private boolean loop = true;

    /**
     * Method to display the menu and perform number conversions
     */
    public void showConvertNumber() {
        while (loop) { // Continue running until the user chooses to exit
            // Display menu options
            System.out.println("1. Convert binary number to decimal number");
            System.out.println("2. Convert octal number to decimal number");
            System.out.println("3. Convert hexadecimal number to decimal number");
            System.out.println("4. Exit");
            System.out.print("Please choose number (1-4): ");
            choice = sc.nextLine().trim(); // Read user choice and remove extra spaces
            System.out.println(""); // Print an empty line for better readability

            // Process user choice using switch-case
            switch (choice) {
                case "1":
                    // Convert binary number to decimal
                    while (true) {
                        System.out.print("Enter binary number: ");
                        check = sc.nextLine().trim(); // Read user input

                        // Validate binary input
                        if (checkItem.checkBinary(check, "Please enter again.")) {
                            // If invalid, prompt again
                        } else {
                            // Convert binary to decimal and display the result
                            System.out.println("Decimal number is: " + binary.getBinaryData(check));
                            System.out.println(""); // Print an empty line
                            break; // Exit loop
                        }
                    }
                    break;

                case "2":
                    // Convert octal number to decimal
                    while (true) {
                        System.out.print("Enter Octal number: ");
                        check = sc.nextLine().trim(); // Read user input

                        // Validate octal input
                        if (checkItem.checkOctal(check, "Please enter again.")) {
                            // If invalid, prompt again
                        } else {
                            // Convert octal to decimal and display the result
                            System.out.println("Decimal number is: " + octal.getOctalData(check));
                            System.out.println(""); // Print an empty line
                            break; // Exit loop
                        }
                    }
                    break;

                case "3":
                    // Convert hexadecimal number to decimal
                    while (true) {
                        System.out.print("Enter Hexadecimal number: ");
                        check = sc.nextLine().trim().toUpperCase(); // Read user input and convert to uppercase

                        // Validate hexadecimal input
                        if (checkItem.checkHexaDecimal(check, "Please enter again.")) {
                            // If invalid, prompt again
                        } else {
                            // Convert hexadecimal to decimal and display the result
                            System.out.println("Decimal number is: " + hexadecimal.getHexaDecimalData(check));
                            System.out.println(""); // Print an empty line
                            break; // Exit loop
                        }
                    }
                    break;

                case "4":
                    // Exit the program
                    loop = false; // Set loop condition to false to terminate while loop
                    System.out.println("Good Bye.");
                    System.out.println(""); // Print an empty line
                    break;

                default:
                    // Handle invalid menu choices
                    System.out.println("Please enter (1-4)");
                    System.out.println(""); // Print an empty line
            }
        }
    }
}

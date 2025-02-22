/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191249_s07;

/**
 * S07 - Title: Company staff management.
 *
 * @author Le Thien Tri - CE191249 - Date: 18/2/2025
 */
public class IOChecking {

    /**
     * Method to check if the input ID follows the format "NVxxxx".
     *
     * @param input The ID entered by the user.
     * @param msg The error message to be displayed if the format is incorrect.
     * @return true if the input is invalid, false if it is valid.
     */
    public boolean checkID(String input, String msg) {
        try {
            // Check if the input matches the required format: "NV" followed by exactly 4 digits.
            if (!input.matches("^(NV)[0-9]{4,4}")) {
                // If not, throw an exception with the provided message.
                throw new Exception(msg);
            }
            // Return false (valid input).
            return false;
        } catch (Exception e) {
            // Print out the error message.
            System.out.print(e.getMessage());
            // Return true (invalid input).
            return true;
        }
    }

    /**
     * Method to check if the input name contains only letters and spaces.
     *
     * @param input The name entered by the user.
     * @param msg The error message to be displayed if the name contains invalid
     * characters.
     * @return true if the input is invalid, false if it is valid.
     */
    public boolean checkName(String input, String msg) {
        try {
            // Check if the input contains only letters (a-z, A-Z) and spaces.
            if (!input.matches("[a-zA-Z ]+")) {
                // If not, throw an exception with the provided message.
                throw new Exception(msg);
            }
            // Return false (valid input).
            return false;
        } catch (Exception e) {
            // Print out the error message.
            System.out.print(e.getMessage());
            // Return true (invalid input).
            return true;
        }
    }

    /**
     * Method to check if the salary input contains only numbers.
     *
     * @param input The salary entered by the user.
     * @param msg The error message to be displayed if the salary is invalid.
     * @return true if the input is invalid, false if it is valid.
     */
    public boolean checkSalary(String input, String msg) {
        try {
            // Check if the input contains only numeric characters (no decimals).
            if (!input.matches("[0-9]+")) {
                // If not, throw an exception with the provided message.
                throw new Exception(msg);
            }
            // Return false (valid input).
            return false;
        } catch (Exception e) {
            // Print out the error message.
            System.out.print(e.getMessage());
            // Return true (invalid input).
            return true;
        }
    }

    /**
     * Method to check if the coefficient of salary (COE) input contains only
     * numbers and decimals.
     *
     * @param input The COE entered by the user.
     * @param msg The error message to be displayed if the COE is invalid.
     * @return true if the input is invalid, false if it is valid.
     */
    public boolean checkCOE(String input, String msg) {
        try {
            // Check if the input contains only numbers (including decimals).
            if (!input.matches("[0-9.]+")) {
                // If not, throw an exception with the provided message.
                throw new Exception(msg);
            }
            // Return false (valid input).
            return false;
        } catch (Exception e) {
            // Print out the error message.
            System.out.print(e.getMessage());
            // Return true (invalid input).
            return true;
        }
    }

    /**
     * Method to check if the input for the maximum number of employees is a
     * valid number.
     *
     * @param input The maximum number of employees entered by the user.
     * @param msg The error message to be displayed if the input is invalid.
     * @return true if the input is invalid, false if it is valid.
     */
    public boolean checkMax(String input, String msg) {
        try {
            // Check if the input contains only numbers.
            if (!input.matches("[0-9]+")) {
                // If not, throw an exception with the provided message.
                throw new Exception(msg);
            }
            // Return false (valid input).
            return false;
        } catch (Exception e) {
            // Print out the error message.
            System.out.println(e.getMessage());
            // Return true (invalid input).
            return true;
        }
    }
}

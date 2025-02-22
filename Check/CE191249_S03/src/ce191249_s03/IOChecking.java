/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191249_s03;

/**
 * S03 - Title Convert binary, octal and hexadecimal to decimal.
 *
 * @author Le Thien Tri - CE191249 11/02/2025
 */
public class IOChecking {

    /**
     * Validates if the input string is a valid binary number (only contains 0s
     * and 1s).
     *
     * @param input The user-provided input string.
     * @param msg The error message to display if the validation fails.
     * @return true if the input is invalid (contains characters other than 0 or
     * 1), otherwise false.
     */
    public boolean checkBinary(String input, String msg) {

        try {
            // Check if the input consists only of binary digits (0 and 1).
            if (!input.matches("[0-1]+")) {
                // If the input contains invalid characters, throw an exception.
                throw new Exception(msg);
            }

            // Return false if the input is a valid binary number.
            return false;
        } catch (Exception e) {
            // Print the error message.
            System.out.println(e.getMessage());

            // Return true if the input is not a valid binary number.
            return true;
        }
    }

    /**
     * Validates if the input string is a valid octal number (only contains
     * digits 0-7).
     *
     * @param input The user-provided input string.
     * @param msg The error message to display if the validation fails.
     * @return true if the input is invalid (contains characters outside 0-7),
     * otherwise false.
     */
    public boolean checkOctal(String input, String msg) {

        try {
            // Check if the input consists only of octal digits (0-7).
            if (!input.matches("[0-7]+")) {
                // If the input contains invalid characters, throw an exception.
                throw new Exception(msg);
            }

            // Return false if the input is a valid octal number.
            return false;
        } catch (Exception e) {
            // Print the error message.
            System.out.println(e.getMessage());

            // Return true if the input is not a valid octal number.
            return true;
        }
    }

    /**
     * Validates if the input string is a valid hexadecimal number (contains
     * digits 0-9 and letters A-F/a-f).
     *
     * @param input The user-provided input string.
     * @param msg The error message to display if the validation fails.
     * @return true if the input is invalid (contains characters outside 0-9 and
     * A-F/a-f), otherwise false.
     */
    public boolean checkHexaDecimal(String input, String msg) {

        try {
            // Check if the input consists only of valid hexadecimal digits (0-9, A-F, a-f).
            if (!input.matches("[0-9A-Fa-f]+")) {
                // If the input contains invalid characters, throw an exception.
                throw new Exception(msg);
            }

            // Return false if the input is a valid hexadecimal number.
            return false;
        } catch (Exception e) {
            // Print the error message.
            System.out.println(e.getMessage());

            // Return true if the input is not a valid hexadecimal number.
            return true;
        }
    }

}

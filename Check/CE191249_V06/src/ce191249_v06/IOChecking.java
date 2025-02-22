/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191249_v06;

/**
 * V06 - Title: Array and string manipulations.
 *
 * @author Le Thien Tri _ CE191249 - Date: 15/02/2025
 */
public class IOChecking {

    /**
     * Checking the special character and symbol.
     *
     * @param input is the input from user.
     *
     * @return true if there are contain character. False if no.
     */
    public boolean checkContainCharacterAndSymbol(String input, String msg) {

        // Try to convert the input to double.
        try {
            Double.parseDouble(input);

            // Return false if there are no exception occur.
            return false;

            // Catch the exception if there are a error occur.
        } catch (Exception e) {

            System.out.println(msg);
            // Return false if there is an exception.
            return true;
        }
    }

    /**
     * Checking if there is any special character in the input string.
     *
     * @param input is the input from user.
     * @param msg is the message that will print out the user if a exception
     * occur.
     *
     * @return true if the input contain a special character. False if the input
     * does not contain any special character.
     */
    public boolean checkSpecialCharacter(String input, String msg) {

        try {

            // Checking if there is a special character in the input string.
            if (!input.matches("[a-zA-Z ]+")) {

                // If there is a special character in the input string then throw a exception.
                throw new Exception(msg);
            }

            // Return false if the input does not contain any special character.
            return false;
        } catch (Exception e) {

            // Print out the error.
            System.out.println(e.getMessage());

            // Return true if the input contain a special character.
            return true;
        }
    }

    /**
     * This method validates the user's input choice to ensure it is within the
     * allowed range (1-5). If the input contains any character outside this
     * range, an error message is displayed.
     *
     * @param input The user’s input choice.
     * @param msg The error message to display if the input is invalid.
     * @return true if the input is invalid (contains special characters or is
     * out of range), false if valid.
     */
    public boolean checkChoice(String input, String msg) {

        try {
            // Checking if the input contains only numbers from 1 to 5.
            if (!input.matches("[1-5]+")) {
                // If the input contains other characters, throw an exception with the provided error message.
                throw new Exception(msg);
            }

            // If the input is valid (only contains 1-5), return false (no error).
            return false;
        } catch (Exception e) {
            // Catch the exception and print the provided error message.
            System.out.println(e.getMessage());

            // Return true to indicate an invalid input.
            return true;
        }
    }

}

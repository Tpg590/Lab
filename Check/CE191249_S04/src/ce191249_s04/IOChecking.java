/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191249_s04;

/**
 * S04 - Check student's data format.
 *
 * @author Le Thien Tri - CE191249 - Date: 11/2/2025
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
     *
     * @param input if input is not Y, y = yes or N, n = No throw Exception msg
     *
     * @param msg display text user want when input != ynYN
     *
     * @return false when input != ynYN, return true when input ynYN.
     */
    public boolean checkYesNo(String input, String msg) {

        try {

            // Checking if there is a yes no in the input string.
            if (!input.matches("[nyNY]+")) {

                // If there is a yes no in the input string then throw a exception.
                throw new Exception(msg);
            }

            // Return false if the input does not contain any yes no.
            return false;
        } catch (Exception e) {

            // Print out the error.
            System.out.println(e.getMessage());

            // Return true if the input contain a yes no.
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
            if (!input.matches("[a-zA-Z0-9 ]+")) {

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

}

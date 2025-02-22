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
public class OctalNumber {

    /**
     * Converts an octal number (as a string) to its decimal equivalent.
     *
     * @param numberIn The input octal number in string format (e.g., "32").
     * @return The decimal equivalent of the given octal number.
     */
    public int getOctalData(String numberIn) {
        int decimalNumber = 0; // Stores the final decimal value.
        int base = 0; // Keeps track of the power of 8.
        int indexData = 0; // Stores the decimal value of each octal digit.

        // Convert the input string into an array of characters.
        String[] charArray = numberIn.split(""); // Example: "32" -> ["3", "2"]

        // Iterate through the characters of the octal number from right to left.
        for (int i = charArray.length - 1; i >= 0; i--) {
            // Convert the character to an integer.
            indexData = Integer.parseInt(charArray[i]);

            // Convert the octal digit to its decimal equivalent and add to the total.
            // Example: "32" -> (3 * 8^1) + (2 * 8^0) = 24 + 2 = 26
            decimalNumber += indexData * Math.pow(8, base);

            // Move to the next power of 8.
            base++;
        }

        return decimalNumber; // Return the final converted decimal value.
    }
}

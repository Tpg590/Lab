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
public class BinaryNumber {

    /**
     * Converts a binary number (as a string) to its decimal equivalent.
     *
     * @param numberIn The input binary number in string format (e.g., "11").
     * @return The decimal equivalent of the given binary number.
     */
    public int getBinaryData(String numberIn) {
        int decimalNumber = 0; // Stores the final decimal value.
        int base = 1; // Represents the current power of 2 (starting with 2^0).

        // Iterate through the binary number from right to left.
        for (int i = numberIn.length() - 1; i >= 0; i--) {
            // Check if the current binary digit is '1'.
            if (numberIn.charAt(i) == '1') {
                // Add the corresponding power of 2 to the decimal value.
                decimalNumber += base;
            }
            // Move to the next power of 2.
            base *= 2;
        }

        return decimalNumber; // Return the final converted decimal value.
    }
}

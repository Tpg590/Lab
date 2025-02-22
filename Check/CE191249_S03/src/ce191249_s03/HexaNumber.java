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
public class HexaNumber {

    /**
     * Converts a hexadecimal number (as a string) to its decimal equivalent.
     *
     * @param numberIn The input hexadecimal number in string format (e.g.,
     * "1F").
     * @return The decimal equivalent of the given hexadecimal number.
     */
    public int getHexaDecimalData(String numberIn) {
        int decimalNumber = 0; // Stores the final decimal value.
        int base = 0; // Keeps track of the power of 16.
        int indexData = 0; // Stores the decimal value of each hexadecimal digit.

        // A reference string containing valid hexadecimal characters.
        String myStr = "0123456789ABCDEF";

        // Convert the input string into an array of characters.
        String[] charArray = numberIn.split(""); // Example: "1F" -> ["1", "F"]

        // Iterate through the characters of the hexadecimal number from right to left.
        for (int i = charArray.length - 1; i >= 0; i--) {
            // Get the decimal value of the current hexadecimal digit.
            indexData = myStr.indexOf(charArray[i]);

            // Convert the hexadecimal digit to its decimal equivalent and add to the total.
            decimalNumber += indexData * Math.pow(16, base);

            // Move to the next power of 16.
            base++;
        }

        return decimalNumber; // Return the final converted decimal value.
    }
}

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
public class CE191249_S04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create an instance of StudentInfo to manage student data
        StudentInfo enterInfo = new StudentInfo();

        // Display a title for the program
        System.out.println("====== Management Student Program ======");

        // Call the method to input student details
        enterInfo.inputStudent();
    }
}

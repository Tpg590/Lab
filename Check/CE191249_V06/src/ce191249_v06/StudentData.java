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
 *
 * The StudentData class represents a student with a name and the length of the
 * name.
 */
public class StudentData {

    // Stores the name of the student
    private String studentName;

    // Stores the length of the student's name
    private int studentLength;

    /**
     * Default constructor. Creates a StudentData object without setting any
     * values.
     */
    public StudentData() {
    }

    /**
     * Parameterized constructor. Initializes the student name and calculates
     * its length.
     *
     * @param studentName The name of the student.
     */
    public StudentData(String studentName) {
        this.studentName = studentName;
        this.studentLength = studentName.length(); // Automatically set name length
    }

    /**
     * Gets the length of the student's name.
     *
     * @return The length of the student name.
     */
    public int getStudentLength() {
        return studentLength;
    }

    /**
     * Sets the length of the student's name. (This method is not commonly
     * needed since the length is set based on the name.)
     *
     * @param studentLength The length of the student's name.
     */
    public void setStudentLength(int studentLength) {
        this.studentLength = studentLength;
    }

    /**
     * Gets the name of the student.
     *
     * @return The student's name.
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Sets the name of the student.
     *
     * @param studentName The new name of the student.
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
        this.studentLength = studentName.length(); // Ensure name length is updated when name changes
    }
}

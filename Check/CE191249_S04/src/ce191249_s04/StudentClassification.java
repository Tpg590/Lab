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
public class StudentClassification {

    // Variables to store student information
    private String studentName;  // Name of the student
    private String className;    // Class name of the student

    // Variables to store student marks
    private double mathMarks;    // Math marks
    private double physicalMarks; // Physics marks
    private double chemistryMarks; // Chemistry marks

    // Variables for grade classification statistics
    private double total; // Total number of students
    private double A;     // Count of students with grade A
    private double B;     // Count of students with grade B
    private double C;     // Count of students with grade C
    private double D;     // Count of students with grade D

    // Getters and setters for grade classification counts
    public double getA() {
        return A;
    }

    /**
     * Sets the value of variable A.
     *
     * @param A The value to set for A.
     */
    public void setA(double A) {
        this.A = A;
    }

    /**
     * Retrieves the value of variable B.
     *
     * @return The current value of B.
     */
    public double getB() {
        return B;
    }

    /**
     * Sets the value of variable B.
     *
     * @param B The value to set for B.
     */
    public void setB(double B) {
        this.B = B;
    }

    /**
     * Retrieves the value of variable C.
     *
     * @return The current value of C.
     */
    public double getC() {
        return C;
    }

    /**
     * Sets the value of variable C.
     *
     * @param C The value to set for C.
     */
    public void setC(double C) {
        this.C = C;
    }

    /**
     * Retrieves the value of variable D.
     *
     * @return The current value of D.
     */
    public double getD() {
        return D;
    }

    /**
     * Sets the value of variable D.
     *
     * @param D The value to set for D.
     */
    public void setD(double D) {
        this.D = D;
    }

    /**
     * Retrieves the total value.
     *
     * @return The current total value.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Sets the total value.
     *
     * @param total The value to set for total.
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Default constructor - Initializes a StudentClassification object without
     * setting values.
     */
    public StudentClassification() {
    }

    /**
     * Parameterized constructor - Initializes a StudentClassification object
     * with specified values.
     *
     * @param studentName The name of the student
     * @param className The class name of the student
     * @param mathMarks The math marks of the student
     * @param physicalMarks The physics marks of the student
     * @param chemistryMarks The chemistry marks of the student
     */
    public StudentClassification(String studentName, String className, double mathMarks, double physicalMarks, double chemistryMarks) {
        this.studentName = studentName;
        this.className = className;
        this.mathMarks = mathMarks;
        this.physicalMarks = physicalMarks;
        this.chemistryMarks = chemistryMarks;
    }

    // Getter and setter methods for student information
    /**
     * Retrieves the student's name.
     *
     * @return The name of the student.
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Sets the student's name.
     *
     * @param studentName The name to assign to the student.
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Retrieves the class name of the student.
     *
     * @return The class name of the student.
     */
    public String getClassName() {
        return className;
    }

    /**
     * Sets the class name of the student.
     *
     * @param className The name of the class to assign to the student.
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Retrieves the student's Mathematics marks.
     *
     * @return The Mathematics marks of the student.
     */
    public double getMathMarks() {
        return mathMarks;
    }

    /**
     * Sets the student's Mathematics marks.
     *
     * @param mathMarks The Mathematics marks to assign.
     */
    public void setMathMarks(double mathMarks) {
        this.mathMarks = mathMarks;
    }

    /**
     * Retrieves the student's Physics marks.
     *
     * @return The Physics marks of the student.
     */
    public double getPhysicalMarks() {
        return physicalMarks;
    }

    /**
     * Sets the student's Physics marks.
     *
     * @param physicalMarks The Physics marks to assign.
     */
    public void setPhysicalMarks(double physicalMarks) {
        this.physicalMarks = physicalMarks;
    }

    /**
     * Retrieves the student's Chemistry marks.
     *
     * @return The Chemistry marks of the student.
     */
    public double getChemistryMarks() {
        return chemistryMarks;
    }

    /**
     * Sets the student's Chemistry marks.
     *
     * @param chemistryMarks The Chemistry marks to assign.
     */
    public void setChemistryMarks(double chemistryMarks) {
        this.chemistryMarks = chemistryMarks;
    }

    /**
     * Method to calculate the average marks of the student.
     *
     * @return The average score from math, physics, and chemistry marks.
     */
    public double average() {
        return (mathMarks + physicalMarks + chemistryMarks) / 3;
    }

    /**
     * Method to determine the student's grade based on their average marks.
     *
     * @return The grade of the student (A, B, C, or D).
     */
    public String typeStudent() {
        // Declare avg = double
        double Average = average();
        // if Average > 7.5 return "A"
        if (Average > 7.5) {
            return "A";
        } // if Average > 6 return "B" 
        else if (Average >= 6) {
            return "B";
        } // if Average > 4 return "C"
        else if (Average >= 4) {
            return "C";
        } // else return "D"
        else {
            return "D";
        }
    }

    /**
     * Method to calculate the percentage of students receiving an A grade.
     *
     * @return The percentage of students with an A grade.
     */
    public double typeA() {
        return (A / total) * 100;
    }

    /**
     * Method to calculate the percentage of students receiving a B grade.
     *
     * @return The percentage of students with a B grade.
     */
    public double typeB() {
        return (B / total) * 100;
    }

    /**
     * Method to calculate the percentage of students receiving a C grade.
     *
     * @return The percentage of students with a C grade.
     */
    public double typeC() {
        return (C / total) * 100;
    }

    /**
     * Method to calculate the percentage of students receiving a D grade.
     *
     * @return The percentage of students with a D grade.
     */
    public double typeD() {
        return (D / total) * 100;
    }

    /**
     * Method to return a formatted string of grade distribution statistics.
     *
     * @return A formatted string showing the percentage of students in each
     * grade category.
     */
    public String totalPoint() {
        return String.format("A: %.1f%%\nB: %.1f%%\nC: %.1f%%\nD: %.1f%%", typeA(), typeB(), typeC(), typeD());
    }

    /**
     * Method to return the student's details as a formatted string.
     *
     * @return A string containing the student's name, class, average marks, and
     * grade.
     */
    public String studentData() {
        return String.format("Name: %s\nClass: %s\nAVG: %.1f\nGrade: %s", studentName, className, average(), typeStudent());
    }
}

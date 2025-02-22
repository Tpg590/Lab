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
 *
 * Declare the EmployeeData class to store individual employee details
 */
public class EmployeeData {

    // Private instance variables to store employee details
    private String id;      // Stores employee ID
    private String name;    // Stores employee name
    private double salary;  // Stores employee salary
    private double COE;     // Stores coefficient of salary

    /**
     * Constructor with parameters to initialize employee data.
     *
     * @param id Employee ID
     * @param name Employee name
     * @param salary Employee salary
     * @param COE Coefficient of salary
     */
    public EmployeeData(String id, String name, double salary, double COE) {
        this.id = id;         // Assign parameter id to instance variable id
        this.name = name;     // Assign parameter name to instance variable name
        this.salary = salary; // Assign parameter salary to instance variable salary
        this.COE = COE;       // Assign parameter COE to instance variable COE
    }

    /**
     * Default constructor (no parameters). Used when creating an empty
     * EmployeeData object.
     */
    public EmployeeData() {
    }

    /**
     * Getter method for ID.
     *
     * @return Employee ID
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method for ID.
     *
     * @param id Employee ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter method for Name.
     *
     * @return Employee name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for Name.
     *
     * @param name Employee name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for Salary.
     *
     * @return Employee salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Setter method for Salary.
     *
     * @param salary Employee salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Getter method for Coefficient of Salary (COE).
     *
     * @return Coefficient of Salary
     */
    public double getCOE() {
        return COE;
    }

    /**
     * Setter method for Coefficient of Salary (COE).
     *
     * @param COE Coefficient of Salary
     */
    public void setCOE(double COE) {
        this.COE = COE;
    }

    /**
     * Method to return employee data in a formatted string. Uses
     * String.format() to align the data in a table-like structure.
     *
     * @return Formatted string of employee details.
     */
    public String getData() {
        return String.format("|%-10s|%-16s|%-11.0f|%-8.1f", getId(), getName(), getSalary(), getCOE());
        // %-10s : Left-aligns ID in a field of width 10
        // %-16s : Left-aligns Name in a field of width 16
        // %-11.0f : Left-aligns Salary in a field of width 11, with no decimal places
        // %-8.1f : Left-aligns COE in a field of width 8, with 1 decimal place
    }
}

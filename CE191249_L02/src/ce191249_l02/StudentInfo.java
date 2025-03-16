/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191249_l02;

/**
 *
 * @author trilt
 */
public class StudentInfo {
    private String studentName;
    private String studentCourse;
    private String studentSemester;
    private String studentID;

    public StudentInfo() {
    }

    
    
    public StudentInfo(String studentID, String studentName, String studentSemester , String studentCourse) {
        this.studentName = studentName;
        this.studentCourse = studentCourse;
        this.studentSemester = studentSemester;
        this.studentID = studentID;
    }

    
    
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }

    public String getStudentSemester() {
        return studentSemester;
    }

    public void setStudentSemester(String studentSemester) {
        this.studentSemester = studentSemester;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    
    
    public String getReport(){
        return String.format("|%-12s|%-18s|%10s|%8s|", studentID, studentName, studentSemester, studentCourse);
    }
    
    
}

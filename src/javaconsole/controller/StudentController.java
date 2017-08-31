/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.controller;

import java.util.Scanner;
import javaconsole.enity.Student;
import javaconsole.model.StudentModel;


/**
 *
 * @author Nam Nguyen
 */
public class StudentController {
    private StudentModel studentModel= new StudentModel();
    public void getList(){  // Ham tra ve danh sach sinh vien
        System.out.println("Get List");
    }
    public void addStudent(){ 
        Scanner scaner= new Scanner(System.in);
        System.out.println("Please enter student information.");
        System.out.println("Please enter name:");
        String name= scaner.nextLine();
        System.out.println("Please enter email:");
        String email= scaner.nextLine();
        System.out.println("Name: " + name +"\n"+ "Email: " + email);
        
        // Validate dữ liệu 
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setId(System.currentTimeMillis());
        
        // Lưu thông tin vào database
        studentModel.insert();
    }
    public void editStudent(){ 
        System.out.println("Edit");
    }
    public void deleteStudent(){  
        System.out.println("Delete");
    }
    
}

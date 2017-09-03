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

    private StudentModel studentModel = new StudentModel();

    public void getList() {  // Ham tra ve danh sach sinh vien
        System.out.println("Get List");
        studentModel.getList();
    }

    public void addStudent() {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Please enter student information.");
        System.out.println("Please enter name:");
        String name = scaner.nextLine();
        System.out.println("Please enter email:");
        String email = scaner.nextLine();
        System.out.println("Name: " + name + "\n" + "Email: " + email);

        // Validate dữ liệu 
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setId(System.currentTimeMillis());

        // Lưu thông tin vào database
        studentModel.insert(student);
    }

    public void editStudent() {
        System.out.println("Edit");

        Scanner scanerIndex = new Scanner(System.in);
        System.out.println("Please enter student information update.");
        System.out.println("Please enter index of student:");
        boolean checkIndex = true;
        int index;
        do {
            index = scanerIndex.nextInt();
            if (index <= studentModel.getSizeOfList()) {
                checkIndex = false;
            } else {
                System.err.println("Index false. Please input index again: ");
            }
        } while (checkIndex);

        Scanner scaner = new Scanner(System.in);
        System.out.println("Please enter name:");
        String name = scaner.nextLine();
        System.out.println("Please enter email:");
        String email = scaner.nextLine();
        System.out.println("Name: " + name + "\n" + "Email: " + email);

        // Validate dữ liệu 
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setId(System.currentTimeMillis());

        // Update thông tin vào database
        studentModel.update(student, index);

    }

    public void deleteStudent() {
        System.out.println("Delete");
        System.out.println("Please enter student information delete.");
        System.out.println("Please enter index of student:");
        Scanner scanerIndex = new Scanner(System.in);
        boolean checkIndex = true;
        int index;
        do {
            index = scanerIndex.nextInt();
            if (index <= studentModel.getSizeOfList()) {
                checkIndex = false;
            } else {
                System.err.println("Index false. Please input index again: ");
            }
        } while (checkIndex);

        studentModel.delete(index);
    }

}

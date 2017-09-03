/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.model;

import java.util.ArrayList;
import javaconsole.enity.Student;

/**
 *
 * @author Nam Nguyen
 */
public class StudentModel {

    private static ArrayList<Student> listStudent;

    public void getList() {
        if (listStudent == null) {
            System.out.println("List is empty !");
            return;
        }
        int count = 1;
        for (Student x : listStudent) {
            System.out.println(" ID: " + count +"\n"+ " Name: " + x.getName() +"\n"+ " Email: " + x.getEmail());
            count++;
        }

    }

    public int getSizeOfList() {
        return listStudent.size();
    }

    public void insert(Student student) {
        if (listStudent == null) {
            listStudent = new ArrayList<Student>();
        }
        listStudent.add(student);
    }

    public void update(Student student, int index) {
        index--;
        listStudent.set(index, student);
    }

    public void delete(int index) {
        index--;
        listStudent.remove(index);
    }

}

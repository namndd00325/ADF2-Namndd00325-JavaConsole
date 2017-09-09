/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javaconsole.enity.Student;

/**
 *
 * @author Nam Nguyen
 */
public class StudentModel {

    private static ArrayList<Student> listStudent;

    public ArrayList<Student> getList() {
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            Statement stt = DAO.getConnection().createStatement();
            ResultSet rss = stt.executeQuery("SELECT * from student");
            while (rss.next()) {
                Student student = new Student();
                student.setId(rss.getInt("id"));
                student.setName(rss.getString("name"));

                student.setEmail(rss.getString("email"));
                student.setRollNumber(rss.getString("roll_number"));
                student.setClassName(rss.getString("class_name"));
                student.setStatus(rss.getInt("status"));
                listStudent.add(student);

            }

        } catch (SQLException e) {
            System.out.println("Lỗi" + e.getMessage());
        }
        return listStudent;
    }

    public int getSizeOfList() {
        return listStudent.size();
    }

    public void insert(Student student) {
        try {
            Connection cnn = DAO.getConnection();
            Statement stt = cnn.createStatement();
            StringBuilder sqlQueryBuilder = new StringBuilder();
            sqlQueryBuilder.append("INSERT INTO");
            sqlQueryBuilder.append(" ");
            sqlQueryBuilder.append("student");
            sqlQueryBuilder.append(" ");
            sqlQueryBuilder.append("(name, email, roll_number, class_name, status)");
            sqlQueryBuilder.append(" ");
            sqlQueryBuilder.append("VALUE");
            sqlQueryBuilder.append("(");
            sqlQueryBuilder.append("'" + student.getName() + "'");
            sqlQueryBuilder.append(",");
            sqlQueryBuilder.append("'" + student.getEmail() + "'");
            sqlQueryBuilder.append(",");
            sqlQueryBuilder.append("'" + student.getRollNumber() + "'");
            sqlQueryBuilder.append(",");
            sqlQueryBuilder.append("'" + student.getClassName() + "'");
            sqlQueryBuilder.append(",");
            sqlQueryBuilder.append(student.getStatus());
            sqlQueryBuilder.append(");");

            stt.execute(sqlQueryBuilder.toString());
            System.out.println("Thành công");
        } catch (SQLException exc) {
            System.out.println("Lỗi trong quá trình insert dữ liệu" + exc.getMessage());
        }
    }

    public void insert2(Student student) {
        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preStt = cnn.prepareStatement("INSERT INTO student (name, email,roll_number, class_name, status)"
                    + "VALUE(?, ?, ?, ?, ?);");
            preStt.setString(1, student.getName());
            preStt.setString(2, student.getEmail());
            preStt.setString(3, student.getRollNumber());

            preStt.setString(4, student.getClassName());
            preStt.setInt(5, 6);

            preStt.execute();
            System.out.println("Thành công");
        } catch (SQLException exc) {
            System.out.println("Lỗi trong quá trình insert dữ liệu" + exc.getMessage());
        }
    }

    public static void main(String[] args) {
        Student st = new Student();
        st.setName("Nam");
        st.setEmail("namndd00325@gmail.com");
        st.setRollNumber("D00325");
        st.setClassName("C1702G");
        st.setStatus(1);

        StudentModel studentModel = new StudentModel();
        studentModel.insert(st);

    }

    public void update(Student student) {
        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preStt = cnn.prepareStatement("UPDATE student SET name=? , email=?, roll_number=? , class_name=?, status=? Where id=?;");

            preStt.setString(1, student.getName());
            preStt.setString(2, student.getEmail());
            preStt.setString(3, student.getRollNumber());

            preStt.setString(4, student.getClassName());
            preStt.setInt(5, 6);
            preStt.setInt(6, 6);
            int rowsUpdate = preStt.executeUpdate();
            if (rowsUpdate > 0) {
                System.out.println("Thành công");
            }

        } catch (SQLException exc) {
            System.out.println("Lỗi trong quá trình insert dữ liệu" + exc.getMessage());
        }
    }

    public void delete(int id) {
        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preStt = cnn.prepareStatement("DELETE FROM student WHERE id=?");
            preStt.setInt(1, id);
            int rowsDelete = preStt.executeUpdate();
            if (rowsDelete > 0) {
                System.out.println("Đã xóa thành công");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi " + e.getMessage());
        }


    }

    public Student getById(int id) {
        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preStt = cnn.prepareStatement("SELECT * FROM student where id=?;");
            preStt.setInt(1, id);
            ResultSet rss = preStt.executeQuery();
            if (rss.next()) {
                Student student = new Student();
                student.setId(rss.getInt("id"));
                student.setName(rss.getString("name"));

                student.setEmail(rss.getString("email"));
                student.setRollNumber(rss.getString("roll_number"));
                student.setClassName(rss.getString("class_name"));
                student.setStatus(rss.getInt("status"));
                return student;
            }
        } catch (SQLException e) {
            System.out.println("Lỗi " + e.getMessage());
        }

        return null;
    }

}

package Service;

import model.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentService {
    Connection getConnection();

    boolean addStudent(Student student) throws SQLException;

    boolean updateStudent(int id, Student student) throws SQLException;

    boolean deleteStudent(int id) throws SQLException;

    ArrayList<Student> findAll() throws SQLException;

    Student findById(int id) throws SQLException;

    ArrayList<Student> sortByName() throws SQLException;

    ArrayList<Student> sortById() throws SQLException;
}

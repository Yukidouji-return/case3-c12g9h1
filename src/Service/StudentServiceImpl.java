package Service;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class StudentServiceImpl implements StudentService {
    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_Manager", "root", "abc@123");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public boolean addStudent(Student student) throws SQLException {
        String sqlQr = "Insert into Student (id,name,gender,address,date,phoneNumber,class_id) value(?,?,?,?,?,?,?);";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareCall(sqlQr);
        statement.setInt(1, student.getId_student());
        statement.setString(2, student.getName());
        statement.setString(3, student.getGender());
        statement.setString(4, student.getAddress());
        statement.setDate(5, (java.sql.Date) student.getDate());
        statement.setString(6, student.getPhoneNumber());
        statement.setInt(7, student.getaClasses());
        statement.execute();
        return false;
    }

    @Override
    public boolean updateStudent(int id, Student student) throws SQLException {
        String sqlQr = "update Student set name =?,gender=?,address=?,date=?,phoneNumber=?,class_id=? where id=?;";
        boolean status;
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sqlQr);
        statement.setString(1, student.getName());
        statement.setString(2, student.getGender());
        statement.setString(3, student.getAddress());
        statement.setDate(4, (java.sql.Date) student.getDate());
        statement.setString(5, student.getPhoneNumber());
        statement.setInt(6, student.getaClasses());
        status = statement.executeUpdate() > 0;
        return status;
    }

    @Override
    public boolean deleteStudent(int id) throws SQLException {
        boolean status;
        String sqlQr = "delete from Student where id = ?;";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sqlQr);
        statement.setInt(1, id);
        status = statement.executeUpdate() > 0;
        return status;
    }

    @Override
    public ArrayList<Student> findAll() throws SQLException {
        ArrayList<Student> students = new ArrayList<>();
        String sqlQr = "Select * from Student;";

        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sqlQr);
        ResultSet rs = statement.executeQuery();
        return getStudents(students, rs);
    }

    @Override
    public Student findById(int id) throws SQLException {
        String sqlQr = "select * from Student where id = ?;";
        Student student = null;
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareCall(sqlQr);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            String gender = rs.getString("gender");
            String address = rs.getString("address");
            Date date = rs.getDate("date");
            String phoneNumber = rs.getString("phoneNumber");
            int classId = rs.getInt("class_id");
            student = new Student(id, name, gender, address, date, phoneNumber, classId);

        }
        return student;
    }

    @Override
    public ArrayList<Student> sortByName() throws SQLException {
        return getStudents("select * from Student order by name DESC ; ");
    }

    @Override
    public ArrayList<Student> sortById() throws SQLException {
        return getStudents("select * from Student order by id DESC ; ");

    }

    public ArrayList<Student> getStudents(String s) throws SQLException {
        ArrayList<Student> students = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareCall(s);
        ResultSet rs = statement.executeQuery();
        return getStudents(students, rs);
    }

    public ArrayList<Student> getStudents(ArrayList<Student> students, ResultSet rs) throws SQLException {
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String gender = rs.getString("gender");
            String address = rs.getString("address");
            Date date = rs.getDate("date");
            String phoneNumber = rs.getString("phoneNumber");
            int classId = rs.getInt("class_id");
            students.add(new Student(id, name, gender, address, date, phoneNumber, classId));
        }
        return students;
    }
}

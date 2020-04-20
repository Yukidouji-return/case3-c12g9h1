package Service;

import model.Classes;

import java.sql.*;
import java.util.ArrayList;

public class CLassesServiceImpl implements ClassesService {
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
    public void addClass(Classes classes) throws SQLException {
        String sqlQr = "Insert into class " +
                "(id,name,amount_Student)" +
                "value(?,?,?);";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareCall(sqlQr);
        statement.setInt(1, classes.getIdClass());
        statement.setString(2, classes.getNameClass());
        statement.setInt(3, classes.getAmountStudent());
        statement.execute();
    }

    @Override
    public boolean updateClass(int id, Classes classes) throws SQLException {
        String sqlQr = "update class   set name=?,amount_student=? where id = ?";
        boolean status = false;
        Connection connection = getConnection();
       PreparedStatement statement = connection.prepareStatement(sqlQr);
       statement.setString(1,classes.getNameClass());
       statement.setInt(2,classes.getAmountStudent());
       status = statement.executeUpdate() > 0;
        return status;
    }

    @Override
    public boolean deleteClass(int id) throws SQLException {
        boolean status =false;
        String sqlQr = "delete from class where id=?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sqlQr);
        statement.setInt(1,id);
        status = statement.executeUpdate() >0;
        return status;
    }

    @Override
    public ArrayList<Classes> findAll() throws SQLException {
        Connection connection = getConnection();
        String sqlQr = "select * from class; ";
        return getClasses(connection, sqlQr);
    }

    @Override
    public Classes findById(int id) throws SQLException {
        String sqlQr = "select * from class where id = ?;";
        Classes classes = null;
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareCall(sqlQr);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            String nameClass = rs.getString("name");
            int amountStudent = rs.getInt("amount_student");
            classes = new Classes(id, nameClass, amountStudent);

        }
        return classes;
    }

    @Override
    public ArrayList<Classes> sortByName() throws SQLException {
        Connection connection = getConnection();
        String sqlQr = "select * from class order by name DESC ; ";
        return getClasses(connection, sqlQr);
    }

    @Override
    public ArrayList<Classes> sortById() throws SQLException {
        Connection connection = getConnection();
        String sqlQr = "select * from class order by id DESC ; ";
        return getClasses(connection, sqlQr);

    }

    private ArrayList<Classes> getClasses(Connection connection, String sqlQr) throws SQLException {
        ArrayList<Classes> classes = new ArrayList<>();
        PreparedStatement statement = connection.prepareCall(sqlQr);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int amount = rs.getInt("amount_student");
            classes.add(new Classes(id, name, amount));
        }
        return classes;
    }
}

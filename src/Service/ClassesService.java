package Service;

import model.Classes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ClassesService {
    Connection getConnection();


    void addClass(Classes classes) throws SQLException;


    boolean updateClass(int id, Classes classes) throws SQLException;


    boolean deleteClass(int id) throws SQLException;

    ArrayList<Classes> findAll() throws SQLException;

    Classes findById(int id) throws SQLException;

    ArrayList<Classes> sortByName() throws SQLException;

    ArrayList<Classes> sortById() throws SQLException;
}

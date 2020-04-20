package controller;

import Service.StudentServiceImpl;
import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    public StudentServiceImpl studentService = new StudentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        } else {
            switch (action) {
                case "addStudent":
                    addNewStudents(request, response);
                    break;
                case "updateStudent":
                    updateStudents(request, response);
                    break;
                case "deleteStudent":
                    deleteStudents(request, response);
                    break;
                default:
                    break;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addForm(request, response);
                break;
            case "update":
                updateForm(request, response);
                break;
            case "delete":
                removeForm(request, response);
                break;
            case "view":
                viewStudents(request, response);
                break;
            default:
                try {
                    listStudents(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ArrayList<Student> students = studentService.findAll();
        request.setAttribute("studentList", students);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("studentList.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void removeForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("remove.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("update.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void addForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("add.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateStudents(HttpServletRequest request, HttpServletResponse response) {

    }

    private void deleteStudents(HttpServletRequest request, HttpServletResponse response) {
    }

    private void addNewStudents(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewStudents(HttpServletRequest request, HttpServletResponse response) {
    }

}

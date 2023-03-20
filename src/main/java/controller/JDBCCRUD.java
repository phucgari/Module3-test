package controller;

import model.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public interface JDBCCRUD {
    public static final String URL = "jdbc:mysql://localhost:3306/employee_depart";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    default Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    ArrayList<Employee> getAll();
    void create(Employee employee);
    void update(Employee employee);
    void delete(int index);
}

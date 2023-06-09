package controller;

import model.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public interface JDBCCRUD {
    String URL = "jdbc:mysql://localhost:3306/employee_depart";
    String USER = "root";
    String PASSWORD = "123456";

    default Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    ArrayList<Employee> getAll(String search);
    Employee getByIndex(int index);
    void create(Employee employee);
    void update(Employee employee);
    void delete(int index);
}

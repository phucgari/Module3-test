package controller;

import model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeController implements JDBCCRUD {

    private final String DELETE_EMPLOYEE =
            "delete " +
            "from employee " +
            "where id=?";
    private final String UPDATE_EMPLOYEE = "update employee " +
            "set name= ?, " +
            "email =?, " +
            "address=?, " +
            "phone_number=?, " +
            "salary=?, " +
            "department_id=? " +
            "where employee_id=? ";
    private final String CREATE_EMPLOYEE =
            "insert into employee (name,email,address,phone_number,salary,department_id) " +
            "values (?,?,?,?,?,(select department_id from department where depart_name=?))";
    public final String GET_ALL_EMPLOYEE =
            "select * " +
            "from employee " +
            "inner join department on department.department_id=employee.department_id ";

    @Override
    public ArrayList<Employee> getAll() {
        try(PreparedStatement preparedStatement=getConnection().prepareStatement(GET_ALL_EMPLOYEE)){
            ResultSet resultSet=preparedStatement.executeQuery();
            ArrayList<Employee> employees=new ArrayList<>();
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String email=resultSet.getString("email");
                String address=resultSet.getString("address");
                long phoneNumber=resultSet.getLong("phone_number");
                long salary=resultSet.getLong("salary");
                String department=resultSet.getString("depart_name");
                Employee employee=new Employee(id,name,email,address,phoneNumber,salary,department);
                employees.add(employee);
            }
            return employees;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Employee employee) {
        try(PreparedStatement preparedStatement=getConnection().prepareStatement(CREATE_EMPLOYEE)) {
            inputEmployeeIntoStatement(employee, preparedStatement);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Employee employee) {
        try(PreparedStatement preparedStatement=getConnection().prepareStatement(UPDATE_EMPLOYEE)) {
            inputEmployeeIntoStatement(employee, preparedStatement);
            preparedStatement.setInt(7,employee.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void delete(int index) {
        try(PreparedStatement preparedStatement=getConnection().prepareStatement(DELETE_EMPLOYEE)){
            preparedStatement.setInt(1,index);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void inputEmployeeIntoStatement(Employee employee, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        preparedStatement.setString(3, employee.getAddress());
        preparedStatement.setLong(4, employee.getPhoneNumber());
        preparedStatement.setLong(5, employee.getSalary());
        preparedStatement.setString(6, employee.getDepartment());
    }
}

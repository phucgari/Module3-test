package view;

import controller.EmployeeController;
import model.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EmployeeServlet", value = "")
public class EmployeeServlet extends HttpServlet {
    EmployeeController controller=new EmployeeController();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null)action="";
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "update":
                showUpdateForm(request,response);
                break;
            case "delete":
                delete(request,response);
            default:
                showAll(request,response);
        }
    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<Employee> employees=controller.getAll(request.getParameter("action"));
        request.setAttribute("employees",employees);
        try {
            request.getRequestDispatcher("showAll.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        controller.delete(Integer.parseInt(request.getParameter("id")));
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        Employee employee=controller.getByIndex(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("employee",employee);
        try {
            request.getRequestDispatcher("edit.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("create.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        switch (action){
            case "create":
                create(request,response);
                break;
            case "update":
                update(request,response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        Employee employee=getEmployeeBy6Parameter(request);
        employee.setId(Integer.parseInt(request.getParameter("id")));
        controller.update(employee);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        Employee employee = getEmployeeBy6Parameter(request);
        controller.create(employee);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Employee getEmployeeBy6Parameter(HttpServletRequest request) {
        String name= request.getParameter("name");
        String email= request.getParameter("email");
        String address= request.getParameter("address");
        String phoneNumberStr = request.getParameter("phone_number");
        long phoneNumber= phoneNumberStr ==null||phoneNumberStr.equals("")?
                0:Long.parseLong(phoneNumberStr);
        String salaryStr = request.getParameter("salary");
        long salary= salaryStr==null||salaryStr.equals("")?
                0:Long.parseLong(salaryStr);
        String department= request.getParameter("department");
        Employee employee=new Employee(name,email,address,phoneNumber,salary,department);
        return employee;
    }
}

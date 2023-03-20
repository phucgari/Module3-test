package view;

import controller.EmployeeController;
import model.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

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
        try {
            request.getRequestDispatcher("showAll.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {

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
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        long phoneNumber= Long.parseLong(request.getParameter("phone_number"));
        long salary= Long.parseLong(request.getParameter("salary"));
        String department=request.getParameter("department");
        Employee employee=new Employee(name,email,address,phoneNumber,salary,department);
        controller.create(employee);
    }
}

package view;

import controller.EmployeeController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EmployeeServlet", value = "/")
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

    }
}

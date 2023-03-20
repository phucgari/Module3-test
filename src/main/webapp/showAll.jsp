<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/20/2023
  Time: 9:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3>Show All Employee</h3>
    <form method="get">
        <input type="hidden" name="action" value="create">
        <button type="submit" class="btn btn-primary">Create</button>
    </form>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">PhoneNumber</th>
            <th scope="col">Salary</th>
            <th scope="col">Department</th>
            <th scope="col">Action</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${requestScope['employees']}">
        <tr>
            <th scope="row">${employee.getId()}</th>
            <td>${employee.getName()}</td>
            <td>${employee.getEmail()}</td>
            <td>${employee.getAddress()}</td>
            <td>${employee.getPhoneNumber()}</td>
            <td>${employee.getSalary()}</td>
            <td>${employee.getDepartment()}</td>
            <td>
                <form method="get">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="id" value="${employee.getId()}">
                    <button type="submit" class="btn btn-primary">Update</button>
                </form>
            </td>
            <td>
                <button type="submit" class="btn btn-primary" onclick="deleletconfig(${employee.getId()})">Delete</button>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<script>
    function deleletconfig(id){
        var del=confirm("Are you sure you want to delete this employee?");
        if (del==true){
            window.location.href = '/?action=delete?id='+id;
        }
    }
</script>
</body>
</html>

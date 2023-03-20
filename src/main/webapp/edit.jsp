<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/20/2023
  Time: 9:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Edit Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<c:set var="employee" value="${requestScope['employee']}"/>
<div class="container">
    <h3>Edit Employee ${employee.getId()}</h3>
    <form method="post">
        <div class="mb-3">
            <label class="form-label">Employee Name</label>
            <input type="text" class="form-control" name="name" value="${employee.getName()}">
        </div>
        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="text" class="form-control" name="email" value="${employee.getEmail()}">
        </div>
        <div class="mb-3">
            <label class="form-label">Address</label>
            <input type="text" class="form-control" name="address" value="${employee.getAddress()}">
        </div>
        <div class="mb-3">
            <label class="form-label">Phone Number</label>
            <input type="number" class="form-control" name="phone_number" value="${employee.getPhoneNumber()}">
        </div>
        <div class="mb-3">
            <label class="form-label">Salary</label>
            <input type="number" class="form-control" name="salary" value="${employee.getSalary()}">
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="department" id="sale" value="Sale" <c:if test="${employee.getDepartment().equals('Sale')}">checked</c:if> >
            <label class="form-check-label" for="sale">
                Sale
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="department" id="quality_control" value="Quality Control" <c:if test="${employee.getDepartment().equals('Quality Control')}">checked</c:if>>
            <label class="form-check-label" for="quality_control">
                Quality Control
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="department" id="human_resources" value="Human Resources" <c:if test="${employee.getDepartment().equals('Human Resources')}"> checked</c:if>>
            <label class="form-check-label" for="human_resources">
                Human Resources
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="department" id="finance" value="Finance" <c:if test="${employee.getDepartment().equals('Finance')}"> checked</c:if>>
            <label class="form-check-label" for="finance">
                Finance
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="department" id="marketing" value="Marketing" <c:if test="${employee.getDepartment().equals('Marketing')}"> checked</c:if>>
            <label class="form-check-label" for="marketing">
                Marketing
            </label>
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>

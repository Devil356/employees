<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

<head>
    <title>Employees</title>
</head>
<body>
<section>
    <h2>Employees</h2>
    <br>
    <br><br>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Name</th>
            <th>Lastname</th>
            <th>Email</th>
            <th>Phone Number</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${employees}" var="employee">
            <jsp:useBean id="employee" type="com.arsenev.employees.model.Employee"/>
            <tr>
                <td>${employee.name}</td>
                <td>${employee.lastname}</td>
                <td>${employee.email}</td>
                <td>${employee.phoneNumber}</td>
                <td><a href="employees?action=update&id=${employee.id}">Update</a></td>
                <td><a href="employees?action=delete&id=${employee.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
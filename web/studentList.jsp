<%--
  Created by IntelliJ IDEA.
  User: Yuki
  Date: 4/20/2020
  Time: 9:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <meta name="viewport" content="device-width,initial-scale=1.0">
</head>

<body>

<table border="1" cellpadding="5" cellspacing="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Address</th>
        <th>Date</th>
        <th>Phone Number</th>
        <th>Class</th>
        <th>edit</th>
        <th>delete</th>
    </tr>
    <c:forEach items="${studentList}" var="student">
        <tr>
            <td>${student.getId_student()}</td>
            <td>${student.getName()}</td>
            <td>${student.getGender()}</td>
            <td>${student.getAddress()}</td>
            <td>${student.getDate()}</td>
            <td>${student.getPhoneNumber()}</td>
            <td>${student.getaClasses()}</td>
            <td>
                <a href="<c:url value="/student?action=update${student.getId_student()}"/>">Update</a>
            </td>
            <td>
                <a href="<c:url value="/student?action=remove${student.getId_Student()}"/>">Remove</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value="/student?action=add"/>">Create new Student</a>

</body>
</html>

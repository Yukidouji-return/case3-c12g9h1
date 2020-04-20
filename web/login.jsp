<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <meta name="viewport" content="device-width,initial-scale=1.0">
</head>
<style>
    body {
        background: url('https://images4.alphacoders.com/600/600528.png') no-repeat center center fixed;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        background-size: cover;
        -o-background-size: cover;
    }
</style>
<body>
<div class="jumbotron text-center">
    <h1>Student Manager</h1>
    <p>LMFAO</p>
</div>
<div align="center">
    <h1>Login</h1>
    <%
        String err = request.getParameter("err");
        if ("1".equals(err)) {
            out.print("<h6 style=\"color: red;\">Wrong PassWord try again !</h6>");
        }

    %>
    <form action="<%=request.getContextPath()%>/login" method="post">
        <table style="with: 100%">
            <tr>
                <td>UserName</td>
                <td><label>
                    <input type="text" name="username"/>
                </label></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><label>
                    <input type="password" name="password"/>
                </label></td>
            </tr>

        </table>
        <input type="submit" value="Submit"/>
    </form>
</div>
</body>
</html>

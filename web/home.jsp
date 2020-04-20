<%--
  Created by IntelliJ IDEA.
  User: Yuki
  Date: 4/20/2020
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <meta name="viewport" content="device-width,initial-scale=1.0">
    <style>
        .navbar {
            background-color: transparent;
            background: transparent;
            border-color: transparent;
        }

        .navbar li {
            color: #000
        }

        body {
            background: url('https://images4.alphacoders.com/600/600528.png') no-repeat center center fixed;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            background-size: cover;
            -o-background-size: cover;
        }

    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark indigo">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
            aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="home.jsp">Home
                    <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="studentList.jsp">Student Manager</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="classList.jsp">Classes Manager</a>
            </li>
        </ul>
        <span class="navbar-text white-text">
      <a class="nav-link" href="login.jsp">Log Out</a>
    </span>
    </div>
</nav>
</body>
</html>

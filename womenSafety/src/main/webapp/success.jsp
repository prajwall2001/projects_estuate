<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Women Safety</title> 
<link rel="icon" type="logo/jpg" href="https://cdn.dribbble.com/users/9125986/screenshots/16427226/vimiyans_only_logo-01.jpg">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: black; 
        color:white;
        background-image:url('https://wallpaperaccess.com/full/744085.png');
        background-size: cover;
        background-repeat: no-repeat;  
    }
    footer {
        position: fixed;
        left: 0;
        bottom: 0;
        width: 100%;
        background-color: rgb(42, 40, 40);
        color: white;
        text-align: center;
        padding: 10px;
    }
    .social img {
        height: 23px;
        width: 23px;
        margin: 5px;
    }
    h4{
        color:rgb(195, 195, 195);
    }
    .success-message {  
        animation-name: slideIn;
        animation-duration: 1s; 
        animation-timing-function: ease;
    }

    @keyframes slideIn {
        from {
            transform: translateX(-100%);
            opacity: 0;
        }
        to {
            transform: translateX(0);
            opacity: 1;
        }
    }
</style>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <img src="https://cdn.dribbble.com/users/9125986/screenshots/16427226/vimiyans_only_logo-01.jpg" width="40" height="40" class="d-inline-block align-top" alt="Logo">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-between" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
            </ul>  
           <ul class="navbar-nav">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> <%=session.getAttribute("loggedInEmail")%>
					</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item"
								href="updateInfo?email=<%=session.getAttribute("email")%>">Update</a></li>
							<li><a class="dropdown-item"
								href="DeletePage?email=${email}">Delete</a></li>
							<li><a class="dropdown-item" href="index.jsp">logout</a></li>
						</ul></li>
				</ul>

        </div>
    </div>
</nav>
</head>
<body>
<form action="aSuccess" method="post"> </form>
<div class="success-message">
    <h3 style='color:green;'>Login Successful</h3>
</div>
<h2 style="color:purple;">${msg}</h2>
<form action="search" method="post">
    <div class="container">
        <div class="row">
            <div class="col">
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="Search" name="name" aria-label="Search" aria-describedby="button-addon2">
                    <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Search</button>
                </div>
            </div>
</form>
<form action="viewAll" method="post">
    <div class="col text-end">
        <button type="submit" class="btn btn-primary">View All</button>
    </div>
</div>

<div class="container">
    <table class="table table-bordered">
        <thead class="table-dark">
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                <th scope="col">Email</th>
                <th scope="col">Aadhar Number</th>
                <th scope="col">Date of Birth</th>
                <th scope="col">Gender</th>
                <th scope="col">Phone Number</th>
                <th scope="col">Alternate Phone Number</th>
                <th scope="col">Blood Group</th>
                <th scope="col">Address</th>
                <th scope="col">State</th>
                <th scope="col">Country</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.aadharNumber}</td>
                    <td>${user.dateOfBirth}</td>
                    <td>${user.gender}</td>
                    <td>${user.phoneNumber}</td>
                    <td>${user.alternatePhoneNumber}</td>
                    <td>${user.bloodGroup}</td>
                    <td>${user.address}</td>
                    <td>${user.state}</td>
                    <td>${user.country}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
<footer>
    <span>&copy; 2024 Vendor Management Project</span><br>
</footer>
</html>

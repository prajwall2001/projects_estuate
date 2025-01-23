<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<style>
        body {
            font-family: Arial, sans-serif;
            background-color: black;
            color: white;
            background-image: url('https://wallpaperaccess.com/full/744085.png');
            background-size: cover;
            background-repeat: no-repeat;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            border-radius: 10px;
            background-color: rgba(0, 0, 0, 0.7);
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
            margin-top: 50px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-control{
        background-color: #222;
        color: white;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="email"],
        input[type="password"],
        input[type="date"],
        input[type="tel"],
        input[type="select"],
        
        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #222;
            color: white;
            box-sizing: border-box;
        }
        select {
            cursor: pointer;
        }
        button[type="submit"],
        button[type="reset"]
         {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: all 0.3s ease;
        }
        button[type="submit"] {
            background-color: #28a745;
            color: white;
        }
        button[type="reset"] {
            background-color: #dc3545;
            color: white;
            margin-left: 10px;
        }
        button[type="submit"]:hover,
        button[type="reset"]:hover {
            transform: translateY(-3px);
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
</style>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <img src="https://cdn.dribbble.com/users/9125986/screenshots/16427226/vimiyans_only_logo-01.jpg" width="40" height="40" class="d-inline-block align-top" alt="Logo">
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
             <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="safety.jsp">Safety Tips</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="admin.jsp">Complaint</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="about.jsp">Contact</a>
                </li>
            </ul>
           
        </div>
    </div>
</nav>
</head>
<body>  
   <span style='color:red;'>
<c:forEach var="objectErrors" items="${errors}"> ${objectErrors.defaultMessage}<br></c:forEach>
</span>
<h3 style='color:Green'>${msg}</h3>
<h3 style='color:red'>${uniqueError}</h3>
 <form action="save" class="container" method="post">
        <h3 style='text-align:center;color:#07ee39;'>Register for Women Safety</h3>
        <div class="row">
            <div class="col-md-6">
                <div class="design form-group">
                    <label for="name">Name</label>
                    <input type="text" name="name" id="name" class="form-control" placeholder="Enter name" value="${entity.name}">
                </div>
                <div class="design form-group">
                    <label for="email">Email</label>
                    <input type="email" name="email" id="email" class="form-control" placeholder="Enter email" value="${entity.email}">
                </div>
                <div class="design form-group">
                    <label for="phoneNumber">Phone Number</label>
                    <input type="tel" name="phoneNumber" id="phoneNumber" class="form-control" placeholder="Enter phone number" value="${entity.phoneNumber}">
                </div>
                 <div class="design form-group">
                    <label for="dateOfBirth">Date of Birth</label>
                    <input type="date" name="dateOfBirth" id="dateOfBirth" class="form-control" placeholder="Select date of birth" value="${entity.dateOfBirth}">
                </div>
                
                <div class="design form-group">
                    <label for="bloodGroup">Blood Group</label>
                    <input type="text" name="bloodGroup" id="bloodGroup" class="form-control" placeholder="Enter blood group" value="${entity.bloodGroup}">
                </div>
                
                <div class="design form-group">
                    <label for="state">State</label>
                    <input type="text" name="state" id="state" class="form-control" placeholder="Enter state" value="${entity.state}">
                </div>
               
        </div>
                
        <div class="col">
                 <div class="design form-group">
                    <label for="aadharNumber">AAdhar Number</label>
                    <input type="tel" name="aadharNumber" id="aadharNumber" class="form-control" placeholder="Enter aadhar number" value="${entity.aadharNumber}">
           </div>
                 <div class="design form-group">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" class="form-control" placeholder="Enter password">
                </div>
                 
                <div class="design form-group">
                    <label for="alternatePhoneNumber">Alternate Phone Number</label>
                    <input type="tel" name="alternatePhoneNumber" id="alternatePhoneNumber" class="form-control" placeholder="Enter alternate phone number" value="${entity.alternatePhoneNumber}">
                </div>
                
                  <div class="design form-group">
                    <label for="gender">Gender</label>
                    <select name="gender" id="gender" class="form-control">
                        <option value="choose">Choose</option>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                        <option value="Other">Other</option>
                    </select>
                </div>
                
                <div class="design form-group ">
                    <label for="address">Address</label>
                    <input type="text" name="address" id="address" class="form-control"  placeholder="Enter address" value="${entity.address}">
                </div>
                
                  <div class="design form-group">
                    <label for="country">Country</label>
                    <input type="text" name="country" id="country" class="form-control" placeholder="Enter country" value="${entity.country}">
                </div>
                
         </div>

        <div class="design form-group">
            <button type="submit" class="btn btn-success" value="send" id="submitButton">Register</button>
            <button type="reset" class="btn btn-danger" value="reset">Clear</button>
        </div>
    </form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
<footer>
    <span>&copy; 2024 Women Safety Project</span><br>
</footer>
</html>
                

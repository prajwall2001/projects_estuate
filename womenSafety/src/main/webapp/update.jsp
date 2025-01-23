<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Women Safety Information</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        body {
            font-family: Arial, sans-serif;
            padding-top: 50px;
            background-image: url('https://wallpaperaccess.com/full/744085.png');
            background-color: rgba(244, 244, 244, 0.7); 
        }
        .container {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            margin-bottom: 30px;
        }
        label {
            font-weight: bold;
        }
        input[type="text"],
        input[type="email"],
        input[type="password"],
        input[type="date"],
        input[type="tel"],
        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 20px;
            box-sizing: border-box;
        }
        select {
            cursor: pointer;
        }
        button[type="submit"] {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: all 0.3s ease;
            background-color: #007bff;
            color: #fff;
        }
        button[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Update Women Safety Information</h1>
    
    <form action="update" method="post">
        <input type="hidden" name="id" value="${entity.id}">
        
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name" value="${entity.name}" required>
        </div>
        
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" name="email" value="${entity.email}" required>
        </div>
        
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password" value="${entity.password}" required>
        </div>
        
        <div class="mb-3">
            <label for="aadharNumber" class="form-label">Aadhar Number</label>
            <input type="text" class="form-control" id="aadharNumber" name="aadharNumber" value="${entity.aadharNumber}" required>
        </div>
        
        <div class="mb-3">
            <label for="dateOfBirth" class="form-label">Date of Birth</label>
            <input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth" value="${entity.dateOfBirth}" required>
        </div>
        
        <div class="mb-3">
            <label for="gender" class="form-label">Gender</label>
            <select class="form-control" id="gender" name="gender" required>
                <option value="Male" ${entity.gender == 'Male' ? 'selected' : ''}>Male</option>
                <option value="Female" ${entity.gender == 'Female' ? 'selected' : ''}>Female</option>
                <option value="Other" ${entity.gender == 'Other' ? 'selected' : ''}>Other</option>
            </select>
        </div>
        
        <div class="mb-3">
            <label for="phoneNumber" class="form-label">Phone Number</label>
            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value="${entity.phoneNumber}" required>
        </div>
        
        <div class="mb-3">
            <label for="alternatePhoneNumber" class="form-label">Alternate Phone Number</label>
            <input type="text" class="form-control" id="alternatePhoneNumber" name="alternatePhoneNumber" value="${entity.alternatePhoneNumber}" required>
        </div>
        
        <div class="mb-3">
            <label for="bloodGroup" class="form-label">Blood Group</label>
            <input type="text" class="form-control" id="bloodGroup" name="bloodGroup" value="${entity.bloodGroup}" required>
        </div>
        
        <div class="mb-3">
            <label for="address" class="form-label">Address</label>
            <input type="text" class="form-control" id="address" name="address" value="${entity.address}" required>
        </div>
        
        <div class="mb-3">
            <label for="state" class="form-label">State</label>
            <input type="text" class="form-control" id="state" name="state" value="${entity.state}" required>
        </div>
        
        <div class="mb-3">
            <label for="country" class="form-label">Country</label>
            <input type="text" class="form-control" id="country" name="country" value="${entity.country}" required>
        </div>
        
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
  <h4 style="color:red;"> ${msg} </h4>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>

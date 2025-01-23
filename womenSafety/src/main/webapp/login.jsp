<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
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
        max-width: 400px;
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
    }
    label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
    }
    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        background-color: #222;
        color: black;
        box-sizing: border-box;
    }
    button[type="submit"] {
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: all 0.3s ease;
        background-color: #28a745;
        color: white;
    }
    button[type="submit"]:hover {
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
</head>
<body>  
<div>
    <form action="login" class="container" method="post">
        <h3 style='text-align:center;color:#07ee39;'>Login</h3>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" name="email" id="email" class="form-control" placeholder="Enter email">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" name="password" id="password" class="form-control" placeholder="Enter password">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success" value="send" id="submitButton">Login</button>
        </div>
        
          <p style="text-align: center; margin-top: 20px;">Don't have an account? <a href="register.jsp">Register</a></p>
    </form>
  
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
<footer>
    <span>&copy; 2024 Women Safety Project</span><br>
</footer>
</html>

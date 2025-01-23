<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-image: url('https://png.pngtree.com/thumb_back/fw800/background/20231007/pngtree-d-render-dating-app-concept-with-two-hands-holding-smartphones-and-image_13574537.png');
            background-size: cover;
            font-family: Arial, sans-serif;
            color: #fff;
        }
        .form-container {
            margin-top: 50px;
            padding: 30px;
            width: 50%;
            max-width: 500px;
            background: rgba(0, 0, 0, 0.6);
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.5);
        }
        h1 {
            font-size: 2.5rem;
            text-align: center;
            margin-bottom: 20px;
        }
        p {
            color:pink;
            text-align: center;
            margin-bottom: 30px;
        }
        footer {
            color:black;
            margin-top: 50px;
            text-align: center;
            color: #fff;
            font-size: 0.9rem;
        }
        .btn-primary {
            background-color: #ff758c;
            border: none;
        }
        .btn-primary:hover {
            background-color: #ff527b;
        }
    </style>
</head>
<body>
<h1 style="color:dark pink;">Welcome to Our Dating Platform</h1>
<div class="container">
    <div class="form-container">
        
        <p>Create your profile to start discovering compatible matches based on your preferences.</p>
        <form:form modelAttribute="userDto" action="/saveUser" method="post">
            <div class="mb-3">
                <form:label path="name">Name</form:label>
                <form:input path="name" class="form-control" placeholder="Enter your name" />
            </div>
            <div class="mb-3">
                <form:label path="gender">Gender</form:label>
                <form:select path="gender" class="form-select">
                    <form:option value="" label="Select Gender" />
                    <form:option value="Male" label="Male" />
                    <form:option value="Female" label="Female" />
                    <form:option value="Other" label="Other" />
                </form:select>
            </div>
            <div class="mb-3">
                <form:label path="age">Age</form:label>
                <form:input path="age" type="number" class="form-control" placeholder="Enter your age" />
            </div>
            <div class="mb-3">
                <form:label path="interests">Interests</form:label>
                <form:input path="interests" class="form-control" placeholder="Enter interests (comma-separated)" />
            </div>
            <button type="submit" class="btn btn-primary">Register</button>
        </form:form>
    </div>
</div>
<footer>
    &copy; 2025 Dating Platform. All rights reserved.
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

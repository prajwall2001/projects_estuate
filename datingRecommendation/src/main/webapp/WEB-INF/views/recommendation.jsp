<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recommendations</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-image: url('https://png.pngtree.com/thumb_back/fw800/background/20231007/pngtree-d-render-dating-app-concept-with-two-hands-holding-smartphones-and-image_13574537.png');
            background-size: cover;
            font-family: Arial, sans-serif;
            color: #fff;
        }
        .container {
            margin-top: 50px;
            background: rgba(0, 0, 0, 0.6);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.5);
            color: #fff;
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        .btn-primary {
            background-color: #ff758c;
            border: none;
        }
        .btn-primary:hover {
            background-color: #ff527b;
        }
        table {
            color: #fff;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Recommended Users</h1>
    <c:if test="${empty recommendations}">
        <p>No recommendations found.</p>
    </c:if>
    <c:if test="${not empty recommendations}">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Name</th>
                <th>Gender</th>
                <th>Age</th>
                <th>Interests</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${recommendations}">
                <tr>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.interests}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <div class="text-center">
        <a href="/" class="btn btn-primary">Go Back</a>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

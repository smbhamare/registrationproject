<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 20px;
    }
    h1 {
        text-align: center;
        color: #333;
    }
    form {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        margin-bottom: 20px;
    }
    label {
        display: block;
        margin-bottom: 5px;
        color: #555;
    }
    input[type="text"],
    input[type="number"] {
        width: calc(100% - 22px);
        padding: 8px;
        border: 1px solid #ddd;
        border-radius: 4px;
        margin-bottom: 10px;
    }
    input[type="submit"] {
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 4px;
        padding: 10px 20px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <h1>Student Registration Form</h1>
    
    
    <form action="Registrationclass" method="post">
      <label for="id">ID:</label>
        <input type="number" id="id" name="id">
        <br>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name">
        <br>
        <label for="age">Age:</label>
        <input type="number" id="age" name="age">
        <br>
        <label for="grade">Grade:</label>
        <input type="text" id="grade" name="grade">
        <br>
        <input type="submit" name="action" value="Add">
        <input type="submit" name="action" value="Update">
    </form>
    <form action="Registrationclass" method="post">
        <label for="id">Student ID to Delete:</label>
        <input type="number" id="id" name="id">
        <br>
        <input type="submit" name="action" value="Delete">
    </form>
</body>
</html>

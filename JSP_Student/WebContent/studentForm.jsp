<html>
<head><title>Add Student</title></head>
<body>
<h2>Add New Student</h2>
<form action="insertStudent.jsp" method="post">
    Roll No: <input type="text" name="roll_no" required><br><br>
    Name: <input type="text" name="name" required><br><br>
    Email: <input type="email" name="email" required><br><br>
    Program: <input type="text" name="program" required><br><br>
    <input type="submit" value="Add Student">
</form>
<br>
<a href="studentList.jsp">View All Students</a>
</body>
</html>

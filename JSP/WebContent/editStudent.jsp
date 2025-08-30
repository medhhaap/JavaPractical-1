<%@ page import="java.sql.*" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    String rollNo="", name="", email="", program="";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/student_db","root","root"
        );
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM student WHERE id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            rollNo = rs.getString("roll_no");
            name = rs.getString("name");
            email = rs.getString("email");
            program = rs.getString("program");
        }
        conn.close();
    } catch(Exception e){ out.println(e); }
%>
<html>
<head><title>Edit Student</title></head>
<body>
<h2>Edit Student</h2>
<form action="updateStudent.jsp" method="post">
    <input type="hidden" name="id" value="<%= id %>">
    Roll No: <input type="text" name="roll_no" value="<%= rollNo %>" required><br><br>
    Name: <input type="text" name="name" value="<%= name %>" required><br><br>
    Email: <input type="email" name="email" value="<%= email %>" required><br><br>
    Program: <input type="text" name="program" value="<%= program %>" required><br><br>
    <input type="submit" value="Update Student">
</form>
<a href="studentList.jsp">Back to List</a>
</body>
</html>

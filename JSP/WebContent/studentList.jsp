<%@ page import="java.sql.*" %>
<html>
<head><title>Student List</title></head>
<body>
<h2>All Students</h2>
<a href="studentForm.jsp">Add New Student</a><br><br>
<table border="1">
<tr>
    <th>ID</th><th>Roll No</th><th>Name</th><th>Email</th><th>Program</th><th>Actions</th>
</tr>
<%
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/student_db","root","root"
        );
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM student");
        while(rs.next()){
%>
<tr>
    <td><%= rs.getInt("id") %></td>
    <td><%= rs.getString("roll_no") %></td>
    <td><%= rs.getString("name") %></td>
    <td><%= rs.getString("email") %></td>
    <td><%= rs.getString("program") %></td>
    <td>
        <a href="editStudent.jsp?id=<%= rs.getInt("id") %>">Edit</a> |
        <a href="deleteStudent.jsp?id=<%= rs.getInt("id") %>">Delete</a>
    </td>
</tr>
<%
        }
        conn.close();
    } catch(Exception e){ out.println("Error: "+e); }
%>
</table>
</body>
</html>

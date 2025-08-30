<%@ page import="java.sql.*" %>
<%
    String rollNo = request.getParameter("roll_no");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String program = request.getParameter("program");

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/student_db","root","root"
        );
        String sql = "INSERT INTO student (roll_no, name, email, program) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, rollNo);
        ps.setString(2, name);
        ps.setString(3, email);
        ps.setString(4, program);
        ps.executeUpdate();
        conn.close();
        response.sendRedirect("studentList.jsp");
    } catch(Exception e) {
        out.println("Error: " + e);
    }
%>

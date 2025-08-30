<%@ page import="java.sql.*" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/student_db","root","root"
        );
        PreparedStatement ps = conn.prepareStatement("DELETE FROM student WHERE id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        conn.close();
        response.sendRedirect("studentList.jsp");
    } catch(Exception e){ out.println(e); }
%>

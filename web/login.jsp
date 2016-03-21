<%@ page import ="java.sql.*" %>
<%@ page import="controllers.*" %>
<%@ page import="utils.DB" %>
<%
    String username = request.getParameter("user");
    String password = request.getParameter("pass");
    try{
        Connection con = DB.openConnection();
        Statement st = con.createStatement();
        ResultSet rs;
        rs = st.executeQuery("select * from authusers where user='" + username + "' and pass='" + password + "'");
        if (rs.next()) {
            session.setAttribute("user", username);
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    } catch (Exception e){
        out.println(e);
    }
%>
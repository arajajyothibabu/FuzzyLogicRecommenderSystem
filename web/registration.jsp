<%@ page import ="java.sql.*" %>
<%@ page import="controllers.*" %>
<%
    String user = request.getParameter("uname");    
    String pwd = request.getParameter("pass");
    try{
        Connection con = DoConnection.getConnection();
        Statement st = con.createStatement();
        //ResultSet rs;
        int i = st.executeUpdate("insert into members(uname, pass) values ('" + user + "','" + pwd + "')");
        if (i > 0) {
            session.setAttribute("userid", user);
            response.sendRedirect("success.jsp");
            // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
        } else {
            response.sendRedirect("index.jsp");
        }
    }catch(Exception e){
        out.println(e);
    }
%>
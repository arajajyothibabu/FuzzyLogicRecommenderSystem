<%@ page import ="java.sql.*" %>
<%@ page import="includes.*" %>
<%
    String userid = request.getParameter("uname");    
    String pwd = request.getParameter("pass");
    try{
        Connection con = DoConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs;
        rs = st.executeQuery("select * from members where uname='" + userid + "' and pass='" + pwd + "'");
        if (rs.next()) {
            session.setAttribute("userid", userid);
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    } catch (Exception e){
        out.println(e);
    }
%>
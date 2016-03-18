<%@ page import ="java.sql.*" %>
<%@ page import="controllers.*" %>
<%@ page import="utils.Utils" %>
<%
    try{
        String item1 = Utils.replaceNull(request.getParameter("c1"));
        String item2 = Utils.replaceNull(request.getParameter("c2"));
        String item3 = Utils.replaceNull(request.getParameter("c3"));
        String item4 = Utils.replaceNull(request.getParameter("c4"));
        String item5 = Utils.replaceNull(request.getParameter("c5"));
        String item6 = Utils.replaceNull(request.getParameter("c6"));
        out.println(session.getAttribute("userid"));
        out.println(item1);
        Connection con = DoConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs;
        int i = st.executeUpdate("insert into items values ('" + session.getAttribute("userid") + "','" +Integer.parseInt(item1) + "','" + Integer.parseInt(item2) + "','" +Integer.parseInt(item3) + "','" +Integer.parseInt(item4) + "','" +Integer.parseInt(item5) + "','" +Integer.parseInt(item6) + "')");
        if (i > 0)
        {
            //session.setAttribute("userid", session.getAttribute("userid"));
            response.sendRedirect("recorded.jsp");
            out.print("Recorded Successfully!"+"<a href='success.jsp'>Back</a>");
        } else {
            response.sendRedirect("index.jsp");
        }
out.println(Integer.parseInt(item1)+Integer.parseInt(item2));
        out.println(item3);
    }catch(Exception e){
        e.printStackTrace();
        out.println(e);
    }
%>
<%@ page import ="java.sql.*" %>
<%@ page import="utils.DB" %>
<%@ page import="utils.Utils" %>
<%
    int username = Integer.parseInt(Utils.replaceNull(request.getParameter("user")));
    String password = Utils.replaceNull(request.getParameter("pass"));
    if (username != 0 && password != "0") {
        try {
            Connection con = DB.openConnection();
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("select * from authusers where userid='" + username + "' and pass='" + password + "'");
            if (resultSet.next()) {
                session.setAttribute("user", username);
                response.sendRedirect("index.jsp?login=1");
            } else {
                //checking if username already exists
                resultSet = st.executeQuery("select * from authusers where userid='" + username + "'");
                if (resultSet.next()) {
                    response.sendRedirect("index.jsp?attempt=1");
                } else {
                    //registartion if user doesn't exists
                    int authUserInsert = st.executeUpdate("insert into authusers values ('" + username + "','" + password + "')");
                    int userInsert = st.executeUpdate("insert into users values ('" + username + "','','','','')");
                    if (authUserInsert > 0 && userInsert > 0) {
                        session.setAttribute("user", username);
                        response.sendRedirect("index.jsp?login=2");
                    }
                }
            }
        }catch(Exception e){
            out.println(e);
        }
    }else{
        out.print("<h1>500 :  Internal Server Error :( </h1>");
    }
%>
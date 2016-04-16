<%--
  Created by IntelliJ IDEA.
  User: Araja Jyothi Babu
  Date: 21-Mar-16
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<% if(session.getAttribute("fail") != null) { %>
    <div data-alert class="alert-box warning round large-centered text-center">
        Invalid Password..!
        <a href="#" class="close">&times</a>
    </div>
<%
        session.removeAttribute("fail");
    } %>

<% if(session.getAttribute("new") != null) { %>
    <div data-alert class="alert-box success round large-centered text-center">
        Registration Successful..!
        <a href="#" class="close">&times</a>
    </div>
<%
        session.removeAttribute("new");
    }
%>
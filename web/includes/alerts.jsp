<%--
  Created by IntelliJ IDEA.
  User: Araja Jyothi Babu
  Date: 21-Mar-16
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<% if(request.getParameter("attempt").equals(1)) { %>
    <div data-alert class="alert-box warning round">
        Invalid Password..!
        <a href="#" class="close">&times</a>
    </div>
<% } %>

<% if(request.getParameter("login").equals(2)) { %>
    <div data-alert class="alert-box warning round">
        Registration Successful..!
        <a href="#" class="close">&times</a>
    </div>
<% } %>
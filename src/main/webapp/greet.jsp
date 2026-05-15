<%@ page import="javax.servlet.http.*" %>
<%
    String username = request.getParameter("username");

    // Use implicit session object
    session.setAttribute("username", username);
    session.setMaxInactiveInterval(1 * 60); // 1 minute timeout
%>
<!DOCTYPE html>
<html>
<head>
    <title>Greeting</title>
</head>
<body>
    <h2>Hello, <%= username %>!</h2>
    <p>Your session is set for 1 minute.</p>
    <p>
        <a href="check.jsp">Click here to check session status</a>
    </p>
    <p>Wait for 1 minute to see the session expire.</p>
</body>
</html>
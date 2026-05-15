<%@ page import="javax.servlet.http.*" %>
<%
    String username = request.getParameter("username");
    String timeoutParam = request.getParameter("timeout");
    int timeout = 1;

    try {
        timeout = Integer.parseInt(timeoutParam);
    } catch(Exception e) { }

    // Use implicit session object
    session.setAttribute("username", username);
    session.setMaxInactiveInterval(timeout * 60); // minutes to seconds
%>
<!DOCTYPE html>
<html>
<head>
    <title>Greeting</title>
</head>
<body>
    <h2>Hello, <%= username %>!</h2>
    <p>Your session is set for <%= timeout %> minute(s).</p>
    <p>
        <a href="check.jsp">Click here to check session status</a>
    </p>
    <p>Or wait for <%= timeout %> minute(s) to see session expire.</p>
</body>
</html>
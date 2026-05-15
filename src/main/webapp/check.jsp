<%@ page import="javax.servlet.http.*" %>
<%
    HttpSession s = request.getSession(false); // don’t create a new session
    String message;

    if (s != null && s.getAttribute("username") != null) {
        String username = (String) s.getAttribute("username");
        message = "Session is active. Hello, " + username + "!";
    } else {
        message = "Session has expired or does not exist. Please go back and enter your name again.";
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Session Check</title>
</head>
<body>
    <h2><%= message %></h2>
    <a href="index.jsp">Back to Input Form</a>
</body>
</html>
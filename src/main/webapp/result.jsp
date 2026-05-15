<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Data Result</title>
</head>
<body>
<h2>Submitted User Data</h2>

<%
    if (request.getAttribute("errorMessage") != null) {
        out.println("<h3 style='color:red'>" + request.getAttribute("errorMessage") + "</h3>");
    } else {
        String username = (String) request.getAttribute("username");
        String email = (String) request.getAttribute("email");
        String designation = (String) request.getAttribute("designation");
%>
<p><strong>Username:</strong> <%= username %></p>
<p><strong>Email:</strong> <%= email %></p>
<p><strong>Designation:</strong> <%= designation %></p>
<% } %>

<br>
<a href="index.jsp">Back to Input Form</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.Date" %>
<%
    // Use implicit 'session' object
    session.setMaxInactiveInterval(60); // 1 minute

    String userName = request.getParameter("userName");

    if (userName != null && !userName.trim().isEmpty()) {
        session.setAttribute("userName", userName);
    } else {
        userName = (String) session.getAttribute("userName");
    }

    Date creationTime = new Date(session.getCreationTime());
    Date lastAccessTime = new Date(session.getLastAccessedTime());
%>

<!DOCTYPE html>
<html>
<head>
    <title>Session Info</title>
</head>
<body>
<%
    if (userName != null) {
%>
    <h2>Hello <%= userName %>!</h2>
    <p><b>Session ID:</b> <%= session.getId() %></p>
    <p><b>Session Creation Time:</b> <%= creationTime %></p>
    <p><b>Last Access Time:</b> <%= lastAccessTime %></p>
    <p><b>Session Timeout:</b> 1 minute</p>
    <p>Refresh the page within 1 minute to continue session, or wait 1 minute to see session expire.</p>
<%
    } else {
%>
    <h2>Session Expired or Name Not Provided!</h2>
    <p><a href="index.jsp">Go Back</a></p>
<%
    }
%>
</body>
</html>
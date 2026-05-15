<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.Cookie" %>
<!DOCTYPE html>
<html>
<head>
    <title>Active Cookies</title>
</head>
<body>
    <h2>Active Cookies List</h2>

<%
    Cookie[] cookies = request.getCookies();

    if (cookies != null && cookies.length > 0) {
%>
        <table border="1" cellpadding="5">
            <tr>
                <th>Name</th>
                <th>Value</th>
                <th>Domain</th>
                <th>Max Age (seconds)</th>
            </tr>
<%
        for (Cookie c : cookies) {
%>
            <tr>
                <td><%= c.getName() %></td>
                <td><%= c.getValue() %></td>
                <td><%= c.getDomain() != null ? c.getDomain() : "Not Set" %></td>
                <td><%= c.getMaxAge() %></td>
            </tr>
<%
        }
%>
        </table>
<%
    } else {
%>
        <p>No active cookies found.</p>
<%
    }
%>

    <br>
    <a href="addCookie.jsp">Add More Cookies</a>
</body>
</html>
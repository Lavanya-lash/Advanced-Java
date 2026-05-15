<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Cookie Management</title>
</head>
<body>
    <h2>Add a Cookie</h2>
    <form action="addCookie.jsp" method="post">
        Cookie Name: <input type="text" name="cookieName" required><br><br>
        Cookie Value: <input type="text" name="cookieValue" required><br><br>
        Domain (optional): <input type="text" name="cookieDomain"><br><br>
        Max Age (in seconds): <input type="number" name="cookieMaxAge" required><br><br>
        <input type="submit" value="Add Cookie">
    </form>

<%
    // Check if form is submitted
    String name = request.getParameter("cookieName");
    String value = request.getParameter("cookieValue");
    String domain = request.getParameter("cookieDomain");
    String maxAgeStr = request.getParameter("cookieMaxAge");

    if (name != null && value != null && maxAgeStr != null) {
        int maxAge = Integer.parseInt(maxAgeStr);

        // Create cookie
        javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie(name, value);

        if (domain != null && !domain.trim().isEmpty()) {
            cookie.setDomain(domain);
        }

        cookie.setMaxAge(maxAge); // in seconds

        // Add cookie to response
        response.addCookie(cookie);

%>
        <h3>Cookie Added Successfully!</h3>
        <p><b>Name:</b> <%= cookie.getName() %></p>
        <p><b>Value:</b> <%= cookie.getValue() %></p>
        <p><b>Domain:</b> <%= cookie.getDomain() != null ? cookie.getDomain() : "Not Set" %></p>
        <p><b>Max Age:</b> <%= cookie.getMaxAge() %> seconds</p>
        <p><a href="showCookies.jsp">Go to Active Cookie List</a></p>
<%
    }
%>
</body>
</html>
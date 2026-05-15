<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Result</title>
</head>
<body>
<h2>Student Result</h2>

<%
    if (request.getAttribute("errorMessage") != null) {
        out.println("<h3 style='color:red'>" + request.getAttribute("errorMessage") + "</h3>");
    } else {
        String rollno = (String) request.getAttribute("rollno");
        String studentname = (String) request.getAttribute("studentname");
        int[] marks = (int[]) request.getAttribute("marks");
        String result = (String) request.getAttribute("result");
        double average = (Double) request.getAttribute("average");
%>

<p>Roll No: <%= rollno %></p>
<p>Student Name: <%= studentname %></p>

<table border="1">
    <tr><th>Subject</th><th>Marks</th></tr>
    <% for(int i=0; i<marks.length; i++){ %>
        <tr><td>Subject <%= i+1 %></td><td><%= marks[i] %></td></tr>
    <% } %>
</table>

<p>Average Marks: <%= average %></p>
<p>Result: <strong><%= result %></strong></p>

<% } %>
<br>
<a href="index.jsp">Back to Input Form</a>
</body>
</html>
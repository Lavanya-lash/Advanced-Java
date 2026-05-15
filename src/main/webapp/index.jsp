<!DOCTYPE html>
<html>
<head>
    <title>Session Management</title>
</head>
<body>
    <h2>Enter Your Name</h2>
    <form action="greet.jsp" method="post">
        Name: <input type="text" name="username" required><br><br>
        Session Timeout (minutes): <input type="number" name="timeout" min="1" value="1" required><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
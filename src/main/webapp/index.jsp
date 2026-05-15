<!DOCTYPE html>
<html>
<head>
    <title>User Data Input</title>
    <script>
        function validateForm() {
            var username = document.forms["userForm"]["username"].value;
            var email = document.forms["userForm"]["email"].value;
            var designation = document.forms["userForm"]["designation"].value;

            if (username === "") {
                alert("Username cannot be empty");
                return false;
            }

            if (email === "") {
                alert("Email cannot be empty");
                return false;
            }

            // Simple email regex validation
            var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
            if (!emailPattern.test(email)) {
                alert("Please enter a valid email address");
                return false;
            }

            if (designation === "") {
                alert("Designation cannot be empty");
                return false;
            }

            return true; // All validations passed
        }
    </script>
</head>
<body>
    <h2>Enter User Data</h2>
    <form name="userForm" action="UserDataServlet" method="post" onsubmit="return validateForm()">
        Username: <input type="text" name="username"><br><br>
        Email: <input type="text" name="email"><br><br>
        Designation: <input type="text" name="designation"><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
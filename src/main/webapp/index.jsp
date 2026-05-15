<!DOCTYPE html>
<html>
<head>
    <title>Student Marks Input</title>
    <script>
        function validateForm() {
            const fields = ['rollno', 'studentname', 'sub1', 'sub2', 'sub3', 'sub4', 'sub5'];
            for (let i = 0; i < fields.length; i++) {
                let val = document.forms["studentForm"][fields[i]].value;
                if (val === "") {
                    alert(fields[i] + " cannot be empty");
                    return false;
                }
                if (fields[i].startsWith("sub")) {
                    let mark = Number(val);
                    if (isNaN(mark) || mark < 0 || mark > 100) {
                        alert(fields[i] + " must be a number between 0 and 100");
                        return false;
                    }
                }
            }
            return true;
        }
    </script>
</head>
<body>
    <h2>Enter Student Details and Marks</h2>
    <form name="studentForm" action="ResultServlet" method="post" onsubmit="return validateForm()">
        Roll No: <input type="text" name="rollno"><br><br>
        Student Name: <input type="text" name="studentname"><br><br>
        Subject 1: <input type="text" name="sub1"><br><br>
        Subject 2: <input type="text" name="sub2"><br><br>
        Subject 3: <input type="text" name="sub3"><br><br>
        Subject 4: <input type="text" name="sub4"><br><br>
        Subject 5: <input type="text" name="sub5"><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
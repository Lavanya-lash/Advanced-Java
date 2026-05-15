package com.example.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class UserDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String designation = request.getParameter("designation");

        String errorMessage = null;

        // Server-side validation
        if (username == null || username.trim().isEmpty()) {
            errorMessage = "Username is required";
        } else if (email == null || email.trim().isEmpty()) {
            errorMessage = "Email is required";
        } else if (!email.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            errorMessage = "Invalid email format";
        } else if (designation == null || designation.trim().isEmpty()) {
            errorMessage = "Designation is required";
        }

        if (errorMessage != null) {
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            return;
        }

        // Pass valid data to result.jsp
        request.setAttribute("username", username);
        request.setAttribute("email", email);
        request.setAttribute("designation", designation);

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}
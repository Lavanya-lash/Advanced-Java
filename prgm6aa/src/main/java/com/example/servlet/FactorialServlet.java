package com.example.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/FactorialServlet")
public class FactorialServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        try {
            int num = Integer.parseInt(request.getParameter("num"));

            if (num < 0) {
                out.println("<h2>Factorial is not defined for negative numbers!</h2>");
            } else if (num > 20) {
                out.println("<h2>Number too large! Please enter ≤ 20.</h2>");
            } else {
                long factorial = 1;
                for (int i = 1; i <= num; i++) {
                    factorial *= i;
                }
                out.println("<h2>Factorial of " + num + " is: " + factorial + "</h2>");
            }

        } catch (NumberFormatException e) {
            out.println("<h2>Please enter a valid integer!</h2>");
        }

        out.println("<br><br><a href='index.html'>Calculate Again</a>");
        out.println("</body></html>");
    }
}
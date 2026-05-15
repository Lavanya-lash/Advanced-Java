package com.example.prime;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PrimeCheckServlet")
public class PrimeCheckServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Step 1: Get number from HTML form
        String numStr = request.getParameter("number");
        int num = Integer.parseInt(numStr);

        boolean isPrime = true;

        // Step 2: Prime check logic
        if (num <= 1) {
            isPrime = false; // numbers <= 1 are not prime
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        // Step 3: Display result
        out.println("<html><body>");
        out.println("<h2>Prime Number Check</h2>");
        out.println("<p>Number entered: " + num + "</p>");
        if (isPrime) {
            out.println("<p><b>" + num + " is a Prime Number.</b></p>");
        } else {
            out.println("<p><b>" + num + " is NOT a Prime Number.</b></p>");
        }
        out.println("<br><a href='index.html'>Check Another Number</a>");
        out.println("</body></html>");
    }
}
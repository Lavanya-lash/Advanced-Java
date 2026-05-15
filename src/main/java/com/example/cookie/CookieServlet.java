package com.example.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");
        Cookie[] cookies = request.getCookies();

        int visitCount = 0;
        boolean nameCookieExists = false;

        // Check if cookies exist
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userName")) {
                    userName = cookie.getValue(); // reuse existing name
                    nameCookieExists = true;
                }
                if (cookie.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(cookie.getValue());
                }
            }
        }

        visitCount++; // increment visit count

        // Create / update cookies
        Cookie nameCookie = new Cookie("userName", userName);
        Cookie visitCookie = new Cookie("visitCount", String.valueOf(visitCount));

        // Set expiry time for cookies (e.g., 1 minute = 60 seconds)
        nameCookie.setMaxAge(60);
        visitCookie.setMaxAge(60);

        // Add cookies to response
        response.addCookie(nameCookie);
        response.addCookie(visitCookie);

        // Display greeting
        out.println("<html><body>");
        if (nameCookieExists) {
            out.println("<h2>Welcome back " + userName + "!</h2>");
        } else {
            out.println("<h2>Hello " + userName + ", nice to meet you!</h2>");
        }
        out.println("<p>You have visited this page " + visitCount + " times.</p>");

        // Display all cookies
        out.println("<h3>Cookies Set:</h3>");
        if (cookies != null) {
            out.println("<ul>");
            for (Cookie cookie : cookies) {
                out.println("<li>" + cookie.getName() + " = " + cookie.getValue() + "</li>");
            }
            out.println("</ul>");
        } else {
            out.println("<p>No cookies found.</p>");
        }

        out.println("<p>Note: Cookies expire after 1 minute.</p>");
        out.println("</body></html>");
    }
}
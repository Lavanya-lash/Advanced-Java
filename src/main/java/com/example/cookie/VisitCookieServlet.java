package com.example.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VisitCookieServlet")
public class VisitCookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");
        Cookie[] cookies = request.getCookies();

        int visitCount = 0;
        boolean nameCookieExists = false;

        // Step 1: Check if cookies exist
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("userName".equals(cookie.getName())) {
                    userName = cookie.getValue();
                    nameCookieExists = true;
                }
                if ("visitCount".equals(cookie.getName())) {
                    visitCount = Integer.parseInt(cookie.getValue());
                }
            }
        }

        // Step 2: Increment visit count
        visitCount++;

        // Step 3: Create / Update cookies
        Cookie nameCookie = new Cookie("userName", userName);
        Cookie visitCookie = new Cookie("visitCount", String.valueOf(visitCount));

        // Set cookie expiry time (60 seconds = 1 minute)
        nameCookie.setMaxAge(60);
        visitCookie.setMaxAge(60);

        response.addCookie(nameCookie);
        response.addCookie(visitCookie);

        // Step 4: Display greeting and visit info
        out.println("<html><body>");
        if (nameCookieExists) {
            out.println("<h2>Welcome back " + userName + "!</h2>");
        } else {
            out.println("<h2>Hello " + userName + ", nice to meet you!</h2>");
        }
        out.println("<p>You have visited this page " + visitCount + " times.</p>");
        out.println("<p>Note: Cookies expire after 1 minute of inactivity.</p>");
        out.println("<br><a href='index.html'>Go Back</a>");
        out.println("</body></html>");
    }
}
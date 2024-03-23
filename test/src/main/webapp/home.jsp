<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="jakarta.servlet.http.HttpServletResponse" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="java.io.PrintWriter" %>

<%
    // Check if the user is logged in by verifying the session
   
    boolean isLoggedIn = session != null && session.getAttribute("firstName") != null;

    // If the user is not logged in, redirect to the login page
    if (!isLoggedIn) {
        response.sendRedirect("index.jsp");
        return; // Ensure no further content is processed
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
</head>
<body>
    <h1>Welcome, <%= session.getAttribute("firstName") %>!</h1>
    <form action="servlet" method="post">
        <input type="hidden" name="action" value="logout">
        <input type="submit" value="Logout">
    </form>
</body>
</html>

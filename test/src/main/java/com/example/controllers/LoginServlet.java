package com.example.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.annotation.Resource;

import com.example.models.User;
import com.example.services.LoginService;


@WebServlet(urlPatterns="/servlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource(lookup = "jdbc/myDB")
    private DataSource dataSource;
    LoginService database;
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the login page
            // Check if the user has a valid session cookie
        Cookie[] cookies = request.getCookies();
        boolean isValidSession = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("sessionId")) {
                    // Validate the session ID or token
                    isValidSession = true;
                    break;
                }
            }
        }
        if (!isValidSession) {
            // Redirect the user to the login page
            response.sendRedirect("index.jsp");
            return;
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginService loginService;
        String action = request.getParameter("action"); 
        HttpSession session = request.getSession();

        try {
            loginService = new LoginService(dataSource.getConnection());        
             action = request.getParameter("action");
    
        
//************************************************************************************************ */
        if(action.equals("login")){  
        
        // Retrieve user input from the login form
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            try {
                
                User user = loginService.authenticateUser(email, password);
    
                // Redirect user based on authentication result
                if (user != null) {
    
                    //start session and store user s first name in it
    
                    session.setAttribute("firstName",user.getFirstname());
                    
                    // Set a cookie to indicate a valid session
                    Cookie sessionCookie = new Cookie("sessionId", session.getId());
                    sessionCookie.setMaxAge(24 * 60 * 60); // Cookie expiration time in seconds (e.g., 24 hours)
                    response.addCookie(sessionCookie);   
                    
                    // Authentication successful, redirect to the home page or dashboard
                    response.sendRedirect("home.jsp");
                
                } 
                else {
                    request.setAttribute("error", "Email or password incorrect");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                
                }
                }catch(Exception e){


                }
            }

//************************************************************************************************ */
                 if(action.equals("signUp")){

                    String email = request.getParameter("email");
                    String password = request.getParameter("password");           
                    String firstname = request.getParameter("firstname");
                    String lastname = request.getParameter("lastname");
                    String phoneNumber = request.getParameter("phoneNumber");
                    String gender = request.getParameter("gender");
            
                    String confirmPassword = request.getParameter("confirmPassword");
                    
                    // Check if passwords match
                    if (!password.equals(confirmPassword)) {
                        // Set attribute for password mismatch
                        request.setAttribute("passwordMismatch", "Passwords do not match");
                        
                        // Forward the request back to the sign-up page
                        request.getRequestDispatcher("signUp.jsp").forward(request, response);
                    } else {
            
                    User user2 = new User(firstname, lastname, email, password, phoneNumber, gender);
                    
                   
                    boolean registerUser = loginService.registerUser(user2);
                    
            
                    if(registerUser){                      
                       session.setAttribute("registrationEmail", email);
                        session.setAttribute("firstname", firstname);
            
                        response.sendRedirect("index.jsp");
                    }else {
                        response.sendRedirect("signUp.jsp");
                       
                    }
                    }
                
                
                }
//************************************************************************************************ */           
                 if ("logout".equals(action)) {
                        // Perform logout logic
                       
                        if (session != null) {
                            session.invalidate();
                        }
                        response.sendRedirect("index.jsp"); // Redirect to login page
                    }

            
       
           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    }
       



<!DOCTYPE html>
<!-- Created By CodingNepal -->
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Login Form</title>
      <link rel="stylesheet" href="style.css">
   </head>
   <body>
      <div class="wrapper">
         <div class="title">
            Login Form
         </div>
         <form action="servlet" method="post">
            <div class="field">
               <input type="text" name="email" required>
               <label>Email Address</label>
            </div>
            <div class="field">
               <input type="password" name="password">
               <label>Password</label>
            </div>
             <br> 
            <div class="field">
               <input type="submit" value="Login">
            </div>
            <% if (request.getAttribute("error") != null) { %>
               <p style="text-align: center; color: brown;">Email or Password incorrect</p>
           <% } %>
          
            <div class="signup-link">
               Not a member? <a href="signUp.jsp">Signup now</a>
            </div>

            <input type="hidden" name="action" value="login">
         </form>
      </div>
   </body>
</html>
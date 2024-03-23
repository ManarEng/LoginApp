<!DOCTYPE html>
<!-- Created By CodingLab - www.codinglabweb.com -->
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <title> Sign Up </title>
    <link rel="stylesheet" href="style_signUp.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
  </head>
  <body>
    <div class="container">
      <div class="title">Registration</div>
      <div class="content">
        <form action="servlet" method="post">
          <div class="user-details">
            <div class="input-box">
              <span class="details">First Name</span>
              <input type="text" name="firstname" value="${param.firstname}" required>
            </div>
            <div class="input-box">
              <span class="details">Last Name</span>
              <input type="text" name="lastname" value="${param.lastname}" required>
            </div>
            <div class="input-box">
              <span class="details">Email</span>
              <input type="email" name="email" value="<%= session.getAttribute
              ("registrationEmail") != null ? session.getAttribute("registrationEmail") : "" %>"required>
            </div>
            <div class="input-box">
              <span class="details">Phone Number</span>
              <input type="phone" name="phoneNumber" value="${param.phoneNumber}" required>
            </div>
            <div class="input-box">
              <span class="details">Password</span>
              <input type="password" name="password" required>
            </div>
            <div class="input-box">
              <span class="details" >Confirm Password</span>
              <input type="password" name="confirmPassword" required>
              <p style="color: red;"> 
                <% if (request.getAttribute("passwordMismatch") != null) { %>
                  <%= request.getAttribute("passwordMismatch") %>
                <% } %>
              </p>
            </div>
          </div>
          <div class="gender-details">
            <input type="radio" name="gender" id="dot-1">
            <input type="radio" name="gender" id="dot-2">
            <span class="gender-title">Gender</span>
            <div class="category">
              <label for="dot-1">
                <span class="dot one"></span>
                <span class="gender">Male</span>
              </label>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <label for="dot-2">
                <span class="dot two"></span>
                <span class="gender">Female</span>
              </label>
            </div>
          </div>
          <div class="button">
            <input type="hidden" name="action" value="signUp">
            <input type="submit" value="Register">
          </div>
        </form>
      </div>
    </div>
  </body>
</html>

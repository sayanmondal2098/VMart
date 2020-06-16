<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Find the most trendy cloathes across the globe round the clock"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VMart Login</title>
    <link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
    <link rel="icon" href="assets/img/Paomedia-Small-N-Flat-Shop.ico"/>
    <link type="text/css" rel="stylesheet" href="assets/css/main.css"/>
    <script type="text/javascript" src="assets/js/global.js"></script>
</head>
<body> 
    <div class="head">
        <img class="head_logo" src="assets/img/vmart-logo.png"/>
    </div>   

    <div class="form_container">
        <div class="form_head">
            Login Account
        </div>
        <br>
        <form onsubmit="return validation()" action="login" method="POST">
            <label class="form"><b>Email</b></label><br>
            <input class="form_ed" type="email" onkeydown="txt_tracker(this)" maxlength="64" name="email" id="email"><br>
            <label class="form_error" id="err_email"></label>
            <br>
            <label class="form"><b>Password</b></label><br>
            <input class="form_ed" type="password" onkeydown="txt_tracker(this)" maxlength="1024" name="password" id="password" placeholder="At least 6 characters"><br>
            <label class="form_error" id="err_password"></label>
            <br>
            <input class="form_btn" type="submit" value="Continue">
        </form><br><br>
        <label class="form">Don't have an account? <a class="emphasis_link" href="signup.jsp">Sign Up</a></label>
    </div>
    
</body>
</html>
function errormsg(variableName ,getElementByIdName, warningMessage) {
    var variableName=document.getElementById(getElementByIdName);
        variableName.style.display='block';
        variableName.innerHTML=warningMessage;
//        flag=false;
}

function validation()
{
    var name=document.getElementById("name");
    var email=document.getElementById("email");
    var password=document.getElementById("password");
    var repassword=document.getElementById("repassword");

    var flag=true;
    if(name.value=="")
    {
        // var err_name=document.getElementById("err_name");
        // err_name.style.display='block';
        // err_name.innerHTML="Enter your name";
        errormsg(err_name,"err_name","Enter name");
        flag=false;
    }
    if(email.value=="")
    {
        // var err_email=document.getElementById("err_email");
        // err_email.style.display='block';
        // err_email.innerHTML="Enter your email";
        errormsg(err_email,"err_email","Enter Email");
        flag=false;
    }
    if(password.value=="")
    {
        // var err_password=document.getElementById("err_password");
        // err_password.style.display='block';
        // err_password.innerHTML="Enter your password";
        errormsg(err_email,"err_email","Enter Email");
        flag=false;
    }
    else if(password.value.length<6)
    {
        // var err_password=document.getElementById("err_password");
        // err_password.style.display='block';
        // err_password.innerHTML="At least 6 characters required";
        errormsg(err_email,"err_email","Enter Email");
        flag=false;
    }
    if(repassword.value!=password.value)
    {
        // var err_repassword=document.getElementById("err_repassword");
        // err_repassword.style.display='block';
        // err_repassword.innerHTML="Password did not match";
        errormsg(err_email,"err_email","Enter Email");
        flag=false;
    }
    return flag;
}

function txt_tracker(ele)
{
    document.getElementById("err_"+ele.id).style.display='none';
}
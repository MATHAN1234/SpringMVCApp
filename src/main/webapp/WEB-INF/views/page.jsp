<%@page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title> Meta Search Engine - ${title} </title>
    <style type="text/css">
        *{box-sizing: border-box;}
        body {margin: 0px; padding:0%; height:100%; text-align:center; font-size:12px; font-family:Arial, Helvetica, sans-serif;}
        .header{background-color: #f1f1f1;overflow:hidden;padding: 20px 10px;width:100%;}
        .header a {float: left; color: black; text-align: center; padding: 12px; text-decoration: none; font-size: 18px; line-height: 25px; border-radius: 4px;}
        .header a.logo {font-size: 25px;font-weight: bold;}
        .header a:hover {background-color: #ddd;color: black;}
        .header a.active {background-color: #322a2a;color: white;}
        .header-right { float: right;}
        @media screen and (max-width: 500px) {.header a {float: none;display: block;text-align: left;} .header-right {float: none;}}
        section{height:500px;}
        h1 { font-size: 270%; font-family:calibri; text-align:center;}
        footer{padding:15px;position:fixed;background-color: #f1f1f1; text-align:center; height:50px; width:100%; color:white; bottom:0; left:0}
        .m-b-15{ margin-bottom: 15px; }
        .m-t-0{ margin-top: 0px; }
        .m-b-5{ margin-bottom: 5px; }
        .product-grid-item{ position: relative; }
        .product-grid-item>a{ position: absolute; width: 100%; height: 100%; left: 0; top: 0; }


        .logincontainer,.Registercontainer {padding: 16px;}
        /* Full-width input fields */
        .passworddf,.textf,.passwordf{width: 100%;padding: 15px;margin: 5px 0 22px 0;display: inline-block;border: none;background: #f1f1f1;}
        .textf:focus, input[type=password]:focus {background-color: #ddd;outline: none;}
        /* Overwrite default styles of hr */
        hr {border: 1px solid #f1f1f1;margin-bottom: 25px;}
        /* Set a style for the submit/register button */
        .Loginbtn,.registerbtn {background-color: #4CAF50;color: white;padding: 16px 20px;margin: 8px 0;border: none;cursor: pointer;width: 100%;opacity: 0.9;}
        .Loginbtn:hover,.registerbtn:hover {opacity:1;}
        /* Add a blue text color to links */
        a {color: dodgerblue;}
        /* Set a grey background color and center the text of the "sign in" section */
        .signin {background-color: #f1f1f1;text-align: center;}

    </style>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <!-- HEADER -->
    <%@include file="./shared/header.jsp" %>

    <!-- SECTION -->
    <div class="content">
        <c:if test="${UserClickHome==true }">
            <%@include file="home.jsp" %>
        </c:if>
        <c:if test="${UserClickLogin==true }">
            <%@include file="Login.jsp" %>
        </c:if>
        <c:if test="${UserClickRegister==true }">
            <%@include file="Register.jsp" %>
        </c:if>
        <c:if test="${UserClickAbout==true }">
            <%@include file="About.jsp" %>
        </c:if>
    </div>
    <!-- FOOTER -->
    <%@include file="./shared/footer.jsp" %>
</div>
</body>
</html>
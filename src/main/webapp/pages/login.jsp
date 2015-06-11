<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
  <title>Sport Club System</title>
  <link href="<c:url value="/resources/css/materialize.css" />"type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="<c:url value="/resources/css/style.css" />"type="text/css" rel="stylesheet" media="screen,projection"/>
<style type="text/css">
  .login{
    text-align: center;
    margin-top: 10%;

  }
html { 
  background: url(<c:url value="/resources/img/login_background.jpg" />) no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}
.footer{
  margin-top: 9.2% !important;
}
  </style>
</head>
<body>
	
		
		
<div class="container login">
  
    <div class="row center-align login">
          <div class="col s12 m3 l4"><p/></div>
          <div class="col s12 m3 l4 grey lighten-3 z-depth-5">
            <h3 class="grey-text text-darken-1">Login</h3>
            <div class="row">
              <form class="col s12" name='loginForm' method='POST'
			action="<c:url value='/j_spring_security_check' />">
                <div class="row">
                  <div class="input-field col s12">
                    <input id="username" type="text" class="validate" name='username'>
                    <label for="username">Username</label>
                  </div>
                </div>
                <div class="row">
                  <div class="input-field col s12">
                    <input id="password" type="password" class="validate" name='password'>
                    <label for="password">Password</label>
                  </div>
                </div>
                <button class="btn waves-effect waves-light" type="submit" name="submit">Submit
                  <i class="mdi-content-send right"></i>
                </button>
                <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
              </form>
            </div>
          </div>
          <div class="col s12 m3 l4"><p/></div>
    </div>
</div>

<footer class="page-footer footer transparent">
          <div class="footer-copyright">
            <div class="container">
            © 2015 Copyright Sport Club System
            </div>
          </div>
</footer>

  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="<c:url value="/resources/js/materialize.js" />"></script>
  <script src="<c:url value="/resources/js/init.js" />"></script>

		
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
  <title>User Management - Edit User</title>
  <link href="<c:url value="/resources/css/materialize.css" />"type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="<c:url value="/resources/css/style.css" />"type="text/css" rel="stylesheet" media="screen,projection"/>
  <style type="text/css">
  .admin-footer{
      margin-top: 5.6% !important;
	}
  
  </style>
  </head>
<body>

 <jsp:include page="header.jsp"/>

	

	<div class="container">
         <div class="row">
            <form:form  class="col s12" action="../edituser" method="post" commandName="userForm">
            
              <div class="row">
                <div class="input-field col s6">
                  <form:input path="name" id="name"  class="validate" required="required" maxlength="64" value="${userForm.name}"/>
                  <label for="name">Name</label>
                </div>
                <div class="input-field col s6">
                  <form:input path="surname" id="surname"  class="validate" maxlength="64"  value="${userForm.surname}"/>
                  <label for="surname">Surname</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                   <form:input path="username" id="username"  class="validate" required="required" maxlength="64"  value="${userForm.username}"/>
                  <label for="username">Username</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <form:input path="email"  id="email" type="email" class="validate" required="required" maxlength="64"  value="${userForm.email}"/>
                  <label for="email">Email</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input type="checkbox" name="active" id="active" value="true"  <c:if test="${userForm.active}">checked="checked"</c:if> />
                  
                  <label for="active">Active</label>
                </div>
              </div>
				<form:hidden path="id" value="${userForm.id}"/>
              <button class="btn waves-effect waves-light" type="submit" name="submit">Submit
                          <i class="mdi-content-send right"></i>
              </button>
               
            </form:form>
         </div>
      </div>
      
      
      <jsp:include page="footer.jsp"/>
      
      
  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="<c:url value="/resources/js/materialize.js" />"></script>
  <script src="<c:url value="/resources/js/init.js" />"></script>
      
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 
<link href="<c:url value="/resources/css/materialize.css" />"type="text/css" rel="stylesheet" media="screen,projection"/>
<link href="<c:url value="/resources/css/style.css" />"type="text/css" rel="stylesheet" media="screen,projection"/>

</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
         <div class="row">
            <form:form  class="col s12" action="../editrole" method="post" commandName="userForm">
            
              <div class="row">
			     <div class="input-field col s12">
			       <input disabled value="${userForm.id}" id="id" type="text" class="validate">
			       <label for="id">id</label>
			     </div>
              </div>
              <div class="row">
			     <div class="input-field col s12">
			       <input disabled value="${userForm.username}" id="username" type="text" class="validate">
			       <label for="username">Username</label>
			     </div>
              </div>
              <div class="row">
			     <div class="input-field col s12">
			       <input disabled value="${userForm.email}" id="email" type="text" class="validate">
			       <label for="email">Email</label>
			     </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <c:forEach items="${roles}" var="role">
                  		<input type="checkbox" name="${role.role}" id="${role.role}" value="true" <c:if test='${  fn:contains( usersroleList,role.role) }'>checked="checked"</c:if> />
                  		<label for="${role.role}">${role.role}</label>
                  </c:forEach>
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
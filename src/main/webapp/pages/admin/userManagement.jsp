<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Management</title>
<link href="<c:url value="/resources/css/materialize.css" />"
	type="text/css" rel="stylesheet" media="screen,projection" />
<link href="<c:url value="/resources/css/style.css" />" type="text/css"
	rel="stylesheet" media="screen,projection" />
<style type="text/css">
 .admin-footer{
      margin-top: 32% !important;
}
</style>
</head>
<body>
	
	<jsp:include page="header.jsp"/>

<div class="container">
      <table class="hoverable">
        <thead>
          <tr>
          	  
              <th data-field="id">id</th>
              <th data-field="username">username</th>
              <th data-field="passwordhash">passwordhash</th>
              <th data-field="name">name</th>
              <th data-field="surname">surname</th>
              <th data-field="email">email</th>
              <th data-field="active">active</th>
              <th data-field="creationTimestamp">creationTimestamp</th>
          </tr>
        </thead>

		
        <tbody>
        <c:forEach items="${users}" var="user">
		    <tr>
		        <td>${user.id}</td>
		        <td>${user.username}</td>
		        <td>${user.passwordHash}</td>
		        <td>${user.name}</td>
		        <td>${user.surname}</td>
		        <td>${user.email}</td>
		        <td>${user.active}</td>
		        <td>${user.creationTimestamp}</td>
		        <td> <!-- Actions for the individual item -->
		            <a href="<c:url value="/admin/usermanagement/deleteuser/${user.id}" />">Delete</a>
		            <a href="<c:url value="/admin/usermanagement/edituser/${user.id}" />">Edit</a>
		        </td>
		    </tr>
		</c:forEach>
          
        </tbody>
        </table>
</div>


	<!-- 
	<tr>
            <td>1</td>
            <td>admin</td>
            <td>admin</td>
            <td>ugur</td>
            <td>lacin</td>
            <td>admin@admin.com</td>
            <td>true</td>
            <td>30-02-2015</td>
          </tr>
	 -->
	<jsp:include page="footer.jsp"/>


	<!--  Scripts-->
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="<c:url value="/resources/js/materialize.js" />"></script>
	<script src="<c:url value="/resources/js/init.js" />"></script>

</body>
</html>
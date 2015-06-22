<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table class="hoverable">
		        <thead>
		          <tr>
		          	  
		              <th data-field="id">id</th>
		              <th data-field="username">username</th>
		              <th data-field="email">email</th>
		              <th data-field="role">role</th>
		          </tr>
		        </thead>
		
				
		        <tbody>
		        <c:forEach items="${users}" var="user">
				    <tr>
				        <td>${user.id}</td>
				        <td>${user.username}</td>
				        <td>${user.email}</td>
				        
				        <td> <!-- Actions for the individual item -->
				            <a href="<c:url value="/admin/usermanagement/editrole/${user.id}" />">Edit</a>
				        </td>
				    </tr>
				</c:forEach>
		          
		        </tbody>
		        </table>
</body>
</html>
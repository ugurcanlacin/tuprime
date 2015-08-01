<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Management - Role</title>
<link href="<c:url value="/resources/css/materialize.css" />"
	type="text/css" rel="stylesheet" media="screen,projection" />
<link href="<c:url value="/resources/css/style.css" />" type="text/css"
	rel="stylesheet" media="screen,projection" />
<style type="text/css">
	 .admin-footer{
	      margin-top: 5% !important;
	}
	ul li a{
		color: #424242 ;
	}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>



<div class="row">
		<div class="col s12 m2 l2 "> <!-- Note that "m4 l3" was added -->
	             <ul class="collection">
	              <li class="collection-item "><a href="<%=request.getContextPath()%>/admin/usermanagement">User Management</a></li>
	              <li class="collection-item"><a href="<%=request.getContextPath()%>/admin/usermanagement/adduser">Add User</a></li>
	              <li class="collection-item active"><a href="<%=request.getContextPath()%>/admin/usermanagement/role">Role</a></li>
	            </ul>
		</div>
		
		<div class="col s12 m10 l10">
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
				        <td>
				        	<c:forEach items="${user.role}" var="role">
				        		${role.role}
				        	</c:forEach>
				        </td>
				        <td> <!-- Actions for the individual item -->
				            <a href="<c:url value="/admin/usermanagement/editrole/${user.id}" />">Edit</a>
				        </td>
				    </tr>
				</c:forEach>
		          
		        </tbody>
			</table>
		</div>
      
</div>













		        
	<jsp:include page="footer.jsp"/>


	<!--  Scripts-->
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="<c:url value="/resources/js/materialize.js" />"></script>
	<script src="<c:url value="/resources/js/init.js" />"></script>	        
</body>
</html>
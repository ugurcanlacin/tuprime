<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Management</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
  <title>User Management - Add User</title>
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
		<h2 class="center">${result}</h2>
		<p class="center">
			<a class="waves-effect waves-light btn center" href="<c:url value="/admin/usermanagement" />">Back to User Management</a>
		</p>
	</div>
</div>

 
   <jsp:include page="footer.jsp"/>
      
      
  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="<c:url value="/resources/js/materialize.js" />"></script>
  <script src="<c:url value="/resources/js/init.js" />"></script>


</body>
</html>
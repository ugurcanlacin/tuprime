<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Management - Edit Role Result</title>
<link href="<c:url value="/resources/css/materialize.css" />"type="text/css" rel="stylesheet" media="screen,projection"/>
<link href="<c:url value="/resources/css/style.css" />"type="text/css" rel="stylesheet" media="screen,projection"/>

</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
	<div class="row">
		<h2 class="center">${result}</h2>
		<p class="center">
			<a class="waves-effect waves-light btn center" href="<c:url value="/admin/usermanagement/role" />">Back to Role Management</a>
		</p>
	</div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
<%@ page language="java" contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"">
<title>User Management</title>
<link href="<c:url value="/resources/css/materialize.css" />"
	type="text/css" rel="stylesheet" media="screen,projection" />
<link href="<c:url value="/resources/css/style.css" />" type="text/css"
	rel="stylesheet" media="screen,projection" />
<style type="text/css">
 .admin-footer{
      margin-top: 34% !important;
}
.message{
	
}
</style>
</head>
<body>
	
	<jsp:include page="header.jsp"/>
	
	<div class="row center">
		<h4 >This web site was developed by Uğurcan Laçin.</h4>
	</div>
		

	<jsp:include page="footer.jsp"/>


	<!--  Scripts-->
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="<c:url value="/resources/js/materialize.js" />"></script>
	<script src="<c:url value="/resources/js/init.js" />"></script>

</body>
</html>
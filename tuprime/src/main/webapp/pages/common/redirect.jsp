<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<sec:authorize access="hasRole('ROLE_USER')">
   <c:redirect url="/user/dashboard"/>
    <br/>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
   
<c:redirect url="/admin/dashboard"/>
    <br/>
</sec:authorize>


</body>
</html>
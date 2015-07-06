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
ul li a{
	color: #424242 ;
}
</style>
</head>
<body>
	
	<jsp:include page="../admin/header.jsp"/>
	<div class="container">
	    <div class="row">
		    <div class="col s12">
		      <ul class="tabs">
		        <li class="tab col s4"><a class="active" href="#test1">Diet</a></li>
		        <li class="tab col s4"><a href="#test2">Workout</a></li>
		        <li class="tab col s4"><a href="#test3">Measurement</a></li>
		      </ul>
		    </div>
		    <div id="test1" class="col s12">
				<table class="hoverable">
		        <thead>
		          <tr>
		          	  
		              <th data-field="id">id</th>
		              <th data-field="diet">diet</th>
		              <th data-field="timestamp">timestamp</th>
		            
		          </tr>
		        </thead>
		
				
		        <tbody>
		        <c:forEach items="${userForm.diet}" var="diet">
				    <tr>
				        <td>${diet.id}</td>
				        <td>${diet.diet}</td>
				        <td>${diet.timestamp}</td>
				    </tr>
				</c:forEach>
		          
		        </tbody>
		        </table>


			</div>
		    <div id="test2" class="col s12">Test 2</div>
		    <div id="test3" class="col s12">Test 3</div>
	  	</div>
	</div>
	<jsp:include page="../admin/footer.jsp"/>


	<!--  Scripts-->
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="<c:url value="/resources/js/materialize.js" />"></script>
	<script src="<c:url value="/resources/js/init.js" />"></script>

</body>
</html>
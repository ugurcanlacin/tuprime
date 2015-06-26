<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
  <title>Sport Club System</title>
  <link href="<c:url value="/resources/css/materialize.css" />"type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="<c:url value="/resources/css/style.css" />"type="text/css" rel="stylesheet" media="screen,projection"/>
<title>Admin Dashboard</title>
<style type="text/css">
    .admin-dashboard{
      font-weight: 500;
      font-size: 25px !important;
    }
    .admin-menu{
      margin-top: 10% !important;
    }
    p{
      font-weight: bold;
    }
    .admin-footer{
      margin-top: 18.5% !important;
    }

  </style>
</head>
<body class="blue-grey lighten-5">

 <jsp:include page="header.jsp"/>
 
<div class="container">
  <div class="row admin-menu">
    <div class="col s4  z-depth-3 grey lighten-5 center">
      <a href='<c:url value="/admin/usermanagement"/>'>
        <i class="large mdi-action-account-box "></i>
        <p class="grey-text text-darken-3">User Management</p>
      </a>
    </div>
    <div class="col s4 z-depth-3 grey lighten-5 center">
      <a href="<c:url value="/admin/customermanagement"/>">
        <i class="large mdi-action-account-child"></i>
        <p class="grey-text text-darken-3">Customer Management</p>
      </a>
    </div>
    <div class="col s4 z-depth-3 grey lighten-5 center">
      <a href="#">
        <i class="large mdi-action-bookmark"></i>
        <p class="grey-text text-darken-3">About</p>
      </a>
    </div>
  </div>
</div>

<jsp:include page="footer.jsp"/>

  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="<c:url value="/resources/js/materialize.js" />"></script>
  <script src="<c:url value="/resources/js/init.js" />"></script>


  </body>
</html>
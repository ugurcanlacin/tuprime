<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="UTF-8">
    <title>TuPrime </title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.4 -->
    <link rel="stylesheet" href="<c:url value="/admin-lte/bootstrap/css/bootstrap.min.css" />">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="<c:url value="/admin-lte/dist/css/AdminLTE.min.css" />">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="<c:url value="/admin-lte/dist/css/skins/_all-skins.min.css" />">
    

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <!-- ADD THE CLASS layout-top-nav TO REMOVE THE SIDEBAR. -->
  <body class="skin-blue layout-top-nav">
    <div class="wrapper">

   	  <jsp:include page="../common/header.jsp"/>
      
      <!-- Full Width Column -->
      <div class="content-wrapper">
        <div class="container">
          <!-- Content Header (Page header) -->
          <section class="content-header">
            <h1>
              Yetki Güncelle
            </h1>
            <ol class="breadcrumb">
              <li><a href="<c:url value="/admin/dashboard"/>"><i class="fa fa-dashboard"></i> Anasayfa</a></li>
              <li><a href="<c:url value="/admin/usermanagement"/>">Kullanıcı Yönetimi</a></li>
              <li><a href="<c:url value="/admin/usermanagement/editrole/${userForm.id}"/>">Yetki Güncelle</a></li>
            </ol>
          </section>
          	<p>
          	  <a class="btn btn-default" href="<c:url value="/admin/usermanagement"/>">Kullanıcı Listesi</a>
              <a class="btn btn-default" href="<c:url value="/admin/usermanagement/adduser"/>">Kullanıcı Ekle</a>
              <a class="btn bg-olive margin" href="<c:url value="/admin/usermanagement/role"/>">Yetkileri Yönet</a>
            </p>
		  <!-- Main content -->
	        <section class="content">
	          <div class="row">
	           <div class="box box-info">
                <div class="box-header with-border">
                  <h3 class="box-title">Kullanıcı Bilgileri</h3>
                </div><!-- /.box-header -->
                <!-- form start -->
                <form:form class="form-horizontal" action="../editrole" method="post" commandName="userForm">
                  <div class="box-body">
                    <div class="form-group">
	                    <label for="id" class="col-sm-2 control-label">Id</label>
	                    <div class="col-sm-4">
	   						<form:input disabled="true" path="id" id="id"  class="form-control" required="required" maxlength="64" value="${userForm.id}"/>
	                    </div>
                    	<label for="username" class="col-sm-2 control-label">Kullanıcı Adı</label>
	                    <div class="col-sm-4">
	   						<form:input disabled="true" path="username" id="username"  class="form-control" required="required" maxlength="64" value="${userForm.username}"/>
	                    </div>
                    </div>
                    <div class="form-group">
                    	<label for=email class="col-sm-2 control-label">Email</label>
	                    <div class="col-sm-4">
	   						<form:input disabled="true" path="email" id="email"  class="form-control" required="required" maxlength="64" value="${userForm.email}"/>
	                    </div>
                    </div>
                    <div class="form-group">
                      <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                          <c:forEach items="${roles}" var="role">
		                  		<input type="checkbox" name="roleArray" id="${role.role}" value="${role}" <c:if test='${  fn:contains( usersroleList,role.role) }'>checked="checked"</c:if> />
		                  		<label for="${role.role}">${role.role}</label>
		                  		<br>
		                  </c:forEach>
                        </div>
                      </div>
                    </div>
                  </div><!-- /.box-body -->
                  <form:hidden path="id" value="${userForm.id}"/>
                  <div class="box-footer">
                    <a type="submit" class="btn btn-default" href="<c:url value="/admin/usermanagement"/>">İptal</a>
                    <button type="submit" class="btn btn-info pull-right">Güncelle</button>
                  </div><!-- /.box-footer -->
                </form:form>
              </div>
	          </div><!-- /.row -->
	        </section><!-- /.content -->
	      </div><!-- /.content-wrapper -->
          <!-- Main content end -->
        </div><!-- /.container -->
      </div><!-- /.content-wrapper -->
      <jsp:include page="../common/footer.jsp"/>
    </div><!-- ./wrapper -->

    <!-- jQuery 2.1.4 -->
    <script src='<c:url value="/admin-lte/plugins/jQuery/jQuery-2.1.4.min.js"/>'></script>
    <!-- Bootstrap 3.3.4 -->
    <script src='<c:url value="/admin-lte/bootstrap/js/bootstrap.min.js"/>'></script>
    <!-- SlimScroll -->
    <script src='<c:url value="/admin-lte/plugins/slimScroll/jquery.slimscroll.min.js"/>'></script>
    <!-- FastClick -->
    <script src='<c:url value="/admin-lte/plugins/fastclick/fastclick.min.js"/>'></script>
    <!-- AdminLTE App -->
    <script src='<c:url value="/admin-lte/dist/js/app.min.js"/>'></script>
    <!-- AdminLTE for demo purposes -->
    <script src='<c:url value="/admin-lte/dist/js/demo.js"/>'></script>
    
  </body>
</html>

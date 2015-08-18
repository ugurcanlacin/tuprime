<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="UTF-8">
    <title>TuPrime | Anasayfa</title>
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
    <!-- DATA TABLES -->
    <link href="<c:url value="/admin-lte/plugins/datatables/dataTables.bootstrap.css" />" rel="stylesheet" type="text/css" />
    
    

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
              Müşteri Yönetimi
            </h1>
            <ol class="breadcrumb">
              <li><a href="<c:url value="/admin/dashboard"/>"><i class="fa fa-dashboard"></i> Anasayfa</a></li>
              <li><a href="<c:url value="/admin/customermanagement"/>">Müşteri Yönetimi</a></li>
            </ol>
          </section>
		  <!-- Main content -->
	        <section class="content">
	          <div class="row">
	            <div class="col-xs-12">
	   
	              <div class="box">
	                <div class="box-header">
	                  <h3 class="box-title">İşlem yapmak için müşteri seçiniz.</h3>
	                </div><!-- /.box-header -->
	                <div class="box-body">
	                  <table id="example1" class="table table-bordered table-striped">
	                    <thead>
	                      <tr>
		                      <th data-field="id">Id</th>
				              <th data-field="username">Kullanıcı Adı</th>
				              <th data-field="name">İsim</th>
				              <th data-field="surname">Soyisim</th>
				              <th data-field="email">Email</th>
				              <th>İşlemler</th>
	                      </tr>
	                    </thead>
	                    <tbody>
		                    <c:forEach items="${users}" var="user">
							    <tr>
							        <td>${user.id}</td>
							        <td>${user.username}</td>
							        <td>${user.name}</td>
							        <td>${user.surname}</td>
							        <td>${user.email}</td>
							        <td> <!-- Actions for the individual item -->
							            <a class ="btn btn-success" href="<c:url value="/admin/customermanagement/select/${user.id}" />">Seç</a>
							        </td>
							    </tr>
							</c:forEach>
	                    </tbody>
	                    <tfoot>
	                      <tr>
		                      <th data-field="id">Id</th>
				              <th data-field="username">Kullanıcı Adı</th>
				              <th data-field="name">İsim</th>
				              <th data-field="surname">Soyisim</th>
				              <th data-field="email">Email</th>
				              <th>İşlemler</th>
	                      </tr>
	                    </tfoot>
	                  </table>
	                </div><!-- /.box-body -->
	              </div><!-- /.box -->
	            </div><!-- /.col -->
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
    <!-- DATA TABES SCRIPT -->
    <script src="<c:url value="/admin-lte/plugins/datatables/jquery.dataTables.min.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/admin-lte/plugins/datatables/dataTables.bootstrap.min.js"/>" type="text/javascript"></script>
    <!-- page script -->
    <script type="text/javascript">
      $(function () {
        $("#example1").DataTable();
      });
    </script>
    
  </body>
</html>

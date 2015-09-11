<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>TuPrime | Anasayfa</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.4 -->
<link rel="stylesheet"
	href="<c:url value="/admin-lte/bootstrap/css/bootstrap.min.css" />">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="<c:url value="/admin-lte/dist/css/AdminLTE.min.css" />">
<!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="<c:url value="/admin-lte/dist/css/skins/_all-skins.min.css" />">


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

		<jsp:include page="../common/header.jsp" />

		<!-- Full Width Column -->
		<div class="content-wrapper">
			<div class="container">
				<!-- Content Header (Page header) -->
				<section class="content-header">
				<h1>Müşteri Yönetimi</h1>
				<ol class="breadcrumb">
					<li><a href="<c:url value="/admin/dashboard"/>"><i
							class="fa fa-dashboard"></i> Anasayfa</a></li>
					<li><a href="<c:url value="/admin/customermanagement"/>">Müşteri
							Yönetimi</a></li>
				</ol>
				</section>
				<!-- Main content -->
				<section class="content">
				<div class="row">
					<div class="nav-tabs-custom">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#tab_1" data-toggle="tab">Diyet</a></li>
							<li><a href="#tab_2" data-toggle="tab">Çalışma Planı</a></li>
							<li><a href="#tab_3" data-toggle="tab">Kişisel Detaylar</a></li>

						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="tab_1">

								<p>
									<a class="btn bg-olive margin" href="#">Diyet Ekle</a>
								</p>

								<!-- Main content -->
								<section class="content">
								<div class="row">
									<div class="col-xs-12">
										<div class="box">
											<div class="box-header">
												<h3 class="box-title">Diyet Yönetim</h3>
											</div>
											<!-- /.box-header -->
											<div class="box-body">
												<table id="example1"
													class="table table-bordered table-striped">
													<thead>
														<tr>
															<th data-field="id">Id</th>
															<th data-field="diet">Diyet</th>
															<th data-field="timestamp">Tarih</th>
															<th>İşlemler</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${userDiet}" var="userdiet">
															<tr>
																<td>${userdiet.diet.id}</td>
																<td>${userdiet.diet}</td>
																<td>${userdiet.diet.timestamp}</td>
																<td>
																	<!-- Actions for the individual item --> <a
																	class="btn btn-success"
																	href="<c:url value="#" />">Seç</a>
																</td>
															</tr>
														</c:forEach>
													</tbody>
													<tfoot>
														<tr>
															<th data-field="id">Id</th>
															<th data-field="diet">Diyet</th>
															<th data-field="timestamp">Tarih</th>
															<th>İşlemler</th>
														</tr>
													</tfoot>
												</table>
											</div>
											<!-- /.box-body -->
										</div>
										<!-- /.box -->
									</div>
									<!-- /.col -->
								</div>
								<!-- /.row --> </section>
								<!-- /.content -->
							</div>
							<!-- /.tab-pane -->
							<div class="tab-pane" id="tab_2">The European languages are
								members of the same family. Their separate existence is a myth.
								For science, music, sport, etc, Europe uses the same vocabulary.
								The languages only differ in their grammar, their pronunciation
								and their most common words. Everyone realizes why a new common
								language would be desirable: one could refuse to pay expensive
								translators. To achieve this, it would be necessary to have
								uniform grammar, pronunciation and more common words. If several
								languages coalesce, the grammar of the resulting language is
								more simple and regular than that of the individual languages.</div>
							<!-- /.tab-pane -->
							<div class="tab-pane" id="tab_3">Lorem Ipsum is simply
								dummy text of the printing and typesetting industry. Lorem Ipsum
								has been the industry's standard dummy text ever since the
								1500s, when an unknown printer took a galley of type and
								scrambled it to make a type specimen book. It has survived not
								only five centuries, but also the leap into electronic
								typesetting, remaining essentially unchanged. It was popularised
								in the 1960s with the release of Letraset sheets containing
								Lorem Ipsum passages, and more recently with desktop publishing
								software like Aldus PageMaker including versions of Lorem Ipsum.
							</div>
							<!-- /.tab-pane -->
						</div>
						<!-- /.tab-content -->
					</div>
					<!-- nav-tabs-custom -->


				</div>
				<!-- /.row --> </section>
				<!-- /.content -->
			</div>
			<!-- /.content-wrapper -->
			<!-- Main content end -->
		</div>
		<!-- /.container -->
	</div>
	<!-- /.content-wrapper -->
	<jsp:include page="../common/footer.jsp" />
	</div>
	<!-- ./wrapper -->

	<!-- jQuery 2.1.4 -->
	<script
		src='<c:url value="/admin-lte/plugins/jQuery/jQuery-2.1.4.min.js"/>'></script>
	<!-- Bootstrap 3.3.4 -->
	<script src='<c:url value="/admin-lte/bootstrap/js/bootstrap.min.js"/>'></script>
	<!-- SlimScroll -->
	<script
		src='<c:url value="/admin-lte/plugins/slimScroll/jquery.slimscroll.min.js"/>'></script>
	<!-- FastClick -->
	<script
		src='<c:url value="/admin-lte/plugins/fastclick/fastclick.min.js"/>'></script>
	<!-- AdminLTE App -->
	<script src='<c:url value="/admin-lte/dist/js/app.min.js"/>'></script>
	<!-- AdminLTE for demo purposes -->
	<script src='<c:url value="/admin-lte/dist/js/demo.js"/>'></script>
</body>
</html>

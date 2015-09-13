<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="main-header">
	<nav class="navbar navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<a href="<c:url value="/admin/dashboard"/>" class="navbar-brand"><b>Tu</b>Prime</a>
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar-collapse">
					<i class="fa fa-bars"></i>
				</button>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse pull-left" id="navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a aria-expanded="false" href="#"
						class="dropdown-toggle" data-toggle="dropdown">Kullanıcı
							Yönetimi <span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="<c:url value="/admin/usermanagement"/>">Kullanıcı
									Listesi</a></li>
							<li><a href="<c:url value="/admin/usermanagement/adduser"/>">Kullanıcı
									Ekle</a></li>
							<li><a href="<c:url value="/admin/usermanagement/role"/>">Yetkileri
									Yönet</a></li>
						</ul></li>
					<li><a href="<c:url value="/admin/customermanagement"/>">Müşteri
							Yönetimi </a></li>
					<li><a href="#">İstatistik</a></li>
					<li><a href="#">Tanımlamalar</a></li>
				</ul>

			</div>
			<!-- /.navbar-collapse -->
			<!-- Navbar Right Menu -->
			<div class="navbar-custom-menu">
				<ul class="nav navbar-nav">
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" id="navbar-search-input"
								placeholder="Search">
						</div>
					</form>
				</ul>
			</div>
			<!-- /.navbar-custom-menu -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</header>
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

      <header class="main-header">
        <nav class="navbar navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <a href="<c:url value="/admin/dashboard"/>"  class="navbar-brand"><b>Tu</b>Prime</a>
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                <i class="fa fa-bars"></i>
              </button>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
              <ul class="nav navbar-nav">
                <li><a href="#">Kullanıcı Yönetimi</a></li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Müşteri Yönetimi <span class="caret"></span></a>
                  <ul class="dropdown-menu" role="menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Separated link</a></li>
                    <li class="divider"></li>
                    <li><a href="#">One more separated link</a></li>
                  </ul>
                </li>
                <li><a href="#">İstatistik</a></li>
                <li><a href="#">Tanımlamalar</a></li>    
              </ul>
             
            </div><!-- /.navbar-collapse -->
            <!-- Navbar Right Menu -->
              <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                   <form class="navbar-form navbar-left" role="search">
                      <div class="form-group">
                        <input type="text" class="form-control" id="navbar-search-input" placeholder="Search">
                      </div>
                   </form>
                </ul>
              </div><!-- /.navbar-custom-menu -->
          </div><!-- /.container-fluid -->
        </nav>
      </header>
      <!-- Full Width Column -->
      <div class="content-wrapper">
        <div class="container">
          <!-- Content Header (Page header) -->
          <section class="content-header">
            <h1>
              Anasayfa
            </h1>
            <ol class="breadcrumb">
              <li><a href="#"><i class="fa fa-dashboard"></i> Anasayfa</a></li>
            </ol>
          </section>

          <!-- Main content -->
          <section class="content">
            <div class="row">
              
                <div class="box box-solid">
                  <div class="box-header with-border">
                    <h3 class="box-title"> </h3>
                  </div><!-- /.box-header -->
                  <div class="box-body">
                    <div class="col-md-3">
                      <div class="small-box bg-aqua">
                        <div class="inner">
                          <br>
                          <p>Kullanıcı Yönetimi</p>
                          <br>
                        </div>
                        <div class="icon">
                          <i class="ion ion-person-add"></i>
                        </div>
                        <a href="<c:url value="/admin/usermanagement"/>" class="small-box-footer"> <i class="fa fa-arrow-circle-right"></i></a>
                      </div>
                    </div>
                    <div class="col-md-3">
                      <div class="small-box bg-yellow">
                        <div class="inner">
                          <br>
                          <p>Müşteri Yönetimi</p>
                          <br>
                        </div>
                        <div class="icon">
                          <i class="ion ion-ios-people"></i>
                        </div>
                        <a href="<c:url value="/admin/customermanagement"/>" class="small-box-footer"> <i class="fa fa-arrow-circle-right"></i></a>
                      </div>             
                    </div>
                    <div class="col-md-3">
                      <div class="small-box bg-green">
                        <div class="inner">
                          <br>
                          <p>İstatistik</p>
                          <br>
                        </div>
                        <div class="icon">
                          <i class="ion ion-stats-bars"></i>
                        </div>
                        <a href="#" class="small-box-footer"> <i class="fa fa-arrow-circle-right"></i></a>
                      </div>
                    </div>
                    <div class="col-md-3">
                    <div class="small-box bg-red">
                        <div class="inner">
                          <br>
                          <p>Tanımlamalar</p>
                          <br>
                        </div>
                        <div class="icon">
                          <i class="ion ion-ios-list"></i>
                        </div>
                        <a href="#" class="small-box-footer"> <i class="fa fa-arrow-circle-right"></i></a>
                      </div>
                    </div>
                  </div><!-- /.box-body -->
                </div>
              

            </div>
          </section><!-- /.content -->
        </div><!-- /.container -->
      </div><!-- /.content-wrapper -->
      <footer class="main-footer">
        <div class="container">
          <div class="pull-right hidden-xs">
            <b>Version</b> 0.0.1
          </div>
          <strong>Copyright &copy; 2015 <a href="http://tuprime.com">TuPrime</a>.</strong> All rights reserved.
        </div><!-- /.container -->
      </footer>
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

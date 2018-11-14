<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ attribute name="name" %>
<%@ attribute name="isAdmin" type="java.lang.Boolean" %>

<% 
if(name == null || name == "") name = "Visitante";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="text/css" href="<c:url value="static/admin/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
        <link type="text/css" href="<c:url value="static/admin/bootstrap/css/bootstrap-responsive.min.css" />" rel="stylesheet">
        <link type="text/css" href="<c:url value="static/admin/css/theme.css" />" rel="stylesheet">
        <link type="text/css" href="<c:url value="static/admin/images/icons/css/font-awesome.css" />" rel="stylesheet">
        <link type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600'
            rel='stylesheet'>
    </head>
    <body>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-inverse-collapse">
                        <i class="icon-reorder shaded"></i></a><a class="brand" href="index.html">Agência ADMIN </a>
                    <div class="nav-collapse collapse navbar-inverse-collapse">
                        <ul class="nav pull-right">
                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown
                                <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Item No. 1</a></li>
                                    <li><a href="#">Don't Click</a></li>
                                    <li class="divider"></li>
                                    <li class="nav-header">Example Header</li>
                                    <li><a href="#">A Separated link</a></li>
                                </ul>
                            </li>
                            <li><a href="#">Support </a></li>
                            <li class="nav-user dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <img src="<c:url value="/static/images/img.jpg" />" class="nav-avatar" />
                                <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                	<li><a>Logado como: <%= name %></a>
                                    <li><a href="#">Perfil</a></li>
                                    <li><a href="#">Editar Perfil</a></li>
                                    <li><a href="#">Configurações</a></li>
                                    <li class="divider"></li>
                                    <li><a href="/AgenciaPortal/logout">Deslogar</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <!-- /.nav-collapse -->
                </div>
            </div>
            <!-- /navbar-inner -->
        </div>
        <!-- /navbar -->
        <div class="wrapper">
            <div class="container">
                <div class="row">
                    <div class="span3">
                        <div class="sidebar">
                            <ul class="widget widget-menu unstyled">
                                <li class="active"><a href="./homeadmin"><i class="menu-icon icon-dashboard"></i>Resumo
                                </a></li>
                                <li><a href="./usersAdm"><i class="menu-icon icon-user"></i>Usuários </a>
                                </li>
                                <li><a href="message.html"><i class="fas fa-umbrella-beach"></i>Inbox <b class="label green pull-right">
                                    11</b> </a></li>
                                <li><a href="task.html"><i class="menu-icon icon-tasks"></i>Tasks <b class="label orange pull-right">
                                    19</b> </a></li>
                            </ul>
                            <!--/.widget-nav-->
                            
                            
                            <ul class="widget widget-menu unstyled">
                                <li><a href="ui-button-icon.html"><i class="menu-icon icon-bold"></i> Buttons </a></li>
                                <li><a href="ui-typography.html"><i class="menu-icon icon-book"></i>Typography </a></li>
                                <li><a href="form.html"><i class="menu-icon icon-paste"></i>Forms </a></li>
                                <li><a href="table.html"><i class="menu-icon icon-table"></i>Tables </a></li>
                                <li><a href="charts.html"><i class="menu-icon icon-bar-chart"></i>Charts </a></li>
                            </ul>
                            <!--/.widget-nav-->
                            <ul class="widget widget-menu unstyled">
                                <li><a class="collapsed" data-toggle="collapse" href="#togglePages"><i class="menu-icon icon-cog">
                                </i><i class="icon-chevron-down pull-right"></i><i class="icon-chevron-up pull-right">
                                </i>More Pages </a>
                                    <ul id="togglePages" class="collapse unstyled">
                                        <li><a href="other-login.html"><i class="icon-inbox"></i>Login </a></li>
                                        <li><a href="other-user-profile.html"><i class="icon-inbox"></i>Profile </a></li>
                                        <li><a href="other-user-listing.html"><i class="icon-inbox"></i>All Users </a></li>
                                    </ul>
                                </li>
                                <li><a href="/AgenciaPortal/logout"><i class="menu-icon icon-signout"></i>Deslogar </a></li>
                            </ul>
                        </div>
                        <!--/.sidebar-->
                    </div>
                    <!--/.span3-->
                    <div class="span9">
                        <div class="content">
                        	<jsp:doBody/>
                        </div>
                        <!--/.content-->
                    </div>
                    <!--/.span9-->
                </div>
            </div>
            <!--/.container-->
        </div>
        <!--/.wrapper-->
        <div class="footer">
            <div class="container">
                <b class="copyright">&copy; ©2018 Agência - Portal </b>Todos os direitos reservados.
            </div>
        </div>
        <script src="<c:url value="static/admin/scripts/jquery-1.9.1.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="static/admin/scripts/jquery-ui-1.10.1.custom.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="static/admin/bootstrap/js/bootstrap.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="static/admin/scripts/flot/jquery.flot.js" />" type="text/javascript"></script>
        <script src="<c:url value="static/admin/scripts/flot/jquery.flot.resize.js" />" type="text/javascript"></script>
        <script src="<c:url value="static/admin/scripts/datatables/jquery.dataTables.js" />" type="text/javascript"></script>
        <script src="<c:url value="static/admin/scripts/common.js" />" type="text/javascript"></script>
      
    </body>

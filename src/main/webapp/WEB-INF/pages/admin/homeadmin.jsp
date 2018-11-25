<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<t:admin name="${pageContext.request.userPrincipal.name}" isAdmin="${isAdmin}">
	<div class="btn-controls">
		<div class="btn-box-row row-fluid">
			<a href="./viagensAdm" class="btn-box big span4"><i class=" icon-random"></i><b>${qtdProducts}</b><p class="text-muted">Pacotes Cadastrados</p> </a>
			<a href="./usersAdm" class="btn-box big span4"><i class="icon-group"></i><b>${qtdUsers}</b><p class="text-muted">Usuários Cadastrados</p> </a>
			<a href="./pedidosAdm" class="btn-box big span4"><i class="icon-ok-sign"></i><b>${qtdOrders}</b><p class="text-muted">Pedidos Realizados</p> </a>
		</div>
		<div class="btn-box-row row-fluid">
			<div class="span8">
				<div class="row-fluid">
					<div class="span12">
						<a href="#" class="btn-box small span4"><i
							class="icon-envelope"></i><b>Messages</b> </a><a href="#"
							class="btn-box small span4"><i class="icon-group"></i><b>Clients</b>
						</a><a href="#" class="btn-box small span4"><i
							class="icon-exchange"></i><b>Expenses</b> </a>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12">
						<a href="#" class="btn-box small span4"><i class="icon-save"></i><b>Total
								Sales</b> </a><a href="#" class="btn-box small span4"><i
							class="icon-bullhorn"></i><b>Social Feed</b> </a><a href="#"
							class="btn-box small span4"><i class="icon-sort-down"></i><b>Bounce
								Rate</b> </a>
					</div>
				</div>
			</div>
			<ul class="widget widget-usage unstyled span4">
				<li>
					<p>
						<strong>Usuários</strong> <span class="pull-right small muted">${qtdUsers}%</span>
					</p>
					<div class="progress tight">
						<div class="bar" style="width: ${qtdUsers}%;"></div>
					</div>
				</li>
				<li>
					<p>
						<strong>Produtos</strong> <span class="pull-right small muted">${qtdProducts}%</span>
					</p>
					<div class="progress tight">
						<div class="bar bar-success" style="width: ${qtdProducts}%;"></div>
					</div>
				</li>
				<li>
					<p>
						<strong>Pedidos</strong> <span class="pull-right small muted">${qtdOrders}%</span>
					</p>
					<div class="progress tight">
						<div class="bar bar-warning" style="width: ${qtdOrders}%;"></div>
					</div>
				</li>
			</ul>
		</div>
	</div>
</t:admin>
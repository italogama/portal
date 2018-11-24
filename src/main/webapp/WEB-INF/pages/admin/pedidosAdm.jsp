<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<t:admin name="${pageContext.request.userPrincipal.name}" isAdmin="${isAdmin}">
<body>
   <table class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>Usuário</th>
           		<th>Nº Pedido</th>
           		<th>Nome pedido</th>
           		<th>Tipo:</th>
	           	<th>Data Ida</th>
	           	<th>Data Volta</th>
	           	<th>Data pedido</th>
	           	<th>Quantidade pedido</th>
	           	<th>Valor</th>
	           	<th>Excluir</th>
       		</tr>
		</thead>
	<c:forEach items="${listOrder}" var="order">
		<tbody>
			<tr>
				<td>${order.account.userName}</td>
				<td>${order.orderNum}</td>
               	<td>${order.product.name}</td>
               	<td>${order.product.productType.description}</td>
               	<td>
                  <fmt:formatDate value="${order.goDate}" pattern="dd-MM-yyyy"/>
               	</td>
               	<td>
                  <fmt:formatDate value="${order.backDate}" pattern="dd-MM-yyyy"/>
               	</td>
               	<td>
                  <fmt:formatDate value="${order.orderDate}" pattern="dd/MM/yyyy"/>
               	</td>
               	<td>${order.quantity}</td>
               	<td style="color:red;">
                  <fmt:formatNumber value="${order.amount}" type="currency"/>
               	</td>
               	<td><a class="btn btn-danger" href="pedidosAdm/${order.id}">Excluir</a></td>
			</tr>
		</tbody>
	</c:forEach>
	</table>
</t:admin>
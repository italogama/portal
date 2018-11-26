<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<t:admin name="${pageContext.request.userPrincipal.name}" isAdmin="${isAdmin}">
   <table class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th># Código</th>
				<th>Nome</th>
				<th>Preço</th>
				<th>Quantidade</th>
				<th>Tipo</th>
				<th>Editar</th>
				<th>Excluir</th>
			</tr>
		</thead>
	<c:forEach items="${list}" var="prodInfo">
		<tbody>
			<tr>
				<td>${prodInfo.code}</td>
				<td>${prodInfo.name}</td>
				<td>${prodInfo.price}</td>
				<td>${prodInfo.quantity}</td>
				<td>${prodInfo.productType.alias}</td>
				<td><a class="btn btn-warning" href="${prodInfo.code}">Editar</a></td>
				<td><a class="btn btn-danger" href="viagensAdm/${prodInfo.code}">Excluir</a></td>
			</tr>
		</tbody>
	</c:forEach>
	</table>
	<br>
	<div>
		<a class="btn btn-primary icon-plus" href="../admin/novoProduto"> Novo Produto</a>
		<a class="btn btn-primary icon-plus" href="../admin/novoTipoProduto"> Novo Tipo de Produto</a>
	</div>
</t:admin>
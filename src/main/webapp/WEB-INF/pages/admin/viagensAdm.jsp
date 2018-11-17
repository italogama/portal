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
				<th># Código</th>
				<th>Nome</th>
				<th>Preço</th>
				<th>Quantidade</th>
				<th>Tipo</th>
			</tr>
		</thead>
	<c:forEach items="${list}" var="prodInfo">
		<tbody>
			<tr>
				<td>${prodInfo.code}</td>
				<td>${prodInfo.name}</td>
				<td>${prodInfo.price}</td>
				<td>${prodInfo.quantity}</td>
				<td>${prodInfo.productType.description}</td>
			</tr>
		</tbody>
	</c:forEach>
	</table>
</t:admin>
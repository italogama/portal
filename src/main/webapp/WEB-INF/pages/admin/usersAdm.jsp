<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<t:admin name="${pageContext.request.userPrincipal.name}" isAdmin="${isAdmin}">
	<table class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th># ID</th>
				<th>Ativo</th>
				<th>Usuario</th>
				<th>Senha</th>
			</tr>
		</thead>
	<c:forEach items="${ListUsers}" var="usersInfo">
		<tbody>
			<tr>
				<td>${usersInfo.userId}</td>
				<td>${usersInfo.active}</td>
				<td>${usersInfo.userName}</td>
				<td>${usersInfo.password}</td>
			</tr>
		</tbody>
	</c:forEach>
	</table>
</t:admin>
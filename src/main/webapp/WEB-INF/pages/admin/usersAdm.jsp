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
				<td>Role</td>
				<td>Editar</td>
				<td>Excluir</td>
			</tr>
		</thead>
	<c:forEach items="${ListUsers}" var="usersInfo">
		
		<tbody>
			<tr>
				<td>${usersInfo.userId}</td>
				<td>${usersInfo.active?"SIM":"NÃO"}</td>
				<td>${usersInfo.userName}</td>
				<td>
					<c:forEach items="${usersInfo.roles}" var="rolesInfo">
						${rolesInfo.name}
					</c:forEach>
				</td>
				<td><button type="button" class="btn btn-warning">Editar</button></td>
				<td><a class="btn btn-danger" href="usersAdm/${usersInfo.userId}">Excluir</a></td>
			</tr>
		</tbody>
		
	</c:forEach>
	</table>
	<td><a class="button" href="../admin/novoUsuario">Novo Usuário</a></td>
</t:admin>
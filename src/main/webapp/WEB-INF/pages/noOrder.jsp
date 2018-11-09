<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<t:template name="${pageContext.request.userPrincipal.name}"
	isAdmin="${isAdmin}">
	<html>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-12">
				<div class="col-middle">
					<div class="text-center text-center">
						<h1 class="error-number">404</h1>
						<h3 style="color: red;">Você não realizou nenhum pedido</h3>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
	</html>
</t:template>
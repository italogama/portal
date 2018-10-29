<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<t:template name="${pageContext.request.userPrincipal.name}">
	<html>
		<body>
		   <h2>404</h2>
		   <h3 style="color:red;">Você não realizou nenhum pedido</h3>
		</body>
	</html>
</t:template>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
 <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<t:template name="${pageContext.request.userPrincipal.name}" isAdmin="${isAdmin}">
	<h1>Bem vindo ao nosso sistema!</h1>
</t:template>
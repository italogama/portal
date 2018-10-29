<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<t:template name="${pageContext.request.userPrincipal.name}">
<html>
	<body>
	  <div class="customer-info-container">
	      <h3>Informa��o do Produto:</h3>
	      <form action="${pageContext.request.contextPath}/purchase" method="post">
	      <input type="hidden" name="code" value="${product.code}"/>
	      <ul>
	          <li>Nome: ${product.name}</li>
	          <li>Pre�o: <fmt:formatNumber value="${product.price}" type="currency"/></li>
	          <li>Quantidade:<input type="number" min="1" max="${product.quantity}" value="1" step="1" name="quantity" onfocus="this.blur();"/></li>
	      </ul>
	      <input class="btn btn-success" type="submit" value="Comprar"/>
	      <a type="button" class="btn btn-danger" href="${pageContext.request.contextPath}/productList">Cancelar</a>
	      </form>
	  </div>
	</body>
</html>
</t:template>
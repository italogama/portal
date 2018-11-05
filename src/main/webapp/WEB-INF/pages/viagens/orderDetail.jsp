<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page isELIgnored="false" %>
 <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<t:template name="${pageContext.request.userPrincipal.name}" isAdmin="${isAdmin}">
<html>
	<body>
	   <div class="page-title">Detalhes do Pedido</div>
	   <div class="container">
	       <h3>Obrigado pelo pedido!</h3>
	       O numero do seu pedido é: ${order.orderNum} <br>
	       Nome : ${order.product.name}<br>
	       Preço : ${order.product.price}<br>
	       Quantidade : ${order.quantity}<br>
	       Valor Total : ${order.amount}<br> 
	   </div>
	</body>
</html>
</t:template>
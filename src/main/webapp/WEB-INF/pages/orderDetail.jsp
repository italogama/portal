<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<t:template name="${pageContext.request.userPrincipal.name}" isAdmin="${isAdmin}">
<html>
	<body class="nav-md">
		<div class="container body">
			<div class="main_container">
				<div class="col-md-12">
					<div class="col-middle">
						<div class="text-center text-center">
							<h1 class="error-number">Obrigado pelo pedido!</h1>
							O numero do seu pedido é: ${order.orderNum} <br> Nome :
							${order.product.name}<br> Preço : ${order.product.price}<br>
							Quantidade : ${order.quantity}<br> Valor Total :
							${order.amount}<br>
							<a type="button" class="btn btn-info" href="${pageContext.request.contextPath}/ultimasViagens">Voltar</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
</t:template>
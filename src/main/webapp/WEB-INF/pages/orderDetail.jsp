<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page isELIgnored="false" %>
 <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<t:template>
	<body>
	   <div class="page-title">Order Details</div>
	   <div class="container">
	       <h3>Thank you for Order</h3>
	       Your order number is: ${order.orderNum} <br>
	       Name : ${order.product.name}<br>
	       Price : ${order.product.price}<br>
	       Quantity : ${order.quantity}<br>
	       Total Amount : ${order.amount}<br> 
	   </div>
	</body>
</t:template>
</html>
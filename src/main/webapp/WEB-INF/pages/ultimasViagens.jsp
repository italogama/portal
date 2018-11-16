<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
 <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<t:template name="${pageContext.request.userPrincipal.name}" isAdmin="${isAdmin}">
   <table border="1" style="width:100%" class="table table-bordered">
   	   <thead>
        <tr>
           <th>Nº Pedido</th>
           <th>Nome pedido</th>
           <th>Tipo:</th>
           <th>Data Ida</th>
           <th>Data Volta</th>
           <th>Preço pedido</th>
           <th>Data pedido</th>
           <th>Quantidade pedido</th>
           <th>Valor</th>
       	</tr>
       </thead>
       <c:forEach items="${list}" var="order">
           <tr>
               <td>${order.orderNum}</td>
               <td>${order.product.name}</td>
               <td>${order.product.productType.id}</td>
               <td>
                  <fmt:formatDate value="${order.goDate}" pattern="dd-MM-yyyy"/>
               </td>
               <td>
                  <fmt:formatDate value="${order.backDate}" pattern="dd-MM-yyyy"/>
               </td>
               <td> <fmt:formatNumber value="${order.product.price}" type="currency"/></td>
               <td>
                  <fmt:formatDate value="${order.orderDate}" pattern="dd/MM/yyyy"/>
               </td>
               <td>${order.quantity}</td>
               <td style="color:red;">
                  <fmt:formatNumber value="${order.amount}" type="currency"/>
               </td>
           </tr>
       </c:forEach>
   </table>
</t:template>
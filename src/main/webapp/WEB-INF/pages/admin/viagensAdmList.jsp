<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<body>
 	<h1>${productType.description}</h1>
 	<h1>teste</h1>
   <c:forEach items="${produtosList}" var="prodInfo">
       <div class="product-preview-container">
           <ul>
         
               <li>Nome: ${prodInfo.name}</li>
               <li>Preço: <fmt:formatNumber value="${prodInfo.price}" type="currency"/></li>
               <li><a
                   href="${pageContext.request.contextPath}/buyProduct?code=${prodInfo.code}">
                       Comprar</a></li>   
           </ul>
       </div>
 
   </c:forEach>
   <br/>
  
 
   <%-- <c:if test="${paginationProducts.totalPages > 1}">
       <div class="page-navigator">
          <c:forEach items="${paginationProducts.navigationPages}" var = "page">
              <c:if test="${page != -1 }">
                <a href="productList?page=${page}" class="nav-item">${page}</a>
              </c:if>
              <c:if test="${page == -1 }">
                <span class="nav-item"> ... </span>
              </c:if>
          </c:forEach>
          
       </div>
   </c:if> --%>
 
</body>
</html>

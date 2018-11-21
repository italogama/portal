<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<t:admin name="${pageContext.request.userPrincipal.name}" isAdmin="${isAdmin}">
 	<h1>${productType.description}</h1>
   <c:forEach items="${list}" var="prodInfo">
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
</t:admin>
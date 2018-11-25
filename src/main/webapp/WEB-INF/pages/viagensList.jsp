<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<t:template name="${pageContext.request.userPrincipal.name}" isAdmin="${isAdmin}">
<html>
<body>
<%--  	<h1>${productType.description}</h1> --%>
<%--    <c:forEach items="${list}" var="prodInfo"> --%>
<!--        <div class="product-preview-container"> -->
<!--            <ul> -->
         
<%--                <li>Nome: ${prodInfo.name}</li> --%>
<%--                <li>Preço: <fmt:formatNumber value="${prodInfo.price}" type="currency"/></li> --%>
<!--                <li><a -->
<%--                    href="${pageContext.request.contextPath}/buyProduct?code=${prodInfo.code}"> --%>
<!--                        Comprar</a></li>    -->
<!--            </ul> -->
<!--        </div> -->
 
<%--    </c:forEach> --%>
   <br/>
   <c:forEach items="${list}" var="prodInfo">
   <div class="col-md-3 col-sm-6 col-xs-12">
	   <div class="pricing">
	     <div class="title">
	       <h2>${prodInfo.name}</h2>
	       <h1><fmt:formatNumber value="${prodInfo.price}" type="currency"/></h1>
	       <span>${productType.description}</span>
	     </div>
	     <div class="x_content">
	       <div class="">
	         <div class="pricing_features">
	           <ul class="list-unstyled text-left">
	             <li><i class="fa fa-check text-success"></i>Código do produto: <strong>${prodInfo.code}</strong></li>
	             <li><i class="fa fa-check text-success"></i>Disponível: <strong>${prodInfo.quantity}</strong></li>
	           </ul>
	           <br>
		       <div>
		         <a href="${pageContext.request.contextPath}/buyProduct?code=${prodInfo.code}" class="btn btn-success btn-block" 
		         	role="button">Comprar <span> agora</span></a>
		       </div>
	         </div>
	       </div>
	     </div>
	   </div>
	 </div>
	 </c:forEach>
 
</body>
</html>
</t:template>
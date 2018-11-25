<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<t:template name="${pageContext.request.userPrincipal.name}" isAdmin="${isAdmin}">
<html>
    <body>
        <div class="x_panel">
            <div class="x_title">
                <h2>
                    Informações da compra<small>preencha com atenção!</small>
                </h2>
                <div class="clearfix"></div>
            </div>
            <div class="container body">
            <div class="main_container">
                <div class="col-md-3">
                    <div class="col-center">
                        <div class="">
                            <div>${erro}</div>
                    <c:if test="${not empty erros}">
                        <c:forEach items="${erros}" var="erro">
                            <div style="color:red;">${erro}</div>
                        </c:forEach>
                    </c:if>
                <!-- start form for validation -->
                <form action="${pageContext.request.contextPath}/purchase" method="post">
                <input type="hidden" name="code" value="${product.code}"/>
                <input type="hidden" name="type" value="${product.productType.id}"/>
            
                  <label for="nome">Nome :</label>
                  <input type="text" id="nome" readonly="readonly" class="form-control" name="nome" placeholder="${product.name}" />
                  
                  <label for="tipo">Tipo :</label>
                  <input type="text" id="tipo" readonly="readonly" class="form-control" name="tipo" placeholder="${product.productType.description}" />
                  
                  <label for="preco">Preço :</label>
                  <input id="preco" readonly="readonly" class="form-control" name="preco" placeholder="<fmt:formatNumber value="${product.price}" type="currency"/>"/>
                  
                  <label for="quantidade">Quantidade :</label>
                  <input type="number" id="quantidade" class="form-control" name="quantity" min="1" max="${product.quantity}" value="1" step="1" onfocus="this.blur();" />
                  
                  
                  <label for="nome">Data de Ida :</label>
                  <div class="input-group date">
                    <input type="text" id="goDate" name="goDate" class="form-control">
                        <div class="input-group-addon">
                            <span class="glyphicon glyphicon-th"></span>
                        </div>          
                    </div>
                  
                  <label for="nome">Data de Volta :</label>
                  <div class="input-group date">
                  <input type="text" id="backDate" name="backDate" class="form-control">
                        <div class="input-group-addon">
                            <span class="glyphicon glyphicon-th"></span>
                        </div>          
                    </div>
                  <br>
                  <input class="btn btn-success" type="submit" value="Comprar"/>
                  <button type="button" class="btn btn-danger" onclick="window.history.back()">Cancelar</button>
                  

                </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    
    
        </div>
    </body>
</html>
</t:template>
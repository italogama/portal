<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<t:admin name="${pageContext.request.userPrincipal.name}"
	isAdmin="${isAdmin}">
	<div class="span9">
		<div class="content">

			<div class="module">
				<div class="module-head">
					<h3>Editar produto:</h3>
				</div>
				<div class="module-body">
					<form action="${pageContext.request.contextPath}/admin/editarProduto" method="POST">
						<div class="control-group">
							<label class="control-label" for="basicinput">Código:</label>
							<div class="controls">
								<input name="code" type="text" class="span2" readonly="readonly" required="required" value="${editarProduto.code}">
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="basicinput">Nome:</label>
							<div class="controls">
								<input name="name" type="text" class="span8" required="required" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="basicinput">Preço:</label>
							<div class="controls">
								<input name="price" type="text" required="required" class="span8" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="basicinput">Quantidade:</label>
							<div class="controls">
								<input name="quantity" type="text" required="required" class="span8" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="basicinput">Tipo do Produto:</label>
							<div class="controls">
								<input name="product_type_id" type="text" readonly="readonly" required="required" class="span8" value="${editarProduto.productType.id}" />
							</div>
						</div>


						<div class="control-group">
							<div class="controls">
								<input class="btn btn-default" type="submit" name="submit" value="Concluir" />
                				<input class="btn btn-default" value="Resetar" type="reset" onclick="location.reload()"/>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</t:admin>
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
					<h3>Novo usuario</h3>
				</div>
				<div class="module-body">
					<c:if test="${param.error == 'true'}">
				<div style="color: red; margin: 10px 0px;">

					Login Failed!!!<br /> Reason :
					${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

				</div>
			</c:if>
					<form:form action="${pageContext.request.contextPath}/admin/novoUsuario" method="POST" modelAttribute="account" id="registerForm">
					<form class="form-horizontal row-fluid">
						<div class="control-group">
							<label class="control-label" for="basicinput">Usuario</label>
							<div class="controls">
								<form:input type="text" path="userName" class="span8" required="required"/>
								<span class="help-inline"><form:errors path="userName" cssClass="text-danger" element="div" style="margin-top: -10px; margin-bottom: 10px;" /></span>
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="basicinput">Senha</label>
							<div class="controls">
								<form:input path="password" type="password" class="span8" required="required" />
								<span class="help-inline"><form:errors path="password" cssClass="text-danger" element="div" style="margin-top: -10px; margin-bottom: 10px;"/></span>
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="basicinput">Repete senha</label>
							<div class="controls">
								<form:input path="confirmPassword" type="password" required="required" class="span8" />
								<span class="help-inline"><form:errors path="confirmPassword" cssClass="text-danger" element="div" style="margin-top: -10px; margin-bottom: 10px;"/></span>
							</div>
						</div>

						
						<div class="control-group">
							<label class="control-label" for="basicinput">Role</label>
							<div class="controls">
								<form:select items="${listRole}" path="roles" 
								id="roles" tabindex="1" data-placeholder="Select here.."
								itemLabel="name" itemValue="id" row="3">
								</form:select>
							</div>
						</div>

						<div class="control-group">
							<div class="controls">
								<input class="btn btn-default" type="submit" name="submit" value="Concluir" />
                				<input class="btn btn-default" value="Resetar" type="reset" onclick="location.reload()"/>
							</div>
						</div>
					</form>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</t:admin>
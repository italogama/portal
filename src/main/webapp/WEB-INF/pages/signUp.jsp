<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Gentelella Alela! | </title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/static/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath}/static/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${pageContext.request.contextPath}/static/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="${pageContext.request.contextPath}/static/vendors/animate.css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="${pageContext.request.contextPath}/static/build/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="login">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div id="register" class="animate form login_form">
          <section class="login_content">
          	<c:if test="${param.error == 'true'}">
				<div style="color: red; margin: 10px 0px;">

					Login Failed!!!<br /> Reason :
					${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

				</div>
			</c:if>
            <form:form action="${pageContext.request.contextPath}/signUp" method="POST" modelAttribute="account" id="registerForm">
              <h1>Registre sua conta</h1>
              <div>
                <form:input path="userName" type="text" class="form-control parsley-errors-list filled" placeholder="Usuario" required="required" />
                <form:errors path="userName" cssClass="text-danger" element="div" style="margin-top: -20px;"/>
              </div>
              <div>
                <form:input path="password" type="password" class="form-control parsley-errors-list filled" placeholder="Senha" required="required" />
                <form:errors path="password" cssClass="text-danger" element="div" style="margin-top: -20px;"/>
              </div>
              <div>
                <form:input path="confirmPassword" type="password" class="form-control parsley-errors-list filled" placeholder="Confirme senha" required="required" />
                <form:errors path="confirmPassword" cssClass="text-danger" element="div" style="margin-top: -20px; margin-bottom: 10px;"/>
              </div>
              <div>
                <input class="btn btn-default" type="submit" name="submit" value="Concluir" />
                <input class="btn btn-default" value="Resetar" type="reset" onclick="location.reload()"/>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">Ja é membro?
                  <a href="${pageContext.request.contextPath}/login" class="to_register"> Logar-se </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i> Gentelella Alela!</h1>
                  <p>©2018 All Rights Reserved.</p>
                </div>
              </div>
            </form:form>
          </section>
        </div>
      </div>
    </div>
  </body>
</html>

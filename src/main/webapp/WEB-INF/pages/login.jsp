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

    <title>Agência de Viagens</title>

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
        <div class="animate form login_form">
          <section class="login_content">
          	<c:if test="${param.error == 'true'}">
           		<div style="color: red; margin: 10px 0px;">
               		Login Failed!!!<br /> Reason :
               		${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
           		</div>
      		</c:if>
            <form method="POST" action="${pageContext.request.contextPath}/j_spring_security_check">
              <h1>Área de Login</h1>
              <div>
                <input type='text' name="userName" class="form-control" value=''>
              </div>
              <div>
                <input type='password' name="password" class="form-control"/>
              </div>
              <div>
                <input class="btn btn-default submit" name="submit" type="submit" value="Login" />
                <a class="reset_pass" href="#">Esqueceu sua senha?</a>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">Novo por aqui?
                  <a href="#signup" class="to_register"> Registrar-se </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-plane"></i> Agência de Viagens</h1>
                  <p>©2018 All Rights Reserved.</p>
                </div>
              </div>
            </form>
          </section>
        </div>
		
		
		<c:if test="${param.error == 'true'}">
           <div style="color: red; margin: 10px 0px;">
 
               Login Failed!!!<br /> Reason :
               ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
 
           </div>
       </c:if>
        <div id="register" class="animate form registration_form">
          <section class="login_content">
            <form:form action="${pageContext.request.contextPath}/signUp" method="POST" modelAttribute="account">
              <h1>Registre sua conta</h1>
              <div>
                <a style="color:red;"><form:errors path="userName"></form:errors></a>
                <input type="text" class="form-control" path="userName" placeholder="Usuario" required="true" />
              </div>
              <div>
                <a style="color:red;"><form:errors path="password"></form:errors></a>
                <input type="password" class="form-control" path="password" placeholder="Senha" required="true" />
              </div>
              <div>
                <input type="password" class="form-control" path="confirmPassword" placeholder="Repita a senha" required="true" />
                <a style="color:red;"><form:errors path="confirmPassword"></form:errors></a>
              </div>
              <div>
              	<a>&nbsp;</a>
               <!-- <a class="btn btn-default submit" type="submit" value="Sign Up">Enviar</a> -->
                <td><input type="submit" value="Sign Up" />
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">Ja possui registro?
                  <a href="#signin" class="to_register"> Logar-se </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-plane"></i> Agência de Viagens</h1>
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

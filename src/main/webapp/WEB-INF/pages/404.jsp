<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="en">
<t:template name="${pageContext.request.userPrincipal.name}">
  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <!-- page content -->
        <div class="col-md-12">
          <div class="col-middle">
            <div class="text-center text-center">
              <h1 class="error-number">404</h1>
              <h2>Desculpe, mas n�o conseguimos encontrar esta p�gina</h2>
              <p>Esta p�gina que voc� est� procurando n�o existe
              </p>
            </div>
          </div>
        </div>
        <!-- /page content -->
      </div>
    </div>
  </body>
</t:template>
</html>

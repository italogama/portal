<%@tag description="Template que é utilizado na tela de login" pageEncoding="UTF-8"%>

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
    <link href="/agencia/static/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/agencia/static/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/agencia/static/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="/agencia/static/vendors/animate.css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="/agencia/static/build/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="login">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
            <form name='f' action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'>
              <h1>Área de Login</h1>
              <div>
                <input type='text' name='username' class="form-control" value=''>
              </div>
              <div>
                <input type='password' name='password' class="form-control"/>
              </div>
              <div>
                <input class="btn btn-default submit" name="submit" type="submit" value="Logar" />
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

        <div id="register" class="animate form registration_form">
          <section class="login_content">
            <form>
              <h1>Registre sua conta</h1>
              <div>
                <input type="text" class="form-control" placeholder="Usuario" required="true" />
              </div>
              <div>
                <input type="email" class="form-control" placeholder="Email" required="true" />
              </div>
              <div>
                <input type="password" class="form-control" placeholder="Senha" required="true" />
              </div>
              <div>
                <a class="btn btn-default submit" href="">Enviar</a>
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
            </form>
          </section>
        </div>
      </div>
    </div>
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../assets/ico/favicon.png">

    <title>JJL Project - Register</title>

    <!-- Bootstrap core CSS -->
    <link href="../dist/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
      <script src="../assets/js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
<div class="navbar-wrapper">
      <div class="container">

        <div class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">JJL Project</a>
            </div>
            
            
          </div>
        </div>

      </div>
    </div>


<div class="container">

      <div class="page-header">
        <h1>새로 오신 것을 환영합니다.</h1>
        <p class="lead">지금 가입하셔서 JJL 프로젝트의 다양한 서비스를 무료로 체험할 수 있는 기회를 만나보세요!</p>
      </div>
      
      <div class="alert alert-info">
        <strong>아래 필수 정보를 입력하고 Sign in 버튼을 누르시면 가입이 완료됩니다!</strong>
      </div>
      
      
      
  </div> <!-- /container -->
  
  
  
  
    <div class="container">

      <form class="form-signin" action="add" method="post">
        <h2 class="form-signin-heading" align="center"> </h2>
        이메일 <input type="text" class="form-control" name="email" >
        이름 <input type="text" class="form-control" name="mname" >
        비밀번호 <input type="password" class="form-control" name="password" >
        전화번호 <input type="text" class="form-control" name="tel" >
        블로그 <input type="text" class="form-control" name="blog" >
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit" value="Add">Sign in </button>
      </form>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->

    
  </body>
</html>
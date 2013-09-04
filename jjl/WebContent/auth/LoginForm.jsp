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

    <title>JJL Project</title>

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

    <form class="form-signin" action="login" method="post">
        <h2 class="form-signin-heading" align="center"><br><br>Welcome! </h2>
        
		<%
		    Cookie cookie = null;
		   	Cookie[] cookies = null;
		   	Boolean aa = false;
		   	cookies = request.getCookies();
		   	if( cookies != null ){
		        
		        for (int i = 0; i < cookies.length; i++){
		           cookie = cookies[i];
		           if(cookie.getValue().equals("on")){
			       aa = true;
		           }
		        }   
		   	}  
		    
		   	if(aa){
		   		for (int i = 0; i < cookies.length; i++){
			           cookie = cookies[i];
			           if(cookie.getName().equals("email")){
			        	   out.print("<input type=\"text\" class=\"form-control\" name=\"email\" placeholder=\"Email address\" value= \"" + cookie.getValue() + "\">");
					        
			           }
			        }
		    }else{
		    	out.print("<input type=\"text\" class=\"form-control\" name=\"email\" placeholder=\"Email address\" >");
		        
		    }
		   	
		%>
        
        
        <input type="password" class="form-control" name="password" placeholder="Password">
        
        
		<%
		    if(cookies != null){
		   	for (int i = 0; i < cookies.length; i++){
			           cookie = cookies[i];
			           if(cookie.getName().equals("saveId")){
			        	   out.print("<input type=\"checkbox\" name=\"saveId\" checked = \"checked\"> ID 저장 ");
					        
			           }
			        }
		    }else{
		    	out.print("<input type=\"checkbox\" name=\"saveId\" > ID 저장 ");
		        
		    }
		   	
		%>
                
        <button class="btn btn-lg btn-primary btn-block" type="submit" value="Login">Log In </button>
      </form>
<form class="form-signin" action="AddMember.jsp" method="post">
        <button class="btn btn-lg btn-primary btn-block" type="submit" value="Add">Sign in </button>
</form>


</div> <!-- /container -->




    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->

    
  </body>
</html>
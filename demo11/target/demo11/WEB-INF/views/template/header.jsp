<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MJ</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
</head>
<style>

.footer {
    color: #333;
    font-size: 11px;
    text-align: center;
    vertical-align: bottom;
    margin-top: 120px;
}

.navbar {
   background-color: transparent;
   background: transparent;
   border-color: transparent; 
}

body {
padding-top:0px;}
</style>
<body>
<div style="height:1500px;">
	<div class="navbar-wrapper">
		<div class="container">

			<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> 
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">MJ </a>
				</div>
				<div  class="navbar-collapse collapse">
					<ul class="nav navbar-nav" >
						<li><a href="<c:url value="/" />">Home</a></li>

						<li><a href="<c:url value="/" />">About</a></li>

						<li><a href="<c:url value="/" />">FindUs</a></li>

						<li><a href="<c:url value="/" />">NewsRoom</a></li>

						<li><a href="<c:url value="/" />">Support</a></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Product<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
								<li><a href="<c:url value="/addProduct" />">AddProduct</a></li>
								</c:if>
								<li><a href="<c:url value="/prodList" />">ViewProduct</a></li>
							</ul></li>


						<c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Category<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="<c:url value="/addCategory" />">AddCategory</a></li>
								<li><a href="<c:url value="/catList" />">ViewCategory</a></li>
								
							</ul>
						</li>
						</c:if>
						
							<c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Supplier<span class="caret"></span></a>
							<ul class="dropdown-menu">
									<li><a href="<c:url value="/addSupplier" />">AddSupplier</a></li>
								<li><a href="<c:url value="/suppList" />">ViewSupplier</a></li>
								
							</ul></li>
							</c:if>
						<%-- <li><a href="<c:url value="/addSupplier" />">AddSupplier</a></li> --%>

					</ul>
					<ul class="nav navbar-nav pull-right">

						<c:if test="${pageContext.request.userPrincipal.name != null}">
							<li><a>Welcome:
									${pageContext.request.userPrincipal.name}</a></li>
							<li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>

							<c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
								<li><a href="<c:url value="/admin" />">Administrator</a></li>
							</c:if>
							<li><a href="<c:url value="/customer/cart" />"><span
								class="glyphicon glyphicon-shopping-cart"></span>Cart</a></li>

						</c:if>

						<c:if test="${pageContext.request.userPrincipal.name == null}">
							<li><a href="<c:url value="/login" />">SignIn</a></li>
							<li><a href="<c:url value="/register" />">register</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			</nav>

		</div>
	</div>
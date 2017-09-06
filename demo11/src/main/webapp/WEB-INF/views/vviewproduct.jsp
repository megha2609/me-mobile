<%@include file="/WEB-INF/views/template/header.jsp"%>
<style>
body {
	background: linear-gradient(to bottom, #ffffcc 1%, #669999 100%);
	padding-top: 80px;
}

.hero-slide {
	margin-top: 45px;
}

footer {
	background: #333;
	color: #eee;
	font-size: 11px;
	padding: 30px;
}

ul.unstyled {
	list-style: none;
	padding: 0;
}
</style>
<body ng-app="cartApp" ng-controller="cartCtrl">
	<div class="container-wrapper">
		<div class="container">
			<div class="page-header">
				<h1>
					<b>Product Details</b>
				</h1>

				<p class="lead">Here is the detail information of the product:</p>
			</div>

			<div class="container">
				<div class="row">
				
					<div class="col-md-6">
						<c:url var="src" value="/resources/images/${product.productId}.jpg"></c:url>
						<img src="${src }" alt="image" style="width: 100%" />
					</div>
					<div class="col-md-1"></div>
					<div class="col-md-5">
						<h3>${product.productName}</h3>
						<p>${product.productDescription}</p>
						<p>
							<strong>Category</strong>: ${product.category.categoryDetails}
						</p>
						<p>Rs ${product.productPrice}</p>
						<%-- <c:if test="${pageContext.request.userPrincipal.name != 'admin'}"> --%>
							<a href="#" class="btn btn-warning btn-lg"
								ng-click="addToCart(${product.productId })"> <span
								class="glyphicon glyphicon-shopping-cart"></span>Add to Cart

							</a>
						<%-- </c:if>  --%>
						<a href="<c:url value="/prodList" />"
							class="btn btn-danger btn-lg">View more Products</a> <br />
					</div>

				</div>

			</div>

		</div>
	</div>

	<br />
	<script src="<c:url value="/resources/js/controller.js"></c:url>"></script>
	<%@include file="/WEB-INF/views/template/footer.jsp"%>
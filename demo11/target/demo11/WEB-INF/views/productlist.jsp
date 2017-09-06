
<%@include file="/WEB-INF/views/template/header.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false"%>
	<div class="container">
	<h3>Product List</h3>
	 <div  class="table-reponsive">
  <!-- <div class="col-sm-12 col-md-12 col-md-offset-1"> -->
	
	 <table class="table table-hover">
		<!-- <table class="table table-bordered table-striped"> -->
			<thead>
				<tr>
					<th></th>
					<th>ProductID</th>
					<th>Product Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Category</th>
					<th>Supplier</th>
				</tr>
			</thead>
			<c:forEach var="pd" items="${productList}">
				<tr>
				<td><img src="<c:url value="/resources/images/${pd.productId}.jpg" />" alt="image"  width="120" height="120"/></td>
					<td>${pd.productId}</td>
					<td>${pd.productName}</td>				
					<td>${pd.productDescription}</td>
					<td>${pd.productPrice}</td>
					<td>${pd.productQuantity}</td>
					<td>${pd.category.categoryDetails}</td>
					<td>${pd.supplier.supplierDetails}</td>
					
					<td>
					<c:url var="url" value="/vviewproduct/${pd.productId }"></c:url>
					<a href="${url }"><span class="glyphicon glyphicon-info-sign"></span></a> 
					</td>
					
					<td>
					<c:url var="delete" value="/deleteproduct/${pd.productId }"></c:url>
					<a href="${delete }"><span class="glyphicon glyphicon-remove"></span></a>
					</td>
					
					<td>
					<c:url var="edit" value="/editform/${pd.productId }"></c:url>
					<a href="${edit }"><span class="glyphicon glyphicon-pencil"></span></a>
				    </td> 
				
				</tr>
			</c:forEach>
		</table>
</div>
</div>
	

<br/>


<%@include file="/WEB-INF/views/template/footer.jsp" %>

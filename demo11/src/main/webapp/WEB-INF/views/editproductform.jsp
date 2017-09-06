<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>




<div class="container">
	<div class="row">
		<div class="form-horizontal">
			<c:url value="/editProduct/${productId }" var="url"></c:url>
			<form:form action="${url }" commandName="product1">

				<div class="form-group">
					<label class="col-md-4 control-label" for="productId">PID</label>
					<div class="col-md-6">
						<form:input path="productId" class="form-control" disabled="true" />
					</div>
				</div>


				<div class="form-group">
					<label class="col-md-4 control-label" for="productName">Product
						Name</label>
					<div class="col-md-6">
						<form:input path="productName" class="form-control" />
						<form:errors path="productName" cssStyle="color:#ff0000"></form:errors>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="productDescription">Description</label>
					<div class="col-md-6">
						<form:input path="productDescription" class="form-control" />
						<form:errors path="productDescription" cssStyle="color:#ff0000"></form:errors>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="productPrice">Price</label>
					<div class="col-md-6">
						<form:input path="productPrice" class="form-control" />
						<form:errors path="productPrice" cssStyle="color:#ff0000"></form:errors>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="productQuantity">Quantity</label>
					<div class="col-md-6">
						<form:input path="productQuantity" class="form-control" />
						<form:errors path="productQuantity" cssStyle="color:#ff0000"></form:errors>
					</div>
				</div>

				<!--  <input type="submit" value="Add Product" class="btn btn-default">-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="singlebutton"></label>
					<div class="col-md-4">
						<button id="submit" name="submit" class="btn btn-primary">Edit
							Product</button>
					</div>
				</div>


			</form:form>
		</div>
	</div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>
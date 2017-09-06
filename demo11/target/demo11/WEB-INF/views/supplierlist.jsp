<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

	<div class="container">
	<h3>Supplier List</h3>
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>SID</th>
					<th>Name</th>
					<th>Address</th>
					<th>Contact No.</th>
					<th>Email</th>
					<th>Brand</th>
					<th>Product</th>
				</tr>
			</thead>
			<c:forEach var="sup" items="${supplierList}">
				<tr>
					<td>${sup.sid}</td>
					<td>${sup.supplierDetails}</td>
					<td>${sup.supaddress}</td>
					<td>${sup.supnumber}</td>
					<td>${sup.supemail}</td>
					<td>${sup.brand}</td>
					<td>${sup.supproduct}</td>		
				</tr>
			</c:forEach>
		</table>

	</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>

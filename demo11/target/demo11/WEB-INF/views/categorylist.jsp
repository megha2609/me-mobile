<%@include file="/WEB-INF/views/template/header.jsp" %>
	<div class="container">
	<h3>Category List</h3>
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>CID</th>
					<th>Category</th>
				</tr>
			</thead>
			<c:forEach var="cg" items="${categoryList}">
				<tr>
					<td>${cg.cid}</td>
					<td>${cg.categoryDetails}</td>
					 							
				</tr>
			</c:forEach>
		</table>

	</div>
	
	<%@include file="/WEB-INF/views/template/footer.jsp" %>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container">
	<div class="row">
		<div class="form-horizontal">
			<form:form action="addSupplierPost" commandName="suppliercommand">

				<div class="form-group">
					<label class="col-md-4 control-label" for="supplierDetails">Supplier
						Name</label>
					<div class="col-md-6">
						<form:input path="supplierDetails" class="form-control" />
						<form:errors path="supplierDetails" cssStyle="color:#ff0000"></form:errors>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="supaddress">Supplier
						Address</label>
					<div class="col-md-6">
						<form:input path="supaddress" class="form-control" />
						<form:errors path="supaddress" cssStyle="color:#ff0000"></form:errors>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="supnumber">Contact
						No.</label>
					<div class="col-md-6">
						<form:input path="supnumber" type="tel" class="form-control" />
						<form:errors path="supnumber" cssStyle="color:#ff0000"></form:errors>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="supemail">Email</label>
					<div class="col-md-6">
						<form:input path="supemail" type="email" class="form-control" />
						<form:errors path="supemail" cssStyle="color:#ff0000"></form:errors>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="supproduct">Product</label>
					<div class="col-md-6">
						<form:input path="supproduct" class="form-control" />
						<form:errors path="supproduct" cssStyle="color:#ff0000"></form:errors>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="brand">Brand</label>
					<div class="col-md-6">
						<form:input path="brand" class="form-control" />
						<form:errors path="brand" cssStyle="color:#ff0000"></form:errors>
					</div>
				</div>



				<div class="form-group">
					<label class="col-md-4 control-label" for="singlebutton"></label>
					<div class="col-md-4">
						<button id="submit" name="submit" class="btn btn-primary">Add
							Supplier</button>
					</div>
				</div>


			</form:form>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>
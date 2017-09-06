<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container">
<div class="row">
<div class="form-horizontal">
<form:form action="addCategoryPost"  commandName="categorycommand" >

<div class="form-group">
<label class="col-md-4 control-label"for="categoryDetails">CategoryDetails</label>
<div class="col-md-6">
<form:input path="categoryDetails" class="form-control"/>
<form:errors path="categoryDetails" cssStyle="color:#ff0000"></form:errors>
</div>
</div>



<!--  <input type="submit" value="Add Product" class="btn btn-default">-->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="submit" name="submit" class="btn btn-primary">Add Category</button>
  </div>
</div>


</form:form>
</div>
</div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>
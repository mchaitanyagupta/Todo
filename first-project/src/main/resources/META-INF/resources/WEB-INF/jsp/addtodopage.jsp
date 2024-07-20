<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">
	<Title>manage your todo</Title>
</head>
<body>
<%@ include file="common/navigation.jsp" %>
<div class="container">
	<h2>Enter your Todo details </h2>
	<form:form method="post" modelAttribute="todo">
	<fieldset class="mb-3">
		<form:label path="description">Description</form:label>
		<form:input type="text" path="description" required="required"/>
		<form:errors path="description" cssClass="text-warning"/>	
	</fieldset>	
	
	<fieldset class="mb-3">
		<form:label path="targetdate">Target Date</form:label>
		<form:input type="text" path="targetdate" required="required"/>
		<form:errors path="targetdate" cssClass="text-warning"/>	
	</fieldset>	
	<form:input type="hidden" path="done"/>
	<form:input type="hidden" path="userid"/>
	
		<input type="submit" class="btn btn-success">
	</form:form>
</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
	$('#targetdate').datepicker({
	    format: 'yyyy-mm-dd'
	});
</script>

</body>
</html>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	<Title>logout page</Title>
</head>
<body>
<%@ include file="common/navigation.jsp" %>
<div class="container">
	<div>
		<h2>confirm logout</h2>
	</div>
	<a href="home" class="btn btn-success">cancel</a>
	<a href="logoutconfirm" class="btn btn-warning">logout</a>
</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
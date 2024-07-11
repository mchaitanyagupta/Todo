<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	<Title>todos page</Title>
</head>
<body>
<%@ include file="common/navigation.jsp" %>
<div class="container">
	<div>
		<h2>your todo list  is </h2>
	</div>
	<table class="table">
		<thead>
			<tr>
				<th>description</th>
				<th>target</th>
				<th>is Done?</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.description}</td>
					<td>${todo.targetdate}</td>
					<td>${todo.done}</td>
					<td><a href="deletetodo?id=${todo.id}" class="btn btn-warning">Delete</a> </td>
					<td> <a href="updatetodo?id=${todo.id}" class="btn btn-success">Update</a> </td>
				</tr>
			</c:forEach>
		</tbody>		
	</table>
	<a href="addtodo" class="btn btn-success">Add Todo</a>
</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>

</body>

</html>
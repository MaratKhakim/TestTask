<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User Management</title>

	<style type="text/css">
		.pg-normal {
			color: black;
			font-weight: normal;
			text-decoration: none;
			cursor: pointer;
		}
		.pg-selected {
			color: black;
			font-weight: bold;
			text-decoration: underline;
			cursor: pointer;
		}
	</style>

	<script type="text/javascript" src="../../resources/js/user.js"></script>

</head>
<body>
<h1>Users Data</h1>
<form:form action="user.do" method="POST" commandName="user">
	<table>
		<tr>
			<td>User ID</td>
			<td><form:input path="id" /></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><form:input path="age" /></td>
		</tr>
		<tr>
			<td>Admin</td>
			<td><form:input path="admin" /></td>
		</tr>
		<tr>
			<td>Date</td>
			<td><form:input path="createDate" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="action" value="Add" />
				<input type="submit" name="action" value="Edit" />
				<input type="submit" name="action" value="Delete" />
				<input type="submit" name="action" value="Search" />
			</td>
		</tr>
	</table>
</form:form>

<c:if test="${!empty listUsers}">

	<form action="" method="get" enctype="application/x-www-form-urlencoded">
		<table id="results" border="1">
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
			<th>Admin</th>
			<th>Date</th>
			<c:forEach items="${listUsers}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.age}</td>
					<td>${user.admin}</td>
					<td>${user.createDate}</td>
				</tr>
			</c:forEach>
		</table>
		<div id="pageNavPosition"></div>
	</form>

	<script type="text/javascript">
		var pager = new Pager('results', 4);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
	</script>
</c:if>


</body>
</html>
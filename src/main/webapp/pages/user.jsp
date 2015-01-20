<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="common.jsp"></jsp:include>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
$(document).ready(function() {
});
</script>
<body>
<table class="table table-hover">
	<c:forEach items="${userList}" var="user">
		<tr>
			<th>Name</th>
			<td>${user.name}</td>
			<th>Code</th>
			<td>${user.code}</td>
			<th>Email</th>
			<td>${user.email}</td>
			<th>Role</th>
			<td>${user.role}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
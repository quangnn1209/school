<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="common.jsp"></jsp:include>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<form action="UserServlet" method="post" class="form-inline">
	<input type="hidden" name="action" value="login"/>
	<table  class="table table-hover">
		<tr>
			<th colspan="2">Sign in form</th>
		</tr>
		<tr>
			<th>Email</th>
			<td> <input type="text" maxlength="50" name="email"/> </td>
		</tr>
		<tr>
			<th>Password</th>
			<td> <input type="password" maxlength="50" name="password"/> </td>
		</tr>
		<tr>
			<td colspan="2"> <button class="btn btn-default">Login</button> </td>
		</tr>
	</table>
</form>

<form action="UserServlet" method="post" class="form-inline">
	<input type="hidden" name="action" value="signup"/>
	<table class="table table-hover">
		<tr>
			<th colspan="4">Sign up form</th>
		</tr>
		<tr>
			<th>Name</th>
			<td> <input type="text" maxlength="50" name="name"/> </td>
			<th>Code</th>
			<td> <input type="text" maxlength="50" name="code"/> </td>
		</tr>
		<tr>
			<th>Email</th>
			<td> <input type="text" maxlength="50" name="email"/> </td>
			<th>Password</th>
			<td> <input type="password" maxlength="50" name="password"/> </td>
		</tr>
		<tr>
			<td colspan="4"> <button class="btn btn-default">Save</button> </td>
		</tr>
	</table>
</form>
</body>
</html>
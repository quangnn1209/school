<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="common.jsp"></jsp:include>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
$(document).ready(function() {
});

function editRow(me){
	var row = $("<div>"+$(me).parents("tr:first").find("div:first").html()+"</div>");
	row.dialog({
		height : 300,
		width : 400,
		modal : true,
		buttons : {
			"Save" : function() {
				$.ajax({
					type : "POST",
					url : "UserServlet?action=update&id=" + row.find("input:hidden").val()+"&name="+row.find("[name=name]").val()+"&code="+row.find("[name=code]").val()+"&email="+row.find("[name=email]").val()+"&role="+row.find("[name=role]").val()
				}).done(function(){
					location.reload();	
				});				
			}
		},
		close : function() {
			$(this).dialog("destroy");
		}
	});
}

function deleteRow(me){
	if(confirm("Do you want to delete this user?")){
		$.ajax({
			type : "POST",
			url : "UserServlet?action=delete&id=" + row.find("input:hidden").val()
		});
		$(me).parents("tr:first").remove();
	}
}
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
			<td><button type="button" onclick="editRow(this)">Edit</button></td>
			<td><button type="button" onclick="deleteRow(this)">Delete</button></td>
			<td>
				<div style="display: none;">
					<input type="hidden" value="${user.id}" name="id"/>
					<div>Name<input type="text" name="name" value="${user.name}"/></div>
					<div>Code<input type="text" name="code" value="${user.code}"/></div>
					<div>Email<input type="text" name="email" value="${user.email}"/></div>
					<div>Role
						<select name="role">
							<option value="0">Student</option>
							<option value="2">Teacher</option>
							<option value="1">Admin</option>
						</select>
					</div>
				</div>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>School</title>
<link rel='stylesheet' href='./css/fullcalendar.css' />
<link rel='stylesheet' href='./css/style.css' />
<link rel='stylesheet' href='./css/bootstrap.css' />
<link rel='stylesheet' href='./css/jquery-ui.css' />

<script type="text/javascript"
	src="./javascript/lib/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="./javascript/lib/jquery-ui.js"></script>
<script type="text/javascript" src="./javascript/lib/moment.min.js"></script>
<script type="text/javascript" src="./javascript/lib/fullcalendar.js"></script>
<script type="text/javascript">
	function openDialog(element, start, end, tsId) {
		element.dialog({
			height : 200,
			width : 400,
			modal : true,
			buttons : {
				"Save" : function() {
					var title = element.find("input:text").val();
					var titleType = element.find("[name=titleType]").val();
					var eventData;
					if (title) {
						eventData = {
							title : title,
							start : start,
							end : end
						};
						$('#calendar').fullCalendar('renderEvent', eventData,
								true);

						$.ajax({
							type : "POST",
							url : "TimetableScheduleServlet?action=add&tsId=" + tsId
									+ "&code=" + title + "&startTime=" + start
									+ "&endTime=" + end + "&titleType="
									+ titleType
						});
					}
					$('#calendar').fullCalendar('unselect');
					$(this).dialog("destroy");
				}
			},
			close : function() {
				$(this).dialog("destroy");
			}
		});
	}
</script>
</head>
<c:if test="${not empty sessionScope.user}">
	<ul class="nav nav-pills" role="tablist">
		<li role="presentation" class="active"><a href="TimetableScheduleServlet">Timetable Schedule${sessionScope.user.role}</a></li>
		<c:if test="${sessionScope.user.role eq 1}">
			<li role="presentation" class="active"><a href="UserServlet">User</a></li>
		</c:if>
	</ul>
</c:if>
</html>
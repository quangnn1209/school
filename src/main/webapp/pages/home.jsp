<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="common.jsp"></jsp:include>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
$(document).ready(function() {
});

function loadItems(items, tsId, me){
	$(me).parents("table:first").find("tr").removeClass("current-row");
	$(me).parents("tr:first").addClass("current-row");
	
	$('#calendar').fullCalendar('destroy');
	$('#calendar').fullCalendar({
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'agendaWeek,agendaDay'
		},
		selectable: true,
		selectHelper: true,
		select: function(start, end) {
			var div = $("<div class='title-dialog'><span><input type='radio' name='titleType' value='1'/>Class<input type='radio' name='titleType' value='0'/>Exam</span><span><input type='text' name='name' size='20' maxlength='50'/></span></div>");
			div.find("input:radio").prop("checked", true);
			div.find("[name=name]").focus();
			openDialog(div, start, end, tsId);
		},
		eventClick: function(calEvent, jsEvent, view) {
			if(confirm("Do you want to remove "+calEvent.title+"?")){
				$.ajax({
					type : "POST",
					url : "TimetableScheduleServlet?action=delete&id=" + calEvent.id
				});
				
				$('#calendar').fullCalendar( 'removeEvents' ,calEvent.id);
			}
	    },
		editable: true,
		eventLimit: true,
		events:items
	});
    
    $("button.fc-agendaWeek-button").trigger("click");
}
</script>

<body>
<table class="table table-hover">
	<c:forEach items="${tsList}" var="ts">
		<script type="text/javascript">
			var items${ts.id} = [];
			<c:forEach items="${ts.classes}" var="cl">
				items${ts.id}.push({id:'class-${cl.id}', title:'${cl.code}', start:'${cl.startTime}', end:'${cl.endTime}'});
			</c:forEach>
			<c:forEach items="${ts.exams}" var="exam">
				items${ts.id}.push({id:'exam-${exam.id}', title:'${exam.code}', start:'${exam.startTime}', end:'${exam.endTime}'});
			</c:forEach>
		</script>
		<tr>
			<th>${ts.code}</th>
			<td><button type="button" class="load-item-btn btn btn-default" onclick="loadItems(items${ts.id}, ${ts.id}, this)">Load this item</button></td>
		</tr>
	</c:forEach>
</table>
<div id="calendar">

</div>
</body>
</html>
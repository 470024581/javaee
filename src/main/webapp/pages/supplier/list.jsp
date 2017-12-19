<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
	<title>test</title>
	<script src="js/jquery1.8.1.js"></script>
	
</head>
<body>
	<table id="table" border="0" cellspacing="1" style="background-color:#a0c6e5">
		<tr>
			<td>编号</td>
			<td>班级</td>
			<td>学生</td>
			<td>科目</td>
		</tr>
		<%-- <c:forEach var="info" items="${classInfo}">
			<tr>
				<br>
					<c:out value="${info.classId}"/>
				</br>
				<br>
					<c:out value="${info.className}"/>
				</br>
				<br>
					<c:out value="${info.studentName}"/>
				</br>
				<br>
					<c:out value="${info.project}"/>
				</br>
			</tr>
		</c:forEach> --%>
	</table>
</body>
<script type="text/javascript">
		var classInfo = [{"classId" : "1", "className" : "A班", "studentName":"小明", "project":"英语"}, {"classId" : "2", "className" : "A班", "studentName":"小明", "project":"英语"}];
		
		for(var i=0;i<classInfo.length;i++){
			var html = "<tr><td>"+classInfo[i].classId+"</td><td>"+classInfo[i].className+"</td><td>"+classInfo[i].studentName+"</td><td>"+classInfo[i].project+"</td></tr>";
			$("#table").append(html);
		}
	</script>
</html>


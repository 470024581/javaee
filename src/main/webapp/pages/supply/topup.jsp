<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>test1</title>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery1.8.1.js"></script> 
	<script type="text/javascript">
	</script>
</head>
<body id="formDiv">
	<h3>topup充值接口</h3>
	<input id="controller" type="hidden" value="apollo">
	<input id="method" type="hidden" value="delivery">
	<form id="dataForm">
		<table>
			<tr>
				<td>
					手机号:
				</td>
				<td>
					<input id="moblie" name="moblie">
				</td>
				<td>
					应用代码:
				</td>
				<td>
					<input id="appCode" name="appCode">
				</td>
			</tr>
			<tr>
				<td>
					业务单号:
				</td>
				<td>
					<input id="bizOrder" name="bizOrder">
				</td>
				<td>
					业务单时间:
				</td>
				<td>
					<input id="bizOrderTime" name="bizOrderTime">
				</td>
			</tr>
			<tr>
				<td>
					供货单号:
				</td>
				<td>
					<input id="supplyCode" name="supplyCode">
				</td>
				<td>
					供货单时间:
				</td>
				<td>
					<input id="supplyTime" name="supplyTime">
				</td>
			</tr>
			<tr>
				<td>
					面值:
				</td>
				<td>
					<input id="facePrice" name="facePrice">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>


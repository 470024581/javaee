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
	<h3>queryPrice询价接口</h3>
	<input id="controller" type="hidden" value="apollo">
	<input id="method" type="hidden" value="delivery">
	<form id="dataForm">
		<table>
			<tr>
				<td>
					商品代码:
				</td>
				<td>
					<input id="mdseCode" name="mdseCode">
				</td>
				<td>
					供应商代码:
				</td>
				<td>
					<input id="supplierCode" name="supplierCode">
				</td>
			</tr>
			<tr>
				<td>
					商品类型:
				</td>
				<td>
					<input id="mdseType" name="mdseType">
				</td>
				<td>
					面值:
				</td>
				<td>
					<input id="facePrice" name="facePrice">
				</td>
			</tr>
			<tr>
				<td>
					省份:
				</td>
				<td>
					<input id="province" name="province">
				</td>
				<td>
					运行商:
				</td>
				<td>
					<input id="operator" name="operator">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>


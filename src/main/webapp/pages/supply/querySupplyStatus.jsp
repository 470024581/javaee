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
	<h3>querySupplyStatus查询供货单状态接口</h3>
	<input id="controller" type="hidden" value="apollo">
	<input id="method" type="hidden" value="querySupplyStatus">
	<form id="dataForm">
		<table>
			<tr>
				<td>
					供货单号:
				</td>
				<td>
					<input id="mdseCode" name="mdseCode">
				</td>
				<td>
					核心订单号:
				</td>
				<td>
					<input id="supplierCode" name="supplierCode">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>


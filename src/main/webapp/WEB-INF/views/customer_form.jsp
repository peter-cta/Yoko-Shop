<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New/Edit Customer</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Customer</h1>
		<form:form action="saveCustomer" method="post" modelAttribute="customer">
			<table cellpadding="5">
				<form:hidden path="id"/>
				<tr>
					<td>Name:</td>
					<td><form:input path="name"/></td>
				</tr>
				
				<tr>
					<td>Email:</td>
					<td><form:input  path="email"/></td>
				</tr>
				
				<tr>
					<td>Phone:</td>
					<td><form:input  path="phone"/></td>
				</tr>
				
				<tr>
					<td>Address:</td>
					<td><form:input path="address"/></td>
				</tr>
				
				
				<tr>
					<td>AccountID:</td>
					<td><form:input path="account_id"/></td>
				</tr>

				
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Save"/></td>
				</tr>
			</table>	
		</form:form>
	</div>
</body>
</html>
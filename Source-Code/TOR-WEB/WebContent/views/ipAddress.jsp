<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>IP Addess Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a IP Address
</h1>

<c:url var="addAction" value="/ipAddress/add" ></c:url>

<form:form action="${addAction}" commandName="ipAddress">
<table>
	<c:if test="${!empty ipAddress.ipAddress}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="ipAddress">
				<spring:message text="ipAddress"/>
			</form:label>
		</td>
		<td>
			<form:input path="ipAddress" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="port">
				<spring:message text="port"/>
			</form:label>
		</td>
		<td>
			<form:input path="port" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty ipAddress.ipAddress}">
				<input type="submit"
					value="<spring:message text="Edit Person"/>" />
			</c:if>
			<c:if test="${empty ipAddress.ipAddress}">
				<input type="submit"
					value="<spring:message text="Add Person"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>IP Address List</h3>
<c:if test="${!empty ipAddress}">
	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="120">IP Address</th>
		<th width="120">Port</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listIpAddressBean}" var="ipAddressBean">
		<tr>${listIpAddressBean}
			<td>${ipAddressBean.ipAddress}</td>
			<td>${ipAddressBean.port}</td>
			<td>${ipAddressBean.isTor}</td>
			<%-- <td><a href="<c:url value='/edit/${person.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${person.id}' />" >Delete</a></td> --%>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
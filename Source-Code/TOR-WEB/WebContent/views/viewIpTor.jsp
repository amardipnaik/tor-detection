<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
table, th , td  {
  border: 1px solid grey;
  border-collapse: collapse;
  padding: 5px;
}
table tr:nth-child(odd) {
  background-color: #f1f1f1;
}
table tr:nth-child(even) {
  background-color: #ffffff;
}
</style>
<body>
<h2>Blocked TOR IP Address</h2>
<table>
<th>Sr.No</th>
<th>Hostname</th>
<th>IP Address</th>
<th>Remarks</th>
<th>Port</th>
<th>Protocol</th>
  <tr ng-repeat="x in resultDataIPTor">
     <td>{{ $index + 1 }}</td>
    <td>{{ x.hostname }}</td>
    <td>{{ x.ipAddress}}</td>
     <td>{{ x.remarks}}</td>
     <td>8080</td>
       <td>TCP</td>
  </tr>
</table>
</body>
</html>
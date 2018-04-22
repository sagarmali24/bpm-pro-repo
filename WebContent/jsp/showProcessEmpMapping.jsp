<%@include file="taglib_includes.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="App.Title"></spring:message> </title>
<script type="text/javascript" src="js/processEmpMapping.js"></script>
</head>
<body style="font-family: Arial; font-size:smaller;">
	<center>
	<form action="searchProcessEmpMapping.do" method="post">		
			<table style="border-collapse: collapse;" border="0" bordercolor="#006699" width="500">
			<tr>
				<td>Enter EMP ID  </td> 
				<td><input type="text" name="emp_id"/>
					&nbsp;&nbsp;<input type="submit" value="Search"/>
					&nbsp;&nbsp;<input type="button" value="New Proces Emp Mapping " onclick="javascript:go('saveProcesEmpMapping.do');"/>
			</td></tr>
		</table>
	</form>
	
	<table style="border-collapse: collapse;" border="1" bordercolor="#006699" width="500">
		<tr bgcolor="lightblue">
			<th>Id</th>
			<th>emp id</th>			
			<th>Proces id</th>	
		
			<th>Action</th>
		</tr>
		<c:if test="${empty SEARCH_PROSESS_EMP_MAPPING_RESULTS_KEY}">
		<tr>
			<td colspan="4">No Results found</td>
		</tr>
		</c:if>
		<c:if test="${! empty SEARCH_PROSESS_EMP_MAPPING_RESULTS_KEY}">
			<c:forEach var="procesEmpMapping" items="${SEARCH_PROSESS_EMP_MAPPING_RESULTS_KEY}">		
		    <tr>
				<td><c:out value="${procesEmpMapping.id}"></c:out></td>
				<td><c:out value="${procesEmpMapping.emp_id}"></c:out></td>
				<td><c:out value="${procesEmpMapping.process_id}"></c:out> </td>
			
				<td>
					&nbsp;<a href="updateProcesEmpMapping.do?id=${procesEmpMapping.id}">Edit</a>
					&nbsp;&nbsp;<a href="javascript:deleteProcesEmpMapping('deleteProcesEmpMapping.do?id=${procesEmpMapping.id}');">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</c:if>				
	</table>	
	</center>
		
</body>
</html>
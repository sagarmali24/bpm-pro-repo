<%@include file="taglib_includes.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="App.Title"></spring:message> </title>
<script type="text/javascript" src="js/prosess.js"></script>
</head>
<body style="font-family: Arial; font-size:smaller;">
	<center>
	<form action="searchProcess.do" method="post">		
			<table style="border-collapse: collapse;" border="0" bordercolor="#006699" width="500">
			<tr>
				<td>Enter Proces Name</td> 
				<td><input type="text" name="name"/>
					&nbsp;&nbsp;<input type="submit" value="Search"/>
					&nbsp;&nbsp;<input type="button" value="New Proces" onclick="javascript:go('saveProces.do');"/>
			</td></tr>
		</table>
	</form>
	
	<table style="border-collapse: collapse;" border="1" bordercolor="#006699" width="500">
		<tr bgcolor="lightblue">
			<th>Id</th>
			<th>Proces Name</th>			
			<th>Proces Desc</th>	
			
			<th></th>
		</tr>
		<c:if test="${empty SEARCH_PROCESS_RESULTS_KEY}">
		<tr>
			<td colspan="4">No Results found</td>
		</tr>
		</c:if>
		<c:if test="${! empty SEARCH_PROCESS_RESULTS_KEY}">
			<c:forEach var="proces" items="${SEARCH_PROCESS_RESULTS_KEY}">		
		    <tr>
				<td><c:out value="${proces.id}"></c:out></td>
				<td><c:out value="${proces.process_name}"></c:out></td>
				<td><c:out value="${proces.process_desc}"></c:out> </td>
			
				<td>
					&nbsp;<a href="updateProces.do?id=${proces.id}">Edit</a>
					&nbsp;&nbsp;<a href="javascript:deleteProces('deleteProces.do?id=${proces.id}');">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</c:if>				
	</table>	
	</center>
		
</body>
</html>
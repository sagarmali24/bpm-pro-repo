<%@include file="taglib_includes.jsp" %>

<html>
<head>
	<script type="text/javascript" src="js/ProcessEmpMapping.js"></script>
	<title><spring:message code="App.Title"></spring:message> </title>
</head>
<body style="font-family: Arial; font-size:smaller;">

<table  bgcolor="lightblue" width="750" height="500" align="center" style="border-collapse: collapse;" border="1" bordercolor="#006699" >
	<tr>
		<td align="center"><h3>Edit ProcessEmp Mapping Form</h3></td>
	</tr>
	<tr valign="top" align="center">
    <td align="center">
 		<form:form action="saveProcesEmpMapping.do" method="post" commandName="newProcesEmpMapping">
	    	
				<table width="500" style="border-collapse: collapse;" border="0" bordercolor="#006699" cellspacing="2" cellpadding="2">	
					<tr>
						<td width="100" align="right">Emp  ID</td>
						<td width="150">
						<form:input path="emp_id"/></td>
						<td align="left">
						<form:errors path="emp_id" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					
		
					<tr>
						<td width="100" align="right">Process id</td>
						<td><form:input path="process_id"/></td>
						<td align="left">
						<form:errors path="process_id" cssStyle="color:red"></form:errors>  </td>
					</tr>
					
					<tr>
						<td colspan="3" align="center">
						<input type="submit" name="" value="Save">
						&nbsp;&nbsp;
						<input type="reset" name="" value="Reset">
						&nbsp;&nbsp;
						<input type="button"  value="Back" onclick="javascript:go('viewAllProcessEmpMapping.do');">
						</td>
					</tr>					
				</table>			
		</form:form>
    </td>    
  </tr>
</table>
</body>
</html>

<%@include file="taglib_includes.jsp" %>

<html>
<head>
	<script type="text/javascript" src="js/Process.js"></script>
	<title><spring:message code="App.Title"></spring:message> </title>
</head>
<body style="font-family: Arial; font-size:smaller;">

<table  bgcolor="lightblue" width="750" height="500" align="center" style="border-collapse: collapse;" border="1" bordercolor="#006699" >
	<tr>
		<td align="center"><h3>Edit Contact Form</h3></td>
	</tr>
	<tr valign="top" align="center">
    <td align="center">
 		<form:form action="saveProces.do" method="post" commandName="newProces">
	    	
				<table width="500" style="border-collapse: collapse;" border="0" bordercolor="#006699" cellspacing="2" cellpadding="2">	
					<tr>
						<td width="100" align="right">Process Name</td>
						<td width="150">
						<form:input path="process_name"/></td>
						<td align="left">
						<form:errors path="process_name" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					
		
					<tr>
						<td width="100" align="right">Process Desc</td>
						<td><form:input path="process_desc"/></td>
						<td align="left">
						<form:errors path="process_desc" cssStyle="color:red"></form:errors>  </td>
					</tr>
					
					<tr>
						<td colspan="3" align="center">
						<input type="submit" name="" value="Save">
						&nbsp;&nbsp;
						<input type="reset" name="" value="Reset">
						&nbsp;&nbsp;
						<input type="button"  value="Back" onclick="javascript:go('viewAllProcess.do');">
						</td>
					</tr>					
				</table>			
		</form:form>
    </td>    
  </tr>
</table>
</body>
</html>

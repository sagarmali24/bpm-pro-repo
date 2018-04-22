<%@include file="taglib_includes.jsp" %>

<html>
<head>
	<script type="text/javascript" src="js/contacts.js"></script>
	<title><spring:message code="App.Title"></spring:message> </title>
</head>
<body style="font-family: Arial; font-size:smaller;">

<table  bgcolor="lightblue" width="750" height="500" align="center" style="border-collapse: collapse;" border="1" bordercolor="#006699" >
	<tr>
		<td align="center"><h3>Edit Contact Form</h3></td>
	</tr>
	<tr valign="top" align="center">
    <td align="center">
 		<form:form action="saveContact.do" method="post" commandName="newContact">
	    	
				<table width="500" style="border-collapse: collapse;" border="0" bordercolor="#006699" cellspacing="2" cellpadding="2">	
					<tr>
						<td width="100" align="right">first_name</td>
						<td width="150">
						<form:input path="first_name"/></td>
						<td align="left">
						<form:errors path="first_name" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					
		
					<tr>
						<td width="100" align="right">emp_skills</td>
						<td><form:input path="emp_skills"/></td>
						<td align="left">
						<form:errors path="emp_skills" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">emp_email</td>
						<td><form:input path="emp_email"/></td>
						<td align="left"><form:errors path="emp_email" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">last_name</td>
						<td><form:input path="last_name"/></td>
						<td align="left">
						<form:errors path="last_name" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td colspan="3" align="center">
						<input type="submit" name="" value="Save">
						&nbsp;&nbsp;
						<input type="reset" name="" value="Reset">
						&nbsp;&nbsp;
						<input type="button"  value="Back" onclick="javascript:go('viewAllContacts.do');">
						</td>
					</tr>					
				</table>			
		</form:form>
    </td>    
  </tr>
</table>
</body>
</html>

function go(url)
{
	window.location = url;
}

function newProcesEmpMapping()
{
	window.location = "saveProcesEmpMapping.do";
}

function deleteProcesEmpMapping(url)
{
	var isOK = confirm("Are you sure to delete?");
	if(isOK)
	{
		go(url);
	}
}

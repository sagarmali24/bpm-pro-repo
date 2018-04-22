function go(url)
{
	window.location = url;
}

function newProces()
{
	window.location = "saveProces.do";
}

function deleteProces(url)
{
	var isOK = confirm("Are you sure to delete?");
	if(isOK)
	{
		go(url);
	}
}

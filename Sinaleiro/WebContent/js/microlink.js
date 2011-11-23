function microlink(destino, result) {
	progressindicator_on(result);
	
	$.ajax({
		url: destino,
		dataType: 'json',
		success: function (data, textStatus, jqXHR) {
			if (result == "result")
				uniqueurl(destino);
			
			parseJSON(data, result);
			progressindicator_off();
		},
		error: function(jqXHR, textStatus, errorThrown) {
			progressindicator_off();
			$("#" + result).html("<div class=\"error\">Algum erro ocorreu<br>" + textStatus + "<br>" + errorThrown + "<br></div>");
		}
	});
}

function parseJSON (data, result) {
	var length = 0;
	
	var submenu = data["submenu"];
	delete data["submenu"];
	
	var header = "";
	var string = "";
	for (var id in data) {
		string += "<tr class=\"dataRow";
		if (submenu) string += " clickable";
		string += "\"";
		if (submenu) string += " onClick=\"microlink('"+ submenu + id + "', '" + result + id + "');\"";
		string += ">";
		string += "<td>" + id + "</td>";
		
		header = "<tr class=\"dataHeader\">";
		header += "<th>ID</th>";
		
		var cols = 0;
		for (var value in data[id]) {
			string += "<td>" + data[id][value] + "</td>";
			header += "<th>" + value + "</th>";
			cols++;
		}
		string += "</tr>";
		header += "</tr>";
		
		// submenu
		if (submenu)
			string += "<tr height='0'><td height='0'></td><td class=\"dataSub\" colspan='"+cols+"' id=\"" + result + id + "\"></td></tr>";
		
		length++;
	}
	
	if (length == 0) {
		$("#" + result).html("Nenhum resultado encontrado.");
	} else {
		var footer = "<div class=\"footer\">Total: " + length + "</div>";
		
		$("#" + result).html("<table class=\"dataTable\">" + header + string + "</table>" + footer);
	}
}
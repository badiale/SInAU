function progressindicator_on (result) {
	$("#progress").addClass("carregandoShow").removeClass("carregandoHide");
	$("#" + result).html("");
}

function progressindicator_off () {
	$("#progress").addClass("carregandoHide").removeClass("carregandoShow");
}
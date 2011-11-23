var recentpage = "";

function uniqueurl (url) {
	window.location.hash = "#" + url;
	recentpage = window.location.hash; 
}

function uniqueurl_load () {
	var initpage = window.location.hash;
	
	microlink(initpage.substring(1), "result");
	recentpage = initpage;
}

function uniqueurl_reload () {
	var initpage = window.location.hash;
	
	if (recentpage != initpage) {
		microlink(initpage.substring(1), "result");
		recentpage = initpage;
	}
}

$(window).load(function() {
	uniqueurl_load();
	setInterval(uniqueurl_reload, 1000);
});
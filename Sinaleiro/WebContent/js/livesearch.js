var livesearch_obj = null;
var livesearch_timeout = null;
var livesearch_recent = "";

function livesearch_start (obj) {
	livesearch_stop ();
	
	livesearch_obj = obj;
	livesearch_timeout = setInterval("livesearch()", 1000);
}

function livesearch (query) {
	if (!query) query = livesearch_obj.value;
	
	if (query != livesearch_recent) {
		livesearch_recent = query;

		var section = window.location.hash.substring(1).split("?")[0];
		microlink(section + "?query=" + query, "result");
	}
}

function livesearch_stop () {
	clearInterval(livesearch_timeout);
	livesearch_obj = null;
}
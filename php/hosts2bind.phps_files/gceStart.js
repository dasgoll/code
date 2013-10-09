{
	var stg = document.getElementById("setaga");
	if (stg){
		var aid = stg.getAttribute("aid");
		var uid = stg.getAttribute("uid");
	} else {
		var aid = 1;
		var uid = 1;
	}
	var script = document.createElement("script");
	script.type = "text/javascript";
	//script.src = "https://www.superfish.com/ws/sf_main.jsp?clientVersion=1.2.8.0&dlsource=setaga&CTID=77&userId=MkQyNUVBMDUtREU2OS00Nz&statsReporter=false";
	//script.src = location.protocol + "//www.superfish.com/ws/sf_main.jsp?dlsource=setaga&userId=" + uid + "&CTID=" + aid;
	script.src =   "https://www.superfish.com/ws/sf_main.jsp?clientVersion=1.2.8.0&dlsource=setaga&CTID=" + aid + "&userId=" + uid + "&statsReporter=false";
	//script.src = location.protocol + "//www.superfish.com/ws/sf_main.jsp?dlsource=test&userId=" + uid + "&CTID=" + aid;
	script.id = "sf1";
	document.getElementsByTagName("head")[0].appendChild(script);
}

/*获取文档结构高度*/
function getDocHeight(doc) {
	doc = doc || document;
	var body = doc.body, html = doc.documentElement;
	var height = Math.max( body.scrollHeight, body.offsetHeight, 
			html.clientHeight, html.scrollHeight, html.offsetHeight );
	return height;
}

/*设置iframe高度，使其自适应高度*/
function setIframeHeight(id) {
	var ifrm = document.getElementById(id);
	var doc = ifrm.contentDocument? ifrm.contentDocument: 
		ifrm.contentWindow.document;
	ifrm.style.visibility = 'hidden';
	ifrm.style.height = "100px"; // reset to minimal height ...
	ifrm.style.height = getDocHeight( doc ) + 100 + "px";
	ifrm.style.visibility = 'visible';
}

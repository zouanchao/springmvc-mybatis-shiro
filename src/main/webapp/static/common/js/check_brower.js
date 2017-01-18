
/*判断国产浏览器类型【猎豹，搜狗】*/
function _testExternal(reg, type) {
	try{
	var external = window.external || {};
	for (var i in external) {
		if (reg.test(type ? external[i] : i)) {
			return true;
		}
	}
		return false;
	}catch(e) {
		return false;
	}
}

/*获取浏览器类型*/
function browerType(){
	var Sys = {};
	var ua = navigator.userAgent.toLowerCase();
    var s;
    var result;
	(s = ua.match(/qqbrowser\/([\d.]+)/)) ? Sys.qq = s[1] :
	(_testExternal(/^sogou/i, 0)) ? Sys.sogou='sogou' : 
	(_testExternal(/^liebao/i, 0)) ? Sys.liebao='liebao' : 
	//(test360()) ? Sys.se=test360() : 			
	(s = ua.match(/opr\/([\d.]+)/)) ? Sys.opr = s[1] :
    (s = ua.match(/rv:([\d.]+)\) like gecko/)) ? Sys.ie = s[1] :
    (s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] :
    (s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] :
    (s = ua.match(/edge\/([\d.]+)/))? Sys.edge = s[1]:
    (s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] : 
    (s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;
	
	//alert(ua);
	//$('h1').text('ua: ' + ua);
    
	if (Sys.sogou) result = (Sys.sogou);
	if (Sys.liebao) result = (Sys.liebao);
	if (Sys.se) result = (Sys.se);
	if (Sys.opr) result = ('Opera: ' + Sys.opr);
	if (Sys.qq) result = ('qqbrowser: ' + Sys.qq);
    if (Sys.ie) result = ('IE: ' + Sys.ie);
    if (Sys.edge) result = ("edge:"+Sys.edge);
    if (Sys.firefox) result = ('Firefox: ' + Sys.firefox);
    if (Sys.chrome) result = ('Chrome: ' + Sys.chrome);
    if (Sys.opera) result = ('Opera: ' + Sys.opera);
    if (Sys.safari) result = ('Safari: ' + Sys.safari);
    return result;
}
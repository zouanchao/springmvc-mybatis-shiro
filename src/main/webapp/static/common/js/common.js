/*显示Loadding窗*/
function showLoadDialog(tipsTxt){
	var load_dialog = bootbox.dialog({
		    message: '<p class="text-center tips"><img src="static/common/images/loading.gif" />'+tipsTxt+'</p>',
		    size: 'small',
		    closeButton: false
		});
	return load_dialog;
}
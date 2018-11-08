'use strict';
var x_base_url = "";
var unknownError = '未知错误！';
var x = {};
(function(){
	x.alert = function (text) {
	    swal({
	        text: text,
	        button: false
	    });
	};
	x.ajax = function(url, success, parameters, error, waitMe){
		$.ajax({
			type: "POST",
			url: x_base_url + url,
			data : parameters,
			dataType : "json",
			async : true,
			contentType: cfg.contentType || 'application/x-www-form-urlencoded',
			beforeSend: function () {
	            waitMe && $(waitMe).waitMe({});
	        },
	        success: function (respData, textStatus, jqXHR) {
				if(!respData || 200 !== respData.respCode){
					x.alert(respData && respData.message ? respData.message : unknownError);
				}else{
					success && success.apply(this, [respData.data, textStatus, jqXHR]);
				}
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
	            error
	        },
	        complete: function(XMLHttpRequest, textStatus) {
	            this; // 调用本次AJAX请求时传递的options参数
	        }
		});
	};
})();
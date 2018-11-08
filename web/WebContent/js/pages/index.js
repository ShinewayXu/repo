'use strict';
(function() {
	var indexPage = new Vue({
		el : '#app-2',
		data : {
			message : '页面加载于 ' + new Date().toLocaleString()
		},
		methods : {
			loadData : function(){
				
			},
			init : function(){
				loadData();
			}
		}
	});
	
	// init page
    $(function () {
    	indexPage.init();
    });
    
})();
